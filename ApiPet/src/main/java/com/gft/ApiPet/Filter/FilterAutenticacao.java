package com.gft.ApiPet.Filter;

import com.gft.ApiPet.entities.Usuario;
import com.gft.ApiPet.service.AutenticacaoService;
import com.gft.ApiPet.service.UsuarioService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterAutenticacao extends OncePerRequestFilter {

    private final AutenticacaoService autenticacaoService;
    private final UsuarioService usuarioService;

    public FilterAutenticacao(AutenticacaoService autenticacaoService, UsuarioService usuarioService) {
        this.autenticacaoService = autenticacaoService;
        this.usuarioService = usuarioService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        String token = null;

        if (header != null && header.startsWith("Bearer ")) {
            token = header.substring(7, header.length());
        }

        if (autenticacaoService.verificaToken(token)) {
            Long idUsuario = autenticacaoService.retornaIdUsuario(token);
            Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
            SecurityContextHolder.getContext()
                    .setAuthentication(new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities()));
        }

        filterChain.doFilter(request, response);
    }
}
