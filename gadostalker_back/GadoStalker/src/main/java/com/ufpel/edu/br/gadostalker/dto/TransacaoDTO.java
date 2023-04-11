package com.ufpel.edu.br.gadostalker.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TransacaoDTO {

    public Long id;

    public Date dataTransacao;

    public BigDecimal preco;

    public AnuncioDTO anuncioDTO;

    public int quantidade;
}
