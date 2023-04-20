package com.ufpel.edu.br.gadostalker.mapper;

import com.ufpel.edu.br.gadostalker.dto.TransacaoDTO;
import com.ufpel.edu.br.gadostalker.model.Transacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransacaoMapper {
    @Mapping(target = "anuncioDTO", ignore = true)
    TransacaoDTO toDTO(Transacao transacao);
    @Mapping(target = "anuncio", ignore = true)
    Transacao toEntity(TransacaoDTO transacaoDTO);
}
