/*
 * ConsultaExpte.java
 *
 * Created on 16 de octubre de 2009, 11:09
 */

package vistas;

import facades.ExpedienteFacade;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import entidades.Audiencia;
import entidades.Expediente;
import entidades.Menor;
import facades.MenorFacade;
import includes.Constructor;
import java.util.List;

/**
 *
 * @author  Yorch
 */
public class ConsultaExpte extends javax.swing.JFrame {
    private int row = -1;
    public ArrayList ids = new ArrayList();
    private Expediente exp = new Expediente();
    private Audiencia au = new Audiencia();
    private ExpedienteFacade expedienteFacade = new ExpedienteFacade();
    private MenorFacade menorFacade = new MenorFacade();
    private Caratula caratula;
    private String[] titulosMenor = {"id_expte","menor","edad","fecha nac.","padre","madre"};
    private String[] titulosExpte = {"id_expte","expte","causa","cria/uj"};
    
    public ConsultaExpte() {
        initComponents();
        this.setIconImage (new ImageIcon(getClass().getResource("/iconos/iconos16px/icon_16.png")).getImage());
        jTextField1.setEnabled(false);
        jButton1.setEnabled(false);
        jLabel2.setText("");
    }
    
    private void escribirEtiqueta() {
        jLabel2.setText(" Clic en la fila (primera tabla) para ampliar información.");
        jLabel2.setForeground(Color.BLUE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
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
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Expedientes o actuaciones");
        setForeground(new java.awt.Color(153, 153, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 153))); // NOI18N

        jCheckBox1.setBackground(new java.awt.Color(204, 204, 255));
        jCheckBox1.setText("Por Apellido");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarCheckBox(evt);
            }
        });

        jCheckBox2.setBackground(new java.awt.Color(204, 204, 255));
        jCheckBox2.setText("Por Nombre");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarCheckBox(evt);
            }
        });

        jCheckBox3.setBackground(new java.awt.Color(204, 204, 255));
        jCheckBox3.setText("Por D.N.I.");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarCheckBox(evt);
            }
        });

        jCheckBox4.setBackground(new java.awt.Color(204, 204, 255));
        jCheckBox4.setText("Por edad");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarCheckBox(evt);
            }
        });

        jCheckBox5.setBackground(new java.awt.Color(204, 204, 255));
        jCheckBox5.setText("Por letra de Acta inicial");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarCheckBox(evt);
            }
        });

        jCheckBox6.setBackground(new java.awt.Color(204, 204, 255));
        jCheckBox6.setText("Por Número de Expediente");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarCheckBox(evt);
            }
        });

        jCheckBox7.setBackground(new java.awt.Color(204, 204, 255));
        jCheckBox7.setText("Por Año");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarCheckBox(evt);
            }
        });

        jCheckBox8.setBackground(new java.awt.Color(204, 204, 255));
        jCheckBox8.setText("Por Causa");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarCheckBox(evt);
            }
        });

        jCheckBox9.setBackground(new java.awt.Color(204, 204, 255));
        jCheckBox9.setText("Por Comisaría");
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarCheckBox(evt);
            }
        });

        jCheckBox10.setBackground(new java.awt.Color(204, 204, 255));
        jCheckBox10.setText("Por Unidad Judicial");
        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarCheckBox(evt);
            }
        });

        jCheckBox11.setBackground(new java.awt.Color(204, 204, 255));
        jCheckBox11.setText("Por apellido y nombre del padre");
        jCheckBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarCheckBox(evt);
            }
        });

        jCheckBox12.setBackground(new java.awt.Color(204, 204, 255));
        jCheckBox12.setText("Por apellido y nombre de la madre");
        jCheckBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarCheckBox(evt);
            }
        });

        jCheckBox13.setBackground(new java.awt.Color(204, 204, 255));
        jCheckBox13.setText("Archivados");
        jCheckBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarCheckBox(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                habilitarBoton(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/search_16.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/home_16.png"))); // NOI18N
        jButton2.setText("Cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarConsulta(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 153))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id_expte", "menor", "edad", "fecha nac.", "padre", "madre"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarFila(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setMinWidth(50);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
        jTable1.getColumnModel().getColumn(2).setMinWidth(50);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(30);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id_expte", "expte", "causa", "cria/uj"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarFila(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getColumn(0).setMinWidth(60);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(60);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox13)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jCheckBox1)
                                                .addComponent(jCheckBox2))
                                            .addGap(64, 64, 64))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                            .addGap(76, 76, 76)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jCheckBox3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jCheckBox5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jCheckBox6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jCheckBox8))
                                        .addGap(50, 50, 50))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jCheckBox7, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jCheckBox9)
                                        .addGap(88, 88, 88)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox10)
                                            .addComponent(jCheckBox12)
                                            .addComponent(jCheckBox11))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox7)
                            .addComponent(jCheckBox11))
                        .addGap(340, 340, 340))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jCheckBox5)
                                    .addComponent(jCheckBox9)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox2)
                                    .addComponent(jCheckBox6)
                                    .addComponent(jCheckBox10)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jCheckBox4)
                                            .addComponent(jCheckBox8)
                                            .addComponent(jCheckBox12)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jCheckBox3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox13)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(11, 11, 11)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void verificarCheckBox(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarCheckBox
    if(evt.getSource().equals(jCheckBox1)){
        if(jCheckBox1.isSelected()){
            jTextField1.setEnabled(true);
            jTextField1.grabFocus();
            jCheckBox2.setEnabled(false);jCheckBox3.setEnabled(false);jCheckBox4.setEnabled(false);
            jCheckBox5.setEnabled(false);jCheckBox6.setEnabled(false);jCheckBox7.setEnabled(false);jCheckBox8.setEnabled(false);
            jCheckBox9.setEnabled(false);jCheckBox10.setEnabled(false);jCheckBox11.setEnabled(false);jCheckBox12.setEnabled(false);
            jCheckBox13.setEnabled(false);
        }else{
            jTextField1.setText("");jTextField1.setEnabled(false);jButton1.setEnabled(false);
            jCheckBox2.setEnabled(true);jCheckBox3.setEnabled(true);jCheckBox4.setEnabled(true);
            jCheckBox5.setEnabled(true);jCheckBox6.setEnabled(true);jCheckBox7.setEnabled(true);jCheckBox8.setEnabled(true);
            jCheckBox9.setEnabled(true);jCheckBox10.setEnabled(true);jCheckBox11.setEnabled(true);jCheckBox12.setEnabled(true);
            jCheckBox13.setEnabled(true);
        }
    }
    if(evt.getSource().equals(jCheckBox2)){
        if(jCheckBox2.isSelected()){
            jTextField1.setEnabled(true);
            jTextField1.grabFocus();
            jCheckBox1.setEnabled(false);jCheckBox3.setEnabled(false);jCheckBox4.setEnabled(false);
            jCheckBox5.setEnabled(false);jCheckBox6.setEnabled(false);jCheckBox7.setEnabled(false);jCheckBox8.setEnabled(false);
            jCheckBox9.setEnabled(false);jCheckBox10.setEnabled(false);jCheckBox11.setEnabled(false);jCheckBox12.setEnabled(false);
            jCheckBox13.setEnabled(false);
        }else{
            jTextField1.setText("");jTextField1.setEnabled(false);jButton1.setEnabled(false);
            jCheckBox1.setEnabled(true);jCheckBox3.setEnabled(true);jCheckBox4.setEnabled(true);
            jCheckBox5.setEnabled(true);jCheckBox6.setEnabled(true);jCheckBox7.setEnabled(true);jCheckBox8.setEnabled(true);
            jCheckBox9.setEnabled(true);jCheckBox10.setEnabled(true);jCheckBox11.setEnabled(true);jCheckBox12.setEnabled(true);
            jCheckBox13.setEnabled(true);
        }
    }
    if(evt.getSource().equals(jCheckBox3)){
        if(jCheckBox3.isSelected()){
            jTextField1.setEnabled(true);
            jTextField1.grabFocus();
            jCheckBox1.setEnabled(false);jCheckBox2.setEnabled(false);jCheckBox4.setEnabled(false);
            jCheckBox5.setEnabled(false);jCheckBox6.setEnabled(false);jCheckBox7.setEnabled(false);jCheckBox8.setEnabled(false);
            jCheckBox9.setEnabled(false);jCheckBox10.setEnabled(false);jCheckBox11.setEnabled(false);jCheckBox12.setEnabled(false);
            jCheckBox13.setEnabled(false);
        }else{
            jTextField1.setText("");jTextField1.setEnabled(false);jButton1.setEnabled(false);
            jCheckBox1.setEnabled(true);jCheckBox2.setEnabled(true);jCheckBox4.setEnabled(true);
            jCheckBox5.setEnabled(true);jCheckBox6.setEnabled(true);jCheckBox7.setEnabled(true);jCheckBox8.setEnabled(true);
            jCheckBox9.setEnabled(true);jCheckBox10.setEnabled(true);jCheckBox11.setEnabled(true);jCheckBox12.setEnabled(true);
            jCheckBox13.setEnabled(true);
        }
    }
    if(evt.getSource().equals(jCheckBox4)){
        if(jCheckBox4.isSelected()){
            jTextField1.setEnabled(true);
            jTextField1.grabFocus();
            jCheckBox1.setEnabled(false);jCheckBox2.setEnabled(false);jCheckBox3.setEnabled(false);
            jCheckBox5.setEnabled(false);jCheckBox6.setEnabled(false);jCheckBox7.setEnabled(false);jCheckBox8.setEnabled(false);
            jCheckBox9.setEnabled(false);jCheckBox10.setEnabled(false);jCheckBox11.setEnabled(false);jCheckBox12.setEnabled(false);
            jCheckBox13.setEnabled(false);
        }else{
            jTextField1.setText("");jTextField1.setEnabled(false);jButton1.setEnabled(false);
            jCheckBox1.setEnabled(true);jCheckBox2.setEnabled(true);jCheckBox3.setEnabled(true);
            jCheckBox5.setEnabled(true);jCheckBox6.setEnabled(true);jCheckBox7.setEnabled(true);jCheckBox8.setEnabled(true);
            jCheckBox9.setEnabled(true);jCheckBox10.setEnabled(true);jCheckBox11.setEnabled(true);jCheckBox12.setEnabled(true);
            jCheckBox13.setEnabled(true);
        }
    }
    if(evt.getSource().equals(jCheckBox5)){
        if(jCheckBox5.isSelected()){
            jTextField1.setEnabled(true);
            jTextField1.grabFocus();
            jCheckBox1.setEnabled(false);jCheckBox2.setEnabled(false);jCheckBox3.setEnabled(false);
            jCheckBox4.setEnabled(false);jCheckBox6.setEnabled(false);jCheckBox7.setEnabled(false);jCheckBox8.setEnabled(false);
            jCheckBox9.setEnabled(false);jCheckBox10.setEnabled(false);jCheckBox11.setEnabled(false);jCheckBox12.setEnabled(false);
            jCheckBox13.setEnabled(false);
        }else{
            jTextField1.setText("");jTextField1.setEnabled(false);jButton1.setEnabled(false);
            jCheckBox1.setEnabled(true);jCheckBox2.setEnabled(true);jCheckBox3.setEnabled(true);
            jCheckBox4.setEnabled(true);jCheckBox6.setEnabled(true);jCheckBox7.setEnabled(true);jCheckBox8.setEnabled(true);
            jCheckBox9.setEnabled(true);jCheckBox10.setEnabled(true);jCheckBox11.setEnabled(true);jCheckBox12.setEnabled(true);
            jCheckBox13.setEnabled(true);
        }
    }
    if(evt.getSource().equals(jCheckBox6)){
        if(jCheckBox6.isSelected()){
            jTextField1.setEnabled(true);
            jTextField1.grabFocus();
            jCheckBox1.setEnabled(false);jCheckBox2.setEnabled(false);jCheckBox3.setEnabled(false);
            jCheckBox4.setEnabled(false);jCheckBox5.setEnabled(false);jCheckBox7.setEnabled(false);jCheckBox8.setEnabled(false);
            jCheckBox9.setEnabled(false);jCheckBox10.setEnabled(false);jCheckBox11.setEnabled(false);jCheckBox12.setEnabled(false);
            jCheckBox13.setEnabled(false);
        }else{
            jTextField1.setText("");jTextField1.setEnabled(false);jButton1.setEnabled(false);
            jCheckBox1.setEnabled(true);jCheckBox2.setEnabled(true);jCheckBox3.setEnabled(true);
            jCheckBox4.setEnabled(true);jCheckBox5.setEnabled(true);jCheckBox7.setEnabled(true);jCheckBox8.setEnabled(true);
            jCheckBox9.setEnabled(true);jCheckBox10.setEnabled(true);jCheckBox11.setEnabled(true);jCheckBox12.setEnabled(true);
            jCheckBox13.setEnabled(true);
        }
    }
    if(evt.getSource().equals(jCheckBox7)){
        if(jCheckBox7.isSelected()){
            jTextField1.setEnabled(true);
            jTextField1.grabFocus();
            jCheckBox1.setEnabled(false);jCheckBox2.setEnabled(false);jCheckBox3.setEnabled(false);
            jCheckBox4.setEnabled(false);jCheckBox5.setEnabled(false);jCheckBox6.setEnabled(false);jCheckBox8.setEnabled(false);
            jCheckBox9.setEnabled(false);jCheckBox10.setEnabled(false);jCheckBox11.setEnabled(false);jCheckBox12.setEnabled(false);
            jCheckBox13.setEnabled(false);
        }else{
            jTextField1.setText("");jTextField1.setEnabled(false);jButton1.setEnabled(false);
            jCheckBox1.setEnabled(true);jCheckBox2.setEnabled(true);jCheckBox3.setEnabled(true);
            jCheckBox4.setEnabled(true);jCheckBox5.setEnabled(true);jCheckBox6.setEnabled(true);jCheckBox8.setEnabled(true);
            jCheckBox9.setEnabled(true);jCheckBox10.setEnabled(true);jCheckBox11.setEnabled(true);jCheckBox12.setEnabled(true);
            jCheckBox13.setEnabled(true);
        }
    }
    if(evt.getSource().equals(jCheckBox8)){
        if(jCheckBox8.isSelected()){
            jTextField1.setEnabled(true);
            jTextField1.grabFocus();
            jCheckBox1.setEnabled(false);jCheckBox2.setEnabled(false);jCheckBox3.setEnabled(false);
            jCheckBox4.setEnabled(false);jCheckBox5.setEnabled(false);jCheckBox6.setEnabled(false);jCheckBox7.setEnabled(false);
            jCheckBox9.setEnabled(false);jCheckBox10.setEnabled(false);jCheckBox11.setEnabled(false);jCheckBox12.setEnabled(false);
            jCheckBox13.setEnabled(false);
        }else{
            jTextField1.setText("");jTextField1.setEnabled(false);jButton1.setEnabled(false);
            jCheckBox1.setEnabled(true);jCheckBox2.setEnabled(true);jCheckBox3.setEnabled(true);
            jCheckBox4.setEnabled(true);jCheckBox5.setEnabled(true);jCheckBox6.setEnabled(true);jCheckBox7.setEnabled(true);
            jCheckBox9.setEnabled(true);jCheckBox10.setEnabled(true);jCheckBox11.setEnabled(true);jCheckBox12.setEnabled(true);
            jCheckBox13.setEnabled(true);
        }
    }
    if(evt.getSource().equals(jCheckBox9)){
        if(jCheckBox9.isSelected()){
            jTextField1.setEnabled(true);
            jTextField1.grabFocus();
            jCheckBox1.setEnabled(false);jCheckBox2.setEnabled(false);jCheckBox3.setEnabled(false);
            jCheckBox4.setEnabled(false);jCheckBox5.setEnabled(false);jCheckBox6.setEnabled(false);jCheckBox7.setEnabled(false);
            jCheckBox8.setEnabled(false);jCheckBox10.setEnabled(false);jCheckBox11.setEnabled(false);jCheckBox12.setEnabled(false);
            jCheckBox13.setEnabled(false);
        }else{
            jTextField1.setText("");jTextField1.setEnabled(false);jButton1.setEnabled(false);
            jCheckBox1.setEnabled(true);jCheckBox2.setEnabled(true);jCheckBox3.setEnabled(true);
            jCheckBox4.setEnabled(true);jCheckBox5.setEnabled(true);jCheckBox6.setEnabled(true);jCheckBox7.setEnabled(true);
            jCheckBox8.setEnabled(true);jCheckBox10.setEnabled(true);jCheckBox11.setEnabled(true);jCheckBox12.setEnabled(true);
            jCheckBox13.setEnabled(true);
        }
    }
    if(evt.getSource().equals(jCheckBox10)){
        if(jCheckBox10.isSelected()){
            jTextField1.setEnabled(true);
            jTextField1.grabFocus();
            jCheckBox1.setEnabled(false);jCheckBox2.setEnabled(false);jCheckBox3.setEnabled(false);
            jCheckBox4.setEnabled(false);jCheckBox5.setEnabled(false);jCheckBox6.setEnabled(false);jCheckBox7.setEnabled(false);
            jCheckBox8.setEnabled(false);jCheckBox9.setEnabled(false);jCheckBox11.setEnabled(false);jCheckBox12.setEnabled(false);
            jCheckBox13.setEnabled(false);
        }else{
            jTextField1.setText("");jTextField1.setEnabled(false);jButton1.setEnabled(false);
            jCheckBox1.setEnabled(true);jCheckBox2.setEnabled(true);jCheckBox3.setEnabled(true);
            jCheckBox4.setEnabled(true);jCheckBox5.setEnabled(true);jCheckBox6.setEnabled(true);jCheckBox7.setEnabled(true);
            jCheckBox8.setEnabled(true);jCheckBox9.setEnabled(true);jCheckBox11.setEnabled(true);jCheckBox12.setEnabled(true);
            jCheckBox13.setEnabled(true);
        }
    }
    if(evt.getSource().equals(jCheckBox11)){
        if(jCheckBox11.isSelected()){
            jTextField1.setForeground(Color.GRAY);
            jTextField1.setText("Nombre, Apellido");
            jTextField1.setEnabled(true);
            jTextField1.grabFocus();
            jCheckBox1.setEnabled(false);jCheckBox2.setEnabled(false);jCheckBox3.setEnabled(false);
            jCheckBox4.setEnabled(false);jCheckBox5.setEnabled(false);jCheckBox6.setEnabled(false);jCheckBox7.setEnabled(false);
            jCheckBox8.setEnabled(false);jCheckBox9.setEnabled(false);jCheckBox10.setEnabled(false);jCheckBox12.setEnabled(false);
            jCheckBox13.setEnabled(false);
        }else{
            jTextField1.setText("");jTextField1.setEnabled(false);jButton1.setEnabled(false);
            jCheckBox1.setEnabled(true);jCheckBox2.setEnabled(true);jCheckBox3.setEnabled(true);
            jCheckBox4.setEnabled(true);jCheckBox5.setEnabled(true);jCheckBox6.setEnabled(true);jCheckBox7.setEnabled(true);
            jCheckBox8.setEnabled(true);jCheckBox9.setEnabled(true);jCheckBox10.setEnabled(true);jCheckBox12.setEnabled(true);
            jCheckBox13.setEnabled(true);
        }
    }
    if(evt.getSource().equals(jCheckBox12)){
        if(jCheckBox12.isSelected()){
            jTextField1.setForeground(Color.GRAY);
            jTextField1.setText("Nombre, Apellido");
            jTextField1.setEnabled(true);
            jTextField1.grabFocus();
            jCheckBox1.setEnabled(false);jCheckBox2.setEnabled(false);jCheckBox3.setEnabled(false);
            jCheckBox4.setEnabled(false);jCheckBox5.setEnabled(false);jCheckBox6.setEnabled(false);jCheckBox7.setEnabled(false);
            jCheckBox8.setEnabled(false);jCheckBox9.setEnabled(false);jCheckBox10.setEnabled(false);jCheckBox11.setEnabled(false);
            jCheckBox13.setEnabled(false);
        }else{
            jTextField1.setText("");jTextField1.setEnabled(false);jButton1.setEnabled(false);
            jCheckBox1.setEnabled(true);jCheckBox2.setEnabled(true);jCheckBox3.setEnabled(true);
            jCheckBox4.setEnabled(true);jCheckBox5.setEnabled(true);jCheckBox6.setEnabled(true);jCheckBox7.setEnabled(true);
            jCheckBox8.setEnabled(true);jCheckBox9.setEnabled(true);jCheckBox10.setEnabled(true);jCheckBox11.setEnabled(true);
            jCheckBox13.setEnabled(true);
        }
    }
    if(evt.getSource().equals(jCheckBox13)){
        if(jCheckBox13.isSelected()){
            jTextField1.setEnabled(true);
            jTextField1.grabFocus();
            jCheckBox1.setEnabled(false);jCheckBox2.setEnabled(false);jCheckBox3.setEnabled(false);jCheckBox4.setEnabled(false);
            jCheckBox5.setEnabled(false);jCheckBox6.setEnabled(false);jCheckBox7.setEnabled(false);jCheckBox8.setEnabled(false);
            jCheckBox9.setEnabled(false);jCheckBox10.setEnabled(false);jCheckBox11.setEnabled(false);jCheckBox12.setEnabled(false);
        }else{
            jTextField1.setText("");jTextField1.setEnabled(false);jButton1.setEnabled(false);
            jCheckBox1.setEnabled(true);jCheckBox2.setEnabled(true);jCheckBox3.setEnabled(true);jCheckBox4.setEnabled(true);
            jCheckBox5.setEnabled(true);jCheckBox6.setEnabled(true);jCheckBox7.setEnabled(true);jCheckBox8.setEnabled(true);
            jCheckBox9.setEnabled(true);jCheckBox10.setEnabled(true);jCheckBox11.setEnabled(true);jCheckBox12.setEnabled(true);
        }
    }
}//GEN-LAST:event_verificarCheckBox

