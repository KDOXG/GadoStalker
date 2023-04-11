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
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seqAnuncio", sequenceName = "SEQANUNCIO", allocationSize = 1)
@NamedQuery(name = "Anuncio.getAllAnunciosQueContemProduto", query = "SELECT a FROM Anuncio a WHERE a.produto.tipo = :tipo")
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
        return "com.ufpel.edu.br.gadostalker.rest.entity.Anuncio[ id=" + id + " ]";
    }
    
}
