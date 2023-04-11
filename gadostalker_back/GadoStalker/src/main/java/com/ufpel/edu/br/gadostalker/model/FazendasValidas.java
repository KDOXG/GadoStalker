package com.ufpel.edu.br.gadostalker.model;

import jakarta.persistence.*;
import lombok.*;

/**
 *
 * @author thouta
 */
@Entity
@Table(name = "fazendas_validas")
@SequenceGenerator(name = "seqFazendasValidas", sequenceName = "SEQFAZENDASVALIDAS", allocationSize = 1)
public class FazendasValidas implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqFazendasValidas")
    private Long id;
    
    @Column(unique = true)
    private String SNCR;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSNCR() {
        return SNCR;
    }

    public void setSNCR(String SNCR) {
        this.SNCR = SNCR;
    }
}
