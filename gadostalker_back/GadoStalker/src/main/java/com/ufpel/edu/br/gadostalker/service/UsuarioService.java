package com.ufpel.edu.br.gadostalker.service;

import com.ufpel.edu.br.gadostalker.dto.UsuarioDTO;
import com.ufpel.edu.br.gadostalker.model.Funcionario;
import com.ufpel.edu.br.gadostalker.model.Proprietario;
import com.ufpel.edu.br.gadostalker.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Funcionario> findFuncionarios(String sncr);
    Proprietario findProprietarioByCPF(String cpf);
    UsuarioDTO login(String email, String senha);
    Boolean newUsuario(UsuarioDTO usuarioDTO, String tipo);
    //TODO: revisar os metodos abaixo
    Usuario findByCPF(String cpf, String tipo);
    Usuario findByCPF(String cpf);
}
