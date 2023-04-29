package com.ufpel.edu.br.gadostalker.mapper;

import com.ufpel.edu.br.gadostalker.dto.FuncionarioDTO;
import com.ufpel.edu.br.gadostalker.dto.ProprietarioDTO;
import com.ufpel.edu.br.gadostalker.dto.UsuarioComumDTO;
import com.ufpel.edu.br.gadostalker.model.Funcionario;
import com.ufpel.edu.br.gadostalker.model.Proprietario;
import com.ufpel.edu.br.gadostalker.model.UsuarioComum;
import com.ufpel.edu.br.gadostalker.service.FazendaService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {FazendaService.class, UsuarioCustomMapper.class})
public interface UsuarioMapper {
    UsuarioComumDTO toDTO(UsuarioComum usuarioComum);
    UsuarioComum toEntity(UsuarioComumDTO usuarioComumDTO);

    @Mapping(target = "fazenda", source = "fazenda.SNCR")
    @Mapping(target = "cpfPatrao", source = "fazenda.proprietario.cpf")
    FuncionarioDTO toDTO(Funcionario funcionario);
    Funcionario toEntity(FuncionarioDTO funcionarioDTO);

    ProprietarioDTO toDTO(Proprietario proprietario);
    Proprietario toEntity(ProprietarioDTO proprietarioDTO);
}