package com.ufpel.edu.br.gadostalker.model.repository;

import com.ufpel.edu.br.gadostalker.model.Proprietario;
import com.ufpel.edu.br.gadostalker.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    @Query("select count(t) from Transacao t " +
            "where t.anuncio.produto.fazenda.proprietario = ?1 " +
            "and t.dataTransacao between ?2 and ?3")
    Long countTransacaoByProprietarioOnPeriod(Proprietario proprietario, Date dataInicial, Date dataFinal);
}