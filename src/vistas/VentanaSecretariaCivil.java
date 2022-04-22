/*
 * SecretariaCivil.java
 *
 * Created on 16 de marzo de 2010, 11:39
 */

package vistas;

import entidades.CausaCivil;
import entidades.Expediente;
import entidades.Persona;
import facades.CausaCivilFacade;
import includes.Constructor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author  Yorch
 */
public class VentanaSecretariaCivil extends javax.swing.JFrame {
    private CausaCivilFacade civilFacade = new CausaCivilFacade();
    private CausaCivil causaCivil = new CausaCivil();
    private Persona actor = new Persona();
    private Persona demandado = new Persona();
    private Expediente expediente = new Expediente();
    private String atributo = "";
    private Date fecActual;
    private SimpleDateFormat fechaActual;
    private String actual;
    private String[] titulosTabla = {"id","Expte.","Carátula","Estado","fecha último trámite"};
    /** Creates new form SecretariaCivil */
    public VentanaSecretariaCivil() {
        initComponents();
        inicializarComponentes();
    }
    /**
     * @param control indica qué datos se controlan después de haber presionado el botón de "Guardar" o el de "Modificar"
     * @return booleano retorna true si no existen control vacíos, y false si existieran
     */
    private boolean controlarCampos(int control) {
        boolean b = true;
        if (control == 1) {
            if(jTextField1.getText().equals("")) {
                b = false;
            } else {
                actor.setApellido(jTextField1.getText());
            }
            if(jTextField2.getText().equals("")) {
                b = false;
            } else {
                actor.setNombre(jTextField2.getText());
            }
            if(jTextField3.getText().equals("")) {
                b = false;
            } else { 
                demandado.setApellido(jTextField3.getText());
            }
            if(jTextField4.getText().equals("")) {
                b = false;
            } else {
                demandado.setNombre(jTextField4.getText());
            }
            if (jTextField5.getText().equals("")) {
                b = false;
            } else {
                String[] expte = jTextField5.getText().split("/ ");
                if (expte[1].startsWith("9")) { //expte[1] son los dos últimos dígitos del año "----"
                    expte[1] = "19" + expte[1]; //si comienza con 9 --> "--9-" => 199?
                } else { // si comienza con otro número 0 o 1
                    expte[1] = "20" + expte[1]; // => 200?  o  => 201?
                }
                expediente.setNumero(Integer.parseInt(expte[0]));
                expediente.setAnio(expte[1]);
            }
            if(jTextField9.getText().equals("")) {
                b = false;
            }
            if(jComboBox1.getSelectedIndex() == 0) {
                b = false;
            }
        }
        if (control == 2) {
            if (jTextField7.getText().equals("")) {
              b = false;  
            }
            if (jTextField8.getText().equals("")) {
            }
            if (jTextField10.getText().equals("")) {
              b = false;  
            }
            if (jComboBox3.getSelectedIndex() == 0) {
                b = false;
            } else {
                causaCivil.setEstado(String.valueOf(jComboBox3.getSelectedItem()));
            }
        }
        return b;
    }
    
    private void habilitarBotones() {
        jToggleButton1.setEnabled(true);
        jToggleButton2.setEnabled(true);
        jToggleButton3.setEnabled(true);
        jToggleButton4.setEnabled(true);
    }
    /**
     * @param campos se indica mediante un número qué campos de la ventana se vacían
     */
    private void vaciarCampos(int campos) {
        if (campos == 1) { //se vacían campos del panel "Nuevo"
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField9.setText("");
            jComboBox1.setSelectedIndex(0);
        }
        if (campos == 2) { //se vacían campos del panel "Consulta"
            jTextField6.setText("");
            jTextField6.setEnabled(false);
            jButton2.setEnabled(false);
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            habilitarBotones();
        }
        if (campos == 3) { //se vacían campos del panel "Modificar"
            jComboBox3.setSelectedIndex(-1);
            jTextArea1.setText("");
            jTextField7.setText("");
            jTextField8.setText("");
            jTextField10.setText("");
        }
    }

    private void setearFecha() {
        Calendar calendario = GregorianCalendar.getInstance();
        fecActual = new Date();
        fecActual = calendario.getTime();
        fechaActual = new SimpleDateFormat("dd/MM/yy");
        actual = fechaActual.format(fecActual);
        convertirFechaActual(actual);
    }
    /**
     * @param fecha se recibe como String la fecha corriente en el formato en que lo devuelve el sistema con la sentencia GregorianCalendar.getInstance() y lo trasnforma a tipo Date;
     * @throws ParseException en caso que la conversión de tipos de dato no sea factible
     * @see ParseException, Calendar, GregorianCalendar, Date, SimpleDateFormat
     */
    private void convertirFechaActual(String fecha) {
        try {
            fecActual = new Date();
            fechaActual = new SimpleDateFormat("dd/MM/yy");
            fecActual = fechaActual.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(VentanaSecretariaCivil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jTextField6 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setTitle("Secretaría Civil");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 51, 153))); // NOI18N

