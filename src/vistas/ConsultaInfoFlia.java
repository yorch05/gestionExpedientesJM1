/*
 * ConsultaInfoFlia.java
 *
 * Created on 11 de noviembre de 2009, 08:49
 */
package vistas;

import entidades.Estupefaciente;
import entidades.Expediente;
import facades.MenorFacade;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import entidades.GrupoConvivencia;
import entidades.Menor;
import java.util.List;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author  Yorch
 */
public class ConsultaInfoFlia extends javax.swing.JFrame{

    private GrupoConvivencia g = new GrupoConvivencia();
    private DefaultCategoryDataset valores;
    private DefaultPieDataset valoresTorta;
    private MenorFacade menorFacade = new MenorFacade();
    private int totalMenores = 777;
    private int[] porcentajes = menorFacade.calcularPorcentajes();

    /** Creates new form ConsultaInfoFlia */
    public ConsultaInfoFlia() {
        initComponents();
        inicializarComponentes();
    }

    private void cargarValoresGraficoBarras(String calculo) {
        if (calculo.equals("estadísticas")) {
            valores = new DefaultCategoryDataset();
            valores.setValue(porcentajes[0], "Menores sin padre", "");
            valores.setValue(porcentajes[1], "Menores sin madre", "");
            valores.setValue(porcentajes[2], "No asisten a la escuela", "");
            valores.setValue(porcentajes[3], "Trabajan", "");
            valores.setValue(porcentajes[4], "Consumen estupefacientes", "");
            valores.setValue(porcentajes[5], "Viven en institutos", "");
        } else {
            valores = new DefaultCategoryDataset();
            valores.setValue(porcentajes[6], "Menores que viven con tios", "");
            valores.setValue(porcentajes[7], "Menores que viven con abuelos", "");
            valores.setValue(porcentajes[8], "Menores con escolaridad y trabajo", "");
            valores.setValue(porcentajes[9], "Con escolaridad y consumen estupefacientes", "");
            valores.setValue(porcentajes[10], "Menores con padres separados", "");
        }
    }
    private void cargarValoresGraficoTorta(String calculo) {
        if (calculo.equals("estadísticas")) {
            valoresTorta = new DefaultPieDataset();
            valoresTorta.setValue("Menores sin padre", porcentajes[0]);
            valoresTorta.setValue("Menores sin madre", porcentajes[1]);
            valoresTorta.setValue("Asisten a la escuela", porcentajes[2]);
            valoresTorta.setValue("Trabajan", porcentajes[3]);
            valoresTorta.setValue("Consumen estupefacientes", porcentajes[4]);
            valoresTorta.setValue("Viven en institutos", porcentajes[4]);
            
        } else {
            valoresTorta = new DefaultPieDataset();
            valoresTorta.setValue("Menores que viven con tios", porcentajes[6]);
            valoresTorta.setValue("Menores que viven con abuelos", porcentajes[7]);
            valoresTorta.setValue("Menores con escolaridad y trabajo", porcentajes[8]);
            valoresTorta.setValue("Con escolaridad y consumen estupefacientes", porcentajes[9]);
            valoresTorta.setValue("Menores con padres separados", porcentajes[10]);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Información de menores");
        setBackground(new java.awt.Color(204, 255, 204));
        setIconImages(null);

        jCheckBox1.setText("Buscar por Expte");
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                escucharClic(evt);
            }
        });

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
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
                escucharFuente(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/monitor_16.png"))); // NOI18N
        jButton2.setText("Mostrar todos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setCaretColor(new java.awt.Color(0, 102, 0));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estadísticas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 51))); // NOI18N

        jRadioButton1.setBackground(new java.awt.Color(204, 255, 204));
        jRadioButton1.setText("Menores sin padre");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                escucharClic(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(204, 255, 204));
        jRadioButton2.setText("Menores sin madre");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                escucharClic(evt);
            }
        });

        jRadioButton3.setBackground(new java.awt.Color(204, 255, 204));
        jRadioButton3.setText("Menores que no asisten a la escuela");
        jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                escucharClic(evt);
            }
        });

        jRadioButton4.setBackground(new java.awt.Color(204, 255, 204));
        jRadioButton4.setText("Menores que trabajan");
        jRadioButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                escucharClic(evt);
            }
        });

        jRadioButton5.setBackground(new java.awt.Color(204, 255, 204));
        jRadioButton5.setText("Menores que consumen estupefacientes");
        jRadioButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                escucharClic(evt);
            }
        });

        jRadioButton6.setBackground(new java.awt.Color(204, 255, 204));
        jRadioButton6.setText("Menores en Institutos de menores");
        jRadioButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                escucharClic(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(jRadioButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .addComponent(jRadioButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel1.setText("Total de Menores:");

        jLabel2.setBackground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("▼ Otros valores (clic aquí)");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                desplegarLabels(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(204, 255, 204));
        jLabel3.setText("Menores que viven con tios:");

        jLabel4.setBackground(new java.awt.Color(204, 255, 204));
        jLabel4.setText("Menores que viven con abuelos (como único adulto):");

        jLabel5.setBackground(new java.awt.Color(204, 255, 204));
        jLabel5.setText("Menores con escolaridad y trabajo:");

        jLabel6.setBackground(new java.awt.Color(204, 255, 204));
        jLabel6.setText("Menores que consumen estupefacientes y tienen escolaridad:");

        jLabel7.setText("Menores con padres separados: ");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/bubble_16.png"))); // NOI18N
        jButton3.setText("Buscar en del texto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/statistics_16.png"))); // NOI18N
        jButton4.setText("Gráficar");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jCheckBox2.setText("Graficar estadísticas");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jCheckBox3.setText("Graficar otros valores");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jRadioButton7.setText("Gráfico de barras");
        jRadioButton7.setEnabled(false);
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jRadioButton8.setText("Gráfico de torta");
        jRadioButton8.setEnabled(false);
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox3))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton8)
                            .addComponent(jRadioButton7))
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(40, 40, 40))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox2)
                            .addComponent(jRadioButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox3)
                            .addComponent(jRadioButton8)))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void escucharFuente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escucharFuente
    if (evt.getSource().equals(jButton1)) {
        buscarExpediente();
    } else if (evt.getSource().equals(jButton2)) {
        mostrarTodos();
    } else if (evt.getSource().equals(jTextField1)) {
        buscarExpediente();
    } else if (evt.getSource().equals(jButton3)) {
        buscarEnAreaTexto();
    } else if (evt.getSource().equals(jButton4)) {
        graficarEstadisticas();
    } else if (evt.getSource().equals(jCheckBox2)) {
        if (jCheckBox2.isSelected()) {
            jCheckBox3.setEnabled(false);
            jRadioButton7.setEnabled(true);
            jRadioButton8.setEnabled(true);
        } else {
            jCheckBox3.setEnabled(true);
            jRadioButton7.setEnabled(false);
            jRadioButton8.setEnabled(false);
            jRadioButton7.setSelected(false);
            jRadioButton8.setSelected(false);
            jButton4.setEnabled(false);
        }
    } else if (evt.getSource().equals(jCheckBox3)){
        if (jCheckBox3.isSelected()) {
            jCheckBox2.setEnabled(false);
            jRadioButton7.setEnabled(true);
            jRadioButton8.setEnabled(true);
        } else {
            jCheckBox2.setEnabled(true);
            jRadioButton7.setEnabled(false);
            jRadioButton8.setEnabled(false);
            jRadioButton7.setSelected(false);
            jRadioButton8.setSelected(false);
            jButton4.setEnabled(false);
        }
    } else if (evt.getSource().equals(jRadioButton7)) {
        jRadioButton7.setSelected(true);
        jRadioButton8.setSelected(false);
        jButton4.setEnabled(true);
    } else if (evt.getSource().equals(jRadioButton8)) {
        jRadioButton7.setSelected(false);
        jRadioButton8.setSelected(true);
        jButton4.setEnabled(true);
    }
    jTextField1.setText(""); //despues de haber presionado cualquiera de los botones se borra el campo Buscar
}//GEN-LAST:event_escucharFuente

