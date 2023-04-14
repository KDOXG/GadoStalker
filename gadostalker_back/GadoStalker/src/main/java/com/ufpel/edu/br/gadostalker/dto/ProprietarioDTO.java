package com.ufpel.edu.br.gadostalker.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProprietarioDTO extends UsuarioDTO{
    public List<FazendaDTO> fazendas;

    public ProprietarioDTO addFazendaDTO(FazendaDTO fazenda) {
        if (fazendas == null) {
            fazendas = new ArrayList<>();
        }
        fazendas.add(fazenda);

        return this;
    }

    public ProprietarioDTO removeFazendaDTO(FazendaDTO fazenda) {
        fazendas.remove(fazenda);

        return this;
    }
}
