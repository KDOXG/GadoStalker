package com.ufpel.edu.br.gadostalker.model.repository;

import com.ufpel.edu.br.gadostalker.model.Funcionario;
import com.ufpel.edu.br.gadostalker.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {
    List<Funcionario> findByFazenda_Proprietario(Proprietario proprietario);
    Optional<Funcionario> findByCpf(String cpf);
    Long countByFazenda_Proprietario(Proprietario proprietario);
}