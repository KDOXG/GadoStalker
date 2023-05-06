package com.ufpel.edu.br.gadostalker.controller;

import com.ufpel.edu.br.gadostalker.dto.AnuncioDTO;
import com.ufpel.edu.br.gadostalker.service.AnuncioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author thomazio
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/anuncio")
public class AnuncioController {
    private final AnuncioServiceImpl anuncioService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AnuncioDTO cadastraAnuncio(AnuncioDTO anuncioDTO) {
        return anuncioService.newAnuncio(anuncioDTO);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AnuncioDTO editarAnuncio(@PathVariable("id") Long id, AnuncioDTO anuncioDTO) {
        return anuncioService.editAnuncio(id, anuncioDTO);
    }

    @PutMapping("/encerra/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AnuncioDTO encerraAnuncio(@PathVariable("id") Long id) {
        return anuncioService.endAnuncio(id);
    }

    @PutMapping("/reabre/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AnuncioDTO reabreAnuncio(@PathVariable("id") Long id) {
        return anuncioService.reopenAnuncio(id);
    }

    @DeleteMapping("/deleta/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean deletaAnuncio(@PathVariable("id") Long id) {
        return anuncioService.deleteAnuncio(id);
    }

    @GetMapping("getAnuncioID/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AnuncioDTO getAnuncioID(@PathVariable("id") Long id) {
        return anuncioService.getAnuncioByID(id);
    }

    @GetMapping("getAllAnunciosByProprietarioCPF/{cpf}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<AnuncioDTO> anunciosProprietario(@PathVariable("cpf") String cpf) {
        return anuncioService.getAnunciosByProprietarioCpf(cpf);
    }

    @GetMapping("/pesquisa")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<AnuncioDTO> pesquisaAnuncios(@RequestParam("tipo") String tipo,
                                     @RequestParam(name = "page", defaultValue = "1") Integer page,
                                     @RequestParam(name = "order", defaultValue = "datadesc") String order,
                                     @RequestParam(name = "qnt", defaultValue = "0") Integer quantity,
                                     @RequestParam("search") String search,
                                     @RequestParam(name = "count", defaultValue = "false") Boolean count) {
        return anuncioService.search(tipo, page, order, quantity, search, count);
    }

    @GetMapping("/setImagemToAnuncio/{idAnuncio}/{idImagem}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AnuncioDTO setImagemToAnuncio(@PathVariable("idAnuncio") Long idAnuncio, @PathVariable("idImagem") Long idImagem) {
        return anuncioService.setImagemToAnuncio(idAnuncio, idImagem);
    }
}