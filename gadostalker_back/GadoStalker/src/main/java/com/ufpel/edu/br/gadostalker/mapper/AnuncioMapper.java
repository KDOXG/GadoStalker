package com.ufpel.edu.br.gadostalker.mapper;

import com.ufpel.edu.br.gadostalker.dto.AnuncioDTO;
import com.ufpel.edu.br.gadostalker.model.Anuncio;
import com.ufpel.edu.br.gadostalker.service.FazendaService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {FazendaService.class})
public interface AnuncioMapper {
    @Mapping(target = "imagemId", ignore = true)
    @Mapping(target = "produto.fazenda", source = "produto.fazenda.SNCR")
    AnuncioDTO toDTO(Anuncio anuncio);
    @Mapping(target = "imagem", ignore = true)
    @Mapping(target = "isExcluido", ignore = true)
    Anuncio toEntity(AnuncioDTO anuncioDTO);
}
