package com.ufpel.edu.br.gadostalker.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author joaolrezende
 */
@Entity
@Table(name = "anuncio")
@SequenceGenerator(name = "seqAnuncio", sequenceName = "SEQANUNCIO", allocationSize = 1)
@NamedQuery(name = "Anuncio.getAllAnunciosQueContemProduto", query = "SELECT a FROM Anuncio a WHERE a.produto.tipo = :tipo")
//@NamedQuery(name = "Anuncio.getAllAnunciosQueContemProduto", query = "SELECT a FROM Anuncio a INNER JOIN a.produtos p "
//        + "WHERE EXISTS (SELECT p2 FROM Produto p2 WHERE p2.tipo = :tipo)")
public class Anuncio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqAnuncio")
    private Long id;

    @Column
    private String titulo;
    
    @Column
    private String descricao;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal preco;
    
    @Column
    private int desconto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    //@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PRODUTOID", nullable = true, referencedColumnName = "id")
    private Produto produto;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataInicial;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataFinal;
    
    @Column
    private boolean isExcluido;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IMAGEMID")
    private Imagem imagem;

    public Anuncio() {
    }

    public Anuncio(String titulo, String descricao, BigDecimal preco, int desconto, Produto produto, Date dataInicial, Date dataFinal, boolean excluido) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.desconto = desconto;
        this.produto = produto;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.isExcluido = excluido;
    }
    
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public Produto getProduto() {
        return produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }

    public boolean isIsExcluido() {
        return isExcluido;
    }

    public void setIsExcluido(boolean isExcluido) {
        this.isExcluido = isExcluido;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Anuncio other = (Anuncio) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "com.ufpel.cs.gadostalker.rest.entity.Anuncio[ id=" + id + " ]";
    }
    
}
