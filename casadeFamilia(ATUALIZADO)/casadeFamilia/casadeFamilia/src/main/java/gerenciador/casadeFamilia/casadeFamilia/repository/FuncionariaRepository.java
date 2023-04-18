package gerenciador.casadeFamilia.casadeFamilia.repository;

import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionariaRepository extends JpaRepository<Funcionaria, Long>, FuncionariaRepositoryCustom {

    Optional<Funcionaria> findFuncionariaByApelido(String apelido);

    @Query(value = "select count(a) from Funcionaria a where a.apelido=:paramapelido")
    Integer countUtilizacaoApelido(String paramapelido);
}
