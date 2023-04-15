package com.ufpel.edu.br.gadostalker.service;

import com.ufpel.edu.br.gadostalker.model.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String email, String senha);
    Optional<Usuario> findByCPF(String cpf);
}
