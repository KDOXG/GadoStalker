package com.ufpel.edu.br.gadostalker.controller;


import com.ufpel.edu.br.gadostalker.mapper.FazendaMapper;
import com.ufpel.edu.br.gadostalker.mapper.UsuarioMapper;
import com.ufpel.edu.br.gadostalker.service.FazendaServiceImpl;
import com.ufpel.edu.br.gadostalker.service.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fazenda")
public class FazendaController {
    private final UsuarioServiceImpl usuarioService;
    private final FazendaServiceImpl fazendaService;
    private final UsuarioMapper usuarioMapper;
    private final FazendaMapper fazendaMapper;
}
