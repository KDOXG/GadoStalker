package com.ufpel.edu.br.gadostalker.mapper;

import com.ufpel.edu.br.gadostalker.dto.ProdutoDTO;
import com.ufpel.edu.br.gadostalker.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    @Mapping(target = "fazenda", ignore = true)
    ProdutoDTO toDTO(Produto produto);
    @Mapping(target = "fazenda", ignore = true)
    Produto toEntity(ProdutoDTO produtoDTO);
}
