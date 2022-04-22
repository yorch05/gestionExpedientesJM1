/*
 * CargadorArchivo.java
 *
 * Created on 30 de abril de 2010, 08:55
 */
package vistas;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author  Yorch
 */
public class CargadorArchivo extends javax.swing.JFrame {

    static int valor;
    static String file1 = "";
    static String file2 = "";
    static String secretaria = "";
    static final String LOBO = " Lobo Browser es un navegador web escrito desde cero en lenguaje Java.\nEsto le da algunas ventajas, como una mayor seguridad frente a desbordamientos de memoria,\nportabilidad inmediata y un lenguaje más poderoso para crear extensiones.";
    static final String FIREFOX = "C:/Program Files/Firefox/MOZILLA FIREFOX.EXE";
    static final String OPERA = "C:/Program Files/Opera/OPERA.EXE";
    static final String IE = "C:/Program Files/Internet Explorer/IEXPLORE.EXE";
    static final String WORD = "C:/Program Files/Microsoft Office/Office12/WINWORD.EXE";
    static final String EXCEL = "C:/Program Files/Microsoft Office/Office12/EXCEL.EXE";
    static final String WORDPAD = "C:/Windows/NOTEPAD.EXE";
    static final String READER = "C:/Programa Files/Adobe/";
    static final String PATH_LOBO = "C:/Program Files/Lobo";
    static final String PATH_FILE = "C:/Users/Yorch/Documents/JM1/";
    static final String TEXTO = "Iniciando aplicación externa...\nEspere unos instantes.";

    /** Creates new form CargadorArchivo */
    public CargadorArchivo(String nombreSec) {
        initComponents();
        secretaria = nombreSec;
        this.setLocation(300, 150);
        this.jTextArea1.setText(TEXTO);
        this.jLabel2.setVisible(false);
        this.setIconImage (new ImageIcon(getClass().getResource("/menores/imagenes/16px/icon_16.png")).getImage());
        this.setTitle("Abrir archivo");
    }

