/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controladores.UsuarioJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Yorch
 */
public class UsuarioFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
    EntityManager em = emf.createEntityManager();
    UsuarioJpaController usuarioJpaController = new UsuarioJpaController(emf);
    
    public void altaUsuario(Usuario usuario) {
        usuarioJpaController.create(usuario);
    }

    public boolean modificarUsuario(Usuario usuario) {
        try {
            usuarioJpaController.edit(usuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ComisariaFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean eliminarUsuario(Long id) {
        try {
            usuarioJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(UsuarioFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public Usuario buscar(Long id) {
        return usuarioJpaController.findUsuario(id);
    }

    public List<Usuario> getTodos() {
        Query quUsuarios = em.createQuery("SELECT u FROM Usuario u");
        return quUsuarios.getResultList();
    }

    public Long buscarPorNombreUsuario(String nombreUsuario) {
        try {
            Query quNombreUsuario = em.createQuery("SELECT u.id FROM Usuario u WHERE u.nombre ='" + nombreUsuario + "'");
            return (Long) quNombreUsuario.getSingleResult();
        } catch (javax.persistence.NoResultException ex) {
            return null;
        }
    }

    public Long buscarPorPassword(String password) {
        try {
            Query quNombreUsuario = em.createQuery("SELECT u.id FROM Usuario u WHERE u.contraseña ='" + password + "'");
            return (Long) quNombreUsuario.getSingleResult();
        } catch (javax.persistence.NoResultException ex) {
            return null;
        }
    }
    
    public String getNombreUsuario(int query) {
        Query quNombreUsuario = null;
        switch (query) {
            case 1: //usuarios con acceso a gestion a expedientes
                quNombreUsuario = em.createQuery("SELECT u.nombre FROM Usuario u WHERE u.permiso1 ='Si' AND u.permiso2 ='No' AND u.permiso3 ='No' AND u.permiso4 ='No' AND u.permiso5 = 'No'");
                break;
            case 2: //usuarios con acceso a audiencias
                quNombreUsuario = em.createQuery("SELECT u.nombre FROM Usuario u WHERE u.permiso1 ='No' AND u.permiso2 ='Si' AND u.permiso3 ='No' AND u.permiso4 ='No' AND u.permiso5 = 'No'");
                break;
            case 3: //usuarios con acceso a entorno conviviente
                quNombreUsuario = em.createQuery("SELECT u.nombre FROM Usuario u WHERE u.permiso1 ='No' AND u.permiso2 ='No' AND u.permiso3 ='Si' AND u.permiso4 ='No' AND u.permiso5 = 'No'");
                break;
            case 4:
                quNombreUsuario = em.createQuery("SELECT u.nombre FROM Usuario u WHERE u.permiso1 ='Si' AND u.permiso2 ='Si' AND u.permiso3 ='Si' AND u.permiso4 ='No' AND u.permiso5 = 'No'");
                break;
            case 5:
                quNombreUsuario = em.createQuery("SELECT u.nombre FROM Usuario u WHERE u.permiso1 ='No' AND u.permiso2 ='No' AND u.permiso3 ='No' AND u.permiso4 ='No' AND u.permiso5 = 'No'");
                break;
            case 6: //usuarios con acceso a todos los módulos y secretarías
                quNombreUsuario = em.createQuery("SELECT u.nombre FROM Usuario u WHERE u.permiso1 ='Si' AND u.permiso2 ='Si' AND u.permiso3 ='Si' AND u.permiso4 ='Si' AND u.permiso5 = 'Si'");
                break;
        }
            return (String) quNombreUsuario.getSingleResult();
    }

    public String getPassword(int query, String nombreUsuario) {
        Query quPassword = null;
        switch (query) {
            case 1:
                quPassword = em.createQuery("SELECT u.contraseña FROM Usuario u WHERE u.nombre ='" + nombreUsuario + "' AND u.permiso1 ='Si' AND u.permiso2 ='No' AND u.permiso3 = 'No' AND u.permiso4 ='No' AND u.permiso5 = 'No'");
                break;
            case 2:
                quPassword = em.createQuery("SELECT u.contraseña FROM Usuario u WHERE u.nombre ='" + nombreUsuario + "' AND u.permiso1 ='No' AND u.permiso2 ='Si' AND u.permiso3 = 'No' AND u.permiso4 ='No' AND u.permiso5 = 'No'");
                break;
            case 3:
                quPassword = em.createQuery("SELECT u.contraseña FROM Usuario u WHERE u.nombre ='" + nombreUsuario + "' AND u.permiso1 ='No' AND u.permiso2 ='No' AND u.permiso3 = 'Si' AND u.permiso4 ='No' AND u.permiso5 = 'No'");
                break;
            case 4:
                quPassword = em.createQuery("SELECT u.contraseña FROM Usuario u WHERE u.nombre ='" + nombreUsuario + "' AND u.permiso1 ='Si' AND u.permiso2 ='Si' AND u.permiso3 = 'Si' AND u.permiso4 ='No' AND u.permiso5 = 'No'");
                break;
            case 5:
                quPassword = em.createQuery("SELECT u.contraseña FROM Usuario u WHERE u.nombre ='" + nombreUsuario + "' AND u.permiso1 ='No' AND u.permiso2 ='No' AND u.permiso3 = 'No' AND u.permiso4 ='No' AND u.permiso5 = 'No'");
                break;
            case 6:
                quPassword = em.createQuery("SELECT u.contraseña FROM Usuario u WHERE u.nombre ='" + nombreUsuario + "' AND u.permiso1 ='Si' AND u.permiso2 ='Si' AND u.permiso3 = 'Si' AND u.permiso4 ='Si' AND u.permiso5 = 'Si'");
                break;
        }
        return (String) quPassword.getSingleResult();
    }
    
    public boolean validarUsuario(String nombreUsuario) {
        Query quUsuario = em.createQuery("SELECT u FROM Usuario u WHERE u.nombre ='" + nombreUsuario +"'");
        if (!quUsuario.getResultList().isEmpty()) {
            return true;
        } else return false;
    }
    
    public boolean validarPassword(String nombreUsuario, String contraseña) {
        Query quContraseña = em.createQuery("SELECT u FROM Usuario u WHERE u.nombre ='" + nombreUsuario +"' AND u.contraseña ='" + contraseña + "'");
        if (!quContraseña.getResultList().isEmpty()) {
            return true;
        } else return false;
    }
    
    public String validarPermisos(String nombreUsuario, String contraseña) {
        Query quUsuario = em.createQuery("SELECT u FROM Usuario u WHERE u.nombre ='" + nombreUsuario + "' AND u.contraseña ='" + contraseña+ "'");
        Usuario user = (Usuario)quUsuario.getSingleResult();
        return user.getPermiso1() + "," + user.getPermiso2() + "," + user.getPermiso3() + "," + user.getPermiso4() + "," + user.getPermiso5();
    }
}
