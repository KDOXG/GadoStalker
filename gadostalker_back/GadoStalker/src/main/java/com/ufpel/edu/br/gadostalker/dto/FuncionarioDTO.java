package com.ufpel.edu.br.gadostalker.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO extends UsuarioDTO {

    public FazendaDTO fazenda;
    public String cpfPatrao;
}