private void habilitarBoton(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_habilitarBoton
    if (evt.getSource().equals(jTextField1)) {
        if (!jTextField1.getText().equals("")) {
            if (jTextField1.getText().length() >= 3) {
                jButton1.setEnabled(true);
                jButton1.setVisible(true);
            } else {
                jButton1.setEnabled(false);
                jButton1.setVisible(false);
            }
        } else {
            jButton1.setEnabled(false);
            jButton1.setVisible(false);
        }
    }
}//GEN-LAST:event_habilitarBoton

private void escucharClic(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_escucharClic
    if (evt.getSource().equals(jCheckBox1)) {
        if (jCheckBox1.isSelected()) {
            jTextField1.setVisible(true);
            jTextField1.setEnabled(true);
            jTextField1.grabFocus();
        } else {
            jTextField1.setVisible(false);
            jTextField1.setEnabled(false);
        }
    } else if (evt.getSource().equals(jRadioButton1)) {
        if (jRadioButton1.isSelected()) {
            jRadioButton1.setText("Menores sin padre   " + porcentajes[0] + "%");
        } else {
            jRadioButton1.setText("Menores sin padre");
        }
    } else if (evt.getSource().equals(jRadioButton2)) {
        if (jRadioButton2.isSelected()) {
            jRadioButton2.setText("Menores sin madre   " + porcentajes[1] + "%");
        } else {
            jRadioButton2.setText("Menores sin madre");
        }
    } else if (evt.getSource().equals(jRadioButton3)) {
        if (jRadioButton3.isSelected()) {
            jRadioButton3.setText("Menores que asisten a la escuela   " + porcentajes[2] + "%");
        } else {
            jRadioButton3.setText("Menores que asisten a la escuela");
        }
    } else if (evt.getSource().equals(jRadioButton4)) {
        if (jRadioButton4.isSelected()) {
            jRadioButton4.setText("Menores que trabajan   " + porcentajes[3] + "%");
        } else {
            jRadioButton4.setText("Menores que trabajan");
        }
    } else if (evt.getSource().equals(jRadioButton5)) {
        if (jRadioButton5.isSelected()) {
            jRadioButton5.setText("Menores que consumen estupefacientes   " + porcentajes[4] + "%");
        } else {
            jRadioButton5.setText("Menores que consumen estupefacientes");
        }
    } else if (evt.getSource().equals(jRadioButton6)) {
        if (jRadioButton6.isSelected()) {
            jRadioButton6.setText("Menores en Institutos de menores   " + porcentajes[5] + "%");
        } else {
            jRadioButton6.setText("Menores en Institutos de menores");
        }
    }
}//GEN-LAST:event_escucharClic

