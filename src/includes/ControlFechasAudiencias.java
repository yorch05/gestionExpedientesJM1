package includes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import facades.AudienciaFacade;
import entidades.Audiencia;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Yorch - Jorge E. Argañaraz Ponessa
 */
public class ControlFechasAudiencias {

    private static Date fecActual;
    private static SimpleDateFormat fechaActual;
    private static String actual;
    private static String fechaAudiencia;
    
    public ControlFechasAudiencias() {
    }
    
    //obtengo la fecha del sistema y seteo como String
    public static void setearFechaActual(){
        Calendar calendario = GregorianCalendar.getInstance();
        fecActual = new Date();
        fecActual = calendario.getTime();
        fechaActual = new SimpleDateFormat("dd/MM/yy");
        actual = fechaActual.format(fecActual);
    }
 
    public static void consultarFechaAudiencia() {
        setearFechaActual();
        AudienciaFacade audienciaFacade = new AudienciaFacade();
        if(!audienciaFacade.getAudienciasPenales().isEmpty()) { //si la lista de audiencias no está vacía
            for (Audiencia audiencia : audienciaFacade.getAudienciasPenales()) {
                fechaAudiencia = fechaActual.format(audiencia.getFechaAudiencia());
                if(!obtenerDiferenciasFechas(fechaAudiencia)) { //si esto es falso, se borra el registro
                    audienciaFacade.eliminarAudiencia(audiencia.getId());
                }
            }
        }
    }
    
    private static boolean obtenerDiferenciasFechas(String stringFechaAudiencia) {
        boolean bandera = false;
        int año,mes,dia;
        String fecha[];
        String audiencia[];
        fecha = actual.split("/");
        audiencia = stringFechaAudiencia.split("/");
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
