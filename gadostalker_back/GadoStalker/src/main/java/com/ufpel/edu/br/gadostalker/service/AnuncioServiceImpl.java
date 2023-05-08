package com.ufpel.edu.br.gadostalker.service;

import com.ufpel.edu.br.gadostalker.dto.AnuncioDTO;
import com.ufpel.edu.br.gadostalker.mapper.AnuncioMapper;
import com.ufpel.edu.br.gadostalker.model.repository.AnuncioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AnuncioServiceImpl implements AnuncioService {
    private final AnuncioRepository anuncioRepository;
    private final AnuncioMapper anuncioMapper;

    @Override
    public AnuncioDTO newAnuncio(AnuncioDTO anuncioDTO) {
        return null;
    }

    @Override
    public AnuncioDTO editAnuncio(Long id, AnuncioDTO anuncioDTO) {
        return null;
    }

    @Override
    public AnuncioDTO endAnuncio(Long id) {
        return null;
    }

    @Override
    public AnuncioDTO reopenAnuncio(Long id) {
        return null;
    }

    @Override
    public Boolean deleteAnuncio(Long id) {
        return null;
    }

    @Override
    public AnuncioDTO getAnuncioByID(UUID id) {
        var anuncio = anuncioRepository.findById(id);
        return null;
    }

    @Override
    public List<AnuncioDTO> getAnunciosByProprietarioCpf(String cpf) {
        return null;
    }

    @Override
    public List<AnuncioDTO> search(String tipo, Integer page, String order, Integer quantity, String search, Boolean count) {
        if (Stream.of("tituloasc", "titulodesc", "precoasc", "precodesc", "datadesc").noneMatch(order::equals)) {
            return null;
        }

        switch (quantity) {
            case 0:
            case 8:
            case 12:
            case 24:
                break;

            default:
                return null;
        }

        var sort = Sort.by(switch (order) {
            case "tituloasc", "titulodesc" -> "titulo";
            case "precoasc", "precodesc" -> "preco";
            default -> "dataInicial";
        });

        PageRequest.of(page, quantity, switch (order) {
            case "tituloasc", "precoasc" -> sort.ascending();
            default -> sort.descending();
        });



        return null;
    }

    @Override
    public AnuncioDTO setImagemToAnuncio(Long idAnuncio, Long idImagem) {
        return null;
    }
}
