/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import entidades.UnidadJudicial;
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
public class UnidadJudicialJpaController implements Serializable {

    public UnidadJudicialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UnidadJudicial unidadJudicial) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(unidadJudicial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UnidadJudicial unidadJudicial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            unidadJudicial = em.merge(unidadJudicial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = unidadJudicial.getId();
                if (findUnidadJudicial(id) == null) {
                    throw new NonexistentEntityException("The unidadJudicial with id " + id + " no longer exists.");
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
            UnidadJudicial unidadJudicial;
            try {
                unidadJudicial = em.getReference(UnidadJudicial.class, id);
                unidadJudicial.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The unidadJudicial with id " + id + " no longer exists.", enfe);
            }
            em.remove(unidadJudicial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UnidadJudicial> findUnidadJudicialEntities() {
        return findUnidadJudicialEntities(true, -1, -1);
    }

    public List<UnidadJudicial> findUnidadJudicialEntities(int maxResults, int firstResult) {
        return findUnidadJudicialEntities(false, maxResults, firstResult);
    }

    private List<UnidadJudicial> findUnidadJudicialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UnidadJudicial.class));
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

    public UnidadJudicial findUnidadJudicial(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UnidadJudicial.class, id);
        } finally {
            em.close();
        }
    }

    public int getUnidadJudicialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UnidadJudicial> rt = cq.from(UnidadJudicial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
