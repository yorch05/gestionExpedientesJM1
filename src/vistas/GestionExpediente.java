/*
 * GestionExpediente.java
 *
 * Created on 16 de octubre de 2009, 10:22
 */
package vistas;

import facades.ComisariaFacade;
import facades.ExpedienteFacade;
import facades.JuezFacade;
import facades.SecretariaFacade;
import facades.UnidadJudicialFacade;
import entidades.ActaInicial;
import entidades.Causa;
import entidades.Comisaria;
import entidades.Denunciante;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import entidades.Menor;
import entidades.Expediente;
import entidades.Fiscal;
import entidades.Juez;
import entidades.Persona;
import entidades.Secretaria;
import entidades.UnidadJudicial;
import facades.MenorFacade;
import includes.Constructor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author  Yorch
 */
public class GestionExpediente extends javax.swing.JFrame {

    private int cantDenunciados = 1;
    public boolean botonCerrar = false;
    private boolean f = false;
    private boolean f1 = false,  f2 = false;
    private Expediente expediente = new Expediente();
    private ActaInicial actuacion = new ActaInicial();;
    private Menor menor = new Menor();
    private Causa causa = new Causa();
    private Denunciante denunciante = new Denunciante();
    private Fiscal fiscal = new Fiscal();
    private Juez juez = new Juez();
    private Secretaria secretaria = new Secretaria();
    private Persona progenitor = new Persona(), progenitora = new Persona();
    private String nomApeJuez;
    private String nomApeSecretaria;
    private String[] nomApe = null; //utilizado para almacenar nombre y apellido por separados de juez o secretaria
    private List<Menor> listaMenores = new ArrayList();
    private List<Expediente> listaExpedientes = new ArrayList();
    private String[] den = {"", ""};

    /** Creates new form GestionExpediente */
    public GestionExpediente() {
        initComponents();
        inicializarComponentes("alta");
    }

