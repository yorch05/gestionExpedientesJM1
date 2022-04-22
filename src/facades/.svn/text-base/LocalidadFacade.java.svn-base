/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controladores.LocalidadJpaController;
import entidades.Localidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Yorch
 */
public class LocalidadFacade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
    EntityManager em = emf.createEntityManager();
    LocalidadJpaController ljc = new LocalidadJpaController(emf);
    
    public void altaLocalidad(Localidad localidad) {
        ljc.create(localidad);
    }
    
    public List<Localidad> getTodos() {
        Query quLocalidad = em.createQuery("SELECT l FROM Localidad l");
        return quLocalidad.getResultList();
    }
}
