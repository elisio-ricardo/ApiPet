package com.gft.ApiPet.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.gft.ApiPet.dto.auth.AutenticacaoDTO;
import com.gft.ApiPet.dto.auth.TokenDTO;
import com.gft.ApiPet.entities.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.Date;

@Service
public class AutenticacaoService {

    private final AuthenticationManager authManager;

    public AutenticacaoService(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    @Value("${loja.jwt.secret}")
    private String secret;

    @Value("${loja.jwt.expiration}")
    private String expiration;

    @Value("${loja.jwt.issuer}")
    private String issuer;

    public TokenDTO autenticar(AutenticacaoDTO authForm) throws AuthenticationException {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(authForm.getEmail(),
                authForm.getSenha()));
        String token = gerarToken(authentication);

        return new TokenDTO(token);
    }

    private Algorithm criarAlgoritmo() {
        return Algorithm.HMAC256(secret);
    }

    private String gerarToken(Authentication authentication) {
        Usuario principal = (Usuario) authentication.getPrincipal();
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        return JWT.create()
                .withIssuer(issuer)
                .withExpiresAt(dataExpiracao)
                .withSubject(principal.getId().toString())
                .sign(this.criarAlgoritmo());
    }

    public boolean verificaToken(String token) {
        try {
            if (token == null)
                return false;
            JWT.require(this.criarAlgoritmo()).withIssuer(issuer).build().verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            return false;
        }
    }

    public Long retornaIdUsuario(String token) {
        String subject = JWT.require(this.criarAlgoritmo()).withIssuer(issuer).build().verify(token).getSubject();
        return Long.parseLong(subject);
    }


}
