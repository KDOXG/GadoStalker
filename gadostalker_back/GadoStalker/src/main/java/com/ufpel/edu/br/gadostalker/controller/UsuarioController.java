package com.ufpel.edu.br.gadostalker.controller;

import com.ufpel.edu.br.gadostalker.dto.UsuarioDTO;
import com.ufpel.edu.br.gadostalker.model.Usuario;
import com.ufpel.edu.br.gadostalker.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioServiceImpl usuarioService;

    public UsuarioController(UsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody UsuarioDTO usuarioDTO) {

        var login = usuarioService.login(usuarioDTO.email, usuarioDTO.senha);

        if (login.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
