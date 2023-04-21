package com.ufpel.edu.br.gadostalker.service;

import com.ufpel.edu.br.gadostalker.model.Funcionario;
import com.ufpel.edu.br.gadostalker.model.Proprietario;
import com.ufpel.edu.br.gadostalker.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Funcionario> findFuncionarios(String sncr);
    Proprietario findProprietarioByCPF(String cpf);
    Usuario login(String email, String senha);
    //TODO: revisar os metodos abaixo
    Usuario findByCPF(String cpf, String tipo);
    Boolean newUsuario(Usuario usuario);
    Usuario findByCPF(String cpf);
    Boolean newUsuario(Usuario usuario, String tipo);
}
