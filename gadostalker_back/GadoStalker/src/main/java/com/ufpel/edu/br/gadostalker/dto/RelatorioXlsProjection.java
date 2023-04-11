package com.ufpel.edu.br.gadostalker.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RelatorioXlsProjection {

    public Long idTransacao;

    public String nomeAnuncio;

    public BigDecimal precoTransacao;

    public int quantidade;

    public String dataTransacao;
}
