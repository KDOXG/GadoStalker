package com.ufpel.edu.br.gadostalker.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO extends UsuarioDTO {

    public FazendaDTO fazenda;
}
