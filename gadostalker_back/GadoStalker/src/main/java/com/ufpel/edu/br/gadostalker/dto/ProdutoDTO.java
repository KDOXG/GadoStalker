package com.ufpel.edu.br.gadostalker.dto;
import com.ufpel.edu.br.gadostalker.model.Produto;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProdutoDTO {

    public Long id;

    public String nome;

    public Produto.TipoProdutoEnum tipo;

    public String fazenda;

    public BigDecimal quantidade;
}
