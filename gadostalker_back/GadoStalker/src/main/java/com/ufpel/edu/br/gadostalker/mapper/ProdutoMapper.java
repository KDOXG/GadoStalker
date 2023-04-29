package com.ufpel.edu.br.gadostalker.mapper;

import com.ufpel.edu.br.gadostalker.dto.ProdutoDTO;
import com.ufpel.edu.br.gadostalker.model.Produto;
import com.ufpel.edu.br.gadostalker.service.FazendaService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {FazendaService.class})
public interface ProdutoMapper {
    @Mapping(target = "fazenda", source = "fazenda.SNCR")
    ProdutoDTO toDTO(Produto produto);
    @Mapping(target = "fazenda", ignore = true)
    Produto toEntity(ProdutoDTO produtoDTO);
}
