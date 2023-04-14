package com.ufpel.edu.br.gadostalker.model.repository;

import com.ufpel.edu.br.gadostalker.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByEmailAndSenha(String email, String senha);

}