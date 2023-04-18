package gerenciador.casadeFamilia.casadeFamilia.repository;

import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;

import java.util.List;

public interface FuncionariaRepositoryCustom {
    List<Funcionaria> localizarPorFuncionaria(Funcionaria funcionaria);
}
