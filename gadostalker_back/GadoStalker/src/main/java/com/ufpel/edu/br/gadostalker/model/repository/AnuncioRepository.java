package com.ufpel.edu.br.gadostalker.model.repository;

import com.ufpel.edu.br.gadostalker.model.Anuncio;
import com.ufpel.edu.br.gadostalker.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {
    @Query("select count(a) from Anuncio a " +
            "where a.produto.fazenda.proprietario.cpf = ?1 " +
            "and a.dataFinal is null " +
            "and a.isExcluido = false")
    Long countAnunciosByProprietario(Proprietario proprietario);
}