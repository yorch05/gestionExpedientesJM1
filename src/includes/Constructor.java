
package includes;

import entidades.Audiencia;
import entidades.CausaCivil;
import entidades.CentralTelefonica;
import entidades.Comisaria;
import entidades.Estupefaciente;
import entidades.Expediente;
import entidades.Localidad;
import entidades.Menor;
import entidades.Organismo;
import entidades.UnidadJudicial;
import entidades.Usuario;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yorch
 */
public class Constructor {
    
    public static void centrarDialog(JDialog diag) {
        Point punto = new Point();
        Dimension d1 = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension d2 = diag.getSize();
        punto.setLocation((int) ((d1.getWidth() / 2) - (d2.getWidth() / 2)),
                (int) ((d1.getHeight() / 2) - (d2.getHeight() / 2)));
        diag.setLocation(punto);
    }
    
    public static void cargarJList(JList jList, List lista) {
        DefaultListModel modeloLista = new DefaultListModel();
        for (Object objeto : lista) {
            modeloLista.addElement(objeto);
        }
        jList.setModel(modeloLista);
    }

    public static void cargarJCombo(JComboBox jCombo, List lista) {
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        for (Object objeto : lista) {
            modeloCombo.addElement(objeto);
        }
        jCombo.setModel(modeloCombo);
    }

    //metodo que construye y carga la tabla según los parámetros recibidos.
    public static void cargarTabla(JTable jTable, int cantColumnas, String[] titulos, String entidad, List lista) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        for (int i = 0; i < cantColumnas; i++) {
            modeloTabla.addColumn(titulos[i]);
        }
        if (entidad.equals("CausaCivil")) { //para ventana de secretaría civil
            List<CausaCivil> listaCausas = lista;
            for (CausaCivil causa : listaCausas) {
                Object[] fila = new Object[5];
                fila[0] = causa.getId();
                fila[1] = causa.getExpte().toString();
                fila[2] = causa.getActor().toString() + " c/ " + causa.getDemandado().toString() + " s/ " + causa.getCausa();
                fila[3] = causa.getEstado();
                fila[4] = String.format("dd/MM/aa", causa.getFechaUltimoTramite());
                modeloTabla.addRow(fila);
            }
        } else if (entidad.equals("consultaMenor")) { //tabla1 de consulta de Expedientes
           List<Expediente> listaExpedientes = lista; 
           for (Expediente expediente : listaExpedientes) {
               Object[] fila = new Object[6];
               for (Menor menor : expediente.getMenor()) {
                   fila[0] = expediente.getId();
                   fila[1] = menor.toString();
                   fila[2] = menor.getEdad();
                   fila[3] = menor.getFechaNacimiento();
                   try {
                       fila[4] = menor.getProgenitor().toString();
                       fila[5] = menor.getProgenitora().toString();
                   } catch (java.lang.NullPointerException ex) {
                       fila[4] = "sin datos";
                       fila[5] = "sin datos";
                   }
                   modeloTabla.addRow(fila);
               }
           }
        } else if (entidad.equals("consultaExpte")) { //tabla2 de consulta de Expedientes
           List<Expediente> listaExpedientes = lista; 
           for (Expediente expediente : listaExpedientes) {
               Object[] fila = new Object[4];
               fila[0] = expediente.getId();
               fila[1] = expediente.toString();
               fila[2] = expediente.getCausa().toString();
               if (expediente.getComisaria() != null) {
                   fila[3] = expediente.getComisaria().toString();
               } else {
                   fila[3] = expediente.getUnidadJudicial().toString();
               }
               modeloTabla.addRow(fila);
           }
        } else if (entidad.equals("Usuarios")) { //ventana de administración de usuarios
            List<Usuario> listaUsuarios = lista;
            for (Usuario usuario : listaUsuarios) {
                Object[] fila = new Object[7];
                fila[0] = usuario.getNombre();
                fila[1] = usuario.getContraseña();
                fila[2] = usuario.getPermiso1();
                fila[3] = usuario.getPermiso2();
                fila[4] = usuario.getPermiso3();
                fila[5] = usuario.getPermiso4();
                fila[6] = usuario.getPermiso5();
                modeloTabla.addRow(fila);
            }
        } else if (entidad.equals("Comisaría")) { //ventana de administación de comisarías y agenda
            List<Comisaria> listaComisarias = lista;
            for (Comisaria comisaria : listaComisarias) {
                Object[] fila = new Object[3];
                fila[0] = comisaria.getId();
                fila[1] = comisaria.getDescripcion();
                fila[2] = comisaria.getNumeroTelefono();
                modeloTabla.addRow(fila);
            }
        } else if (entidad.equals("Unidad Judicial")) { //ventana de administación de Unidades Judiciales y agenda
            List<UnidadJudicial> listaUnidadesJudiciales = lista;
            for (UnidadJudicial uj : listaUnidadesJudiciales) {
                Object[] fila = new Object[3];
                fila[0] = uj.getId();
                fila[1] = uj.getDescripcion();
                fila[2] = uj.getNumeroTelefono();
                modeloTabla.addRow(fila);
            }
        } else if (entidad.equals("Organismo")) { //para tabla de organismos en ventana de agenda
            List<Organismo> listaOrganismos = lista;
            for (Organismo organismo : listaOrganismos) {
                Object[] fila = new Object[3];
                fila[0] = organismo.getId();
                fila[1] = organismo.getDescripcion();
                fila[2] = organismo.getNumTelefono();
                modeloTabla.addRow(fila);
            }
        } else if (entidad.equals("Localidad")) { //para tabla de localidades en ventana de agenda
            List<Localidad> listaLocalidades = lista;
            for (Localidad localidad : listaLocalidades) {
                Object[] fila = new Object[3];
                fila[0] = localidad.getId();
                fila[1] = localidad.getDescripcion();
                fila[2] = localidad.getCodigoPostal();
                modeloTabla.addRow(fila);
            }
        } else if (entidad.equals("Central Telefónica")) { //para tabla de central telefónica en ventana de agenda
            List<CentralTelefonica> listaTelefonos = lista;
            for (CentralTelefonica central : listaTelefonos) {
                Object[] fila = new Object[6];
                fila[0] = central.getId();
                fila[1] = central.getJuzgado();
                fila[2] = central.getSecretaria();
                fila[3] = central.getPersonas();
                fila[4] = central.getCargo();
                fila[5] = central.getNumInterno();
                modeloTabla.addRow(fila);
            }
        } else if (entidad.equals("Audiencia")) {
            List<Audiencia> listaAudiencia = lista;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Audiencia audiencia : listaAudiencia) {
                Object[] fila = new Object[6];
                fila[0] = audiencia.getExpte();
                if (audiencia.getComisaria() != null) {
                    fila[1] = audiencia.getComisaria();
                } else {
                    fila[1] = audiencia.getUnidadJudicial();
                }
                fila[2] = audiencia.getMenor();
                fila[3] = sdf.format(audiencia.getFechaAudiencia());
                fila[4] = audiencia.getHoraAudiencia();
                if (audiencia.isAlojado()) {
                    fila[5] = "Sí";
                } else {
                    fila[5] = "No";
                }
                modeloTabla.addRow(fila);
            }
        } else if (entidad.equals("Estupefaciente")) {
            List<Estupefaciente> listaEstupefaciente = lista;
            for (Estupefaciente estupefaciente : listaEstupefaciente) {
                Object[] fila = new Object[2];
                fila[0] = estupefaciente.getId();
                fila[1] = estupefaciente.getDescripcion();
                modeloTabla.addRow(fila);
            }
        }
        jTable.setModel(modeloTabla);
    }
}

