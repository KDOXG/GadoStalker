package com.ufpel.edu.br.gadostalker.model;

import lombok.*;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author joaolrezende
 */
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Anuncio implements Serializable {
    @PrimaryKeyColumn(
            type = PrimaryKeyType.PARTITIONED,
            ordering = Ordering.ASCENDING,
            ordinal = 5
    )
    private UUID id;

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED, ordinal = 1)
    private String titulo;
    
    @Column
    private String descricao;

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED, ordinal = 4)
    private BigDecimal preco;
    
    @Column
    private int desconto;
    
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED, ordinal = 2)
    private Long produtoId;

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED, ordinal = 0)
    private Produto.TipoProdutoEnum tipoProduto;

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED, ordinal = 3)
    private Date dataInicial;
    
    @Column
    private Date dataFinal;
    
    @Column
    private boolean isExcluido;
    
    @Column
    private Long imagemId;

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
