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
public class Audiencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaAudiencia;
    @OneToOne
    private Expediente expte;
    @OneToOne
    private Menor menor;
//    @Temporal(javax.persistence.TemporalType.TIME)
    private String horaAudiencia;
    private boolean alojado;
    private String fueroSecretaria;
    @OneToOne
    private Comisaria comisaria;
    @OneToOne
    private UnidadJudicial unidadJudicial;

    public Menor getMenor() {
        return menor;
    }

    public void setMenor(Menor menor) {
        this.menor = menor;
    }
    

    public Comisaria getComisaria() {
        return comisaria;
    }

    public void setComisaria(Comisaria comisaria) {
        this.comisaria = comisaria;
    }

    public Expediente getExpte() {
        return expte;
    }

    public void setExpte(Expediente expte) {
        this.expte = expte;
    }

    public String getHoraAudiencia() {
        return horaAudiencia;
    }

    public void setHoraAudiencia(String horaAudiencia) {
        this.horaAudiencia = horaAudiencia;
    }

    public UnidadJudicial getUnidadJudicial() {
        return unidadJudicial;
    }

    public void setUnidadJudicial(UnidadJudicial unidadJudicial) {
        this.unidadJudicial = unidadJudicial;
    }
    
    

    public String getFueroSecretaria() {
        return fueroSecretaria;
    }

    public void setFueroSecretaria(String fueroSecretaria) {
        this.fueroSecretaria = fueroSecretaria;
    }

    public boolean isAlojado() {
        return alojado;
    }

    public void setAlojado(boolean alojado) {
        this.alojado = alojado;
    }

    public Date getFechaAudiencia() {
        return fechaAudiencia;
    }

    public void setFechaAudiencia(Date fechaAudiencia) {
        this.fechaAudiencia = fechaAudiencia;
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
        if (!(object instanceof Audiencia)) {
            return false;
        }
        Audiencia other = (Audiencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Audiencia[ id=" + id + " ]";
    }
    
}
