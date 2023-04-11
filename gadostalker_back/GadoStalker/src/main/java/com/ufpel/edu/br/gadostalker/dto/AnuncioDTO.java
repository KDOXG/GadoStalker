package com.ufpel.edu.br.gadostalker.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class AnuncioDTO {

    public Long id;

    public String titulo;

    public String descricao;

    public BigDecimal preco;

    public int desconto;

    public ProdutoDTO produto;

    public Date dataInicial;

    public Date dataFinal;

    public Long imagemId;
}
