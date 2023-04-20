package com.ufpel.edu.br.gadostalker.controller;

import com.ufpel.edu.br.gadostalker.dto.*;
import com.ufpel.edu.br.gadostalker.mapper.FazendaMapper;
import com.ufpel.edu.br.gadostalker.mapper.UsuarioMapper;
import com.ufpel.edu.br.gadostalker.model.Funcionario;
import com.ufpel.edu.br.gadostalker.model.Proprietario;
import com.ufpel.edu.br.gadostalker.model.UsuarioComum;
import com.ufpel.edu.br.gadostalker.service.FazendaServiceImpl;
import com.ufpel.edu.br.gadostalker.service.UsuarioServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioServiceImpl usuarioService;
    private final FazendaServiceImpl fazendaService;
    private final UsuarioMapper usuarioMapper;
    private final FazendaMapper fazendaMapper;

    public UsuarioController(UsuarioServiceImpl usuarioService, FazendaServiceImpl fazendaService, UsuarioMapper usuarioMapper, FazendaMapper fazendaMapper) {
        this.usuarioService = usuarioService;
        this.fazendaService = fazendaService;
        this.usuarioMapper = usuarioMapper;
        this.fazendaMapper = fazendaMapper;
    }


    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody UsuarioDTO usuarioDTO) {

        var login = usuarioService.login(usuarioDTO.email, usuarioDTO.senha);

        if (login.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (login.get() instanceof UsuarioComum) {
            var usuarioLogado = usuarioMapper.toDTO((UsuarioComum)login.get());
            usuarioLogado.senha = null;
            usuarioLogado.pergunta = null;
            usuarioLogado.resposta = null;
            return new ResponseEntity<>(usuarioLogado, HttpStatus.ACCEPTED);
        } else if (login.get() instanceof Funcionario) {
            var usuarioLogado = usuarioMapper.toDTO((Funcionario)login.get());
            usuarioLogado.senha = null;
            usuarioLogado.pergunta = null;
            usuarioLogado.resposta = null;
            return new ResponseEntity<>(usuarioLogado, HttpStatus.ACCEPTED);
        } else if (login.get() instanceof Proprietario) {
            var usuarioLogado = usuarioMapper.toDTO((Proprietario)login.get());
            usuarioLogado.senha = null;
            usuarioLogado.pergunta = null;
            usuarioLogado.resposta = null;
            return new ResponseEntity<>(usuarioLogado, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping("/getAllFazendasByProprietarioCpf/{cpf}")
    public List<FazendaDTO> getFazendasProprietario(@PathVariable("cpf") String cpf) {
        return usuarioService.findByCPF(cpf)
                .stream()
                .map(Proprietario.class::cast)
                .map(fazendaService::findFazendasByProprietario)
                .flatMap(Collection::stream)
                .map(fazendaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping("cadastro/validaSncr/{sncr}")
    public Boolean fazendaIsValida(@PathVariable("sncr") String sncr) {
        return fazendaService.validaFazenda(sncr);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping("/cadastro/{tipo}")
    public Boolean cadastro(UsuarioDTO usuarioDTO, @PathVariable("tipo") String tipo) {
        return switch (tipo) {
            case "prop" -> usuarioService.newUsuario(usuarioMapper.toEntity((ProprietarioDTO) usuarioDTO));
            case "func" -> usuarioService.newUsuario(usuarioMapper.toEntity((FuncionarioDTO) usuarioDTO));
            case "uc" ->   usuarioService.newUsuario(usuarioMapper.toEntity((UsuarioComumDTO) usuarioDTO));
            default -> false;
        };
    }
}
