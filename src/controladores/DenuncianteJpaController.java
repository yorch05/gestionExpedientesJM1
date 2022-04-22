/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import entidades.Denunciante;
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
public class DenuncianteJpaController implements Serializable {

    public DenuncianteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Denunciante denunciante) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(denunciante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Denunciante denunciante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            denunciante = em.merge(denunciante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = denunciante.getId();
                if (findDenunciante(id) == null) {
                    throw new NonexistentEntityException("The denunciante with id " + id + " no longer exists.");
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
            Denunciante denunciante;
            try {
                denunciante = em.getReference(Denunciante.class, id);
                denunciante.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The denunciante with id " + id + " no longer exists.", enfe);
            }
            em.remove(denunciante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Denunciante> findDenuncianteEntities() {
        return findDenuncianteEntities(true, -1, -1);
    }

    public List<Denunciante> findDenuncianteEntities(int maxResults, int firstResult) {
        return findDenuncianteEntities(false, maxResults, firstResult);
    }

    private List<Denunciante> findDenuncianteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Denunciante.class));
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

    public Denunciante findDenunciante(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Denunciante.class, id);
        } finally {
            em.close();
        }
    }

    public int getDenuncianteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Denunciante> rt = cq.from(Denunciante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
