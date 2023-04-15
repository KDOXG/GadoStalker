package com.ufpel.edu.br.gadostalker.model.repository;

import com.ufpel.edu.br.gadostalker.model.FazendasValidas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FazendasValidasRepository extends JpaRepository<FazendasValidas, Long> {
    Optional<FazendasValidas> findBySNCR(String sncr);
}