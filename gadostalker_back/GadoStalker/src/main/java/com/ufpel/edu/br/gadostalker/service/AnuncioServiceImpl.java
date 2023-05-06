package com.ufpel.edu.br.gadostalker.service;

import com.ufpel.edu.br.gadostalker.dto.AnuncioDTO;

import java.util.List;

public class AnuncioServiceImpl implements AnuncioService {
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
    public AnuncioDTO getAnuncioByID(Long id) {
        return null;
    }

    @Override
    public List<AnuncioDTO> getAnunciosByProprietarioCpf(String cpf) {
        return null;
    }

    @Override
    public List<AnuncioDTO> search(String tipo, Integer page, String order, Integer quantity, String search, Boolean count) {
        return null;
    }

    @Override
    public AnuncioDTO setImagemToAnuncio(Long idAnuncio, Long idImagem) {
        return null;
    }
}
