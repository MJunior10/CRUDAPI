package gerenciador.casadeFamilia.casadeFamilia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "TBL_FUNCIONARIAS",
        uniqueConstraints = {
         @UniqueConstraint(name= Funcionaria.UK_FUNCIONARIA_APELIDO, columnNames = "apelido" )
})

public class Funcionaria {
    public static final String UK_FUNCIONARIA_APELIDO = "uk_funcionaria_apelido";
    @SequenceGenerator(
            name="f_gerador_sequence",
            sequenceName = "amigo_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "f_gerador_sequence"
    )
    @Id
    @Column(name="codigo")
    private Long id;
    @Column(name = "nome", length = 200, nullable = false)
    private String nome;
    @Column(name="apelido", length = 200, nullable = false)
    private String apelido;
    @Column(name = "especialidade", length = 300)
    private String especialidade;
    @Column(name="supervisor",length = 200, nullable = false)
    private String supervisor;
    @Column(name="Valor", nullable = false)
    private Float valorAtendimento;
}