/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controladores.CausaJpaController;
import entidades.Causa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Yorch
 */
public class CausaFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
    EntityManager em = emf.createEntityManager();
    CausaJpaController causaJpaController = new CausaJpaController(emf);
    
    public void altaCausa(Causa causa) {
        causaJpaController.create(causa);
    }
    
    public List<Causa> getTodos(){
        Query quCausas = em.createQuery("SELECT c FROM Causa c");
        return quCausas.getResultList();
    }
    
}