    public void abrirArchivoWord() {
        if (secretaria.equals("penal")) {
            file1 = "Penal/archivopenal2010-copia.docx";
            file2 = "Penal/archivopenal2010-copia.doc";
        } else if (secretaria.equals("asistencial")) {
            file1 = "Asistencial/archivoasistencial2010-copia.docx";  //nombre de archivo htm de asistencial
            file2 = "Asitencial/asistencial2010-copia.doc";
        } else {
            file1 = "Civil/archivocivil2010-copia.docx";  //nombre de archivo htm de civil
            file2 = "Civil/archivocivil2010-copia.doc";
        }
        try {
            Runtime run = Runtime.getRuntime();
            run.exec(WORD + " " + PATH_FILE + file1);
            this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/menores/imagenes/64px/word64px.png")));
            this.jLabel3.setText("WORD");
            this.setVisible(true);
            this.cargarBarra(10);
        } catch (IOException ex) {
            Logger.getLogger(CargadorArchivo.class.getName()).log(Level.SEVERE, null, ex);
            try {
                Runtime run = Runtime.getRuntime();
                run.exec(WORD + " " + PATH_FILE + file2);
                this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/menores/imagenes/64px/word64px.png")));
                this.jLabel3.setText("WORD");
                this.setVisible(true);
                this.cargarBarra(10);
            } catch (IOException e) {
                Logger.getLogger(CargadorArchivo.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(rootPane, "No se puede abrir el archivo.\nConsulte la ayuda disponible en el Menú principal", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void abrirArchivoExcel() {
        if (secretaria.equals("penal")) {
            file1 = "Penal/archivopenal2010-copia.xlsx";
            file2 = "Penal/archivopenal2010-copia.xls";
        } else if (secretaria.equals("asistencial")) {
            file1 = "Asistencial/archivoasistencial2010-copia.xlsx";  //nombre de archivo htm de asistencial
            file2 = "Asitencial/asistencial2010-copia.xls";
        } else {
            file1 = "Civil/archivocivil2010-copia.xlsx";  //nombre de archivo htm de civil
            file2 = "Civil/archivocivil2010-copia.xls";
        }
        try {
            Runtime run = Runtime.getRuntime();
            run.exec(EXCEL + " " + PATH_FILE + file1);
            this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/menores/imagenes/64px/excel64px.png")));
            this.jLabel3.setText("EXCEL");
            this.setVisible(true);
            this.cargarBarra(10);
        } catch (IOException ex) {
            Logger.getLogger(CargadorArchivo.class.getName()).log(Level.SEVERE, null, ex);
            try {
                Runtime run = Runtime.getRuntime();
                run.exec(EXCEL + " " + PATH_FILE + file2);
                this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/menores/imagenes/64px/excel64px.png")));
                this.jLabel3.setText("EXCEL");
                this.setVisible(true);
                this.cargarBarra(10);
            } catch (IOException e2) {
                Logger.getLogger(CargadorArchivo.class.getName()).log(Level.SEVERE, null, e2);
                JOptionPane.showMessageDialog(rootPane, "No se puede abrir el archivo.\nConsulte la ayuda disponible en el Menú principal", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void abrirArchivoTxt() {
        try {
            Runtime run = Runtime.getRuntime();
            run.exec(WORDPAD + " " + PATH_FILE + "Penal/archivopenal2010-copia.txt");
            this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/menores/imagenes/64px/wordpad64px.png")));
            this.jLabel3.setText("NOTEPAD");
            this.setVisible(true);
            this.cargarBarra(50);
        } catch (IOException ex) {
            Logger.getLogger(CargadorArchivo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "No se puede abrir el archivo.\nConsulte la ayuda disponible en el Menú principal", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void abrirArchivoHtm() {
        if (secretaria.equals("penal")) {
            file1 = "Penal/archivopenal2010-copia.htm";
        } else if (secretaria.equals("asistencial")) {
            file1 = "Asistencial/archivoasistencial2010-copia.htm";  //nombre de archivo htm de asistencial
        } else {
            file1 = "Civil/archivocivil2010-copia.htm";  //nombre de archivo htm de civil
        }
        try {
            Runtime.getRuntime().exec(OPERA + " " + PATH_FILE + file1);
            this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/menores/imagenes/64px/opera64px.png")));
            this.jLabel3.setText("Opera");
            this.setVisible(true);
            this.cargarBarra(20);
        } catch (IOException ex) {
            Logger.getLogger(CargadorArchivo.class.getName()).log(Level.SEVERE, null, ex);
            try {
                Runtime run = Runtime.getRuntime();
                run.exec(FIREFOX + " " + PATH_FILE + file1);
                this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/menores/imagenes/64px/firefox64px.png")));
                this.jLabel3.setText("Firefox");
                this.setVisible(true);
                this.cargarBarra(20);
            } catch (IOException exc) {
                Logger.getLogger(CargadorArchivo.class.getName()).log(Level.SEVERE, null, exc);
                try {
                    Runtime run = Runtime.getRuntime();
                    run.exec(IE + " " + PATH_FILE + file1);
                    this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/menores/imagenes/64px/ie64px.png")));
                    this.jLabel3.setText("Explorer");
                    this.setVisible(true);
                    this.cargarBarra(10);
                } catch (IOException exce) {
                    Logger.getLogger(CargadorArchivo.class.getName()).log(Level.SEVERE, null, exce);
                    try {
                        Runtime.getRuntime().exec(LOBO + " " + PATH_FILE + file1);
                        this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/menores/imagenes/64px/lobo64px.png")));
                        this.jLabel3.setText("Lobo");
                        this.setVisible(true);
                        this.cargarBarra(15);
                        if (JOptionPane.showConfirmDialog(this, "No hay navegadores web instalados en su PC. ¿Desea instalar uno ahora mismo?\nEl navegador que se instalará es:" +
                                "\n -->" + LOBO, "Navegador web", JOptionPane.YES_NO_OPTION) == 0) {
                            try {
                                /**
                                 * OPCION DE SENTENCIA PARA ABRIR ARCHIVO JAR
                                 * Runtime r = Runtime.getRuntime()
                                 * Process p=r.exec("JAVAW.EXE -jar Ejemplo1.jar");;
                                 */
                                Runtime.getRuntime().exec("JAVAW.EXE -jar C:/WINDOWS/install-lobo-0.98.4.jar");
                                JOptionPane.showMessageDialog(this, "Se recomienda instalar este software en la ruta: " +
                                        "\n " + PATH_LOBO, "Atención", JOptionPane.WARNING_MESSAGE);
                            } catch (IOException except) {
                                Logger.getLogger(CargadorArchivo.class.getName()).log(Level.SEVERE, null, except);
                                JOptionPane.showMessageDialog(rootPane, "No se pudo instalar el software.\nContáctese con el administrador del sistema", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch (IOException exc2) {
                        Logger.getLogger(CargadorArchivo.class.getName()).log(Level.SEVERE, null, exc2);
                        JOptionPane.showMessageDialog(rootPane, "No se pudo abrir el archivo. Ud no posee un navegador web instalado." +
                                "\nInstale el software indicado para abrir el archivo htm", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

    public void abrirArchivoPdf() {
        File path;
        if (secretaria.equals("penal")) {
            file1 = "Penal/archivopenal2010-copia.pdf";
        } else if (secretaria.equals("asistencial")) {
            file1 = "Asistencial/archivoasistencial2010-copia.pdf";  //nombre de archivo htm de asistencial
        } else {
            file1 = "Civil/archivocivil2010-copia.pdf";  //nombre de archivo htm de civil
        }
        try {
            /* metodo para abrir cualquier archivo pero solo en windows
             * Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"ayuda.pdf");        
             * TIEMPO DE DEMORA DE APERTURA: 12 seg primera prueba, 4 seg segunda prueba, 3 seg tercer prueba....
             * DESVENTAJA: solo para SO windows
             */
//        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:/Users/Yorch/Documents/JM1/Penal/archivopenal2010-copia.pdf");

//        Pattern p = Pattern.compile(READER + "Reader" + "*" + "/" + file1);
//        Matcher match = p.matcher(READER);

            /* otro metodo para abrir un archivo sin especificar el software asociado
            File path = new File ("carpeta/tuArchivo.pdf");
            Desktop.getDesktop().open(path);
             * TIEMPO DE DEMORA DE APERTURA : 20 seg primera prueba, 3 seg segunda y otras pruebas
             * otra de las soluciones seria abrir un JFileChooser y escoger la ruta del programa 
             * con que se quiere abrir el archivo. 
             * DESVENTAJA: para operarios novatos esto es desconocido
             */
            path = new File(PATH_FILE + file1);
            Desktop.getDesktop().open(path);
            this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/menores/imagenes/64px/adobe64px.png")));
            this.jLabel3.setText("Adobe");
            this.setVisible(true);
            cargarBarra(30);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(rootPane, "El archivo no existe. Verifique que no haya sido borrado o modificado de ubicación.", "Puntero Nulo", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            Logger.getLogger(CargadorArchivo.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void cargarBarra(int suma) {
        Random random = new Random();
        for (valor = 0; valor <= 100; valor += suma) {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException ignore) {
            }
            jProgressBar1.setValue(valor);
            this.jLabel4.setText(valor + "% cargado");
            /*
             * jProgressBar1.updateUI(); //no aparece la ventana que deberia
             * jProgressBar1.update(this.jPanel1.getGraphics()); //no aparece la ventana que deberia, solo la barra cargando
             * jProgressBar1.setMaximum(valor);
             * jProgressBar1.repaint();  // solo aparece la barra de menu ( de la barra o la ventana(?) )
             */
            this.update(this.getGraphics()); //se actualiza toda la ventana -> funciona
        }
        if (valor > 100) {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException ex) {
            }
            jProgressBar1.setValue(100);
            this.jLabel2.setVisible(true);
            this.jLabel4.setText("Listo");
            this.jTextArea1.setText("\nPuede cerrar esta mensaje.");
        }
    }

    private boolean leer(String path) {
        File file = new File(path);
        try {
            String linea;
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            try {
                while ((linea = br.readLine()) != null) {
//                        this.ultimoControl = linea;
                    if (linea.startsWith("letra")) {
                        this.jTextArea1.append("\n----------------------------" +
                                "-------------------------------------------" +
                                "-------------------------------------------" +
                                "-------------------------------------------" +
                                "-------------------------------------------" +
                                "-------------------------------------------" +
                                "-------------------------------------------" +
                                "-------------------------------------------" +
                                "-------------------------------------------" +
                                "------------------------------------------");
                        this.jTextArea1.append("\n\t\t\t\t\t\t\t" + linea);
                        this.jTextArea1.append("\n----------------------------" +
                                "-------------------------------------------" +
                                "-------------------------------------------" +
                                "-------------------------------------------" +
                                "-------------------------------------------" +
                                "-------------------------------------------" +
                                "-------------------------------------------" +
                                "-------------------------------------------" +
                                "-------------------------------------------" +
                                "------------------------------------------");
                    } else {
                        this.jTextArea1.append("\n" + linea);
                    }
                }
                br.close();
                fr.close();
                return true;
            } catch (IOException ex) {
                return false;
            }
        } catch (FileNotFoundException ex) {
            return false;
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Abriendo archivo..."));

        jTextArea1.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14));
        jTextArea1.setRows(5);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menores/imagenes/opera64px.png"))); // NOI18N

        jLabel2.setText("Cerrar Ventana");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarVentanaArchivo(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                            .addComponent(jTextArea1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cerrarVentanaArchivo(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarVentanaArchivo
    this.dispose();
}//GEN-LAST:event_cerrarVentanaArchivo
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CargadorArchivo("").setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
