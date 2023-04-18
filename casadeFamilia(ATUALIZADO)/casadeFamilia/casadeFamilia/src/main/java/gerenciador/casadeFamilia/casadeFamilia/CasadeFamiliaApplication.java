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

	@Bean
	public CommandLineRunner commandLineRunner(FuncionariaRepository funcionariaRepository)
	{
		return args -> {
			System.out.println("Executado");
			System.out.println(funcionariaRepository);
			Funcionaria q1 = new Funcionaria();
			q1.setNome("Ester");
			q1.setApelido("Tigresa VIP");
			q1.setEspecialidade("Folhinha Verde");
			q1.setValorAtendimento(100.00F);

			try {
				funcionariaRepository.save(q1);
			}catch (Exception e)
			{
				e.printStackTrace();
			}
			q1.setId(1L);
			funcionariaRepository.save(q1);
			System.out.println("funcionariaRepository:"+q1);
			q1.setSupervisor("Um Cafetão chamado Maciota");
			funcionariaRepository.save(q1);
			System.out.println("Funcionaria2:"+q1);

			q1.setId(2L);
			q1.setNome("Raquel");
			q1.setApelido("Pantera");
			boolean apelido_duplicado = false;
			Integer totalUsoEmail = funcionariaRepository.countUtilizacaoApelido(q1.getApelido());
			if(totalUsoEmail>0){
				System.out.println("O Apelido:"+q1.getApelido()+" não pode ser utilizado!!");
				System.out.println("Total de utilização: "+totalUsoEmail);
			}else{
				funcionariaRepository.save(q1);
			}

			Optional<Funcionaria> funcionariaByApelido = funcionariaRepository.findFuncionariaByApelido(q1.getApelido());
			if(funcionariaByApelido.isPresent()){
				Funcionaria funcionaria = funcionariaByApelido.get();
				System.out.println("Não é possível utilizar o Apelido:"+q1.getApelido());
				System.out.println("Porque ele pertence a Funcionaria:"+funcionaria.getApelido());
			}else{
				q1 = funcionariaRepository.save(q1);
			}
			try {
				q1 = funcionariaRepository.save(q1);
			} catch (Exception e){
				System.out.println(e.getMessage());
				apelido_duplicado = e.getMessage().contains(Funcionaria.UK_FUNCIONARIA_APELIDO);
			}
			if(apelido_duplicado){
				System.out.println("Apelido duplicado:"+ q1.getApelido());
			}

			System.out.println("Funcionaria2:"+q1);
			imprimirLista(funcionariaRepository);
			funcionariaRepository.delete(q1);
			imprimirLista(funcionariaRepository);
		};
	}

	private static void imprimirLista(FuncionariaRepository funcionariaRepository) {
		List<Funcionaria> lista = funcionariaRepository.findAll();
		lista.forEach(item ->{
			System.out.println("funcionariaRepository:"+item);
		});
	}

}
