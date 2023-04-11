package com.ufpel.edu.br.gadostalker.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author thomazio
 */
@Entity
@Table(name = "transacao")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seqTransacao", sequenceName = "SEQTRANSACAO", allocationSize = 1)
public class Transacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqTransacao")
    private Long id;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataTransacao;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal preco;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ANUNCIOID", nullable = true, referencedColumnName = "id")
    private Anuncio anuncio;
    
    @Column
    private int quantidade;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Transacao other = (Transacao) obj;
        return Objects.equals(this.id, other.id);
    }
    
    @Override
    public String toString() {
        return "com.ufpel.edu.br.gadostalker.rest.entity.Transacao[ id=" + id + " ]";
    }
    
}
