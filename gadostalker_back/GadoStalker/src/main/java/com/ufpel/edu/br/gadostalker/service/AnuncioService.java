package com.ufpel.edu.br.gadostalker.service;

import com.ufpel.edu.br.gadostalker.dto.AnuncioDTO;

import java.util.List;
import java.util.UUID;

public interface AnuncioService {
    AnuncioDTO newAnuncio(AnuncioDTO anuncioDTO);
    AnuncioDTO editAnuncio(Long id, AnuncioDTO anuncioDTO);
    AnuncioDTO endAnuncio(Long id);
    AnuncioDTO reopenAnuncio(Long id);
    Boolean deleteAnuncio(Long id);
    AnuncioDTO getAnuncioByID(UUID id);
    List<AnuncioDTO> getAnunciosByProprietarioCpf(String cpf);
    List<AnuncioDTO> search(String tipo, Integer page, String order, Integer quantity, String search, Boolean count);
    AnuncioDTO setImagemToAnuncio(Long idAnuncio, Long idImagem);

}