private void habilitarBoton(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_habilitarBoton
    jLabel2.setText("");
    jButton1.setEnabled(true);
    if(jTextField1.getText().equals("")){
        jButton1.setEnabled(false);
    }
}//GEN-LAST:event_habilitarBoton

private void cerrarConsulta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarConsulta
    this.dispose();
}//GEN-LAST:event_cerrarConsulta

private void buscar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar
    buscarExpediente();
}//GEN-LAST:event_buscar

private void seleccionarFila(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarFila
    
    if (evt.getSource().equals(jTable1)) {
        row = jTable1.getSelectedRow();
        if (!jTable1.getValueAt(row, 0).equals("")) {
            for (int fila = 0; fila < jTable2.getRowCount(); fila++) { //verifico cada uno de los id de la segunda tabla
                if (jTable1.getValueAt(row, 0).equals(jTable2.getValueAt(fila, 0))) { //comparo sin son iguales los ID EXPTE
                    jTable2.setRowSelectionInterval(fila, fila); //esto selecciona toda la fila con el clic
                }
            }
            if (ids.contains(jTable1.getValueAt(row, 0))) {
                jLabel2.setText("La descripción de este expte. ya fue abierta.");
            } else {
                ids.add(jTable1.getValueAt(row, 0));
                caratula = new Caratula ((Expediente)expedienteFacade.buscar((Long)jTable1.getValueAt(row, 0)), (Menor)menorFacade.buscarPorApellidoNombre((String)jTable1.getValueAt(row, 1)));
                caratula.setVisible(true);
                caratula.setLocation(800, 200);
            }
        } else {
            jTable2.clearSelection();
        }
    }
}//GEN-LAST:event_seleccionarFila

    /**
    * @param args the command line arguments
    */
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaExpte().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable1;
    public static javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void buscarExpediente() {
        List<Expediente> expedientes = null;
        if (jCheckBox1.isSelected()) { //metodo de consultar por apellido
            expedientes = expedienteFacade.buscarExpedientePorParametro("apellido", jTextField1.getText());
        } else if (jCheckBox2.isSelected()) { //metodo de consultar por nombre
            expedientes = expedienteFacade.buscarExpedientePorParametro("nombre", jTextField1.getText());
        } else if (jCheckBox3.isSelected()) { //consulta por dni
            expedientes = expedienteFacade.buscarExpedientePorParametro("dni", jTextField1.getText());
        } else if (jCheckBox4.isSelected()) { //metodo de consultar por edad
            expedientes = expedienteFacade.buscarExpedientePorParametro("edad", jTextField1.getText());
        } else if (jCheckBox5.isSelected()) { //consulta por letra de acta inicial
            expedientes = expedienteFacade.buscarExpedientePorParametro("letra de acta inicial", jTextField1.getText());
        } else if (jCheckBox6.isSelected()) { //consulta por num de expte
            expedientes = expedienteFacade.buscarExpedientePorParametro("numero de expediente", jTextField1.getText());
        } else if (jCheckBox7.isSelected()) { //consulta por año
            expedientes = expedienteFacade.buscarExpedientePorParametro("año", jTextField1.getText());
        } else if (jCheckBox8.isSelected()) { //consulta por causa
            expedientes = expedienteFacade.buscarExpedientePorParametro("causa", jTextField1.getText());
        } else if (jCheckBox9.isSelected()) { //consulta por comisaria
            expedientes = expedienteFacade.buscarExpedientePorParametro("comisaria", jTextField1.getText());
        } else if (jCheckBox10.isSelected()) { //consulta por uj
            expedientes = expedienteFacade.buscarExpedientePorParametro("unidad judicial", jTextField1.getText());
        } else if (jCheckBox11.isSelected()) { //consulta por apellido y nombre del padre
            expedientes = expedienteFacade.buscarExpedientePorParametro("apellido y nombre de padre", jTextField1.getText());
        } else if (jCheckBox12.isSelected()) { //consulta por apellido y nombre de la madre
            expedientes = expedienteFacade.buscarExpedientePorParametro("apellido y nombre de madre", jTextField1.getText());
        } else if (jCheckBox13.isSelected()) { //consulta por expediente archivado
            expedientes = expedienteFacade.buscarExpedientePorParametro("archivado", jTextField1.getText());
        }
        if (expedientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontró registro con el parámetro especificado", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Constructor.cargarTabla(jTable1, 6, titulosMenor, "consultaMenor", expedientes);
            Constructor.cargarTabla(jTable2, 4, titulosExpte, "consultaExpte", expedientes);
            escribirEtiqueta();
            jTextField1.setForeground(Color.GRAY);
        }
    }
}
