package com.ufpel.edu.br.gadostalker.service;

import com.ufpel.edu.br.gadostalker.model.Fazenda;
import com.ufpel.edu.br.gadostalker.model.Proprietario;
import com.ufpel.edu.br.gadostalker.model.repository.FazendaRepository;
import com.ufpel.edu.br.gadostalker.model.repository.FazendasValidasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FazendaServiceImpl implements FazendaService {

    private final FazendaRepository fazendaRepository;
    private final FazendasValidasRepository fazendasValidasRepository;

    public FazendaServiceImpl(FazendaRepository fazendaRepository, FazendasValidasRepository fazendasValidasRepository) {
        this.fazendaRepository = fazendaRepository;
        this.fazendasValidasRepository = fazendasValidasRepository;
    }


    @Override
    public List<Fazenda> findFazendasByProprietario(Proprietario proprietario) {
        return fazendaRepository.findAllByProprietario(proprietario);
    }

    @Override
    public Boolean validaFazenda(String sncr) {
        return fazendasValidasRepository.findBySNCR(sncr).isPresent();
    }
}
