/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import entidades.Estupefaciente;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Yorch
 */
public class EstupefacienteJpaController implements Serializable {

    public EstupefacienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estupefaciente estupefaciente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(estupefaciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estupefaciente estupefaciente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            estupefaciente = em.merge(estupefaciente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = estupefaciente.getId();
                if (findEstupefaciente(id) == null) {
                    throw new NonexistentEntityException("The estupefaciente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estupefaciente estupefaciente;
            try {
                estupefaciente = em.getReference(Estupefaciente.class, id);
                estupefaciente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estupefaciente with id " + id + " no longer exists.", enfe);
            }
            em.remove(estupefaciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estupefaciente> findEstupefacienteEntities() {
        return findEstupefacienteEntities(true, -1, -1);
    }

    public List<Estupefaciente> findEstupefacienteEntities(int maxResults, int firstResult) {
        return findEstupefacienteEntities(false, maxResults, firstResult);
    }

    private List<Estupefaciente> findEstupefacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estupefaciente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Estupefaciente findEstupefaciente(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estupefaciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstupefacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estupefaciente> rt = cq.from(Estupefaciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