private void desplegarLabels(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_desplegarLabels
    if (jLabel2.getText().equals("▼ Otros valores (clic aquí)")) {
        jLabel2.setText("▲");
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jLabel5.setVisible(true);
        jLabel6.setVisible(true);
        jLabel7.setVisible(true);
    } else {
        jLabel2.setText("▼ Otros valores (clic aquí)");
        ocultarEtiquetas();
    }
}//GEN-LAST:event_desplegarLabels

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaInfoFlia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void inicializarComponentes() {
        jTextArea1.setText("");
        jTextField1.setEnabled(false);
        jButton1.setVisible(false);
        jButton1.setEnabled(false);
        jButton3.setVisible(false);
        ocultarEtiquetas();
        escribirEtiquetas();
        this.setIconImage (new ImageIcon(getClass().getResource("/iconos/iconos16px/icon_16.png")).getImage());
        this.jLabel2.setCursor(new Cursor(HAND_CURSOR));
    }
    
    private void escribirEtiquetas() {
        totalMenores = menorFacade.getTodos().size();
        jLabel1.setText("Total de Menores: " + totalMenores);
        jLabel3.setText("Menores que viven con tios: " + porcentajes[6] + "%");
        jLabel4.setText("Menores que viven con abuelos (como único adulto): " + porcentajes[7] + "%");
        jLabel5.setText("Menores con escolaridad y trabajo:" + porcentajes[8] + "%");
        jLabel6.setText("Menores que consumen estupefacientes y tienen escolaridad: " + porcentajes[9] + "%");
        jLabel7.setText("Menores con padres separados: " + porcentajes[10] + "%");
    }

    private void ocultarEtiquetas() {
        jLabel3.setVisible(false);
        jLabel4.setVisible(false); 
        jLabel5.setVisible(false); 
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
    }
    

    private void buscarExpediente() {
        jCheckBox1.setSelected(false);
        jTextField1.setEnabled(false);
        jButton1.setVisible(false);
        menorFacade = new MenorFacade();
        if (!menorFacade.getMenoresPorExpediente(jTextField1.getText()).isEmpty()) {
            List<Menor> listaMenores = menorFacade.getMenoresPorExpediente(jTextField1.getText());
            for (Menor menor : listaMenores) {
                escribirAreaTexto(menor);
            }
            jButton3.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se encontró el expediente ingresado.", "Resultado", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void escribirAreaTexto(Menor menor) {
        this.jTextArea1.append("\n________________________________________________");
        for (Expediente expediente : menor.getExpedientes()) {
            System.out.println("dentro de lista de Expediente");
            this.jTextArea1.append("\n   Expte: " + expediente.toString());
            this.jTextArea1.append("\n---------------------------------------------------------------------------------------");
            this.jTextArea1.append("\n   Causa:  " + expediente.getCausa().getDescripcion());
            this.jTextArea1.append("\n---------------------------------------------------------------------------------------");
            this.jTextArea1.append("\n   Menor:  " + menor.toString());
            this.jTextArea1.append("\n---------------------------------------------------------------------------------------");
            this.jTextArea1.append("\n   Edad:  " + menor.getEdad());
            this.jTextArea1.append("\n________________________________________________");
            this.jTextArea1.append("\n\tDatos del grupo de convivencia ");
            this.jTextArea1.append("\n________________________________________________");
            try {
                for (String parientes : menor.getGrupoConvivencia().getGrupoConvivencia()) {
                    if (parientes.equals("Tio: Si")) {
                        this.jTextArea1.append("\n  Tio");
                    }
                    if (parientes.equals("Tia: Si")) {
                        this.jTextArea1.append("\n  Tia");
                    }
                    if (parientes.equals("Abuelo: Si")) {
                        this.jTextArea1.append("\n  Abuelo");
                    }
                    if (parientes.equals("Abuela: Si")) {
                        this.jTextArea1.append("\n  Abuela");
                    }
                    if (parientes.equals("Primo: Si")) {
                        this.jTextArea1.append("\n  Primo");
                    }
                    if (parientes.equals("Prima: Si")) {
                        this.jTextArea1.append("\n  Prima");
                    }
                    if (parientes.equals("Cuñado: Si")) {
                        this.jTextArea1.append("\n  Cuñado");
                    }
                    if (parientes.equals("Cuñada: Si")) {
                        this.jTextArea1.append("\n  Cuñada");
                    }
                    if (parientes.equals("Sobrino: Si")) {
                        this.jTextArea1.append("\n  Sobrino");
                    }
                    if (parientes.equals("Sobrina: Si")) {
                        this.jTextArea1.append("\n  Sobrina");
                    }
                    if (!parientes.equals("") || !parientes.equals("información adicional para agregar...")) {
                        this.jTextArea1.append("\n  Información adicional:\n  " + parientes);
                    } else {
                        this.jTextArea1.append("\n  " + parientes); //al no cumplir ninguna de las condiciones imprime: padre, madre, hno, hna
                    }
                }
            } catch (java.lang.NullPointerException ex) {
                this.jTextArea1.append("\n No hay datos cargados sobre el grupo conviviente");
            }
            this.jTextArea1.append("\n________________________________________________");
            this.jTextArea1.append("\n\t Situación del menor");
            this.jTextArea1.append("\n________________________________________________");
            try {
                if (menor.getEscolaridad().equals("Si")) {
                    this.jTextArea1.append("\n  Escolaridad:\n   El menor está concurriendo a la escuela");
                    this.jTextArea1.append("\n---------------------------------------------------------------------------------------");
                } else {
                    this.jTextArea1.append("\n  Escolaridad:\n   El menor no está concurriendo a la escuela");
                    this.jTextArea1.append("\n---------------------------------------------------------------------------------------");
                }
            } catch (java.lang.NullPointerException ex) {
                this.jTextArea1.append("\n No hay datos cargados acerca de la escolaridad del menor.");
            }
            try {
                if (menor.getTrabajo().equals("Si")) {
                    this.jTextArea1.append("\n  Trabajo:\n   El menor trabaja");
                    this.jTextArea1.append("\n---------------------------------------------------------------------------------------");
                } else {
                    this.jTextArea1.append("\n  Trabajo:\n   El menor no trabaja");
                    this.jTextArea1.append("\n---------------------------------------------------------------------------------------");
                }
            } catch (java.lang.NullPointerException ex) {
                this.jTextArea1.append("\n No hay datos cargados acerca de la ocupación del menor.");
            }
            if (menor.getConsumoEstupefacientes() != null) {
                for (Estupefaciente est : menor.getConsumoEstupefacientes()) {
                    this.jTextArea1.append("\n  Consumo de estupefacientes:\n   El menor consume " + est.getDescripcion());
                }
                this.jTextArea1.append("\n---------------------------------------------------------------------------------------");
            } else {
                this.jTextArea1.append("\n  Consumo de estupefacientes:\n   El menor no consume");
                this.jTextArea1.append("\n---------------------------------------------------------------------------------------");
            }
            this.jTextArea1.append("");
            jTextArea1.setEditable(false);
        }
    }

    private void mostrarTodos() {
        jTextArea1.setText("");
        menorFacade = new MenorFacade();
        if (!menorFacade.getTodos().isEmpty()) {
            List<Menor> listaMenores = menorFacade.getTodos();
            for (Menor menor : listaMenores) {
                System.out.println("TAMAÑO DE LISTA DE MENORES: " +  listaMenores.size());
                escribirAreaTexto(menor);
                System.out.println("despues de escribir area de texto");
            }
            jButton3.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "No hay menores cargados.", "Resultado", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarEnAreaTexto() {
        boolean f = true;
        int longitud = 0;
        String textoABuscar = "";
        do {
            int posicion = 0;
            try {
                if (f) {
                    String aux = JOptionPane.showInputDialog(this, "Texto a buscar", textoABuscar);
                    textoABuscar = aux;
                    longitud = Integer.valueOf(posicion + textoABuscar.length());
                }
                System.out.println("longitud del texto a buscar: " + textoABuscar.length());
                f = false;
                String texto = jTextArea1.getText();
                posicion = texto.indexOf(textoABuscar, posicion);
                System.out.println("indice de texto a buscar: " + posicion);
                System.out.println("palabra seleccionada de " + Integer.valueOf(posicion + textoABuscar.length()) + " caracteres");
                System.out.println("suma: " + Integer.valueOf(posicion + textoABuscar.length()));
                try {
                    jTextArea1.setCaretPosition(posicion);
                    jTextArea1.moveCaretPosition(Integer.valueOf(posicion + textoABuscar.length()));
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(rootPane, "No se encontró la palabra.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                }
                if (posicion == -1) {
                    System.out.println("Dentro de posicion = -1");
                    if (JOptionPane.showConfirmDialog(rootPane, "Llegó al final del archivo ¿Desea buscar desde el inicio?", "Resultado", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {
                        f = true;
                    } else {
                        f = false;
                    }
                }
            } catch (java.lang.NullPointerException e) {
                if (longitud == 0) {
                    JOptionPane.showMessageDialog(rootPane, "No se ingresó ninguna palabrapara buscar.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    f = false;
                }
            }
        } while (f);
    }

    private void graficarEstadisticas() {
        if (jCheckBox2.isSelected()) {
            if (jRadioButton7.isSelected()) {
                cargarValoresGraficoBarras("estadísticas");
            } else {
                cargarValoresGraficoTorta("estadísticas");
            }
        } else {
            if (jRadioButton7.isSelected()) {
                cargarValoresGraficoBarras("otros valores");
            } else {
                cargarValoresGraficoTorta("otros valores");
            }
        }
        if (jRadioButton7.isSelected()) {
            VentanaGraficas graficas = new VentanaGraficas("barras");
            graficas.graficarBarras3D(valores);
            graficas.setVisible(true);
        } else {
            VentanaGraficas graficas = new VentanaGraficas("torta");
            graficas.graficarTorta(valoresTorta);
            graficas.setVisible(true);
        }
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox2.setEnabled(true);
        jCheckBox3.setEnabled(true);
        jRadioButton7.setSelected(false);
        jRadioButton8.setSelected(false);
        jRadioButton7.setEnabled(false);
        jRadioButton8.setEnabled(false);
        jButton4.setEnabled(false);
    }
}
