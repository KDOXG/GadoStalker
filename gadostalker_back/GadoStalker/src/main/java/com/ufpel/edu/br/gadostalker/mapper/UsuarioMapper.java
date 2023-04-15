package com.ufpel.edu.br.gadostalker.mapper;

import com.ufpel.edu.br.gadostalker.dto.FuncionarioDTO;
import com.ufpel.edu.br.gadostalker.dto.ProprietarioDTO;
import com.ufpel.edu.br.gadostalker.dto.UsuarioComumDTO;
import com.ufpel.edu.br.gadostalker.model.Funcionario;
import com.ufpel.edu.br.gadostalker.model.Proprietario;
import com.ufpel.edu.br.gadostalker.model.UsuarioComum;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioComumDTO toDTO(UsuarioComum usuarioComum);
    UsuarioComum toEntity(UsuarioComumDTO usuarioComumDTO);

    FuncionarioDTO toDTO(Funcionario funcionario);
    Funcionario toEntity(FuncionarioDTO funcionarioDTO);

    ProprietarioDTO toDTO(Proprietario proprietario);
    Proprietario toEntity(ProprietarioDTO proprietarioDTO);
}
