/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controladores.ComisariaJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Comisaria;
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
public class ComisariaFacade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
    EntityManager em = emf.createEntityManager();
    ComisariaJpaController comisariaJpaController = new ComisariaJpaController(emf);
    
    public void altaComisaria(Comisaria comisaria) {
        comisariaJpaController.create(comisaria);
    }
    
    public boolean modificarComisaria(Comisaria comisaria) {
        try {
            comisariaJpaController.edit(comisaria);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ComisariaFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(ComisariaFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean eliminarComisaria(Long id) {
        try {
            comisariaJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ComisariaFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public Comisaria buscar(Long id) {
        return comisariaJpaController.findComisaria(id);
    }
    
    public List<Comisaria> getTodos(){
        Query quComisarias = em.createQuery("SELECT c FROM Comisaria c");
        return quComisarias.getResultList();
    }
    
}
