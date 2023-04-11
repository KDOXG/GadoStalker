package com.ufpel.edu.br.gadostalker.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author fernandOlle
 */
@Entity
@Table(name = "produto")
@SequenceGenerator(name = "seqProduto", sequenceName = "SEQPRODUTO", allocationSize = 1)
@NamedQuery(name = "Produto.getAllProdutosByTipo", query = "SELECT p FROM Produto p WHERE p.tipo = :tipo")
public class Produto implements Serializable {

    public enum TipoProdutoEnum {
        MEL("Mel"),
        OVO("Ovo"),
        ALFACE("Alface"),
        FEIJAO("Feijão"),
        LEITE("Leite"),
        MILHO("Milho"),
        SOJA("Soja"),
        TOMATE("Tomate"),
        VAGEM("Vagem"),
        ARROZ("Arroz"),
        BANANA("Banana"),
        QUEIJO("Queijo"),
        GELEIA("Geleia"),
        LARANJA("Laranja"),
        UVA("Uva");
        
        private final String tipo;

        private TipoProdutoEnum(String tipo) {
            this.tipo = tipo;
        }

        public String getTipo() {
            return tipo;
        }
    };

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqProduto")
    private Long id;

    @Column
    private String nome;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private TipoProdutoEnum tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FAZENDA_SNCR", nullable = true, referencedColumnName = "SNCR")
    private Fazenda fazenda;

    @Column(precision = 10, scale = 2)
    private BigDecimal quantidade;

    public Produto() {
    }

    public Produto(String nome, TipoProdutoEnum tipo, Fazenda fazenda, BigDecimal quantidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.fazenda = fazenda;
        this.quantidade = quantidade;
    }

    public Produto(ProdutoDTO produtoDTO) {
        this.nome = produtoDTO.nome;
        this.tipo = produtoDTO.tipo;
        this.quantidade = produtoDTO.quantidade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoProdutoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoProdutoEnum tipo) {
        this.tipo = tipo;
    }

    public Fazenda getFazenda() {
        return fazenda;
    }

    public void setFazenda(Fazenda fazenda) {
        this.fazenda = fazenda;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", fazenda=" + fazenda + ", quantidade=" + quantidade + ", dataInicial=" + '}';
    }

}
