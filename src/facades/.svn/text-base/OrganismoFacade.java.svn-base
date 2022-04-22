/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controladores.OrganismoJpaController;
import entidades.Organismo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Yorch
 */
public class OrganismoFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
    EntityManager em = emf.createEntityManager();
    OrganismoJpaController ojc = new OrganismoJpaController(emf);
    
    public void altaOrganismo(Organismo organismo) {
        ojc.create(organismo);
    }
    
    public List<Organismo> getTodos() {
        Query quOrganismos = em.createQuery("SELECT o FROM Organismo o");
        return quOrganismos.getResultList();
    }
    
}
