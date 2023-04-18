package gerenciador.casadeFamilia.casadeFamilia.dto;

import lombok.Data;

public @Data  class FuncionariaDadosAlteravelDTO {
    private String nome;
    private String apelido;
    private String especialidade;
    private String supervisor;
    private Float valorAtendimento;
}
