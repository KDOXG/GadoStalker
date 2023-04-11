package com.ufpel.edu.br.gadostalker.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashBoardDTO {

    public Long totalAnunciosAtivos;

    public Long totalVendasUltimoMes;

    public Long totalFuncionarios;

    public Long totalProdutosCatalogo;
}
