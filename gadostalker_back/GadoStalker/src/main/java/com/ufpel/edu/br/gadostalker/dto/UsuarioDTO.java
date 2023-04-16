package com.ufpel.edu.br.gadostalker.dto;

import com.ufpel.edu.br.gadostalker.model.Usuario;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    public String cpf;

    public String nome;

    public String senha;

    public String telefone;

    public String email;

    public Usuario.PerguntaSegurancaEnum pergunta;

    public String resposta;

    public Usuario.TipoUsuario tipoUsuario;
}
