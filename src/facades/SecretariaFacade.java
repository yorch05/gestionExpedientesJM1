/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controladores.SecretariaJpaController;
import entidades.Secretaria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Yorch
 */
public class SecretariaFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
    EntityManager em = emf.createEntityManager();
    SecretariaJpaController secretariaJpaController = new SecretariaJpaController(emf);
    
    public void altaSecretaria(Secretaria secretaria) {
        secretariaJpaController.create(secretaria);
    }
    
    public List<Secretaria> getTodos(){
        Query quSecretarias = em.createQuery("SELECT s FROM Secretaria s");
        return quSecretarias.getResultList();
    }
    
}
