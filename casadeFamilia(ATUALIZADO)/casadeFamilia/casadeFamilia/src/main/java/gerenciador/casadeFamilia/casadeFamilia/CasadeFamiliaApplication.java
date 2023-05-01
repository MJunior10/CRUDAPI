package gerenciador.casadeFamilia.casadeFamilia;

import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;
import gerenciador.casadeFamilia.casadeFamilia.repository.FuncionariaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EntityScan(basePackageClasses = { Jsr310JpaConverters.class }, basePackages = "gerenciador.casadeFamilia.*")
public class CasadeFamiliaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasadeFamiliaApplication.class, args);
	}

	private static void imprimirLista(FuncionariaRepository funcionariaRepository) {
		List<Funcionaria> lista = funcionariaRepository.findAll();
		lista.forEach(item ->{
			System.out.println("funcionariaRepository:"+item);
		});
	}

}
