/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controladores.PersonaJpaController;
import entidades.Persona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Yorch
 */
public class PersonaFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
    EntityManager em = emf.createEntityManager();
    PersonaJpaController personaJpaController = new PersonaJpaController(emf);
    
    public void altaPersona(Persona persona) {
        personaJpaController.create(persona);
    }
    
    public List<Persona> getTodos(){
        Query quPersonas = em.createQuery("SELECT p FROM Persona p");
        return quPersonas.getResultList();
    }
    
}
