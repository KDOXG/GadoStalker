package com.ufpel.edu.br.gadostalker.controller;

import com.ufpel.edu.br.gadostalker.dto.FazendaDTO;
import com.ufpel.edu.br.gadostalker.dto.UsuarioDTO;
import com.ufpel.edu.br.gadostalker.mapper.FazendaMapper;
import com.ufpel.edu.br.gadostalker.mapper.UsuarioMapper;
import com.ufpel.edu.br.gadostalker.model.Fazenda;
import com.ufpel.edu.br.gadostalker.model.Proprietario;
import com.ufpel.edu.br.gadostalker.model.UsuarioComum;
import com.ufpel.edu.br.gadostalker.service.FazendaServiceImpl;
import com.ufpel.edu.br.gadostalker.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioService;
    @Autowired
    private FazendaServiceImpl fazendaService;
    @Autowired
    private UsuarioMapper usuarioMapper;
    @Autowired
    private FazendaMapper fazendaMapper;


    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody UsuarioDTO usuarioDTO) {

        var login = usuarioService.login(usuarioDTO.email, usuarioDTO.senha);

        if (login.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        var usuarioLogado = usuarioMapper.toDTO((UsuarioComum)login.get());

        return new ResponseEntity<>(usuarioLogado, HttpStatus.OK);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/getAllFazendasByProprietarioCpf/{cpf}")
    public List<FazendaDTO> getFazendasProprietario(@PathVariable("cpf") String cpf) {
        return usuarioService.findByCPF(cpf)
                .stream()
                .map(usuario -> fazendaService.findFazendasByProprietario((Proprietario) usuario))
                .flatMap(Collection::stream)
                .map(fazenda -> fazendaMapper.toDTO(fazenda))
                .collect(Collectors.toList());
    }
}
