package com.ufpel.edu.br.gadostalker.mapper;

import com.ufpel.edu.br.gadostalker.dto.FazendaDTO;
import com.ufpel.edu.br.gadostalker.model.Fazenda;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class UsuarioCustomMapper {
    public Fazenda mapDTOToEntity(FazendaDTO fazendaDTO) {

        if ( fazendaDTO == null ) {
            return null;
        }

        Fazenda.FazendaBuilder fazenda = Fazenda.builder();

        fazenda.SNCR( fazendaDTO.getSNCR() );
        fazenda.nome( fazendaDTO.getNome() );
        fazenda.email( fazendaDTO.getEmail() );
        fazenda.telefone( fazendaDTO.getTelefone() );
        fazenda.isZapZap( fazendaDTO.getIsZapZap() );

        return fazenda.build();
    }
}
