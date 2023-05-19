package gerenciador.casadeFamilia.casadeFamilia.service.impl;

import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;
import gerenciador.casadeFamilia.casadeFamilia.service.FuncionariaService;
import gerenciador.casadeFamilia.casadeFamilia.repository.FuncionariaRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Service
public class FuncionariaServiceImpl implements FuncionariaService {

    @Autowired
    private FuncionariaRepository funcionariaRepository;
    @Override
    public Funcionaria incluir(Funcionaria funcionaria){
    this.validarCamposObrigatorios(funcionaria);
    this.validarIdade(funcionaria);
    Funcionaria funcionariaincluida = this.gravarDados(funcionaria);
    return funcionariaincluida;
    }
    private Funcionaria gravarDados(Funcionaria funcionaria) {
        return funcionariaRepository.save(funcionaria);
    }

    private void validarDados(Funcionaria funcionaria) {
        List<String> erros = new ArrayList<>();

        if(!erros.isEmpty()){
            throw  new IllegalArgumentException("Erro ao Validar dados da Funcionaria: "+
                    String.join(",", erros)
            );
        }
    }
    public  static int idade(LocalDate dataNascimento)
    {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        return periodo.getYears();
    }
    private void validarIdade(Funcionaria funcionaria){
        if(idade(funcionaria.getDataNascimento()) < 18)
        {
            throw new IllegalArgumentException("Idade não pode ser menor que 18 anos");
        }
   }
    private void validarCamposObrigatorios(Funcionaria funcionaria) {

        if(Objects.isNull(funcionaria)){
            throw  new IllegalArgumentException("Entidiade Funcionaria deve ser preenchida");
        }
        List<String> camposVazios = new ArrayList<>();
        if(Strings.isEmpty(funcionaria.getNome())){
            camposVazios.add("Primeiro Nome");
        }
        if(Strings.isEmpty(funcionaria.getApelido())){
            camposVazios.add("Apelido");
        }
        if(Strings.isEmpty(funcionaria.getSupervisor())){
            camposVazios.add("Supervisor");
        }
        if((funcionaria.getDataNascimento() == null)){
            camposVazios.add("Data Nascimento");
        }
        if(!camposVazios.isEmpty()) {
            throw  new IllegalArgumentException(
                    "Campos Obrigatórios não preenchidos ("+
                            String.join(",",camposVazios)+")"
            );
        }
    }

    @Override
    public Funcionaria alterar(Funcionaria funcionaria, Long Id) {
        this.validarCamposObrigatorios(funcionaria);
        Funcionaria funcionariaBD = recuperarFuncionariaOuGeraErro(Id);
        funcionaria.setId(Id);
        Funcionaria save = funcionariaRepository.save(funcionaria);
        return save;
    }
    private Funcionaria recuperarFuncionariaOuGeraErro(Long Id) {
        Funcionaria funcionariaBD = funcionariaRepository
                .findById(Id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Erro ao Localizar a Funcionaria!")
                );
        return funcionariaBD;
    }


@Override
public Funcionaria excluir(Long Id){
    Funcionaria funcionariaExcluir = this.recuperarFuncionariaOuGeraErro(Id);
    this.funcionariaRepository.delete(funcionariaExcluir);
    return funcionariaExcluir;
}
    @Override
    public Funcionaria obterFuncionariaPeloId(Long id) {
        return this.recuperarFuncionariaOuGeraErro(id);
    }
    @Override
    public List<Funcionaria> listarTodos(){return funcionariaRepository.findAll();}
    @Override
   public List<Funcionaria> localizar(Funcionaria funcionaria){
        return this.funcionariaRepository.localizarPorFuncionaria(funcionaria);
    }
}

