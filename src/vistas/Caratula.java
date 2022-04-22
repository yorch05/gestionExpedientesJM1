/*
 * Caratula.java
 *
 * Created on 19 de febrero de 2010, 08:23
 */

package vistas;

import facades.ExpedienteFacade;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import entidades.Menor;
import entidades.Expediente;
import java.text.SimpleDateFormat;

/**
 *
 * @author  Yorch
 */
public class Caratula extends javax.swing.JFrame {
    private Menor menor = new Menor();
    private Expediente expediente = new Expediente();
    public static JTextArea jTextArea1;
    
    public Caratula() {
    }
    
    public Caratula(Expediente idExpte, Menor menor) {
        initComponents();
        inicializarComponentes(idExpte, menor);
    }

    public String cargarPanel() {
        this.setTitle(expediente.getNumero() + "/" + expediente.getAnio().substring(2));
        jLabel1.setText("Expediente: " + expediente.getNumero() + "/" + expediente.getAnio().substring(2));
        jLabel2.setText("Causa: " + expediente.getCausa().toString());
        if (expediente.getComisaria() != null) {
            jLabel3.setText("Cría/U.J.: " + expediente.getComisaria().toString());
        } else {
            jLabel3.setText("Cría/U.J.: " + expediente.getUnidadJudicial());
        }
        jLabel4.setText("Nombre y Apellido del menor: " + menor.getNombre() + " " + menor.getApellido());
        jLabel5.setText("D.N.I.: " + menor.getDni());
        jLabel6.setText("Edad: " + menor.getEdad());
        if ( menor.getProgenitor() == null || menor.getProgenitor().toString().equals("") || menor.getProgenitor().toString().equals("No tiene padre ni padrastro")) { //sin datos del padre
            if (menor.getProgenitora() == null || menor.getProgenitora().toString().equals("No tiene madre ni madrastra")) { //sin datos del madre
                jLabel7.setText("Progenitores: sin datos");
            } else { //solo hay datos de la madre
                jLabel7.setText("Progenitores: " + menor.getProgenitora().toString() + ", DNI " + menor.getProgenitora().getDni());
            }
        } else {
            if ( menor.getProgenitora() == null || menor.getProgenitora().toString().equals("No tiene madre ni madrastra")) { //solo hay datos del padre
                jLabel7.setText("Progenitores: " + menor.getProgenitor().toString() + ", DNI " + menor.getProgenitor().getDni());
            } else { //hay datos del padre y de la madre
                jLabel7.setText("Progenitores: " + menor.getProgenitor().toString() + ", DNI " + menor.getProgenitor().getDni() + " y " + menor.getProgenitora().toString() + ", DNI " + menor.getProgenitora().getDni());
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        jLabel8.setText("Fecha de inicio de la Causa: " + sdf.format(expediente.getCausa().getFechaInicio()));
        jLabel9.setText("Fiscal: " + expediente.getFiscal().getNumeroFiscal());
        jLabel10.setText("Juez: " + expediente.getJuez().toString());
        jLabel11.setText("Secretaria: " + expediente.getSecretario().toString());
        jLabel12.setText("Denunciante: " + expediente.getDenunciante().toString());
        jLabel13.setText("Fecha de Nacimiento: " + menor.getFechaNacimiento());
        if (expediente.isArchivado()) {
            jLabel14.setText("Expediente archivado: Sí");
        } else {
            jLabel14.setText("Expediente archivado: No");
        }
        jLabel15.setText("Acta inicial: " + expediente.getActaInicial().toString());
        return this.getTitle();
    }
    
    public boolean windowsClosed(WindowEvent e) {
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Información");

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Expediente:");

        jLabel2.setText("Causa:");

        jLabel3.setText("Cría/U.J.:");

        jLabel4.setText("Nombre y Apellido del menor:");

        jLabel5.setText("D.N.I.:");

        jLabel6.setText("Edad:");

        jLabel7.setText("Progenitores: ");

        jLabel8.setText("Fecha de inicio de la causa:");

        jLabel9.setText("Fiscal:");

        jLabel10.setText("Juez:");

        jLabel11.setText("Secretaria:");

        jLabel12.setText("Denunciante:");

        jLabel13.setText("Fecha de Nacimiento:");

        jLabel14.setText("Expediente archivado:");

        jLabel15.setText("Acta inicial: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                .addGap(198, 198, 198))
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/folder_16.png"))); // NOI18N
        jButton1.setText("Modificar Expediente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharBoton(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/delete_16.png"))); // NOI18N
        jButton2.setText("Eliminar registro");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharBoton(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void escucharBoton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escucharBoton
    if (evt.getSource().equals(jButton1)) { //botón de modificar registro
        GestionExpediente gestionExpte = new GestionExpediente(menor, expediente);
        gestionExpte.setVisible(true);
        this.dispose();
    } else if (evt.getSource().equals(jButton2)) { //botón de eliminar registro
        ExpedienteFacade expedienteFacade = new ExpedienteFacade();
        String msj1 = "\nError al intentar borrar Expediente.";
        if (expedienteFacade.eliminarExpediente(expediente.getId())) {
            msj1 = "";
            JOptionPane.showMessageDialog(rootPane, "Se efectuó la operación con éxito.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se pudo efectuar la operación." + msj1, "Resultado", JOptionPane.ERROR_MESSAGE);
        }
    }
}//GEN-LAST:event_escucharBoton
 
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caratula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    public static javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

    private void inicializarComponentes(Expediente expte, Menor minor) {
        this.setIconImage (new ImageIcon(getClass().getResource("/iconos/iconos16px/icon_16.png")).getImage());
        jPanel2.setVisible(true);
        expediente = expte;
        menor = minor;
        cargarPanel();
    }
}
