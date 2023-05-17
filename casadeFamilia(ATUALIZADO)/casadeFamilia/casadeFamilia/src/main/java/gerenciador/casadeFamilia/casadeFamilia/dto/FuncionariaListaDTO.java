package gerenciador.casadeFamilia.casadeFamilia.dto;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

public @Data class FuncionariaListaDTO {
    private Long id;
    private String nome;
    private String apelido;
    private Float valorAtendimento;
    private LocalDate dataNascimento;
}
