package com.ufpel.edu.br.gadostalker.dto;

import com.ufpel.edu.br.gadostalker.model.Usuario;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Builder
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
    public List<FazendaDTO> fazendas;

    public Usuario.TipoUsuario tipoUsuario;

    public String cpfPatrao;

    
    public UsuarioDTO addFazendaDTO(FazendaDTO fazenda) {
        if (fazendas == null) {
            fazendas = new ArrayList<>();
        }
        fazendas.add(fazenda);
        
        return this;
    }
    
    public UsuarioDTO removeFazendaDTO(FazendaDTO fazenda) {
        fazendas.remove(fazenda);
        
        return this;
    }
}
