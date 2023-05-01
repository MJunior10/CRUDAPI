package gerenciador.casadeFamilia.casadeFamilia.repository.impl;

import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;
import gerenciador.casadeFamilia.casadeFamilia.repository.FuncionariaRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuncionariaRepositoryImpl implements FuncionariaRepositoryCustom{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Funcionaria> localizarPorFuncionaria(Funcionaria funcionaria) {
        Map<String, Object> parametros = new HashMap<>();
        StringBuilder jpql = new StringBuilder();
        jpql.append(" SELECT funcionaria FROM Funcionaria funcionaria");

        jpql.append(" WHERE 1=1 ");

        if (Strings.isNotEmpty(funcionaria.getNome())) {
            jpql.append(" AND UPPER(funcionaria.nome) LIKE UPPER('%' || :nome || '%')  ");
            parametros.put("nome", funcionaria.getNome());
        }
        if (Strings.isNotEmpty(funcionaria.getApelido())) {
            jpql.append(" AND UPPER(funcionaria.apelido) LIKE UPPER('%' || :apelido || '%')  ");
            parametros.put("apelido", funcionaria.getApelido());
        }

        TypedQuery<Funcionaria> query = entityManager.createQuery(jpql.toString(), Funcionaria.class);
        parametros.entrySet().forEach(parametro -> query.setParameter(parametro.getKey(), parametro.getValue()));
        return query.getResultList();
    }
}
