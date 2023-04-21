package com.ufpel.edu.br.gadostalker.mapper;

import com.ufpel.edu.br.gadostalker.dto.FazendaDTO;
import com.ufpel.edu.br.gadostalker.model.Fazenda;
import com.ufpel.edu.br.gadostalker.service.FazendaService;
import com.ufpel.edu.br.gadostalker.service.UsuarioService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UsuarioService.class, FazendaService.class})
public interface FazendaMapper {

    FazendaDTO toDTO(Fazenda fazenda);

    @Mapping(target = "produtos", ignore = true)
    @Mapping(target = "funcionarios", ignore = true)
    @Mapping(target = "proprietario", ignore = true)
    Fazenda toEntity(FazendaDTO fazendaDTO, String cpf);
}