package com.ufpel.edu.br.gadostalker.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author gustavo
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

// define o DTYPE da classe Funcionario como FUNCIONARIO
@DiscriminatorValue(value = Usuario.TipoUsuario.Tipo.FUNCIONARIO)
public class Funcionario extends Usuario implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FAZENDA_SNCR", nullable = true, referencedColumnName = "SNCR")
    private Fazenda fazenda;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.cpf);
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
        final Funcionario other = (Funcionario) obj;
        return Objects.equals(this.cpf, other.cpf);
    }

}
