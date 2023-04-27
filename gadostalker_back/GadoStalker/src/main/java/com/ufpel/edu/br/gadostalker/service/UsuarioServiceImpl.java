package com.ufpel.edu.br.gadostalker.service;

import com.ufpel.edu.br.gadostalker.dto.FuncionarioDTO;
import com.ufpel.edu.br.gadostalker.dto.ProprietarioDTO;
import com.ufpel.edu.br.gadostalker.dto.UsuarioComumDTO;
import com.ufpel.edu.br.gadostalker.dto.UsuarioDTO;
import com.ufpel.edu.br.gadostalker.mapper.FazendaMapper;
import com.ufpel.edu.br.gadostalker.mapper.UsuarioMapper;
import com.ufpel.edu.br.gadostalker.model.Funcionario;
import com.ufpel.edu.br.gadostalker.model.Proprietario;
import com.ufpel.edu.br.gadostalker.model.Usuario;
import com.ufpel.edu.br.gadostalker.model.UsuarioComum;
import com.ufpel.edu.br.gadostalker.model.repository.FazendaRepository;
import com.ufpel.edu.br.gadostalker.model.repository.FuncionarioRepository;
import com.ufpel.edu.br.gadostalker.model.repository.ProprietarioRepository;
import com.ufpel.edu.br.gadostalker.model.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final ProprietarioRepository proprietarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final FazendaMapper fazendaMapper;
    private final FazendaRepository fazendaRepository;

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

    @Override
    public UsuarioDTO login(String email, String senha) {

        var login = usuarioRepository.findByEmailAndSenha(email, senha).orElse(null);

        if (Objects.isNull(login)) {
            return null;
        }
        UsuarioDTO usuarioLogado = new UsuarioDTO();
        if (login instanceof UsuarioComum usuarioComum) {
            usuarioLogado = usuarioMapper.toDTO(usuarioComum);

        } else if (login instanceof Funcionario funcionario) {
            usuarioLogado = usuarioMapper.toDTO(funcionario);

        } else if (login instanceof Proprietario proprietario) {
            usuarioLogado = usuarioMapper.toDTO(proprietario);
        }
        usuarioLogado.senha = null;
        usuarioLogado.pergunta = null;
        usuarioLogado.resposta = null;
        return usuarioLogado;
    }

    @Override
    public Usuario findByCPF(String cpf, String tipo) {
        return null;
    }

    @Override
    public Boolean newUsuario(UsuarioDTO usuarioDTO, String tipo) {
        //TODO: Trocar os casts para alguma coisa que funciona
        return switch (tipo) {
            case "prop" -> saveUsuario(usuarioMapper.toEntity((ProprietarioDTO) usuarioDTO));
            case "func" -> saveUsuario(usuarioMapper.toEntity((FuncionarioDTO) usuarioDTO));
            case "uc" ->   saveUsuario(usuarioMapper.toEntity((UsuarioComumDTO) usuarioDTO));
            default -> false;
        };
    }

    //TODO: A princípio nenhum save do Spring deveria ser validado se houver alguma exception
    //No momento, funciona e está idêntico à implementação original
    //Ver o que dá pra fazer no front-end também pra melhorar isso
    private Boolean saveUsuario(Usuario usuario) {
        try {
            usuarioRepository.save(usuario);
            if (usuario instanceof Proprietario proprietario) {
                var fazenda = proprietario.getFazendas().get(0);
                fazenda.setProprietario(proprietario);
                fazendaRepository.save(fazenda);
            } else if (usuario instanceof Funcionario funcionario) {
                var fazenda = funcionario.getFazenda();
                fazenda.addFuncionario(funcionario);
                //TODO: Não sei se é necessário aqui
//                fazendaRepository.save(fazenda);
            }
        } catch (OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

    @Override
    public Usuario findByCPF(String cpf) {
        return usuarioRepository.findByCpf(cpf).orElse(null);
    }

}
