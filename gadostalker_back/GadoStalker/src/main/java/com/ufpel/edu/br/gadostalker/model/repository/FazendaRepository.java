package com.ufpel.edu.br.gadostalker.model.repository;

import com.ufpel.edu.br.gadostalker.model.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FazendaRepository extends JpaRepository<Fazenda, String> {
}