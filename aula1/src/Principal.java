
import br.edu.ifsp.pep.modelo.Pessoa;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aluno
 */
public class Principal {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("aula1PU");
        
        
        Pessoa p1 = new Pessoa();
        p1.setDataNascimento(new Date());
        p1.setNome("César");
        p1.setSalario(new BigDecimal(555.999999d));
        p1.setEmail("cesar@ifsp.edu.br");
        p1.setLogradouro("X");
        p1.setNumero(1);

        Pessoa p2 = new Pessoa();
        p2.setDataNascimento(new Date());
        p2.setNome("Ana");
        p2.setSalario(new BigDecimal(555.999999d));
        p2.setEmail("ana@ifsp.edu.br");
        p2.setLogradouro("X");
        p2.setNumero(2);

        Pessoa p3 = new Pessoa();
        p3.setDataNascimento(new Date());
        p3.setNome("José");
        p3.setSalario(new BigDecimal(555.999999d));
        p3.setEmail("jose@ifsp.edu.br");
        p3.setLogradouro("Y");
        p3.setNumero(1);
        
        //TEM QUE FALHAR POR CAUSA DO E-MAIL
//        Pessoa p4 = new Pessoa();
//        p4.setDataNascimento(new Date());
//        p4.setNome("José");
//        p4.setSalario(new BigDecimal(555.999999d));
//        p4.setEmail("cesar@ifsp.edu.br");
//        p4.setLogradouro("X");
//        p4.setNumero(3);
        
        //TEM QUE FALHAR POR CAUSA DO LOGRADOURO E NÚMERO
//        Pessoa p5 = new Pessoa();
//        p5.setDataNascimento(new Date());
//        p5.setNome("José");
//        p5.setSalario(new BigDecimal(555.999999d));
//        p5.setEmail("maria@ifsp.edu.br");
//        p5.setLogradouro("X");
//        p5.setNumero(1);
        
        

        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin(); //inicia uma transação
        
//        em.persist(pessoa);//insert
        em.merge(p1); //update se o objeto existir, senão faz o insert
        em.merge(p2); //update se o objeto existir, senão faz o insert
        em.merge(p3); //update se o objeto existir, senão faz o insert
//        em.merge(p4); //update se o objeto existir, senão faz o insert
//        em.merge(p5); //update se o objeto existir, senão faz o insert
        
        em.getTransaction().commit(); //finaliza a transação
        
        
        
        
        
    }
    
}
