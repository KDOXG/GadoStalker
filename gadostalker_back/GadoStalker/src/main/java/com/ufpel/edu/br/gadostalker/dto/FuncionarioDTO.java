package com.ufpel.edu.br.gadostalker.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FuncionarioDTO extends UsuarioDTO {

    public FazendaDTO fazenda;
}
