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

    @GetMapping("/getAllFazendasByProprietarioCpf/{cpf}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<FazendaDTO> getFazendasProprietario(@PathVariable("cpf") String cpf) {
        return usuarioService.findAllFazendasByProprietarioCpf(cpf);
    }

    @GetMapping("cadastro/validaSncr/{sncr}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean fazendaIsValida(@PathVariable("sncr") String sncr) {
        return fazendaService.validaFazenda(sncr);
    }

    @PostMapping("/cadastro/{tipo}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean cadastro(UsuarioDTO usuarioDTO, @PathVariable("tipo") String tipo) {
        return usuarioService.newUsuario(usuarioDTO, tipo);
    }

    @PutMapping("/cadastro/editar/{cpf}")
    @ResponseStatus(HttpStatus.ACCEPTED)

    public UsuarioDTO editarUsuario(UsuarioDTO usuarioDTO, @PathVariable("cpf") String cpf) {
        return usuarioService.editUsuario(usuarioDTO, cpf);
    }

    @GetMapping("/getAllPerguntas")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<Usuario.PerguntaSegurancaEnum, String> getAllPerguntas() {
        return usuarioService.getAllPerguntas();
    }

    @PutMapping("/recuperarSenha")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean recuperarSenha(UsuarioDTO usuarioRecuperaSenha) {
        return usuarioService.recoverPassword(usuarioRecuperaSenha);
    }

    @GetMapping("/getListaFuncionariosByProprietarioCpf/{cpf}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<UsuarioDTO> listaFuncionarios(@PathVariable("cpf") String cpf) {
        return usuarioService.findAllFuncionariosByProprietarioCPF(cpf);
    }

    @DeleteMapping("/remover/{cpf}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean removerUsuario(@PathVariable("cpf") String cpf) {
        return usuarioService.deleteUsuarioByCpf(cpf);
    }

    @PutMapping("/funcionario/trocaFazenda")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UsuarioDTO trocaFazendaFuncionario(UsuarioDTO usuarioDTO) {
        return usuarioService.editFuncionarioFazenda(usuarioDTO);
    }
}