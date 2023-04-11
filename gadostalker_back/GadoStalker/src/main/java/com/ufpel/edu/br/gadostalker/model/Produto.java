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
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

        TipoProdutoEnum(String tipo) {
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
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", fazenda=" + fazenda + ", quantidade=" + quantidade + ", dataInicial=" + '}';
    }

}
