package gerenciador.casadeFamilia.casadeFamilia.controller;

import gerenciador.casadeFamilia.casadeFamilia.dto.FuncionariaDTO;
import gerenciador.casadeFamilia.casadeFamilia.dto.FuncionariaDadosAlteravelDTO;
import gerenciador.casadeFamilia.casadeFamilia.dto.FuncionariaListaDTO;
import gerenciador.casadeFamilia.casadeFamilia.mapper.FuncionariaMapper;
import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;
//import io.swagger.annotations.Api;
import gerenciador.casadeFamilia.casadeFamilia.service.FuncionariaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.Id;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/${app.api.version}/funcionaria")
public class FuncionariaController {

    @Autowired
    private FuncionariaMapper funcionariaMapper;

    @Autowired
    private FuncionariaService funcionariaService;

    @GetMapping()
    @Operation(description = "Listagem geral de Funcionarias" )
    public List<FuncionariaListaDTO> listAll(){
        List<Funcionaria> funcionarias = funcionariaService.listarTodos();
        return funcionariaMapper.toDTO(funcionarias);
    }

    @PostMapping
    @Operation(description = "Metodo utilizado para realizar a inclusão de uma Funcionaria" )
    public FuncionariaDTO incluir(@RequestBody FuncionariaDadosAlteravelDTO funcionaria)
    {
        //preparando entrada
        Funcionaria funcionariaIncluir = this.funcionariaMapper.toModelo(funcionaria);

        // chamada de serviço
        System.out.println(funcionariaIncluir);
        funcionariaIncluir = this.funcionariaService.incluir(funcionariaIncluir);

        // prepando retorno
        FuncionariaDTO retorno = this.funcionariaMapper.toFuncionariaDTO(funcionariaIncluir);
        return retorno;
    }
    @PutMapping(path="/{id}")
    @Operation (description = "Metodo utilizado para alterar dados de uma Funcionaria")
    public FuncionariaDTO alterar(@RequestBody() FuncionariaDadosAlteravelDTO funcionaria, @PathVariable(name = "id") Long id){
    Funcionaria pFuncionaria = funcionariaMapper.toModelo(funcionaria);
    Funcionaria alterar = funcionariaService.alterar(pFuncionaria, id);
    return funcionariaMapper.toFuncionariaDTO(alterar);
    }
    @DeleteMapping(path ="/{id}")
    @Operation(description = "Método utililzado para remover uma funcionaria pelo ID informada")
    public FuncionariaDTO remover(@PathVariable(name = "id") Long id){
        Funcionaria funcionariaExcluida = this.funcionariaService.excluir(id);
        return funcionariaMapper.toFuncionariaDTO(funcionariaExcluida);
    }

    @GetMapping(path = "/{id}")
    @Operation(description = "Obter os dados completos de uma funcionaria pelo ID informado!")
    public FuncionariaDTO ObterPorId(@PathVariable(name = "id") Long id){
        Funcionaria funcionaria = this.funcionariaService.obterFuncionariaPeloId(id);
        return this.funcionariaMapper.toFuncionariaDTO(funcionaria);
    }

    @PostMapping(path = "/pesquisar")
    @Operation(description = "Busca funcionaria pelos dados informados")
    public List<FuncionariaListaDTO> pesquisar(
            @RequestBody FuncionariaDTO funcionaria
    ){
        Funcionaria funcionariaBusca = this.funcionariaMapper.toModelo(funcionaria);
        List<Funcionaria> localizar = funcionariaService.localizar(funcionariaBusca);
        return this.funcionariaMapper.toDTO(localizar);
    }
    }
