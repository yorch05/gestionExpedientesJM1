/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controladores.FiscalJpaController;
import entidades.Fiscal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Yorch
 */
public class FiscalFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
    EntityManager em = emf.createEntityManager();
    FiscalJpaController fiscalJpaController = new FiscalJpaController(emf);
    
    public void altaFiscal(Fiscal fiscal) {
        fiscalJpaController.create(fiscal);
    }
    
    public List<Fiscal> getTodos(){
        Query quFiscals = em.createQuery("SELECT f FROM Fiscal f");
        return quFiscals.getResultList();
    }
    
}
