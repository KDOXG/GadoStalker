package com.ufpel.edu.br.gadostalker.service;

import com.ufpel.edu.br.gadostalker.model.Fazenda;
import com.ufpel.edu.br.gadostalker.model.Proprietario;
import com.ufpel.edu.br.gadostalker.model.repository.FazendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FazendaServiceImpl implements FazendaService {

    private final FazendaRepository fazendaRepository;

    public FazendaServiceImpl(FazendaRepository fazendaRepository) {
        this.fazendaRepository = fazendaRepository;
    }


    @Override
    public List<Fazenda> findFazendasByProprietario(Proprietario proprietario) {
        return fazendaRepository.findAllByProprietario(proprietario);
    }
}
