package com.ufpel.edu.br.gadostalker.mapper;

import com.ufpel.edu.br.gadostalker.dto.FazendaDTO;
import com.ufpel.edu.br.gadostalker.model.Fazenda;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FazendaMapper {
    FazendaDTO toDTO(Fazenda fazenda);
    Fazenda toEntity(FazendaDTO fazendaDTO);
}
