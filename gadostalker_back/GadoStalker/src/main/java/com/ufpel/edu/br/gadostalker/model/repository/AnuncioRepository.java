package com.ufpel.edu.br.gadostalker.model.repository;

import com.ufpel.edu.br.gadostalker.model.Anuncio;
import com.ufpel.edu.br.gadostalker.model.Produto;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AnuncioRepository extends CassandraRepository<Anuncio, UUID> {
//    Optional<Anuncio> findById(UUID id);
//    Optional<List<Anuncio>> findAll();
    Optional<List<Anuncio>> findAllByTipoProduto(Produto.TipoProdutoEnum tipoProduto);
    Optional<List<Anuncio>> findAllByTituloContaining(String titulo);
    Optional<List<Anuncio>> findAllByTipoProdutoAndTituloContaining(Produto.TipoProdutoEnum tipoProduto, String titulo);
    Optional<List<Anuncio>> countAll();
    Optional<List<Anuncio>> countAllByTipoProduto(Produto.TipoProdutoEnum tipoProduto);
    Optional<List<Anuncio>> countAllByTituloContaining(String titulo);
    Optional<List<Anuncio>> countAllByTipoProdutoAndTituloContaining(Produto.TipoProdutoEnum tipoProduto, String titulo);

}