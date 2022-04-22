/*
 * FliaMenor.java
 *
 * Created on 9 de noviembre de 2009, 08:23
 */

package vistas;

import facades.EstupefacienteFacade;
import facades.MenorFacade;
import entidades.Estupefaciente;
import entidades.Expediente;
import entidades.GrupoConvivencia;
import entidades.Menor;
import includes.Constructor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author  Yorch
 */
public class EntornoMenor extends javax.swing.JFrame {
    private boolean f1 = true, f2 = true, f3 = true, f4 = true, text = true;
    private String m1 = "", m2 = "", m3 = "", m4 = "";
    private Menor menor = new Menor();
    private GrupoConvivencia grupo = new GrupoConvivencia();
    private Expediente expediente = new Expediente();
    public String tipoVentana = "";
    
    public EntornoMenor() {
        initComponents();
        inicializarComponentes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jTextField5 = new javax.swing.JTextField();
        jCheckBox21 = new javax.swing.JCheckBox();
        jCheckBox22 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingresar Información del Menor");
        setBackground(new java.awt.Color(153, 153, 255));
        setForeground(new java.awt.Color(153, 153, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 51))); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Expte.");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Ilícito");

        jLabel3.setText("Menor");

        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("----/--");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                borrarCampo(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formatearCampo(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Edad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addGap(169, 169, 169))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Grupo de convivencia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 51))); // NOI18N

        jCheckBox1.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox1.setText("Padre");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlarCheckBox(evt);
            }
        });

        jCheckBox2.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox2.setText("Madre");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlarCheckBox(evt);
            }
        });

        jCheckBox3.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox3.setText("Padrastro");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlarCheckBox(evt);
            }
        });

        jCheckBox4.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox4.setText("Madrastra");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlarCheckBox(evt);
            }
        });

        jCheckBox5.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox5.setText("Hermano");
        jCheckBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                habilitarSpinner(evt);
            }
        });

        jCheckBox6.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox6.setText("Hermana");
        jCheckBox6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                habilitarSpinner(evt);
            }
        });

        jCheckBox7.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox7.setText("Ninguno");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlarCheckBox(evt);
            }
        });

        jCheckBox8.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox8.setText("Ninguna");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlarCheckBox(evt);
            }
        });

        jCheckBox9.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox9.setText("Tio");

        jCheckBox10.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox10.setText("Abuelo");

        jCheckBox14.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox14.setText("Instituto de menores");
        jCheckBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlarCheckBox(evt);
            }
        });

        jCheckBox15.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox15.setText("Tia");

        jCheckBox16.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox16.setText("Abuela");

        jCheckBox17.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox17.setText("Primo");

        jCheckBox18.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox18.setText("Prima");

        jCheckBox19.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox19.setText("Cuñado");

        jCheckBox20.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox20.setText("Cuñada");

        jCheckBox21.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox21.setText("Sobrino");

        jCheckBox22.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox22.setText("Sobrina");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                .addComponent(jCheckBox5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jCheckBox15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jCheckBox6, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(jCheckBox14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox4)
                                    .addComponent(jCheckBox3)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jSpinner2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jCheckBox20)
                                    .addComponent(jCheckBox19))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox21)
                                    .addComponent(jCheckBox18)
                                    .addComponent(jCheckBox8)
                                    .addComponent(jCheckBox7)
                                    .addComponent(jCheckBox17)
                                    .addComponent(jCheckBox22)))
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
                    .addComponent(jCheckBox10)
                    .addComponent(jCheckBox16))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox5)
                                .addGap(32, 32, 32)
                                .addComponent(jCheckBox9)
                                .addGap(7, 7, 7)
                                .addComponent(jCheckBox15))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jCheckBox6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox19)
                                    .addComponent(jCheckBox21)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox3)
                                    .addComponent(jCheckBox7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox4)
                                    .addComponent(jCheckBox8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jCheckBox18)
                                .addGap(29, 29, 29)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox20)
                            .addComponent(jCheckBox22))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox14)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                borrarLabel(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Más información", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 51))); // NOI18N

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Monospaced", 2, 13));
        jTextArea2.setForeground(new java.awt.Color(153, 153, 153));
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("información adicional para agregar...");
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vaciarAreaComentarios(evt);
            }
        });
        jTextArea2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                escribirAreaComentarios(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/save_16.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarInfoFlia(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/pencil_16.png"))); // NOI18N
        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarInfo(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/right_16.png"))); // NOI18N
        jButton3.setText("Listo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarCampos(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Situación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 51))); // NOI18N

        jCheckBox11.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox11.setText("Escolaridad");

        jCheckBox12.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox12.setText("Trabajo");

        jCheckBox13.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox13.setText("Consumo de estupefacientes");
        jCheckBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlarCheckBox(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox11)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jCheckBox13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, 142, Short.MAX_VALUE))
                    .addComponent(jCheckBox12))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jCheckBox11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox13)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/search_16.png"))); // NOI18N
        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarExpte(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(183, 183, 183))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, 0, 266, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(jButton3)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void borrarCampo(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_borrarCampo
    if(jTextField1.getText().equals("----/--")){
        jTextField1.setText("");
        jTextField1.setForeground(Color.BLACK);
    }
}//GEN-LAST:event_borrarCampo

