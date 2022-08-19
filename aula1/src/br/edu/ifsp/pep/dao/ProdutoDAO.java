package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author aluno
 */
public class ProdutoDAO {
    
    private EntityManagerFactory emf;

    public ProdutoDAO(EntityManagerFactory emf) {
        emf = Persistence.createEntityManagerFactory("aula1PU");
    }

    public ProdutoDAO() {
    }
    
    private EntityManager getEntityManager() {
        
        return this.emf.createEntityManager();
    }
    
    public void inserir(Produto produto){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        em.close();
    }
    
    public void alterar (Produto produto) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Produto> buscar() {
    TypedQuery<Produto> query = getEntityManager().createQuery("SELECT p FROM Produto p", Produto.class);
    
    return query.getResultList();
    }
}
