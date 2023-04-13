package com.ufpel.edu.br.gadostalker.model.repository;

import com.ufpel.edu.br.gadostalker.model.UsuarioComum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioComumRepository extends JpaRepository<UsuarioComum, String> {
}