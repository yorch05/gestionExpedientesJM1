/*
 * VentanaGraficas.java
 *
 * Created on 23 de mayo de 2011, 21:07
 */

package vistas;

import java.awt.BorderLayout;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author  Yorch
 */
public class VentanaGraficas extends javax.swing.JFrame {
    private JFreeChart barras;
    private JFreeChart torta;
    private ChartPanel panel;

    /** Creates new form VentanaGraficas */
    public VentanaGraficas(String instancia) {
        initComponents();
        if (instancia.equals("barras")) {
            this.setSize(460, 503);
        } else {
            this.setSize(650, 503);
        }
        this.setIconImage (new ImageIcon(getClass().getResource("/iconos/iconos16px/icon_16.png")).getImage());
        this.setLocationRelativeTo(this);
        this.toFront();
    }

    public void graficarBarras3D(CategoryDataset porcentajes) {
        barras = ChartFactory.createBarChart3D(
                "Valores estadísticos: Juzgado de Menores 1",     //nombre de la gráfia
                "grupos",                   //nombre del eje horizontal
                "porcentaje",               //nombre del eje vertical
                porcentajes,                      //datos
                PlotOrientation.VERTICAL,   //orientacion de las barras
                true,                       //incluir leyenda
                true,                       //información al pasar el mouse
                true);                      //URLs
        panel = new ChartPanel(barras, false);
        prepararPaneles();
    }

        public void graficarTorta(DefaultPieDataset porcentajes) {
        torta = ChartFactory.createPieChart3D(
                "Valores estadísticos: Juzgado de Menores 1",     //nombre de la gráfia
                porcentajes,                //datos
                true,                       //incluir leyenda
                true,                       //información al pasar el mouse
                true);                      //URLs
        panel = new ChartPanel(torta, false);
        prepararPaneles();
    }
        
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gráficos estadísticos");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/print_16.png"))); // NOI18N
        jButton1.setText("Imprimir gráfico");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirGrafico(evt);
            }
        });

        jLabel1.setText("Opciones:Clic botón derecho sobre el gráfico.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(465, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void imprimirGrafico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirGrafico
    panel.createChartPrintJob();
}//GEN-LAST:event_imprimirGrafico

    @SuppressWarnings("static-access")
private void prepararPaneles() {
    JPanel panelBoton = new JPanel();
    this.setLayout(new BorderLayout());
    panelBoton.add(jLabel1, BorderLayout.WEST);
    panelBoton.add(jButton1, BorderLayout.EAST);
    this.add(panel, BorderLayout.NORTH);
    this.add(panelBoton, BorderLayout.SOUTH);
    
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
