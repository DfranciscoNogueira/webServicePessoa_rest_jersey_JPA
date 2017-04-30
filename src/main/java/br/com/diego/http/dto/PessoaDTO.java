package br.com.diego.http.dto;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.diego.entity.Pessoa;

/**
 * 
 * Esta classe e utilizada para o envio e retorno de dados via request e
 * response.
 * 
 * @author Diego Francisco
 *
 */
@XmlRootElement
public class PessoaDTO {

    private Integer id;

    private String nome;

    private String sexo;

    private String cpf;
    
    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.sexo = pessoa.getSexo();
        this.cpf = pessoa.getCpf();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
