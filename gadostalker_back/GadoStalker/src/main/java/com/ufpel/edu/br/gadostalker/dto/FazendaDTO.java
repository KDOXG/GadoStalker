package com.ufpel.edu.br.gadostalker.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FazendaDTO {

    public String SNCR;
    public String nome;
    public String email;
    public String telefone;
    public List<UsuarioDTO> funcionarios;
    public Boolean isZapZap;
}
