package gerenciador.casadeFamilia.casadeFamilia.mapper;

import gerenciador.casadeFamilia.casadeFamilia.dto.FuncionariaDTO;
import gerenciador.casadeFamilia.casadeFamilia.dto.FuncionariaDadosAlteravelDTO;
import gerenciador.casadeFamilia.casadeFamilia.dto.FuncionariaListaDTO;
import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FuncionariaMapper {

    /**
     * Converte a entidade {@link Funcionaria} em {@link FuncionariaListaDTO}
     * @param funcionaria
     * @return
     */

    public FuncionariaListaDTO toDTO(Funcionaria funcionaria);

    public List<FuncionariaListaDTO> toDTO(List<Funcionaria> funcionarias);

    public FuncionariaDadosAlteravelDTO toFuncionariaIncluirDTO(Funcionaria funcionaria);

    public Funcionaria toModelo(FuncionariaDadosAlteravelDTO funcionaria);

    public FuncionariaDTO toFuncionariaDTO(Funcionaria funcionaria);

    public Funcionaria toModelo(FuncionariaDTO funcionaria);

}
