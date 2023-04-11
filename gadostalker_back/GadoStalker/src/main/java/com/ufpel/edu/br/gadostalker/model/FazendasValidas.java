package com.ufpel.edu.br.gadostalker.model;

import jakarta.persistence.*;
import lombok.*;

/**
 *
 * @author thouta
 */
@Entity
@Table(name = "fazendas_validas")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seqFazendasValidas", sequenceName = "SEQFAZENDASVALIDAS", allocationSize = 1)
public class FazendasValidas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqFazendasValidas")
    private Long id;
    
    @Column(unique = true)
    private String SNCR;
}
