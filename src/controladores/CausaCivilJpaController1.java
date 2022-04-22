/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import entidades.CausaCivil;
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
public class CausaCivilJpaController1 implements Serializable {

    public CausaCivilJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CausaCivil causaCivil) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(causaCivil);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CausaCivil causaCivil) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            causaCivil = em.merge(causaCivil);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = causaCivil.getId();
                if (findCausaCivil(id) == null) {
                    throw new NonexistentEntityException("The causaCivil with id " + id + " no longer exists.");
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
            CausaCivil causaCivil;
            try {
                causaCivil = em.getReference(CausaCivil.class, id);
                causaCivil.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The causaCivil with id " + id + " no longer exists.", enfe);
            }
            em.remove(causaCivil);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CausaCivil> findCausaCivilEntities() {
        return findCausaCivilEntities(true, -1, -1);
    }

    public List<CausaCivil> findCausaCivilEntities(int maxResults, int firstResult) {
        return findCausaCivilEntities(false, maxResults, firstResult);
    }

    private List<CausaCivil> findCausaCivilEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CausaCivil.class));
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

    public CausaCivil findCausaCivil(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CausaCivil.class, id);
        } finally {
            em.close();
        }
    }

    public int getCausaCivilCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CausaCivil> rt = cq.from(CausaCivil.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
