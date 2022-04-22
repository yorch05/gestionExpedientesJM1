/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controladores.UnidadJudicialJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.UnidadJudicial;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Yorch
 */
public class UnidadJudicialFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
    EntityManager em = emf.createEntityManager();
    UnidadJudicialJpaController unidadJudicialJpaController = new UnidadJudicialJpaController(emf);
    
    public void altaUnidadJudicial(UnidadJudicial unidadJudicial) {
        unidadJudicialJpaController.create(unidadJudicial);
    }

    public boolean modificarUnidadJudicial(UnidadJudicial unidadJudicial) {
        try {
            unidadJudicialJpaController.edit(unidadJudicial);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(UnidadJudicialFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(UnidadJudicialFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean eliminarUnidadJudicial(Long id) {
        try {
            unidadJudicialJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(UnidadJudicialFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
     public UnidadJudicial buscar(Long id) {
        return unidadJudicialJpaController.findUnidadJudicial(id);
    }
    
    public List<UnidadJudicial> getTodos(){
        Query quUnidadesJudiciales = em.createQuery("SELECT u FROM UnidadJudicial u");
        return quUnidadesJudiciales.getResultList();
    }
    
}
