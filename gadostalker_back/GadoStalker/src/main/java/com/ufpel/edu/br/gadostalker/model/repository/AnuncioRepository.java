package com.ufpel.edu.br.gadostalker.model.repository;

import com.ufpel.edu.br.gadostalker.model.Anuncio;
import com.ufpel.edu.br.gadostalker.model.Proprietario;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface AnuncioRepository extends CassandraRepository<Anuncio, UUID> {

}