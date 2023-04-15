package com.ufpel.edu.br.gadostalker.model.repository;

import com.ufpel.edu.br.gadostalker.model.Fazenda;
import com.ufpel.edu.br.gadostalker.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FazendaRepository extends JpaRepository<Fazenda, String> {
    List<Fazenda> findAllByProprietario(Proprietario proprietario);
    Optional<Fazenda> findBySNCR(String sncr);
}