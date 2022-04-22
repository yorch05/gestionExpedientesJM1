/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controladores.CausaCivilJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.CausaCivil;
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
public class CausaCivilFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
    EntityManager em = emf.createEntityManager();
    CausaCivilJpaController civilJpaController = new CausaCivilJpaController(emf);
    
    public void altaCausa(CausaCivil causa) {
        civilJpaController.create(causa);
    }
    
    public boolean modificarCausaCivil(CausaCivil causaCivil) {
        try {
            civilJpaController.edit(causaCivil);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(CausaCivilFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(CausaCivilFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public CausaCivil buscarPorExpediente(String text) {
        String[] expte = text.split("/");
        if (expte[1].startsWith("9")) { //expte[1] son los dos últimos dígitos del año "----"
            expte[1] = "19" + expte[1]; //si comienza con 9 --> "--9-" => 199_?
        } else { // si comienza con otro número 0 o 1
            expte[1] = "20" + expte[1]; // => 200_?  o  => 201_?
        }
        Query quCausa = em.createQuery("SELECT c FROM CausaCivil c WHERE c.expte.numero =" + expte[0] + " AND c.expte.año ='" + expte[1] + "'");
        return (CausaCivil) quCausa.getSingleResult();
    }
    
    public List<CausaCivil> getTodos(){
        Query quCausas = em.createQuery("SELECT c FROM CausaCivil c");
        return quCausas.getResultList();
    }

    public List<CausaCivil> buscarPorParametro(String atributo, String text) {
        Query quCausas = null;
        if (atributo.equals("expte")) {
            String[] expte = text.split("/");
            if (expte[1].startsWith("9")) { //expte[1] son los dos últimos dígitos del año "----"
                expte[1] = "19" + expte[1]; //si comienza con 9 --> "--9-" => 199?
            } else { // si comienza con otro número 0 o 1
                expte[1] = "20" + expte[1]; // => 200?  o  => 201?
            }
            quCausas = em.createQuery("SELECT c FROM CausaCivil c WHERE c.expte.numero =" + expte[0] + " AND c.expte.año ='" + expte[1] + "'");
        } else if (atributo.equals("apellido actor")) {
            quCausas = em.createQuery("SELECT c FROM CausaCivil c WHERE c.actor.apellido ='" + text + "'");
        }else if (atributo.equals("apellido demandado")) {
            quCausas = em.createQuery("SELECT c FROM CausaCivil c WHERE c.demandado.apellido ='" + text + "'");
        } else if (atributo.equals("causa")) {
            quCausas = em.createQuery("SELECT c FROM CausaCivil c WHERE c.causa ='" + text + "'");
        }
        return quCausas.getResultList();
    }
}
