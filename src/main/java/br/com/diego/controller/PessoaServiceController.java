package br.com.diego.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.diego.entity.Pessoa;
import br.com.diego.http.dto.PessoaDTO;
import br.com.diego.repository.PessoaRepository;

/**
 * 
 * @author Diego Francisco
 * 
 * Essa classe vai expor os nossos métodos para serem acessasdos via http
 *
 * @Path - Caminho para a chamada da classe que vai representar o nosso serviço
 *
 */
@Path("/pessoasevice")
public class PessoaServiceController {

    private final PessoaRepository repository = new PessoaRepository();

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastar")
    public String cadastrar(PessoaDTO dto) {

        Pessoa pessoa = new Pessoa();

        try {
            pessoa.setNome(dto.getNome());
            pessoa.setSexo(dto.getSexo());
            pessoa.setCpf(dto.getCpf());
            this.repository.salvar(pessoa);

            return "Cadastro realizado com sucesso !";

        } catch (Exception e) {
            return "Erro ao cadastrar a pessoa " + e.getMessage();
        }

    }
    
    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String alterar(PessoaDTO dto) {
        
        Pessoa pessoa = new Pessoa();
        
        try {
            pessoa.setNome(dto.getNome());
            pessoa.setSexo(dto.getSexo());
            pessoa.setCpf(dto.getCpf());
            this.repository.alterar(pessoa);
            
            return "Alteração realizada com sucesso !";
            
        } catch (Exception e) {
            return "Erro ao alterar a pessoa " + e.getMessage();
        }
        
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/buscartodas")
    public List<PessoaDTO> buscarTodas() {

        List<PessoaDTO> pessoas = new ArrayList<PessoaDTO>();

        for (Pessoa pessoa : this.repository.buscarTodas()) {
            pessoas.add(new PessoaDTO(pessoa));
        }

        return pessoas;
    }
    
    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{codigo}")      
    public String excluir(@PathParam("codigo") Integer codigo) {

        try {
            this.repository.excluir(codigo);
            return "Registro excluido com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }
    
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/buscarPorId/{codigo}")
    public PessoaDTO buscarPorId(@PathParam("codigo") Integer codigo) {

        Pessoa entity = repository.buscarPorId(codigo);

        if (entity != null)
            return new PessoaDTO(entity);

        return null;
    }

}
