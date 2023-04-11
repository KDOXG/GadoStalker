package com.ufpel.edu.br.gadostalker.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seqUsuario", sequenceName = "SEQUSUARIO", allocationSize = 1)
@NamedQuery(name = "Usuario.login", query = "SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha")

/**
 * DiscriminatorColumn -> permite fazer a juncao da coluna DTYPE gerada pelo JPA com o enum de tipo de usuario
 * a annotation nao permite enum como tipo, entao precisa fazer uns esqueminhas
 * o uso dessa annotation nao muda em nada o uso dos endpoints, todos os endpoints criados ate entao continuam funcionando igualmente
 */
@DiscriminatorColumn(name = "TIPO_USUARIO", discriminatorType = DiscriminatorType.STRING)
public class Usuario implements Serializable {

    public enum PerguntaSegurancaEnum {
        PROFESSORA("Nome primeira professora?"),
        COMIDA("Qual é a sua comida favorita?"),
        ANIMAL("Nome do seu primeiro animal de estimação?"),
        AMIGO("Nome do seu melhor amigo de infância?");
        private final String pergunta;

        PerguntaSegurancaEnum(String pergunta) {
            this.pergunta = pergunta;
        }

        public String getPergunta() {
            return pergunta;
        }
    }

    /**
     * pra conseguir fazer a juncao da tabela DTYPE com o enum de tipo é necessario criar constantes,
     * ja que apenas constantes sao permitidas como DTYPE
     * a classe Tipo dentro do enum encapsula essas constantes
     */
    public enum TipoUsuario {
        PROPRIETARIO(Tipo.PROPRIETARIO),
        FUNCIONARIO(Tipo.FUNCIONARIO),
        USUARIO_COMUM(Tipo.USUARIO_COMUM);

        private TipoUsuario(String val) {
            if (!this.name().equals(val)) {
                throw new IllegalArgumentException("Valor do Enum deve ser igual ao da constante");
            }
        }

        public static class Tipo {

            public static final String PROPRIETARIO = "PROPRIETARIO";
            public static final String FUNCIONARIO = "FUNCIONARIO";
            public static final String USUARIO_COMUM = "USUARIO_COMUM";
        }
    }

    @Id
    protected String cpf;

    @Column
    protected String nome;

    @Column
    protected String telefone;

    @Column
    protected String senha;

    @Column
    @Enumerated(EnumType.ORDINAL)
    protected PerguntaSegurancaEnum pergunta;

    @Column
    protected String resposta;

    @Column(unique = true)
    protected String email;

    // tipo do enum precisa ser string
    @Column(name = "tipo_usuario", nullable = false, insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    protected TipoUsuario tipoUsuario;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.cpf);
        hash = 41 * hash + Objects.hashCode(this.cpf);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.cpf, other.cpf);
    }
}