private void controlarCheckBox(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlarCheckBox
    if(evt.getSource().equals(jCheckBox1)){
        if(jCheckBox1.isSelected()){
            jCheckBox3.setEnabled(false);
            jCheckBox7.setEnabled(false);
            inhabilitarOpcionConv();
        }else {
            jCheckBox3.setEnabled(true);
            jCheckBox7.setEnabled(true);
            habilitarOpcionConv();
        }
    } else if(evt.getSource().equals(jCheckBox2)){
        if(jCheckBox2.isSelected()){
            jCheckBox4.setEnabled(false);
            jCheckBox8.setEnabled(false);
            inhabilitarOpcionConv();
        }else {
            jCheckBox4.setEnabled(true);
            jCheckBox8.setEnabled(true);
            habilitarOpcionConv();
        }
    } else if(evt.getSource().equals(jCheckBox3)){
        if(jCheckBox3.isSelected()){
            jCheckBox1.setEnabled(false);
            jCheckBox7.setEnabled(false);
            inhabilitarOpcionConv();
        }else {
            jCheckBox1.setEnabled(true);
            jCheckBox7.setEnabled(true);
            habilitarOpcionConv();
        }
    } else if (evt.getSource().equals(jCheckBox4)) {
        if (jCheckBox4.isSelected()) {
            jCheckBox2.setEnabled(false);
            jCheckBox8.setEnabled(false);
            inhabilitarOpcionConv();
        } else {
            jCheckBox2.setEnabled(true);
            jCheckBox8.setEnabled(true);
            habilitarOpcionConv();
        }
    } else if (evt.getSource().equals(jCheckBox7)) {
        if (jCheckBox7.isSelected()) {
            jCheckBox1.setEnabled(false);
            jCheckBox3.setEnabled(false);
        } else {
            jCheckBox1.setEnabled(true);
            jCheckBox3.setEnabled(true);
        }
    } else if (evt.getSource().equals(jCheckBox8)) {
        if (jCheckBox8.isSelected()) {
            jCheckBox2.setEnabled(false);
            jCheckBox4.setEnabled(false);
        } else {
            jCheckBox2.setEnabled(true);
            jCheckBox4.setEnabled(true);
        }
    } else if (evt.getSource().equals(jCheckBox13)) {
      if (jCheckBox13.isSelected()) {
          agregarElementosCombo();
          jComboBox1.setVisible(true);
      } else {
          jComboBox1.setVisible(false);
          jComboBox1.removeAllItems();
      }
    } else if (evt.getSource().equals(jCheckBox14)) {
        if (jCheckBox14.isSelected()) {
            jTextField5.setEnabled(true);
        } else {
            jTextField5.setEnabled(false);
        }
    }
}//GEN-LAST:event_controlarCheckBox

private void formatearCampo(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formatearCampo
    if(jTextField1.getText().equals("")){
        jTextField1.setForeground(Color.GRAY);
        jTextField1.setText("----/--");
    }
}//GEN-LAST:event_formatearCampo

private void verificarCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarCampos
    //se borran los strings por si se sobre-escriben luego de haberse mostrado msj de error previo.
    m1 = "";
    m2 = "";
    m3 = "";
    m4 = "";
    f1 = true;
    f2 = true;
    f3 = true;
    f4 = true;
    verificarNumExpte();
    verificarMenor();
    verificarCausa();
    if (!f1 || !f2 || !f3 || !f4) {
        JOptionPane.showMessageDialog(this, m1 + m2 + m3 + m4, "Verificar Campos", JOptionPane.ERROR_MESSAGE);
    } else {
        if (verificarCheckBoxFlia()) {
            mostrarDatosIngresados();
            inhabilitarElementos();
            escribirAreaTexto();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Al menos un adulto debe estar conviviendo con el menor.", "Atención", JOptionPane.WARNING_MESSAGE);
        }
    }
}//GEN-LAST:event_verificarCampos

