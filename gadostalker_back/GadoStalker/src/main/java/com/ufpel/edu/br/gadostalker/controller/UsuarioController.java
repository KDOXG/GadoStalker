package com.ufpel.edu.br.gadostalker.controller;

import com.ufpel.edu.br.gadostalker.dto.FuncionarioDTO;
import com.ufpel.edu.br.gadostalker.dto.ProprietarioDTO;
import com.ufpel.edu.br.gadostalker.dto.UsuarioComumDTO;
import com.ufpel.edu.br.gadostalker.dto.UsuarioDTO;
import com.ufpel.edu.br.gadostalker.mapper.FazendaMapper;
import com.ufpel.edu.br.gadostalker.mapper.UsuarioMapper;
import com.ufpel.edu.br.gadostalker.model.Funcionario;
import com.ufpel.edu.br.gadostalker.model.Proprietario;
import com.ufpel.edu.br.gadostalker.model.UsuarioComum;
import com.ufpel.edu.br.gadostalker.service.FazendaServiceImpl;
import com.ufpel.edu.br.gadostalker.service.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioServiceImpl usuarioService;
    private final FazendaServiceImpl fazendaService;
    private final UsuarioMapper usuarioMapper;
    private final FazendaMapper fazendaMapper;

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody UsuarioDTO usuarioDTO) {

        var login = usuarioService.login(usuarioDTO.email, usuarioDTO.senha);

        if (Objects.isNull(login)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (login instanceof UsuarioComum usuarioComum) {
            var usuarioLogado = usuarioMapper.toDTO(usuarioComum);
            usuarioLogado.senha = null;
            usuarioLogado.pergunta = null;
            usuarioLogado.resposta = null;
            return new ResponseEntity<>(usuarioLogado, HttpStatus.ACCEPTED);

        } else if (login instanceof Funcionario funcionario) {
            var usuarioLogado = usuarioMapper.toDTO(funcionario);
            usuarioLogado.senha = null;
            usuarioLogado.pergunta = null;
            usuarioLogado.resposta = null;
            return new ResponseEntity<>(usuarioLogado, HttpStatus.ACCEPTED);

        } else if (login instanceof Proprietario proprietario) {
            var usuarioLogado = usuarioMapper.toDTO(proprietario);
            usuarioLogado.senha = null;
            usuarioLogado.pergunta = null;
            usuarioLogado.resposta = null;
            return new ResponseEntity<>(usuarioLogado, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //TODO: Refazer este metodo, esta completamente errado
//    @GetMapping
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    @RequestMapping("/getAllFazendasByProprietarioCpf/{cpf}")
//    public List<FazendaDTO> getFazendasProprietario(@PathVariable("cpf") String cpf) {
//        return usuarioService.findByCPF(cpf)
//                .stream()
//                .map(Proprietario.class::cast)
//                .map(fazendaService::findFazendasByProprietario)
//                .flatMap(Collection::stream)
//                .map(fazendaMapper::toDTO)
//                .collect(Collectors.toList());
//    }

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