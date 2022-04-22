/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controladores.DenuncianteJpaController;
import entidades.Denunciante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Yorch
 */
public class DenuncianteFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
    EntityManager em = emf.createEntityManager();
    DenuncianteJpaController denuncianteJpaController = new DenuncianteJpaController(emf);
    
    public void altaDenunciante(Denunciante denunciante) {
        denuncianteJpaController.create(denunciante);
    }
    
    public List<Denunciante> getTodos(){
        Query quDenunciantes = em.createQuery("SELECT d FROM Denunciante d");
        return quDenunciantes.getResultList();
    }
    
}