private void borrarLabel(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_borrarLabel
    jLabel4.setText("");
}//GEN-LAST:event_borrarLabel

private void editarInfo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarInfo
    jTextField1.setEnabled(true);
    jTextField2.setEnabled(true);
    jTextField3.setEnabled(true);
    jTextField4.setEnabled(true);
    jTextField5.setEnabled(true);
    jCheckBox1.setEnabled(true);
    jCheckBox2.setEnabled(true);
    jCheckBox3.setEnabled(true);
    jCheckBox4.setEnabled(true);
    jCheckBox5.setEnabled(true);
    jCheckBox6.setEnabled(true);
    jCheckBox7.setEnabled(true);
    jCheckBox8.setEnabled(true);
    jCheckBox9.setEnabled(true);
    jCheckBox10.setEnabled(true);
    jCheckBox11.setEnabled(true);
    jCheckBox12.setEnabled(true);
    jCheckBox13.setEnabled(true);
    jCheckBox14.setEnabled(true);
    jCheckBox15.setEnabled(true);
    jCheckBox16.setEnabled(true);
    jCheckBox17.setEnabled(true);
    jCheckBox18.setEnabled(true);
    jCheckBox19.setEnabled(true);
    jCheckBox20.setEnabled(true);
    jCheckBox21.setEnabled(true);
    jCheckBox22.setEnabled(true);
    jSpinner1.setEnabled(true);
    jSpinner2.setEnabled(true);
    jButton1.setVisible(false);
    jButton2.setVisible(false);
    jButton3.setVisible(true);
    jLabel4.setText("");
    jComboBox1.setEnabled(true);
    jTextArea2.setEnabled(true);
    jTextArea2.setEditable(true);
}//GEN-LAST:event_editarInfo

private void habilitarSpinner(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_habilitarSpinner
    if(evt.getSource().equals(jCheckBox5)){
        if(jCheckBox5.isSelected()){
            jSpinner1.setEnabled(true);
        }else{
            jSpinner1.setEnabled(false);
        }
    }else{
        if(jCheckBox6.isSelected()){
            jSpinner2.setEnabled(true);
        }else {
            jSpinner2.setEnabled(false);
        }
    }
}//GEN-LAST:event_habilitarSpinner

