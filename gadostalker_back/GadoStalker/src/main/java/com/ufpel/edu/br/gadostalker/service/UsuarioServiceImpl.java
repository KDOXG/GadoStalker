package com.ufpel.edu.br.gadostalker.service;

import com.ufpel.edu.br.gadostalker.model.Funcionario;
import com.ufpel.edu.br.gadostalker.model.Proprietario;
import com.ufpel.edu.br.gadostalker.model.Usuario;
import com.ufpel.edu.br.gadostalker.model.UsuarioComum;
import com.ufpel.edu.br.gadostalker.model.repository.FuncionarioRepository;
import com.ufpel.edu.br.gadostalker.model.repository.ProprietarioRepository;
import com.ufpel.edu.br.gadostalker.model.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final ProprietarioRepository proprietarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, FuncionarioRepository funcionarioRepository,
                              ProprietarioRepository proprietarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.proprietarioRepository = proprietarioRepository;
    }

    @Override
    public List<Funcionario> findFuncionarios(String sncr) {
        return funcionarioRepository.findAllByFazendaSNCR(sncr);
    }

    public Proprietario findProprietarioByCPF(String cpf) {
        return proprietarioRepository.findByCpf(cpf).orElse(null);
    }

    public List<Funcionario> findAllFuncionariosByProprietarioCPF(String cpf) {
        return funcionarioRepository.findByFazenda_ProprietarioCpf(cpf);
    }

    public Usuario login(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha).orElse(null);
    }

    @Override
    public Usuario findByCPF(String cpf, String tipo) {
        return null;
    }

    @Override
    public Boolean newUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public Usuario findByCPF(String cpf) {
        return usuarioRepository.findByCpf(cpf).orElse(null);
    }

    @Override
    public Boolean newUsuario(Usuario usuario, String tipo) {
        if (tipo.equals("prop") && !(usuario instanceof Proprietario)) {
            return false;

        }
        if (tipo.equals("func") && !(usuario instanceof Funcionario)) {
            return false;
        }

        if (tipo.equals("uc") && !(usuario instanceof UsuarioComum)) {
            return false;
        }

        if (usuario == null) {
            return false;
        } else {
            usuarioRepository.save(usuario);
            return true;
        }
    }
}
