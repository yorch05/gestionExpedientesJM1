/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import entidades.GrupoConvivencia;
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
public class GrupoConvivenciaJpaController implements Serializable {

    public GrupoConvivenciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(GrupoConvivencia grupoConvivencia) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(grupoConvivencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(GrupoConvivencia grupoConvivencia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            grupoConvivencia = em.merge(grupoConvivencia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = grupoConvivencia.getId();
                if (findGrupoConvivencia(id) == null) {
                    throw new NonexistentEntityException("The grupoConvivencia with id " + id + " no longer exists.");
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
            GrupoConvivencia grupoConvivencia;
            try {
                grupoConvivencia = em.getReference(GrupoConvivencia.class, id);
                grupoConvivencia.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The grupoConvivencia with id " + id + " no longer exists.", enfe);
            }
            em.remove(grupoConvivencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<GrupoConvivencia> findGrupoConvivenciaEntities() {
        return findGrupoConvivenciaEntities(true, -1, -1);
    }

    public List<GrupoConvivencia> findGrupoConvivenciaEntities(int maxResults, int firstResult) {
        return findGrupoConvivenciaEntities(false, maxResults, firstResult);
    }

    private List<GrupoConvivencia> findGrupoConvivenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(GrupoConvivencia.class));
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

    public GrupoConvivencia findGrupoConvivencia(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(GrupoConvivencia.class, id);
        } finally {
            em.close();
        }
    }

    public int getGrupoConvivenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<GrupoConvivencia> rt = cq.from(GrupoConvivencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