        jLabel1.setText("Expediente");

        jLabel2.setText("Estado");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Causa");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Actor"));

        jLabel3.setText("Apellido");

        jLabel4.setText("Nombre");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Demandado"));

        jLabel5.setText("Apellido");

        jLabel6.setText("Nombre");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "para decretar", "para la firma", "para sentencia", "para retirar oficio", "para sacar cédula" }));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/save_16.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, 321, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField9)))
                    .addComponent(jButton1)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 51, 153))); // NOI18N

        jToggleButton1.setText("Expte");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jToggleButton2.setText("Apellido actor");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jToggleButton3.setText("Apellido demandado");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jToggleButton4.setText("Causa");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarExpteCivil(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                habilitarBoton(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/search_16.png"))); // NOI18N
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Expte.", "Carátula", "Estado", "fecha último trámite"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarFila(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setMinWidth(40);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(30);
        jTable1.getColumnModel().getColumn(1).setMinWidth(70);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(70);
        jTable1.getColumnModel().getColumn(3).setMinWidth(130);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(130);
        jTable1.getColumnModel().getColumn(3).setMaxWidth(130);
        jTable1.getColumnModel().getColumn(4).setMinWidth(120);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(4).setMaxWidth(120);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jToggleButton1)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton3)
                    .addComponent(jToggleButton4)
                    .addComponent(jButton2)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modificar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 51, 153))); // NOI18N

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Expte");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Carátula");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Incidente");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Estado");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/pencil_16.png"))); // NOI18N
        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "para decretar", "para la firma", "para sentencia", "para retirar oficio", "para sacar cédula" }));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Causa");

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, 281, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField10)
                        .addComponent(jLabel13))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(41, 41, 41))
                            .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)))
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void escucharFuente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escucharFuente
    if(evt.getSource().equals(jButton1)) {  //metodo para ingresar nuevo expte
        guardarCausaCivil();
    } else if(evt.getSource().equals(jButton2)) {  //metodo de consultar
        buscarCausaCivil();
    } else if (evt.getSource().equals(jButton3)) {  //metodo de modificar
        modificarCausaCivil();
    } else if(evt.getSource().equals(jToggleButton1)) {
        if(jToggleButton1.isSelected()) {
            jToggleButton2.setEnabled(false);
            jToggleButton3.setEnabled(false);
            jToggleButton4.setEnabled(false);
            jTextField6.setEnabled(true);
            jTextField6.grabFocus();
            atributo = "expte";
        } else {
            jToggleButton2.setEnabled(true);
            jToggleButton3.setEnabled(true);
            jToggleButton4.setEnabled(true);
            jTextField6.setEnabled(false);
        }
    } else if(evt.getSource().equals(jToggleButton2)) {
        if(jToggleButton2.isSelected()) {
            jToggleButton1.setEnabled(false);
            jToggleButton3.setEnabled(false);
            jToggleButton4.setEnabled(false);
            jTextField6.setEnabled(true);
            jTextField6.grabFocus();
            atributo = "apellido actor";
        } else {
            jToggleButton1.setEnabled(true);
            jToggleButton3.setEnabled(true);
            jToggleButton4.setEnabled(true);
            jTextField6.setEnabled(false);
        }
    } else if(evt.getSource().equals(jToggleButton3)) {
        if(jToggleButton3.isSelected()) {
            jToggleButton1.setEnabled(false);
            jToggleButton2.setEnabled(false);
            jToggleButton4.setEnabled(false);
            jTextField6.setEnabled(true);
            jTextField6.grabFocus();
            atributo = "apellido demandado";
        } else {
            jToggleButton1.setEnabled(true);
            jToggleButton2.setEnabled(true);
            jToggleButton4.setEnabled(true);
            jTextField6.setEnabled(false);
        }
    } else if(evt.getSource().equals(jToggleButton4)) {
        if(jToggleButton4.isSelected()) {
            jToggleButton1.setEnabled(false);
            jToggleButton2.setEnabled(false);
            jToggleButton3.setEnabled(false);
            jTextField6.setEnabled(true);
            jTextField6.grabFocus();
            atributo = "causa";
        } else {
            jToggleButton1.setEnabled(true);
            jToggleButton2.setEnabled(true);
            jToggleButton3.setEnabled(true);
            jTextField6.setEnabled(false);
        }
    }
}//GEN-LAST:event_escucharFuente

