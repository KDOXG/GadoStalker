package com.ufpel.edu.br.gadostalker.model.repository;

import com.ufpel.edu.br.gadostalker.model.Anuncio;
import com.ufpel.edu.br.gadostalker.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {
    Long countByProduto_Fazenda_ProprietarioAndDataFinalIsNullAndExcluidoIsFalse(Proprietario proprietario);
}