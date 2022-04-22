/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Yorch
 */
@Entity
public class CausaCivil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Expediente expte;
    @OneToOne
    private Persona actor;
    @OneToOne
    private Persona demandado;
    private String causa;
    private String incidente;
    private String estado;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaUltimoTramite;

    public Persona getActor() {
        return actor;
    }

    public void setActor(Persona actor) {
        this.actor = actor;
    }

    public Persona getDemandado() {
        return demandado;
    }

    public void setDemandado(Persona demandado) {
        this.demandado = demandado;
    }

    public Expediente getExpte() {
        return expte;
    }

    public void setExpte(Expediente expte) {
        this.expte = expte;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaUltimoTramite() {
        return fechaUltimoTramite;
    }

    public void setFechaUltimoTramite(Date fechaUltimoTramite) {
        this.fechaUltimoTramite = fechaUltimoTramite;
    }

    public String getIncidente() {
        return incidente;
    }

    public void setIncidente(String incidente) {
        this.incidente = incidente;
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
        if (!(object instanceof CausaCivil)) {
            return false;
        }
        CausaCivil other = (CausaCivil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CausaCivil[ id=" + id + " ]";
    }
    
}
