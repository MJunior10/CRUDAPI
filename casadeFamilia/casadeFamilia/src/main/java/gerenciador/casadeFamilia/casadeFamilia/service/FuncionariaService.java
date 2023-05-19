package gerenciador.casadeFamilia.casadeFamilia.service;

import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;

import java.util.List;

public interface FuncionariaService {

    public Funcionaria incluir(Funcionaria funcionaria);

    public Funcionaria alterar(Funcionaria funcionaria, Long id);

    public Funcionaria excluir(Long id);

    public Funcionaria obterFuncionariaPeloId(Long id);

    public List<Funcionaria> listarTodos();

   public List<Funcionaria> localizar(Funcionaria funcionaria);

}
