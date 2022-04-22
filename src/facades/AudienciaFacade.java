/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controladores.AudienciaJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Audiencia;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Yorch
 */
public class AudienciaFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
    EntityManager em = emf.createEntityManager();
    AudienciaJpaController audienciaJpaController = new AudienciaJpaController(emf);
    
    public boolean altaAudiencia(Audiencia audiencia) {
        audienciaJpaController.create(audiencia);
        if (audiencia.getId() != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean modificarAudiencia(Audiencia audiencia) {
        try {
            audienciaJpaController.edit(audiencia);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AudienciaFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(AudienciaFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean eliminarAudiencia(Long id) { //clase que realiza controles utiliza este método para eliminar audiencias con 2 meses de antigüedad
        try {
            audienciaJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AudienciaFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public List<Audiencia> getAudienciasPenales() {
        Query quTodas = em.createQuery("SELECT a FROM Audiencia a WHERE a.fueroSecretaria = 'Penal'");
        return quTodas.getResultList();
    }
    
    public List<Audiencia> getAudienciasAsistenciales() {
        Query quTodas = em.createQuery("SELECT a FROM Audiencia a WHERE a.fueroSecretaria = 'Asistencial'");
        return quTodas.getResultList();
    }

    public List<Audiencia> buscarAudienciaPorParametro(String atributo, String parametro, String secretaria) {
        Query quAudienciaMenor = em.createQuery("SELECT a FROM Audiencia a WHERE '" + atributo + "' = '" + parametro + "' AND a.fueroSecretaria = '" + secretaria + "'");
        return quAudienciaMenor.getResultList();
    }
    
    public List<Audiencia> buscarAudienciaPorFecha(String fecha, String fueroSecretaria) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        Query quTodas;
        List<Audiencia> audiencias = new ArrayList();
        if (fueroSecretaria.equals("Penal")) {
            quTodas = em.createQuery("SELECT a FROM Audiencia a WHERE a.fueroSecretaria = 'Penal'");
        } else {
            quTodas = em.createQuery("SELECT a FROM Audiencia a WHERE a.fueroSecretaria = 'Asistencial'");
        }
        if (!quTodas.getResultList().isEmpty()) {
            List<Audiencia> listaAudiencias = quTodas.getResultList();
            for (Audiencia audiencia : listaAudiencias) {
                if (sdf.format(audiencia.getFechaAudiencia()).equals(fecha)) {
                    audiencias.add(audiencia);
                }
            }
        }
        return audiencias;
    }
    
    public boolean controlarFechasAudiencias() {
        String fechaActual = setearFechaActual();
        List<Audiencia> listaAudiencias = new ArrayList();
        listaAudiencias = getAudienciasPenales();
        if (!listaAudiencias.isEmpty()) { //si hay audiencias penales guardadas, se busca las audiencias asistenciales
            if (!getAudienciasAsistenciales().isEmpty()) {
                for (Audiencia audiencia : getAudienciasAsistenciales()) {
                    listaAudiencias.add(audiencia); //agrego a la lista de audiencias penales las audiencias asistenciales
                }
            }
            for (Audiencia audiencia : listaAudiencias) { //realizo el control de fechas sobre la lista de audiencias de ambas secretarías
                if (!obtenerDiferenciaFechas(fechaActual, convertirFormatoFecha(audiencia.getFechaAudiencia()))) {
                    eliminarAudiencia(audiencia.getId()); //elimino audiencia
                }    
            }
        }
        return true;
    }

    private String setearFechaActual() {
        Calendar calendario = GregorianCalendar.getInstance();
        Date fecActual = new Date();
        fecActual = calendario.getTime();
        return convertirFormatoFecha(fecActual);
    }

    private String convertirFormatoFecha(Date fecActual) {
        SimpleDateFormat fechaActual = new SimpleDateFormat("dd/MM/yy");
        return fechaActual.format(fecActual);
    }

    private boolean obtenerDiferenciaFechas(String fechaActual, String fechaAudiencia) {
        boolean bandera = false;
        int año,mes,dia;
        String fecha[];
        String audiencia[];
        fecha = fechaActual.split("/");
        audiencia = fechaAudiencia.split("/");
        año = Integer.valueOf(audiencia[2])-Integer.valueOf(fecha[2]);
        mes = Integer.valueOf(audiencia[1])-Integer.valueOf(fecha[1]);
        dia = Integer.valueOf(audiencia[0])-Integer.valueOf(fecha[0]);
        if (año == 0 ) { // el año debe ser el mismo
            if ( mes >= -1) { //si la audiencia fue hace un mes no hay problemas con el día que haya sido realizada
                bandera = true;
            } else if (mes == -2){ // si fue hace dos meses, la diferencia entre dias debe ser cero o mayor
                if (dia >= 0 ) {
                    bandera = true;
                } else {
                    bandera = false;
                }
            } else {
                bandera = false;
            }
        } else {
            bandera = false;
        }
        return bandera;
    }
}
