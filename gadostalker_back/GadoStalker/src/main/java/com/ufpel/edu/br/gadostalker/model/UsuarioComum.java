package com.ufpel.edu.br.gadostalker.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author thomazio
 */
@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
// define o DTYPE da classe UsuarioComum como USUARIO_COMUM
@DiscriminatorValue(value = Usuario.TipoUsuario.Tipo.USUARIO_COMUM)
public class UsuarioComum extends Usuario implements Serializable {

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
        final UsuarioComum other = (UsuarioComum) obj;
        return Objects.equals(this.cpf, other.cpf);
    }
}
