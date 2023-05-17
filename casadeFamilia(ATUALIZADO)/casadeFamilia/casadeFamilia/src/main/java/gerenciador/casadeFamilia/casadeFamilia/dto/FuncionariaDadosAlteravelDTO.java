package gerenciador.casadeFamilia.casadeFamilia.dto;

import lombok.Data;

import java.time.LocalDate;

public @Data  class FuncionariaDadosAlteravelDTO {
    private String nome;
    private String apelido;
    private String especialidade;
    private String supervisor;
    private Float valorAtendimento;
    private LocalDate dataNascimento;
}
