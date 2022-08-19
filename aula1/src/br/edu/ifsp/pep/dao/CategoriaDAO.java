package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Categoria;
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
public class CategoriaDAO {
    
    private EntityManagerFactory emf;

    public CategoriaDAO(EntityManagerFactory emf) {
        emf = Persistence.createEntityManagerFactory("aula1PU");
    }

    public CategoriaDAO() {
    }
    
    private EntityManager getEntityManager() {
        
        return this.emf.createEntityManager();
    }
    
    public void inserir(Categoria categoria){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(categoria);
        em.getTransaction().commit();
        em.close();
    }
    
    public void alterar (Categoria categoria) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(categoria);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Categoria> buscar() {
    TypedQuery<Categoria> query = getEntityManager().createQuery("SELECT p FROM Produto p", Categoria.class);
    
    return query.getResultList();
    }
}
