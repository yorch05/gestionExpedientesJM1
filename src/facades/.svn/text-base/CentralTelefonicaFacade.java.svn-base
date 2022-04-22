/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controladores.CentralTelefonicaJpaController;
import entidades.CentralTelefonica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Yorch
 */
public class CentralTelefonicaFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
    EntityManager em = emf.createEntityManager();
    CentralTelefonicaJpaController ctjc = new CentralTelefonicaJpaController(emf);
    
    public void altaCentralTelefónicaFacade(CentralTelefonica centralTelefonica) {
        ctjc.create(centralTelefonica);
    }
    
    public List<CentralTelefonica> getTodos() {
        Query quTelefonos = em.createQuery("SELECT t FROM CentralTelefonica t");
        return quTelefonos.getResultList();
    }
    
}