    public GestionExpediente(Menor menor, Expediente expediente) {
        initComponents();
        inicializarComponentes("modificación");
        rellenarCampos(menor, expediente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta de Expedientes");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Expediente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 153))); // NOI18N

        jRadioButton1.setBackground(new java.awt.Color(204, 204, 255));
        jRadioButton1.setText("Comisaría");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonMouseClicked(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(204, 204, 255));
        jRadioButton2.setText("Unidad Judicial");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonMouseClicked(evt);
            }
        });

        jLabel2.setText("Número");

        jLabel3.setText("Año");

        jLabel4.setText("Causa");

        jLabel5.setText("Denunciante");

        jLabel6.setText("Juez");

        jLabel7.setText("Secretaria");

        jLabel21.setText("Fiscal");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel23.setForeground(new java.awt.Color(204, 0, 0));
        jLabel23.setText(" * ");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel24.setForeground(new java.awt.Color(204, 0, 0));
        jLabel24.setText(" * ");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel25.setForeground(new java.awt.Color(204, 0, 0));
        jLabel25.setText(" * ");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel26.setForeground(new java.awt.Color(204, 0, 0));
        jLabel26.setText(" * ");

        jLabel27.setText("Fecha inicio");

        jLabel33.setText("Acta inicial");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                borrarLabel(evt);
            }
        });

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                borrarLabel(evt);
            }
        });

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                borrarLabel(evt);
            }
        });

        jTextField5.setForeground(new java.awt.Color(153, 153, 153));
        jTextField5.setText("\"nombre, apellido\"");
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });

        jTextField18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                borrarLabel(evt);
            }
        });

        jCheckBox2.setText("Expediente Archivado");

        jButton5.setText("nuevo/a");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText("nuevo/a");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Buscar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel21)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox3, 0, 268, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, 268, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
                                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(135, 135, 135))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jRadioButton1)
                .addGap(4, 4, 4)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel24))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(jCheckBox2))
                .addContainerGap())
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/save_16.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarExpte(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/flag_16.png"))); // NOI18N
        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarAlta(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/delete_16.png"))); // NOI18N
        jButton6.setText("Cerrar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarAlta(evt);
            }
        });

        jTabbedPane1.setName("Denunciado"); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel8.setText("Nombre");

        jLabel9.setText("Apellido");

        jLabel10.setText("D.N.I.");

        jLabel11.setText("edad");

        jLabel12.setText("fecha de nacimiento");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        jFormattedTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField1.setText("--/--/--");

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                borrarLabel(evt);
            }
        });

        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                borrarLabel(evt);
            }
        });

        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                borrarLabel(evt);
            }
        });

        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                borrarLabel(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("Padre");

        jLabel14.setText("nombre");

        jLabel15.setText("apellido");

        jLabel16.setText("D.N.I.");

        jLabel17.setText("Madre");

        jLabel18.setText("nombre");

        jLabel19.setText("apellido");

        jLabel20.setText("D.N.I.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel13))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField13)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel17))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jCheckBox1.setBackground(new java.awt.Color(204, 204, 255));
        jCheckBox1.setText("Progenitores");
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseClicked(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel29.setForeground(new java.awt.Color(204, 0, 0));
        jLabel29.setText(" * ");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel30.setForeground(new java.awt.Color(204, 0, 0));
        jLabel30.setText(" * ");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel31.setForeground(new java.awt.Color(204, 0, 0));
        jLabel31.setText(" * ");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel32.setForeground(new java.awt.Color(204, 0, 0));
        jLabel32.setText(" * ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(64, 64, 64)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(308, 308, 308))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)))
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Denunciado1", jPanel2);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 10));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/plus_16.png"))); // NOI18N
        jButton3.setText("agregar menor");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarMenor(evt);
            }
        });

        jLabel28.setText("Menores en la causa:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(406, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void guardarExpte(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarExpte
    System.out.println("DESPUES DE PRESIONAR BOTON");
    if (verificarCamposExpte()) {
        if (verificarCamposMenor()) {
            cargarDatos();
            ingresarExpte();
            if (f1) {//& f2) {  //si se ingresó el expediente y los menores corectamente se confirma la operacion
                limpiarVentana();
                cantDenunciados = 1;
                den[0] = "";
                den[1] = "";
                listaMenores.clear();
                listaExpedientes.clear();
                JOptionPane.showMessageDialog(rootPane, "Los datos fueron ingresados correctamente.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se pudo efectuar el ingreso de los datos.", "Operación cancelada", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Complete los campos obligatorios (los que muestran un asterisco rojo)", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Complete los campos obligatorios (los que muestran un asterisco rojo)", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
    }
}//GEN-LAST:event_guardarExpte

private void borrarLabel(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_borrarLabel
    if (evt.getSource().equals(jTextField2)) {
        jLabel23.setVisible(false);
    } else if (evt.getSource().equals(jTextField3)) {
        jLabel24.setVisible(false);
    } else if (evt.getSource().equals(jTextField4)) {
        jLabel25.setVisible(false);
    } else if (evt.getSource().equals(jTextField18)) {
        jLabel26.setVisible(false);
    } else if (evt.getSource().equals(jTextField8)) {
        jLabel29.setVisible(false);
    } else if (evt.getSource().equals(jTextField9)) {
        jLabel30.setVisible(false);
    } else if (evt.getSource().equals(jTextField10)) {
        jLabel31.setVisible(false);
    } else if (evt.getSource().equals(jTextField11)) {
        jLabel32.setVisible(false);
    }
}//GEN-LAST:event_borrarLabel

private void cerrarAlta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarAlta
    this.dispose();
}//GEN-LAST:event_cerrarAlta

private void agregarMenor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarMenor
    cantDenunciados++;
    if (verificarCamposExpte()) {
        dialogAgregarMenor agregarMenor = new dialogAgregarMenor(this, true);
        agregarMenor.setVisible(true);
        agregarMenor.setNumeroDenunciado(cantDenunciados);
        listaMenores.add(agregarMenor.getMenor());
    } else {
        JOptionPane.showMessageDialog(this, "Antes de ingresar un menor complete los campos obligatorios (los que muestran un asterisco rojo)", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
    }
}//GEN-LAST:event_agregarMenor

private void cancelarAlta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarAlta
    if (JOptionPane.showConfirmDialog(rootPane, "Esto hará que se borren los campos ingresados. ¿Desea continuar?", "Confirmar", JOptionPane.YES_NO_OPTION) == 0) {
        vaciarCamposExpte();
        vaciarCamposMenor();
        jLabel28.setText("");
        jLabel28.setVisible(false);
    }
}//GEN-LAST:event_cancelarAlta

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    nomApeJuez = JOptionPane.showInputDialog(rootPane, "Ingrese Nombre y Apellido separados por una coma (,)", "Nuevo Juez", JOptionPane.OK_CANCEL_OPTION);
    if (nomApeJuez.contains(", ")) {
        nomApe = nomApeJuez.split(", ");
    } else { //si no hay espacio en blanco después de la coma
        nomApe = nomApeJuez.split(",");
    }
    JuezFacade juezFacade = new JuezFacade();
    Juez juez = new Juez();
    juez.setNombre(nomApe[0]);
    juez.setApellido(nomApe[1]);
    juezFacade.altaJuez(juez);
    Constructor.cargarJCombo(jComboBox2, juezFacade.getTodos());
}//GEN-LAST:event_jButton5ActionPerformed

