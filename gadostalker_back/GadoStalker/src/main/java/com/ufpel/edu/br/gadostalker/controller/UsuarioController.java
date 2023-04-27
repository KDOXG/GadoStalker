package com.ufpel.edu.br.gadostalker.controller;

import com.ufpel.edu.br.gadostalker.dto.UsuarioDTO;
import com.ufpel.edu.br.gadostalker.service.FazendaServiceImpl;
import com.ufpel.edu.br.gadostalker.service.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioServiceImpl usuarioService;
    private final FazendaServiceImpl fazendaService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UsuarioDTO login(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.login(usuarioDTO.email, usuarioDTO.senha);
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
        return usuarioService.newUsuario(usuarioDTO, tipo);
    }
}