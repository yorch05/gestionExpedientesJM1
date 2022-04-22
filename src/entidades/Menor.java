/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Yorch
 */
@Entity
public class Menor extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Expediente> expedientes;
    private String domicilio;
    @OneToOne (cascade = CascadeType.ALL)
    private Persona progenitor;
    @OneToOne (cascade = CascadeType.ALL)
    private Persona progenitora;
    @OneToOne (cascade = CascadeType.ALL)
    private GrupoConvivencia grupoConvivencia;
    private String escolaridad; //actua como valor booleano
    private String trabajo;     //actúa como valor booleano
    @OneToMany
    private List<Estupefaciente> consumoEstupefacientes;
    @OneToMany
    private List<Audiencia> audiencias;
    
    public List<Audiencia> getAudiencias() {
        return audiencias;
    }

    public void setAudiencias(List<Audiencia> audiencias) {
        this.audiencias = audiencias;
    }

    public Persona getProgenitor() {
        return progenitor;
    }

    public void setProgenitor(Persona progenitor) {
        this.progenitor = progenitor;
    }

    public Persona getProgenitora() {
        return progenitora;
    }

    public void setProgenitora(Persona progenitora) {
        this.progenitora = progenitora;
    }

    public GrupoConvivencia getGrupoConvivencia() {
        return grupoConvivencia;
    }

    public void setGrupoConvivencia(GrupoConvivencia grupoConvivencia) {
        this.grupoConvivencia = grupoConvivencia;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public List<Estupefaciente> getConsumoEstupefacientes() {
        return consumoEstupefacientes;
    }

    public void setConsumoEstupefacientes(List<Estupefaciente> consumoEstupefacientes) {
        this.consumoEstupefacientes = consumoEstupefacientes;
    }

    public List<Expediente> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(List<Expediente> expedientes) {
        this.expedientes = expedientes;
    }


    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
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
        if (!(object instanceof Menor)) {
            return false;
        }
        Menor other = (Menor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.getApellido() + ", " + super.getNombre();
    }
    
}