private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    nomApeSecretaria = JOptionPane.showInputDialog(rootPane, "Ingrese Nombre y Apellido separados por una coma (,)", "Nueva Secreatria/o", JOptionPane.OK_CANCEL_OPTION);
    if (nomApeSecretaria.contains(", ")) {
        nomApe = nomApeSecretaria.split(", ");
    } else {
        nomApe = nomApeSecretaria.split(",");
    }
    SecretariaFacade secretariaFacade = new SecretariaFacade();
    Secretaria secretaria = new Secretaria();
    secretaria.setNombre(nomApe[0]);
    secretaria.setApellido(nomApe[1]);
    secretariaFacade.altaSecretaria(secretaria);
    Constructor.cargarJCombo(jComboBox3, secretariaFacade.getTodos());
}//GEN-LAST:event_jButton7ActionPerformed

private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    dialogActaInicial actaInicial = new dialogActaInicial(this, true);
    Constructor.centrarDialog(actaInicial);
    actaInicial.setVisible(true);
    actuacion = actaInicial.getActaInicial();
    if ( actuacion != null) {
        jTextField19.setText(actuacion.toString());
    }
}//GEN-LAST:event_jButton8ActionPerformed

private void jRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonMouseClicked
    ComisariaFacade comisariaFacade = new ComisariaFacade();
    UnidadJudicialFacade unidadJudicialFacade = new UnidadJudicialFacade();
    if (evt.getSource().equals(jRadioButton1)) {
        if (jRadioButton1.isSelected()) {
            jRadioButton2.setSelected(false);
            Constructor.cargarJCombo(jComboBox1, comisariaFacade.getTodos());
            jComboBox1.setVisible(true);
            jComboBox1.setSelectedIndex(-1);
        } else {            
            jComboBox1.setVisible(false);
            jComboBox1.setSelectedIndex(-1);
        }
    } else {
        if (jRadioButton2.isSelected()) {
            jRadioButton1.setSelected(false);
            Constructor.cargarJCombo(jComboBox1, unidadJudicialFacade.getTodos());
            jComboBox1.setVisible(true);
            jComboBox1.setSelectedIndex(-1);
        } else {
            jComboBox1.setVisible(false);
            jComboBox1.setSelectedIndex(-1);
        }
    }
}//GEN-LAST:event_jRadioButtonMouseClicked

private void jCheckBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseClicked
    if (jCheckBox1.isSelected()) {
        jPanel3.setVisible(true);
    } else {
        jPanel3.setVisible(false);
    }
}//GEN-LAST:event_jCheckBox1MouseClicked

