package gerenciador.casadeFamilia.casadeFamilia.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

public @Data class FuncionariaDTO {
    private Long id;
    private String nome;
    private String apelido;
    private String especialidade;
    private String supervisor;
    private Float valorAtendimento;
    private LocalDate dataNascimento;
}
