/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Yorch
 */
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String contraseña;
    private String permiso1; //permiso a gestion de expediente - penal
    private String permiso2; //permiso a gestion de audiencias - penal
    private String permiso3; //permiso a gestion de entorno conviviente - penal
    private String permiso4; //permiso a secretaría asistencial
    private String permiso5; //permiso a secretaria civil

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPermiso1() {
        return permiso1;
    }

    public void setPermiso1(String permiso1) {
        this.permiso1 = permiso1;
    }

    public String getPermiso2() {
        return permiso2;
    }

    public void setPermiso2(String permiso2) {
        this.permiso2 = permiso2;
    }

    public String getPermiso3() {
        return permiso3;
    }

    public void setPermiso3(String permiso3) {
        this.permiso3 = permiso3;
    }

    public String getPermiso4() {
        return permiso4;
    }

    public void setPermiso4(String permiso4) {
        this.permiso4 = permiso4;
    }

    public String getPermiso5() {
        return permiso5;
    }

    public void setPermiso5(String permiso5) {
        this.permiso5 = permiso5;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Usuario[ id=" + id + " ]";
    }
    
}
