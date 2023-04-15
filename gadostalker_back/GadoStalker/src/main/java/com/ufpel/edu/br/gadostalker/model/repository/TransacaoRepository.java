package com.ufpel.edu.br.gadostalker.model.repository;

import com.ufpel.edu.br.gadostalker.model.Proprietario;
import com.ufpel.edu.br.gadostalker.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    Long countByAnuncio_Produto_Fazenda_ProprietarioAndDataTransacaoBetween(Proprietario proprietario, Date dataInicial, Date dataFinal);
}