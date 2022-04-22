/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controladores.ExpedienteJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Expediente;
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
public class ExpedienteFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
    EntityManager em = emf.createEntityManager();
    ExpedienteJpaController expedienteJpaController = new ExpedienteJpaController(emf);
    
    public void altaExpediente(Expediente expediente) {
        expedienteJpaController.create(expediente);
    }
    
    public boolean modificarExpediente(Expediente expediente) {
        try {
            expedienteJpaController.edit(expediente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EstupefacienteFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(EstupefacienteFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean eliminarExpediente(Long id) {
        try {
            expedienteJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EstupefacienteFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public Expediente buscar(Long id) {
        return expedienteJpaController.findExpediente(id);
    }
    
    public List<Expediente> buscarExpedientePorParametro(String parametro, String variable) {
        Query quExpediente = null;
        if (parametro.equals("apellido")) {
            quExpediente = em.createQuery("SELECT e FROM Expediente e WHERE e.menor.apellido ='" + variable + "'");
            return quExpediente.getResultList();
        }
        if (parametro.equals("nombre")) {
            quExpediente = em.createQuery("SELECT e FROM Expediente e WHERE e.menor.nombre ='" + variable + "'");
            return quExpediente.getResultList();
        }
        if (parametro.equals("dni")) {
            quExpediente = em.createQuery("SELECT e FROM Expediente e WHERE e.menor.dni ='" + variable + "'");
            return quExpediente.getResultList();
        }
        if (parametro.equals("edad")) {
            quExpediente = em.createQuery("SELECT e FROM Expediente e WHERE e.menor.edad ='" + variable + "'");
            return quExpediente.getResultList();
        }
        if (parametro.equals("archivado")) {
            quExpediente = em.createQuery("SELECT e FROM Expediente e WHERE e.archivado =" + true);
            return quExpediente.getResultList();
        }
        if (parametro.equals("letra de acta inicial")) {
            quExpediente = em.createQuery("SELECT e FROM Expediente e WHERE e.actaInicial.letra ='" + variable + "'");
            return quExpediente.getResultList();
        }
        if (parametro.equals("numero de expediente")) {
            quExpediente = em.createQuery("SELECT e FROM Expediente e WHERE e.numero =" + Integer.valueOf(variable));
            return quExpediente.getResultList();
        }
        if (parametro.equals("año")) {
            quExpediente = em.createQuery("SELECT e FROM Expediente e WHERE e.año ='" + variable + "'");
            return quExpediente.getResultList();
        }
        if (parametro.equals("causa")) {
            quExpediente = em.createQuery("SELECT e FROM Expediente e WHERE e.causa.descripcion ='" + variable + "'");
            return quExpediente.getResultList();
        }
        if (parametro.equals("comisaria")) {
            quExpediente = em.createQuery("SELECT e FROM Expediente e WHERE e.comisaria.descripcion ='" + variable + "'");
            return quExpediente.getResultList();
        }
        if (parametro.equals("unidad judicial")) {
            quExpediente = em.createQuery("SELECT e FROM Expediente e WHERE e.unidadJudicial.descripcion ='" + variable + "'");
            return quExpediente.getResultList();
        }
        if (parametro.equals("apellido y nombre de padre")) {
            String[] nomApePadre = variable.split(", ");
            quExpediente = em.createQuery("SELECT e FROM Expediente e WHERE e.menor.progenitor.apellido ='" + nomApePadre[0] 
                    + "' AND e.Menor.Progenitor.nombre ='" + nomApePadre[1] + "'");
            return quExpediente.getResultList();
        } else { //"apellido y nombre de madre"
            String[] nomApeMadre = variable.split(", ");
            quExpediente = em.createQuery("SELECT e FROM Expediente e WHERE e.menor.progenitora.apellido ='" + nomApeMadre[0] 
                    + "' AND e.menor.progenitora.nombre ='" + nomApeMadre[1] + "'");
            return quExpediente.getResultList();
        }
    }
    
    public Expediente getExpediente(String expte) { //recibo el siguiente formato ----/----
        try {
            String[] expediente = expte.split("/"); //lo separo en número y año
            int num = Integer.parseInt(expediente[0]);
            Query quExpediente = em.createQuery("SELECT e FROM Expediente e WHERE e.numero='" + num + "' AND e.año ='" + expediente[1] + "'");
            return (Expediente)quExpediente.getSingleResult();
        } catch (javax.persistence.NoResultException ex) {
            return null;
        }
    }
            
    public List<Expediente> getTodos(){
        Query quExpedientes = em.createQuery("SELECT e FROM Expediente e");
        return quExpedientes.getResultList();
    }
    
}
