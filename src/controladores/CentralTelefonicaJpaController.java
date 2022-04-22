/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import entidades.CentralTelefonica;
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
public class CentralTelefonicaJpaController implements Serializable {

    public CentralTelefonicaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CentralTelefonica centralTelefonica) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(centralTelefonica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CentralTelefonica centralTelefonica) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            centralTelefonica = em.merge(centralTelefonica);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = centralTelefonica.getId();
                if (findCentralTelefonica(id) == null) {
                    throw new NonexistentEntityException("The centralTelefonica with id " + id + " no longer exists.");
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
            CentralTelefonica centralTelefonica;
            try {
                centralTelefonica = em.getReference(CentralTelefonica.class, id);
                centralTelefonica.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The centralTelefonica with id " + id + " no longer exists.", enfe);
            }
            em.remove(centralTelefonica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CentralTelefonica> findCentralTelefonicaEntities() {
        return findCentralTelefonicaEntities(true, -1, -1);
    }

    public List<CentralTelefonica> findCentralTelefonicaEntities(int maxResults, int firstResult) {
        return findCentralTelefonicaEntities(false, maxResults, firstResult);
    }

    private List<CentralTelefonica> findCentralTelefonicaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CentralTelefonica.class));
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

    public CentralTelefonica findCentralTelefonica(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CentralTelefonica.class, id);
        } finally {
            em.close();
        }
    }

    public int getCentralTelefonicaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CentralTelefonica> rt = cq.from(CentralTelefonica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
