package com.ufpel.edu.br.gadostalker.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author thomazio
 */
@Entity
@Table(name = "fazenda")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seqFazenda", sequenceName = "SEQFAZENDA", allocationSize = 1)
@NamedQueries({
    @NamedQuery(name = "Fazenda.getAllProdutos", query = "SELECT p FROM Fazenda f INNER JOIN f.produtos p WHERE f.SNCR = :sncr"),
    @NamedQuery(name = "Fazenda.getAllProdutosByTipo", query = "SELECT p FROM Fazenda f INNER JOIN f.produtos p where f.SNCR = :sncr and p.tipo = :tipo")
})
public class Fazenda implements Serializable {

    @Id
    private String SNCR;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String telefone;
    
    @Column
    private Boolean isZapZap;
    
    @OneToMany(mappedBy = "fazenda", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "FAZENDA_SNCR")
    private List<Produto> produtos;
    
    @ManyToOne(cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
    private Proprietario proprietario;
    
    @OneToMany(mappedBy = "fazenda", cascade={CascadeType.MERGE, CascadeType.REMOVE}, fetch=FetchType.LAZY)
    @JoinColumn(name="fazendaid")
    private List<Funcionario> funcionarios;
    
    public void addProduto(Produto produto) {
        produtos.add(produto);
    }
    
    public void removeProduto(Produto produto) {
        produtos.remove(produto);
    }
    
    public void addFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }
    
    public void removeFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.SNCR);
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
        final Fazenda other = (Fazenda) obj;
        return Objects.equals(this.SNCR, other.SNCR);
    }

    @Override
    public String toString() {
        return "com.ufpel.edu.br.gadostalker.rest.entity.Fazenda[ SNCR=" + SNCR + " ]";
    }
}
