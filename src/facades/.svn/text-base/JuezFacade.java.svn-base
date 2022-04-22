/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controladores.JuezJpaController;
import entidades.Juez;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Yorch
 */
public class JuezFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
    EntityManager em = emf.createEntityManager();
    JuezJpaController juezJpaController = new JuezJpaController(emf);
    
    public void altaJuez(Juez juez) {
        juezJpaController.create(juez);
    }
    
    public List<Juez> getTodos(){
        Query quJuez =  em.createQuery("SELECT j FROM Juez j");
        return quJuez.getResultList();
    }
    
}
