/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controladores.GrupoConvivenciaJpaController;
import entidades.GrupoConvivencia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Yorch
 */
public class GrupoConvivenciaFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
    EntityManager em = emf.createEntityManager();
    GrupoConvivenciaJpaController grupoConvivenciaJpaController = new GrupoConvivenciaJpaController(emf);
    
    public void altaGrupoConvivencia(GrupoConvivencia grupoConvivencia) {
        grupoConvivenciaJpaController.create(grupoConvivencia);
    }
    
    public List<GrupoConvivencia> getTodos(){
        Query quGrupoConvivencias = em.createQuery("SELECT g FROM GrupoConvivencia g");
        return quGrupoConvivencias.getResultList();
    }
    
}
