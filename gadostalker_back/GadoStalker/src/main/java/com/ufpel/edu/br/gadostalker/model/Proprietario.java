package com.ufpel.edu.br.gadostalker.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

// define o DTYPE da classe Proprietario como PROPRIETARIO
@DiscriminatorValue(value = Usuario.TipoUsuario.Tipo.PROPRIETARIO)
public class Proprietario extends Usuario implements Serializable {
    
    @OneToMany(mappedBy = "proprietario", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="proprietarioid")
    private List<Fazenda> fazendas = new ArrayList<>();

    public Proprietario addFazenda(Fazenda fazenda) {
        fazendas.add(fazenda);
        
        return this;
    }
    
    public Proprietario removeFazenda(Fazenda fazenda) {
        fazendas.remove(fazenda);
        
        return this;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.cpf);
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
        final Proprietario other = (Proprietario) obj;
        return Objects.equals(this.cpf, other.cpf);
    }

}
