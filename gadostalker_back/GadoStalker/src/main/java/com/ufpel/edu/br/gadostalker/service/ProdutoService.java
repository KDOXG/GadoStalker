package com.ufpel.edu.br.gadostalker.service;

import com.ufpel.edu.br.gadostalker.dto.ProdutoDTO;
import com.ufpel.edu.br.gadostalker.model.Produto;

import java.util.List;
import java.util.Map;

public interface ProdutoService {
    ProdutoDTO addProduto(ProdutoDTO produtoDTO);
    Map<Produto.TipoProdutoEnum, String> findAllProdutosByFazendaSncr(String sncr);
    List<ProdutoDTO> findAllProdutosByTypeAndSncr(Produto.TipoProdutoEnum tipo, String sncr);
    ProdutoDTO findProdutoById(Long id);
    ProdutoDTO editProduto(ProdutoDTO produtoDTO, Long id);
    Boolean deleteProduto(Long id);
    Map<Produto.TipoProdutoEnum, String> findAllProdutos();
    List<ProdutoDTO> findAllProdutosByProprietarioCpf(String cpf);
}
