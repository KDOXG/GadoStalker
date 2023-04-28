package com.ufpel.edu.br.gadostalker.controller;

import com.ufpel.edu.br.gadostalker.dto.FazendaDTO;
import com.ufpel.edu.br.gadostalker.dto.UsuarioDTO;
import com.ufpel.edu.br.gadostalker.model.Usuario;
import com.ufpel.edu.br.gadostalker.service.FazendaServiceImpl;
import com.ufpel.edu.br.gadostalker.service.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping("/getAllFazendasByProprietarioCpf/{cpf}")
    public List<FazendaDTO> getFazendasProprietario(@PathVariable("cpf") String cpf) {
        return usuarioService.findAllFazendasByProprietarioCpf(cpf);
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
        return usuarioService.newUsuario(usuarioDTO, tipo);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping("/cadastro/editar/{cpf}")

    public UsuarioDTO editarUsuario(UsuarioDTO usuarioDTO, @PathVariable("cpf") String cpf) {
        return usuarioService.editUsuario(usuarioDTO, cpf);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping("/getAllPerguntas")
    public Map<Usuario.PerguntaSegurancaEnum, String> getAllPerguntas() {
        return usuarioService.getAllPerguntas();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping("/recuperarSenha")
    public Boolean recuperarSenha(UsuarioDTO usuarioRecuperaSenha) {
        return usuarioService.recoverPassword(usuarioRecuperaSenha);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping("/getListaFuncionariosByProprietarioCpf/{cpf}")
    public List<UsuarioDTO> listaFuncionarios(@PathVariable("cpf") String cpf) {
        return usuarioService.findAllFuncionariosByProprietarioCPF(cpf);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping("/remover/{cpf}")
    public Boolean removerUsuario(@PathVariable("cpf") String cpf) {
        return usuarioService.deleteUsuarioByCpf(cpf);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping("/funcionario/trocaFazenda")
    public UsuarioDTO trocaFazendaFuncionario(UsuarioDTO usuarioDTO) {
        return usuarioService.editFuncionarioFazenda(usuarioDTO);
    }

}