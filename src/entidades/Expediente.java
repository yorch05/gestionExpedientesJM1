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
public class Expediente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private String año;
    @OneToOne
    private ActaInicial actaInicial;
    @OneToMany (cascade = CascadeType.ALL)
    private List <Menor> menor;
    @OneToOne (cascade = CascadeType.ALL)
    private Denunciante denunciante;
    @OneToOne (cascade = CascadeType.ALL)
    private Causa causa;
    @OneToOne (cascade = CascadeType.ALL)
    private Fiscal fiscal;
    @OneToOne
    private Comisaria comisaria;
    @OneToOne
    private UnidadJudicial unidadJudicial;
    @OneToOne
    private Juez juez;
    @OneToOne
    private Secretaria secretario;
    private boolean archivado;

    public boolean isArchivado() {
        return archivado;
    }

    public void setArchivado(boolean archivado) {
        this.archivado = archivado;
    }

    public Comisaria getComisaria() {
        return comisaria;
    }

    public void setComisaria(Comisaria comisaria) {
        this.comisaria = comisaria;
    }

    public Juez getJuez() {
        return juez;
    }

    public void setJuez(Juez juez) {
        this.juez = juez;
    }

    public Secretaria getSecretario() {
        return secretario;
    }

    public void setSecretario(Secretaria secretario) {
        this.secretario = secretario;
    }

    public UnidadJudicial getUnidadJudicial() {
        return unidadJudicial;
    }

    public void setUnidadJudicial(UnidadJudicial unidadJudicial) {
        this.unidadJudicial = unidadJudicial;
    }

    public Fiscal getFiscal() {
        return fiscal;
    }

    public void setFiscal(Fiscal fiscal) {
        this.fiscal = fiscal;
    }
    
    public ActaInicial getActaInicial() {
        return actaInicial;
    }

    public void setActaInicial(ActaInicial actaInicial) {
        this.actaInicial = actaInicial;
    }

    public Causa getCausa() {
        return causa;
    }

    public void setCausa(Causa causa) {
        this.causa = causa;
    }

    public Denunciante getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(Denunciante denunciante) {
        this.denunciante = denunciante;
    }

    public String getAnio() {
        return año;
    }

    public void setAnio(String anio) {
        this.año = anio;
    }

    public List<Menor> getMenor() {
        return menor;
    }

    public void setMenor(List<Menor> menor) {
        this.menor = menor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
        if (!(object instanceof Expediente)) {
            return false;
        }
        Expediente other = (Expediente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(numero) + "/" + this.getAnio().substring(2);
    }
    
}
