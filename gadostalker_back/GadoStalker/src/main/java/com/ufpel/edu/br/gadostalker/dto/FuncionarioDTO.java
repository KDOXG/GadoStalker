package com.ufpel.edu.br.gadostalker.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO extends UsuarioDTO {

    public String fazenda;
    public String cpfPatrao;
}