private void seleccionarFila(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarFila
    try {
        if (!jTable1.getValueAt(jTable1.getSelectedRow(), 1).equals("")) {
            causaCivil = civilFacade.buscarPorExpediente((String)jTable1.getValueAt(jTable1.getSelectedRow(), 1));
            if (causaCivil != null) {
                jButton3.setEnabled(true);
                jTextField7.setText(causaCivil.getExpte().toString());
                if (!causaCivil.getIncidente().equals("")) {
                    jTextField8.setText(causaCivil.getIncidente());
                }
                jTextField10.setText(causaCivil.getCausa());
                jTextArea1.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 2));
                for (int i = 0; i < jComboBox3.getItemCount(); i++) {
                    if (causaCivil.getEstado().equals((String) jComboBox3.getItemAt(i))) {
                        jComboBox3.setSelectedIndex(i);
                    }
                }
            }
        }
    } catch (NullPointerException e) {
        jTable1.clearSelection();
    }
}//GEN-LAST:event_seleccionarFila

private void habilitarBoton(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_habilitarBoton
    if(jTextField6.getText().length()>2){
        jButton2.setEnabled(true);
    } else {
        jButton2.setEnabled(false);
    }
}//GEN-LAST:event_habilitarBoton

//metodo que captura el evento del textfield donde se escribe el parametro de busqueda, este evento es si se presiona Enter en el textField
private void buscarExpteCivil(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarExpteCivil
        if(!civilFacade.buscarPorParametro(atributo, jTextField6.getText()).isEmpty()) {
            Constructor.cargarTabla(jTable1, 5, titulosTabla, "CausaCivil", civilFacade.buscarPorParametro(atributo, jTextField6.getText()));
            vaciarCampos(2);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró expte. con el parámetro especificado", "Resultado", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_buscarExpteCivil

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    // End of variables declaration//GEN-END:variables

    private void inicializarComponentes() {
        this.setIconImage (new ImageIcon(getClass().getResource("/iconos/iconos16px/icon_16.png")).getImage());
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jTextField6.setEnabled(false);
    }

    private void guardarCausaCivil() {
        int contador = civilFacade.getTodos().size();
        if(controlarCampos(1)) {
            setearFecha();
            causaCivil.setActor(actor);
            causaCivil.setDemandado(demandado);
            causaCivil.setExpte(expediente);
            causaCivil.setCausa(jTextField9.getText());
            causaCivil.setEstado(String.valueOf(jComboBox1.getSelectedItem()));
            causaCivil.setFechaUltimoTramite(fecActual);
            civilFacade.altaCausa(causaCivil);
            if(contador++ == civilFacade.getTodos().size()) {
                vaciarCampos(1);
                JOptionPane.showMessageDialog(rootPane, "Los datos se almacenaron correctamente. ", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se pudieron ingresar los datos. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,"Complete los campos vacíos","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarCausaCivil() {
        if(!civilFacade.buscarPorParametro(atributo, jTextField6.getText()).isEmpty()) {
            Constructor.cargarTabla(jTable1, 5, titulosTabla, "CausaCivil", civilFacade.buscarPorParametro(atributo, jTextField6.getText()));
            vaciarCampos(2);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró expte. con el parámetro especificado", "Resultado", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarCausaCivil() {
        if (controlarCampos(2)) {
            String[] expte = jTextField7.getText().split("/");
            if (expte[1].startsWith("9")) { //expte[1] son los dos últimos dígitos del año "----"
                expte[1] = "19" + expte[1]; //si comienza con 9 --> "--9-" => 199_?
            } else { // si comienza con otro número 0 o 1
                expte[1] = "20" + expte[1]; // => 200_?  o  => 201_?
            }
            expediente.setNumero(Integer.parseInt(expte[0]));
            expediente.setAnio(expte[1]);
            String[] caratula = jTextArea1.getText().split(" s/ "); //se obtiene la causa
            String[] actores = caratula[0].split(" c/ "); //se obtienen ambas partes
            String[] actorApeNom = actores[0].split(", "); //se obtiene apellido y nombre de actor
            String[] demandadoApeNom = actores[1].split(", "); //se obtiene apellido y nombre de demandado
            actor.setApellido(actorApeNom[0]);
            actor.setApellido(actorApeNom[1]);
            demandado.setApellido(demandadoApeNom[0]);
            demandado.setNombre(demandadoApeNom[1]);
            causaCivil.setCausa(caratula[1]); //cargo causa
            causaCivil.setActor(actor); //cargo actor
            causaCivil.setDemandado(demandado); //cargo demandado
            causaCivil.setExpte(expediente); //cargo expediente
            causaCivil.setIncidente(jTextField10.getText()); //cargo incidente
            causaCivil.setEstado((String)jComboBox1.getSelectedItem()); //cargo estado
            causaCivil.setFechaUltimoTramite((Date)jTable1.getValueAt(jTable1.getSelectedRow(), 4));
            if (civilFacade.modificarCausaCivil(causaCivil)) {
                vaciarCampos(3);
                habilitarBotones();
                jTable1.clearSelection();
                JOptionPane.showMessageDialog(this, "Los datos fueron modificados correctamente", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Los datos no fueron modificados. Intente nuevamente la operación", "Resultado", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Complete los campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
