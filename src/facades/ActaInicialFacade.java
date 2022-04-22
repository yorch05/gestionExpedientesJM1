/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controladores.ActaInicialJpaController;
import entidades.ActaInicial;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Yorch
 */
public class ActaInicialFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
    EntityManager em = emf.createEntityManager();
    ActaInicialJpaController controller = new ActaInicialJpaController(emf);
    
    public void altaActuacion(ActaInicial actaInicial) {
        controller.create(actaInicial);
    }
    
    public List<ActaInicial> getTodos() {
        Query quTodos = em.createQuery("SELECT a FROM ActaInicial a");
        return quTodos.getResultList();
    }
    
    public List<ActaInicial> buscarPorLetra(String letra) {
        System.err.println("dentro de buscar por letra");
        Query quLetra = em.createQuery("SELECT a FROM ActaInicial a WHERE a.letra='" + letra + "'");
        return quLetra.getResultList();
    }
    
    public List<ActaInicial> buscarPorAño(String año) {
//        System.err.println("dentro de buscar por año");
        Query quAño = em.createQuery("SELECT a FROM ActaInicial a WHERE a.año='" + año + "'");
        return quAño.getResultList();
    }
    
    public List<ActaInicial> buscarPorNumero(int numero) {
        System.err.println("dentro de buscar por año");
        Query quNumero = em.createQuery("SELECT a FROM ActaInicial a WHERE a.numero=" + numero);
        return quNumero.getResultList();
    }
}