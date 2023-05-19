package gerenciador.casadeFamilia.casadeFamilia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "TBL_FUNCIONARIAS")

public class Funcionaria {
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
    @Min(100)
    @Column(name="Valor", nullable = false)
    private Float valorAtendimento;
    @Column(name = "Nascimento", nullable = true)
    private LocalDate dataNascimento;
}