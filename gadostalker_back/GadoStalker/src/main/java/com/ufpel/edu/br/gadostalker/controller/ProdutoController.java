package com.ufpel.edu.br.gadostalker.controller;

import com.ufpel.edu.br.gadostalker.dto.ProdutoDTO;
import com.ufpel.edu.br.gadostalker.model.Produto;
import com.ufpel.edu.br.gadostalker.service.FazendaServiceImpl;
import com.ufpel.edu.br.gadostalker.service.ProdutoService;
import com.ufpel.edu.br.gadostalker.service.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class ProdutoController {
    private final UsuarioServiceImpl usuarioService;
    private final FazendaServiceImpl fazendaService;
    private final ProdutoService produtoService;

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProdutoDTO adicionarProduto(ProdutoDTO produtoDTO) {
        return produtoService.addProduto(produtoDTO);
    }

    @GetMapping("/getAllProdutosByFazendaSNCR/{sncr}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<Produto.TipoProdutoEnum, String> getAllProdutosFazenda(@PathVariable("sncr") String sncr) {
        return produtoService.findAllProdutosByFazendaSncr(sncr);
    }

    @GetMapping("/getAllProdutosByTypeAndSncr/{tipo}/{sncr}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<ProdutoDTO> consultarProdutoPorTipo(@PathVariable("tipo") Produto.TipoProdutoEnum tipo, @PathVariable("sncr") String sncr) {
        return produtoService.findAllProdutosByTypeAndSncr(tipo, sncr);
    }

    @GetMapping("/consultar/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProdutoDTO consultarProduto(@PathVariable("id") Long id) {
        return produtoService.findProdutoById(id);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProdutoDTO editarProduto(ProdutoDTO produtoDTO, @PathVariable("id") Long id) {
        return produtoService.editProduto(produtoDTO, id);
    }

    @GetMapping("/remover/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean removerProduto(@PathVariable("id") Long id) {
        return produtoService.deleteProduto(id);
    }

    @GetMapping("/getAllTiposProdutos")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<Produto.TipoProdutoEnum, String> getAllTiposProdutos() {
        return produtoService.findAllTiposProdutos();
    }

    @GetMapping("/getAllProdutosByProprietarioCpf/{cpf}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<ProdutoDTO> getAllProdutosProprietario(@PathVariable("cpf") String cpf) {
        return produtoService.findAllProdutosByProprietarioCpf(cpf);
    }
}
