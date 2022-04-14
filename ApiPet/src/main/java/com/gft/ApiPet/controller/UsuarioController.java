package com.gft.ApiPet.controller;


import com.gft.ApiPet.dto.usuario.ConsultaUsuarioDTO;
import com.gft.ApiPet.dto.usuario.RegistroUsuarioDTO;
import com.gft.ApiPet.dto.usuario.UsuarioMapper;
import com.gft.ApiPet.entities.Usuario;
import com.gft.ApiPet.service.UsuarioService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/usuarios")
@Api(tags = "Autenticação Token")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<ConsultaUsuarioDTO> salvarUsuario(@RequestBody RegistroUsuarioDTO dto) {
        Usuario usuario = usuarioService.salvarUsuario(UsuarioMapper.fromDTO(dto));

        return ResponseEntity.ok(UsuarioMapper.fromEntity(usuario));
    }
}