private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
    jTextField5.setText("");
    jTextField5.setForeground(Color.black);
}//GEN-LAST:event_jTextField5MouseClicked
    
    private void vaciarCamposExpte() {
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jComboBox1.setSelectedIndex(-1);
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField18.setText("");
        jTextField19.setText("");
        jXDatePicker1.repaint();
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
    }
    
    private void vaciarCamposMenor() {
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
        jTextField12.setText("");
        jTextField13.setText("");
        jTextField14.setText("");
        jTextField15.setText("");
        jTextField16.setText("");
        jTextField17.setText("");
        jCheckBox1.setSelected(false);
        jFormattedTextField1.setText("--/--/--");
        jPanel3.setVisible(false);
    }

    private boolean verificarCamposExpte() {
        System.out.println("DENTRO DE VERIFICAR CAMPOS EXPTE");
        f = true;
        if ("".equals(jTextField2.getText())) {
            jLabel23.setVisible(true);
            f = false;
        }
        if ("".equals(jTextField3.getText())) {
            jLabel24.setVisible(true);
            f = false;
        }
        if ("".equals(jTextField4.getText())) {
            jLabel25.setVisible(true);
            f = false;
        }
        if ("".equals(jTextField18.getText())) {
            jLabel26.setVisible(true);
            f = false;
        }
        return f;
    }
    
    private boolean verificarCamposMenor() { //comprueba que los campos del menor no esten vacíos
        System.out.println("DENTRO DE VERIFICAR CAMPOS MENOR");
        f = true;
        if ("".equals(jTextField8.getText())) {
            jLabel29.setVisible(true);
            f = false;
        }
        if ("".equals(jTextField9.getText())) {
            jLabel30.setVisible(true);
            f = false;
        }
        if ("".equals(jTextField10.getText())) {
            jLabel31.setVisible(true);
            f = false;
        }
        if ("".equals(jTextField11.getText())) {
            jLabel32.setVisible(true);
            f = false;
        }
        return f;
    }
    
    private void cargarDatos() {
        System.out.println("DENTRO DE CARGAR DATOS");
        if (jRadioButton1.isSelected()) {
            expediente.setComisaria((Comisaria) jComboBox1.getSelectedItem());
            expediente.setUnidadJudicial(null);
        } else if (jRadioButton2.isSelected()) {
            expediente.setUnidadJudicial((UnidadJudicial) jComboBox1.getSelectedItem());
            expediente.setComisaria(null);
        } else {
            expediente.setComisaria(null);
            expediente.setUnidadJudicial(null);
        }
        try {
            if (this.getTitle().equals("Modificación de Expediente")) {
                String[] letraActaInicial = jTextField19.getText().split(" "); //separo "A" y ---/--  por el espacio
                actuacion.setLetra(letraActaInicial[0]);
                String[] numActaInicial = letraActaInicial[1].split("/"); //separo ---- y --  (n° y año) por la barra
                actuacion.setNumero(Integer.valueOf(numActaInicial[0])); //almaceno el número de expediente
                actuacion.setAño("20"+numActaInicial[1]); //almaceno el año de expediente
            }
            expediente.setNumero(Integer.valueOf(jTextField2.getText()));
            expediente.setAnio(jTextField3.getText());
        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Formato de número incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
        }
        causa.setDescripcion(jTextField4.getText());
        if (jTextField5.getText().contains(", ")) {
            den = jTextField5.getText().split(", ");
        } else {
            den = jTextField5.getText().split(",");
        }
        denunciante.setNombre(den[0]);
        denunciante.setApellido(den[1]);
        juez = (Juez) jComboBox2.getSelectedItem();
        secretaria = (Secretaria) jComboBox3.getSelectedItem();
        fiscal.setNumeroFiscal(Integer.valueOf(jTextField18.getText()));
        causa.setFechaInicio(jXDatePicker1.getDate());
        expediente.setActaInicial(actuacion);
        expediente.setCausa(causa);
        expediente.setDenunciante(denunciante);
        expediente.setFiscal(fiscal);
        expediente.setJuez(juez);
        expediente.setSecretario(secretaria);
        if (jCheckBox2.isSelected()) {
            expediente.setArchivado(true);
        } else {
            expediente.setArchivado(false);
        }
        cargarDatosMenor();
        expediente.setMenor(listaMenores);
    }
    
    private void ingresarExpte() {
        System.out.println("DENTRO DE INGRESAR EXPEDIENTE");
        ExpedienteFacade expedienteFacade = new ExpedienteFacade();
        if (this.getTitle().equals("Modificación de Expediente")) {
            System.out.println("TITULO --------> " + this.getTitle());
            if (expedienteFacade.modificarExpediente(expediente) && ingresarMenor()) f1 = true;
            else f1 = false;
        } else {
            System.out.println("TITULO --------> DISTINTO A MODIFICACIÓN DE EXPEDIENTE");
            expedienteFacade.altaExpediente(expediente);
            if (expediente.getId() != null) {
                if (ingresarMenor()) f1 = true;
                else f1 = false;
            }
        }
    }
    
    private boolean ingresarMenor() { //este módulo es para ingresar el objeto expediente a la lista que tiene el objeto Menor
        System.out.println("DENTRO DE INGRESAR MENOR");
        listaExpedientes.add(expediente);
        menor.setExpedientes(listaExpedientes);
        MenorFacade menorFacade = new MenorFacade();
        if (menorFacade.modificarMenor(menor)) return true;
        else return false;
    }
    
    private void limpiarVentana() {
        jRadioButton1.setSelected(false);        
        jRadioButton2.setSelected(false);
        jRadioButton1.setEnabled(true);
        jRadioButton2.setEnabled(true);
        jComboBox1.setSelectedIndex(-1);
        jComboBox2.setSelectedIndex(-1);
        jComboBox3.setSelectedIndex(-1);
        jComboBox1.setVisible(false);
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
        jTextField12.setText("");
        jTextField13.setText("");
        jTextField14.setText("");
        jTextField15.setText("");
        jTextField16.setText("");
        jTextField17.setText("");
        jTextField18.setText("");
        jTextField19.setText("");
        jFormattedTextField1.setText("--/--/--");
        jXDatePicker1.repaint();
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jPanel3.setVisible(false);
        jLabel28.setText("");
    }
  
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionExpediente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    // End of variables declaration//GEN-END:variables

    private void inicializarComponentes(String tipoInicio) {
        System.out.println("DENTRO DE INICIALIZAR CAMPOS");
        this.setIconImage(new ImageIcon(getClass().getResource("/iconos/iconos16px/icon_16.png")).getImage());
        jComboBox1.setVisible(false);
        jPanel3.setVisible(false);
        jLabel23.setVisible(false);
        jLabel24.setVisible(false);
        jLabel25.setVisible(false);
        jLabel26.setVisible(false);
        jLabel28.setVisible(false);
        jLabel29.setVisible(false);
        jLabel30.setVisible(false);
        jLabel31.setVisible(false);
        jLabel32.setVisible(false);
        JuezFacade juezFacade = new JuezFacade();
        SecretariaFacade secretariaFacade = new SecretariaFacade();
        Constructor.cargarJCombo(jComboBox2, juezFacade.getTodos());
        Constructor.cargarJCombo(jComboBox3, secretariaFacade.getTodos());
        jComboBox2.setSelectedIndex(-1);
        jComboBox3.setSelectedIndex(-1);
        if (tipoInicio.equals("modificación")) {
            System.out.println("SE TRATA DE UNA MODIFICACIÓN");
            this.setTitle("Modificación de Expediente");
            jButton2.setVisible(false);
            jTextField5.setForeground(Color.black);
        }
    }

    public void rellenarCampos(Menor menor, Expediente expediente) {
        System.out.println("DENTRO DE RELLENAR CAMPOS");
        jTextField2.setText(String.valueOf(expediente.getNumero()));
        jTextField3.setText(expediente.getAnio());
        jTextField4.setText(expediente.getCausa().toString());
        jTextField5.setText(expediente.getDenunciante().toString());
        jTextField8.setText(menor.getNombre());
        jTextField9.setText(menor.getApellido());
        jTextField10.setText(menor.getDni());
        jTextField11.setText(String.valueOf(menor.getEdad()));
        jTextField18.setText(expediente.getFiscal().toString());
        jTextField19.setText(expediente.getActaInicial().toString());
        jFormattedTextField1.setText(menor.getFechaNacimiento());
        jXDatePicker1.setDate((expediente.getCausa().getFechaInicio()));
        for (int index = 0; index < jComboBox2.getItemCount(); index++) { //seteo el comboBox con el valor del atributo
            if (String.valueOf(jComboBox2.getItemAt(index)).equals(expediente.getJuez().toString())) { //comparoel valor de cada item del combo con el valor almacenado
                jComboBox2.setSelectedIndex(index);
            }
        }
        for (int index = 0; index < jComboBox3.getItemCount(); index++) { //seteo el comboBox con el valor del atributo
            if (String.valueOf(jComboBox3.getItemAt(index)).equals(expediente.getSecretario().toString())) { //comparoel valor de cada item del combo con el valor almacenado
                jComboBox3.setSelectedIndex(index);
            }
        }        
        //métodos de carga de comboBox utilizados en "NuevaAudiencia"
        if (expediente.getComisaria() != null) {
            jRadioButton1.setSelected(true);
            ComisariaFacade comisariaFacade = new ComisariaFacade();
            Constructor.cargarJCombo(jComboBox1, comisariaFacade.getTodos());
            jComboBox1.setVisible(true);
            for (int index = 0; index < jComboBox1.getItemCount(); index++) { //seteo el comboBox con el valor del atributo
                if (String.valueOf(jComboBox1.getItemAt(index)).equals(expediente.getComisaria().getDescripcion())) { //comparoel valor de cada item del combo con el valor almacenado
                    jComboBox1.setSelectedIndex(index);
                }
            }
        } else {
            jRadioButton2.setSelected(true);
            UnidadJudicialFacade ujf = new UnidadJudicialFacade();
            Constructor.cargarJCombo(jComboBox1, ujf.getTodos());
            jComboBox1.setVisible(true);
            for (int index = 0; index < jComboBox1.getItemCount(); index++) { //seteo el comboBox con el valor del objeto
                if (String.valueOf(jComboBox1.getItemAt(index)).equals(expediente.getUnidadJudicial().getDescripcion())) {
                    jComboBox1.setSelectedIndex(index);
                }
            }
        }
        if (expediente.isArchivado()) {
            jCheckBox2.setSelected(true);
        } else {
            jCheckBox2.setSelected(false);
        }
        if (menor.getProgenitor() != null || menor.getProgenitora() != null) {
            jCheckBox1.setSelected(true);
            jPanel3.setVisible(true);
            jTextField12.setText(menor.getProgenitor().getNombre());
            jTextField13.setText(menor.getProgenitor().getApellido());
            jTextField14.setText(menor.getProgenitor().getDni());
            jTextField15.setText(menor.getProgenitora().getNombre());
            jTextField16.setText(menor.getProgenitor().getApellido());
            jTextField17.setText(menor.getProgenitora().getDni());
        }
    }

    private void cargarDatosMenor() {
        System.out.println("DENTRO DE CARGAR DATOS MENOR");
        menor.setNombre(jTextField8.getText());
        menor.setApellido(jTextField9.getText());
        menor.setDni(jTextField10.getText());
        try {
            menor.setEdad(Integer.valueOf(jTextField11.getText()));
        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Verificar que el campo de edad no está vacío o que sea un número válido", "Atención", JOptionPane.WARNING_MESSAGE);
        }
        menor.setFechaNacimiento(jFormattedTextField1.getText());
        if (jCheckBox1.isSelected()) {
            progenitor.setNombre(jTextField12.getText());
            progenitor.setApellido(jTextField13.getText());
            progenitor.setDni(jTextField14.getText());
            progenitora.setNombre(jTextField15.getText());
            progenitora.setApellido(jTextField16.getText());
            progenitora.setDni(jTextField17.getText());
            menor.setProgenitor(progenitor);
            menor.setProgenitora(progenitora);
        }
        listaMenores.add(menor);
    }
}