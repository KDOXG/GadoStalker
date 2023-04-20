package com.ufpel.edu.br.gadostalker.service;

import com.ufpel.edu.br.gadostalker.model.Funcionario;
import com.ufpel.edu.br.gadostalker.model.Proprietario;
import com.ufpel.edu.br.gadostalker.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Funcionario> findFuncionarios(String sncr);
    Proprietario findProprietarioByCPF(String cpf);
    Optional<Usuario> login(String email, String senha);
    Optional<Usuario> findByCPF(String cpf);
    Boolean newUsuario(Usuario usuario);
}
