package br.com.diego.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.diego.entity.Pessoa;

/**
 * 
 * @author Diego Francisco
 *
 */
public class PessoaRepository {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public PessoaRepository() {
        // criei o entityManeger aqui pq neste projeto so tem esse repository
        this.entityManagerFactory = Persistence.createEntityManagerFactory("webServicePessoa_rest_jersey_JPA");
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }

    public void salvar(Pessoa pessoa) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(pessoa);
        this.entityManager.getTransaction().commit();
    }

    public void alterar(Pessoa pessoa) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(pessoa);
        this.entityManager.getTransaction().commit();
    }
    
    public List<Pessoa> buscarTodas(){
        return this.entityManager.createQuery("SELECT p FROM Pessoa p ORDER BY p.id", Pessoa.class).getResultList();
    }
    
    public Pessoa buscarPorId(Integer id){
       return this.entityManager.find(Pessoa.class, id); 
    }

    public void excluir(Integer id) {
        this.entityManager.getTransaction().begin();
        this.entityManager.refresh(buscarPorId(id));
        this.entityManager.getTransaction().commit();
    }
    
}
