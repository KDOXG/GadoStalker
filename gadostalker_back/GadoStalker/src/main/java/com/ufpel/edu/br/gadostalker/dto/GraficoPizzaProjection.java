package com.ufpel.edu.br.gadostalker.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GraficoPizzaProjection {

    public String produto;

    public Long vendas;
}
