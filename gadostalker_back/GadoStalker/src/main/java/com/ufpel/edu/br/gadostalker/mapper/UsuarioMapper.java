package com.ufpel.edu.br.gadostalker.mapper;

import com.ufpel.edu.br.gadostalker.dto.UsuarioComumDTO;
import com.ufpel.edu.br.gadostalker.model.UsuarioComum;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioComumDTO toDTO(UsuarioComum usuarioComum);
    UsuarioComum toEntity(UsuarioComumDTO usuarioComumDTO);
}
