/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controladores.EstupefacienteJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Estupefaciente;
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
public class EstupefacienteFacade {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
    private static EntityManager em = emf.createEntityManager();
    private EstupefacienteJpaController estupefacienteJpaController = new EstupefacienteJpaController(emf);
    private static Query quEstupefacientes;
    
    public void altaEstupefaciente(Estupefaciente estupefaciente) {
        estupefacienteJpaController.create(estupefaciente);
    }
    
    public boolean modificarEstupefaciente(Estupefaciente estupefaciente) {
        try {
            estupefacienteJpaController.edit(estupefaciente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EstupefacienteFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(EstupefacienteFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean eliminarEstupefaciente(Long id) {
        try {
            estupefacienteJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EstupefacienteFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public Estupefaciente buscar(Long id) {
        return estupefacienteJpaController.findEstupefaciente(id);
    }
    
    public static List<Estupefaciente> getTodos(){
        quEstupefacientes = em.createQuery("SELECT e FROM Estupefaciente e");
        return quEstupefacientes.getResultList();
    }

    public Long buscarPorNombreEstupefaciente(String estupefaciente) {
        Query quEstupefaciente = em.createQuery("SELECT e.id FROM Estupefaciente e WHERE e.descripcion ='" + estupefaciente + "'");
        return (Long) quEstupefaciente.getSingleResult();
    }
    
}