private void guardarInfoFlia(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarInfoFlia
    if(cargarDatos()){
        JOptionPane.showMessageDialog(this, "Los datos se ingresaron correctamente.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Se produjo un error al intentar ingresar los datos. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    vaciarVentana();
}//GEN-LAST:event_guardarInfoFlia

private void vaciarAreaComentarios(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vaciarAreaComentarios
    if (text) {
        text = false;
        jTextArea2.setText("");
        jTextArea2.setForeground(Color.BLACK);
    }
}//GEN-LAST:event_vaciarAreaComentarios

private void escribirAreaComentarios(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_escribirAreaComentarios
    if (jTextArea2.getText().equals("")){
        jTextArea2.setForeground(Color.GRAY);
        jTextArea2.setText("información adicional para agregar...");
        text = true;
    }
}//GEN-LAST:event_escribirAreaComentarios

private void buscarExpte(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarExpte
        dialogBuscarExpte buscarExpte = new dialogBuscarExpte(this, true);
        Constructor.centrarDialog(buscarExpte);
        buscarExpte.setVisible(true);
        expediente = buscarExpte.getExpediente();
        menor = buscarExpte.getMenor();
        rellenarCampos(expediente, menor);
}//GEN-LAST:event_buscarExpte
    
    private void inhabilitarOpcionConv() {
        jCheckBox14.setEnabled(false);
    }
    
    private void habilitarOpcionConv() {
        jCheckBox14.setEnabled(true);
    }    
    
    private void escribirAreaTexto() {
        this.jTextArea1.setText("");
        this.jTextArea1.append("\n_______________________________________________");
            for (Expediente expte : menor.getExpedientes()) {
                this.jTextArea1.append("\n   Expte:  " + expte.toString());
                this.jTextArea1.append("\n---------------------------------------------------------------------------------------");
                this.jTextArea1.append("\n   Causa:  " + expte.getCausa().getDescripcion());
            }
        this.jTextArea1.append("\n---------------------------------------------------------------------------------------");
        this.jTextArea1.append("\n   Menor:  " + menor.toString());
        this.jTextArea1.append("\n---------------------------------------------------------------------------------------");
        this.jTextArea1.append("\n   Edad:  " + menor.getEdad());
        this.jTextArea1.append("\n_______________________________________________");
        this.jTextArea1.append("\n\tDatos del grupo de convivencia ");
        this.jTextArea1.append("\n_______________________________________________");
        if (jCheckBox1.isSelected()) jTextArea1.append("\nPadre");
        if (jCheckBox2.isSelected()) jTextArea1.append("\nMadre");
        if (jCheckBox3.isSelected()) jTextArea1.append("\nPadrastro");
        if (jCheckBox4.isSelected()) jTextArea1.append("\nMadrastra");
        if (jCheckBox5.isSelected()) jTextArea1.append("\n" + String.valueOf(jSpinner1.getValue()) + "Hermanos");
        else jTextArea1.append("\nSin hermanos varones.");
        if (jCheckBox6.isSelected()) jTextArea1.append("\n" + String.valueOf(jSpinner2.getValue()) + "Hermanas");
        else jTextArea1.append("\nNo tiene hermanas.");
        if (jCheckBox7.isSelected()) jTextArea1.append("\nNo tiene padre ni padrastro.");
        if (jCheckBox8.isSelected()) jTextArea1.append("\nNo tiene madre ni madrastra.");
        if (jCheckBox9.isSelected()) jTextArea1.append("\nTío");
        if (jCheckBox15.isSelected()) jTextArea1.append("\nTía");
        if (jCheckBox10.isSelected()) jTextArea1.append("\nAbuelo");
        if (jCheckBox16.isSelected()) jTextArea1.append("\nAbuela");
        if (jCheckBox17.isSelected()) jTextArea1.append("\nPrimo");
        if (jCheckBox18.isSelected()) jTextArea1.append("\nPrima");
        if (jCheckBox19.isSelected()) jTextArea1.append("\nCuñado");
        if (jCheckBox20.isSelected()) jTextArea1.append("\nCuñada");
        if (jCheckBox21.isSelected()) jTextArea1.append("\nSobrino");
        if (jCheckBox22.isSelected()) jTextArea1.append("\nSobrina");
        if (jCheckBox14.isSelected()) jTextArea1.append("\n Instituto de menores: " + jComboBox1.getSelectedItem());
        if (!jTextArea2.getText().equals("información adicional para agregar...") || !jTextArea2.getText().startsWith("")) {
            jTextArea1.append("\n\tInformación adicional");
            jTextArea1.append("\n_______________________________________________");
            jTextArea1.append("\n" + jTextArea1.getText());
        }

        if (jCheckBox11.isSelected() || jCheckBox12.isSelected() || jCheckBox13.isSelected()) {
            this.jTextArea1.append("\n_______________________________________________");
            this.jTextArea1.append("\n\t Situación del menor");
            this.jTextArea1.append("\n_______________________________________________");
            if (jCheckBox11.isSelected()) {
                this.jTextArea1.append("\n  Escolaridad:\n   El menor está concurriendo a la escuela");
                this.jTextArea1.append("\n---------------------------------------------------------------------------------------");
            } else {
                this.jTextArea1.append("\n  Escolaridad:\n   El menor no está concurriendo a la escuela");
                this.jTextArea1.append("\n---------------------------------------------------------------------------------------");
            }
            if (jCheckBox12.isSelected()) {
                this.jTextArea1.append("\n  Trabajo:\n   El menor trabaja");
                this.jTextArea1.append("\n---------------------------------------------------------------------------------------");
            } else {
                this.jTextArea1.append("\n  Trabajo:\n   El menor no trabaja");
                this.jTextArea1.append("\n---------------------------------------------------------------------------------------");
            }
            if (jCheckBox13.isSelected()) {
                this.jTextArea1.append("\n  Consumo de estupefacientes:\n   El menor consume " + jComboBox1.getSelectedItem());
                this.jTextArea1.append("\n---------------------------------------------------------------------------------------");
            } else {
                this.jTextArea1.append("\n  Consumo de estupefacientes:\n   El menor no consume");
                this.jTextArea1.append("\n---------------------------------------------------------------------------------------");
            }
        }
        this.jTextArea1.setEditable(false);
    }

    private boolean cargarDatos() {
        List<String> grupoConv = new ArrayList();
        if (jCheckBox11.isSelected()) {
            menor.setEscolaridad("Si");
        } else {
            menor.setEscolaridad("No");
        }
        if (jCheckBox12.isSelected()) {
            menor.setTrabajo("Si");
        } else {
            menor.setTrabajo("No");
        }
        if (jCheckBox13.isSelected()) {
            List listaEstupefacientes = new ArrayList();
            listaEstupefacientes.add(jComboBox1.getSelectedItem());
            menor.setConsumoEstupefacientes(listaEstupefacientes);
        } else {
            menor.setConsumoEstupefacientes(null);
        }
        if (jCheckBox1.isSelected()) {
            grupoConv.add("Padre");
        } else if (jCheckBox3.isSelected()) {
            grupoConv.add("Padrastro");
        } else if (jCheckBox7.isSelected()) {
            grupoConv.add("No tiene padre ni padrastro.");
        }
        if(!jCheckBox1.isSelected() && !jCheckBox3.isSelected() && !jCheckBox7.isSelected()){
            grupoConv.add("No tiene padre ni padrastro.");
        }
        if(jCheckBox2.isSelected()){
            grupoConv.add("Madre");
        }else if(jCheckBox4.isSelected()){
            grupoConv.add("Madrastra");
        }else if(jCheckBox8.isSelected()){
            grupoConv.add("No tiene madre ni madrastra.");
        }
        if(!jCheckBox2.isSelected() && !jCheckBox4.isSelected() && !jCheckBox8.isSelected()){
            grupoConv.add("No tiene madre ni madrastra.");
        }
        if(jCheckBox5.isSelected()){
            if((Integer)jSpinner1.getValue() < 2){
                if((Integer)jSpinner1.getValue() == 0){
                    grupoConv.add("No se especifica cantidad de hermanos."); 
                }else{
                    grupoConv.add(jSpinner1.getValue() + " Hermano");
                }
            }else {
                grupoConv.add(jSpinner1.getValue() + " Hermanos");
            }
        } else{
            grupoConv.add("No tiene hermanos."); 
        }
        if(jCheckBox6.isSelected()){
            if((Integer)jSpinner2.getValue() < 2){
                if((Integer)jSpinner2.getValue() == 0){
                    grupoConv.add("No se especifica cantidad de hermanas");
                }else{    
                    grupoConv.add(jSpinner2.getValue() + " Hermana");
                }
            }else {
                grupoConv.add(jSpinner2.getValue() + " Hermanas");
            }   
        }else{
            grupoConv.add("No tiene hermanas");
        }
        if(jCheckBox9.isSelected()){
            grupoConv.add("Tio: Si");
        } else{ grupoConv.add("Tio: No");}
        if(jCheckBox10.isSelected()){
            grupoConv.add("Abuelo: Si");
        }else { grupoConv.add("Abuelo: No");}
        if(jCheckBox14.isSelected()){
            grupoConv.add("Instituto de Menores "+ jTextField5.getText());
        }else { grupoConv.add("Inst. de Menores: No");}
        if(jCheckBox15.isSelected()){
            grupoConv.add("Tia: Si");
        }else { grupoConv.add("Tia: No");}
        if(jCheckBox16.isSelected()){
            grupoConv.add("Abuela: Si");
        }else { grupoConv.add("Abuela: No");}
        if(jCheckBox17.isSelected()){
            grupoConv.add("Primo: Si");
        }else { grupoConv.add("Primo: No");}
        if(jCheckBox18.isSelected()){
            grupoConv.add("Prima: Si");
        }else { grupoConv.add("Prima: No");}
        if(jCheckBox19.isSelected()){
            grupoConv.add("Culado: Si");
        }else { grupoConv.add("Cuñado: No");}
        if(jCheckBox20.isSelected()){
            grupoConv.add("Cuñada: Si");
        }else { grupoConv.add("Cuñada: No");}
        if(jCheckBox21.isSelected()){
            grupoConv.add("Sobrino: Si");
        }else { grupoConv.add("Sobrino: No");}
        if(jCheckBox22.isSelected()){
            grupoConv.add("Sobrina: Si");
        }else { grupoConv.add("Sobrina: No");}
        if(!jCheckBox1.isSelected() && !jCheckBox3.isSelected() && !jCheckBox7.isSelected() && 
                !jCheckBox2.isSelected() && !jCheckBox2.isSelected() && !jCheckBox2.isSelected() &&
                !jCheckBox9.isSelected() && !jCheckBox10.isSelected() && !jCheckBox14.isSelected() &&
                !jCheckBox15.isSelected() && !jCheckBox9.isSelected()){
            JOptionPane.showMessageDialog(rootPane, "El menor debe estar conviviendo con al menos un adulto. Verificar Casillas", "Atención", JOptionPane.WARNING_MESSAGE);
        }
        if (!jTextArea2.getText().equals("información adicional para agregar...") || !jTextArea2.getText().equals("")) {
            grupoConv.add(jTextArea2.getText());
        }
        System.out.println("-------->grupoConv: " + grupoConv);
        grupo.setGrupoConvivencia(grupoConv);
        menor.setGrupoConvivencia(grupo);
        MenorFacade menorFacade = new MenorFacade();
        if (menorFacade.modificarMenor(menor)) {
            return true;
        } else {
            return false;
        }
    }
    
    private void mostrarDatosIngresados() {
        jButton1.setVisible(true);
        jButton2.setVisible(true);
        jButton3.setVisible(false);
        jLabel4.setText("Verifique los datos en el área de texto.");
        jTextArea1.setEnabled(true);
        jTextArea1.setBackground(Color.WHITE);
    }
    
    private void inhabilitarElementos() {
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);
        jCheckBox1.setEnabled(false);
        jCheckBox2.setEnabled(false);
        jCheckBox3.setEnabled(false);
        jCheckBox4.setEnabled(false);
        jCheckBox5.setEnabled(false);
        jCheckBox6.setEnabled(false);
        jCheckBox7.setEnabled(false);
        jCheckBox8.setEnabled(false);
        jCheckBox9.setEnabled(false);
        jCheckBox10.setEnabled(false);
        jCheckBox11.setEnabled(false);
        jCheckBox12.setEnabled(false);
        jCheckBox13.setEnabled(false);
        jCheckBox14.setEnabled(false);
        jCheckBox15.setEnabled(false);
        jCheckBox16.setEnabled(false);
        jCheckBox17.setEnabled(false);
        jCheckBox18.setEnabled(false);
        jCheckBox19.setEnabled(false);
        jCheckBox20.setEnabled(false);
        jCheckBox21.setEnabled(false);
        jCheckBox22.setEnabled(false);
        jSpinner1.setEnabled(false);
        jSpinner2.setEnabled(false);
        jTextArea2.setEditable(false);
    }
    
    private void verificarNumExpte() {
        if (jTextField1.getText().equals("") || jTextField1.getText().equals("----/--")) {
            f1 = false;
            m1 = "Verificar campo Expte. que no esté vacío o con que contenga un formato de Expte. válido.";
        }
    }

    private void verificarMenor() {
        if (jTextField4.getText().equals("")) {
            f2 = false;
            m2 = "\nCompletar campo 'Edad'.";
        }
        try{
        if (Integer.valueOf(jTextField4.getText()) < 0) {
            if (Integer.valueOf(jTextField4.getText()) >= 18) {
                f4 = false;
                m4 = "\nNo se permite edad mayor o igual a 18 años.";
            }
        }
        }catch(java.lang.NumberFormatException e){
            f4 = false;
            m4 = "\nCorregir edad del menor.";}
    }

    private void verificarCausa() {
        if (jTextField3.getText().equals("")) {
            f3 = false;
            m3 = "\nCompletar campo 'Causa'.";
        }
    }
    
    private boolean verificarCheckBoxFlia() {
        boolean flag = false;
        if (jCheckBox1.isSelected() || jCheckBox3.isSelected()) {
            flag = true;
        }
        if (jCheckBox2.isSelected() || jCheckBox4.isSelected()) {
            flag = true;
        }
        if (jCheckBox9.isSelected() || jCheckBox10.isSelected() || jCheckBox15.isSelected() || jCheckBox16.isSelected()) {
            flag = true;
        }
        return flag;
    }
    
    private void agregarElementosCombo() {
        Constructor.cargarJCombo(jComboBox1, EstupefacienteFacade.getTodos());
    }
    
    private void iniciarVentana() {
        jTextArea1.setText("");
        jTextArea1.setEnabled(false);
        jTextArea1.setBackground(Color.LIGHT_GRAY);
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        jSpinner1.setEnabled(false);
        jSpinner2.setEnabled(false);
        jComboBox1.setVisible(false);
        jTextField5.setEnabled(false);
    }
    
    private void vaciarVentana() {
        iniciarVentana();
        jTextField1.setText("");jTextField1.setEnabled(true);
        jTextField2.setText("");jTextField2.setEnabled(true);
        jTextField3.setText("");jTextField3.setEnabled(true);
        jTextField4.setText("");jTextField4.setEnabled(true);
        jTextField5.setText("");jTextField5.setEnabled(true);
        jCheckBox1.setSelected(false);jCheckBox1.setEnabled(true);
        jCheckBox2.setSelected(false);jCheckBox2.setEnabled(true);
        jCheckBox3.setSelected(false);jCheckBox3.setEnabled(true);
        jCheckBox4.setSelected(false);jCheckBox4.setEnabled(true);
        jCheckBox5.setSelected(false);jCheckBox5.setEnabled(true);
        jCheckBox6.setSelected(false);jCheckBox6.setEnabled(true);
        jCheckBox7.setSelected(false);jCheckBox7.setEnabled(true);
        jCheckBox8.setSelected(false);jCheckBox8.setEnabled(true);
        jCheckBox9.setSelected(false);jCheckBox9.setEnabled(true);
        jCheckBox10.setSelected(false);jCheckBox10.setEnabled(true);
        jCheckBox11.setSelected(false);jCheckBox11.setEnabled(true);
        jCheckBox12.setSelected(false);jCheckBox12.setEnabled(true);
        jCheckBox13.setSelected(false);jCheckBox13.setEnabled(true);
        jCheckBox14.setSelected(false);jCheckBox14.setEnabled(true);
        jCheckBox15.setSelected(false);jCheckBox15.setEnabled(true);
        jCheckBox16.setSelected(false);jCheckBox16.setEnabled(true);
        jCheckBox17.setSelected(false);jCheckBox17.setEnabled(true);
        jCheckBox18.setSelected(false);jCheckBox18.setEnabled(true);
        jCheckBox19.setSelected(false);jCheckBox19.setEnabled(true);
        jCheckBox20.setSelected(false);jCheckBox20.setEnabled(true);
        jCheckBox21.setSelected(false);jCheckBox21.setEnabled(true);
        jCheckBox22.setSelected(false);jCheckBox22.setEnabled(true);
        jSpinner1.setValue(0);jSpinner1.setEnabled(false);
        jSpinner2.setValue(0);jSpinner2.setEnabled(false);
        jTextArea2.setEditable(true);jTextArea2.setForeground(Color.GRAY);jTextArea2.setText("información adicional para agregar...");
        jLabel4.setText("");  
        jButton3.setVisible(true);
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntornoMenor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

    private void inicializarComponentes() {
        if (tipoVentana.equals("modificación")) this.setTitle("Modificación de entorno conviviente");
        else JOptionPane.showMessageDialog(rootPane, "Antes de ingresar un nuevo registro, verifique que el expediente no exista.", "Atención", JOptionPane.INFORMATION_MESSAGE);
        this.setLocationRelativeTo(this);
        this.setIconImage (new ImageIcon(getClass().getResource("/iconos/iconos16px/icon_16.png")).getImage());
        iniciarVentana();
    }

    private void rellenarCampos(Expediente expediente, Menor menor) { //diferencio el expte e identifico a un menor en particular
        jTextField1.setText(expediente.toString());
        jTextField2.setText(menor.toString());
        jTextField4.setText(String.valueOf(menor.getEdad()));
        jTextField3.setText(expediente.getCausa().getDescripcion());
        try {
            if (menor.getEscolaridad().equals("Si")) {
                jCheckBox11.setSelected(true);
            } else {
                jCheckBox11.setSelected(false);
            }
            if (menor.getTrabajo().equals("Si")) {
                jCheckBox12.setSelected(true);
            } else {
                jCheckBox12.setSelected(false);
            }
        } catch (java.lang.NullPointerException ex) {
            System.out.println("EXCEPCION POR ESCOLARIDAD/TRABAJO NULO");
        }
        if (!menor.getConsumoEstupefacientes().isEmpty()) {
            jComboBox1.setVisible(true);
            agregarElementosCombo();
            for (int i = 0; i < jComboBox1.getItemCount(); i++) {

                for (Estupefaciente est : menor.getConsumoEstupefacientes()) { //obtengo los estupefacientes
                    if (est.toString().equals(String.valueOf((Estupefaciente) jComboBox1.getItemAt(i)))) { //comparo si es igual al seleccionado
                        jComboBox1.setSelectedIndex(i);
                    }
                }
            }
            jCheckBox13.setSelected(true);
        } else {
            jCheckBox13.setSelected(false);
        }
        try {
            grupo = menor.getGrupoConvivencia();
            for (String parientes : grupo.getGrupoConvivencia()) {
                if (parientes.equals("Padre")) {
                    jCheckBox1.setSelected(true);
                    jCheckBox3.setSelected(false);
                    jCheckBox7.setSelected(false);
                }
                if (parientes.equals("Padrastro")) {
                    jCheckBox1.setSelected(false);
                    jCheckBox3.setSelected(true);
                    jCheckBox7.setSelected(false);
                }
                if (parientes.equals("No tiene padre ni padrastro.")) {
                    jCheckBox1.setSelected(false);
                    jCheckBox3.setSelected(false);
                    jCheckBox7.setSelected(true);
                }
                if (parientes.equals("Madre")) {
                    jCheckBox2.setSelected(true);
                    jCheckBox4.setSelected(false);
                    jCheckBox8.setSelected(false);
                }
                if (parientes.equals("Madrastra")) {
                    jCheckBox2.setSelected(false);
                    jCheckBox4.setSelected(true);
                    jCheckBox8.setSelected(false);
                }
                if (parientes.equals("No tiene madre ni madrastra.")) {
                    jCheckBox2.setSelected(false);
                    jCheckBox4.setSelected(false);
                    jCheckBox8.setSelected(true);
                }
                if (parientes.endsWith("hermanos.")) {
                    if (!parientes.equals("No tiene hermanos.")) {
                        jCheckBox5.setSelected(true);
                        jSpinner1.setEnabled(true);
                    }
                    if (parientes.equals("No se especifica cantidad de hermanos.")) {
                        jSpinner1.setValue(0);
                    } else {
                        int cant = Integer.valueOf(parientes.substring(0, 1));
                        if (cant == 1) {
                            jSpinner1.setValue(1);
                        } else if (cant > 1) {
                            jSpinner1.setValue(cant);
                        }
                    }
                } else {
                    jCheckBox5.setSelected(false);
                }
                if (parientes.endsWith("hermanas.")) {
                    if (!parientes.equals("No tiene hermanas.")) {
                        jCheckBox6.setSelected(true);
                        jSpinner2.setEnabled(true);
                    }
                    if (parientes.equals("No se especifica cantidad de hermanas")) {
                        jSpinner2.setValue(0);
                    } else {
                        int cant = Integer.valueOf(parientes.substring(0, 1));
                        if (cant == 1) {
                            jSpinner2.setValue(1);
                        } else if (cant > 1) {
                            jSpinner2.setValue(cant);
                        }
                    }
                } else {
                    jCheckBox6.setSelected(false);
                }
                if (parientes.equals("Tio: Si")) {
                    jCheckBox9.setSelected(true);
                } else {
                    jCheckBox9.setSelected(false);
                }
                if (parientes.equals("Abuelo: Si")) {
                    jCheckBox10.setSelected(true);
                } else {
                    jCheckBox10.setSelected(false);
                }
                if (!parientes.equals("Inst. de Menores: No")) {
                    if (parientes.startsWith("Instituto de Menores ")) {
                        jCheckBox14.setSelected(true);
                        jTextField5.setText(parientes.toString());
                    }
                } else {
                    jCheckBox14.setSelected(false);
                }
                if (parientes.equals("Tia: Si")) {
                    jCheckBox15.setSelected(true);
                } else {
                    jCheckBox15.setSelected(false);
                }
                if (parientes.equals("Abuela: Si")) {
                    jCheckBox16.setSelected(true);
                } else {
                    jCheckBox16.setSelected(false);
                }
                if (parientes.equals("Primo: Si")) {
                    jCheckBox17.setSelected(true);
                } else {
                    jCheckBox17.setSelected(false);
                }
                if (parientes.equals("Prima: Si")) {
                    jCheckBox18.setSelected(true);
                } else {
                    jCheckBox18.setSelected(false);
                }
                if (parientes.equals("Cuñado: Si")) {
                    jCheckBox19.setSelected(true);
                } else {
                    jCheckBox19.setSelected(false);
                }
                if (parientes.equals("Cuñada: Si")) {
                    jCheckBox20.setSelected(true);
                } else {
                    jCheckBox20.setSelected(false);
                }
                if (parientes.equals("Sobrino: Si")) {
                    jCheckBox21.setSelected(true);
                } else {
                    jCheckBox21.setSelected(false);
                }
                if (parientes.equals("Sobrina: Si")) {
                    jCheckBox22.setSelected(true);
                } else {
                    jCheckBox22.setSelected(false);
                }
            }
        } catch (java.lang.NullPointerException ex) {
            System.out.println("EXCEPCION POR GRUPO DE CONVIVENCIA NULO");
        }
    }
}
