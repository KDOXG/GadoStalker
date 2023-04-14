package com.ufpel.edu.br.gadostalker.mapper;

import com.ufpel.edu.br.gadostalker.dto.UsuarioComumDTO;
import com.ufpel.edu.br.gadostalker.dto.UsuarioDTO;
import com.ufpel.edu.br.gadostalker.model.Usuario;
import com.ufpel.edu.br.gadostalker.model.UsuarioComum;

public class UsuarioMapper {
    public static UsuarioComum toEntity(UsuarioComumDTO usuarioComumDTO) {
        return usuarioComumDTO == null ? null :
                UsuarioComum.builder()
                        .cpf(usuarioComumDTO.cpf)
                        .tipoUsuario(usuarioComumDTO.tipoUsuario)
                        .nome(usuarioComumDTO.nome)
                        .email(usuarioComumDTO.email)
                        .telefone(usuarioComumDTO.telefone)
                        .build();
    }

    public static UsuarioComumDTO toDTO(UsuarioComum usuarioComum) {
        return usuarioComum == null ? null :
                UsuarioComumDTO.builder()
                        .cpf(usuarioComum.getCpf())
                        .tipoUsuario(usuarioComum.getTipoUsuario())
                        .nome(usuarioComum.getNome())
                        .email(usuarioComum.getEmail())
                        .telefone(usuarioComum.getTelefone())
                        .build();
    }
}
