package com.ufpel.edu.br.gadostalker.service;

import com.ufpel.edu.br.gadostalker.dto.FazendaDTO;
import com.ufpel.edu.br.gadostalker.dto.UsuarioDTO;
import com.ufpel.edu.br.gadostalker.model.Usuario;

import java.util.List;
import java.util.Map;

public interface UsuarioService {
    UsuarioDTO login(String email, String senha);
    List<FazendaDTO> findAllFazendasByProprietarioCpf(String cpf);
    Boolean newUsuario(UsuarioDTO usuarioDTO, String tipo);
    UsuarioDTO editUsuario(UsuarioDTO usuarioDTO, String tipo);
    Map<Usuario.PerguntaSegurancaEnum, String> getAllPerguntas();
    Boolean recoverPassword(UsuarioDTO usuarioRecoverPassword);
    List<UsuarioDTO> findAllFuncionariosByProprietarioCPF(String cpf);
    Boolean deleteUsuarioByCpf(String cpf);
    UsuarioDTO editFuncionarioFazenda(UsuarioDTO usuarioDTO);
}
