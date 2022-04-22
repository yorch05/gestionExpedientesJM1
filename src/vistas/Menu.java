/*
 * Menu.java
 *
 * Created on 26 de octubre de 2009, 10:16
 */
package vistas;

import facades.AudienciaFacade;
import facades.ComisariaFacade;
import facades.EstupefacienteFacade;
import facades.UnidadJudicialFacade;
import facades.UsuarioFacade;
import entidades.Comisaria;
import entidades.Estupefaciente;
import entidades.UnidadJudicial;
import entidades.Usuario;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import includes.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;


/**
 *
 * @author  Yorch
 */
public class Menu extends javax.swing.JFrame {  
    private boolean bandera = true,  bandera2 = true,  bandera3 = true, bandera4 = true, bandera5 = true;
    private int m1, m2, m3, adm;
    private int fila;
    private String estu;
    public boolean permisoAsist = false; //si se trata de admin se cambia a true
    public boolean permisoCivil = false;//si se trata de admin se cambia a true
    //cargo los titulos de las columnas de la tabla.
    private String[] titulosAdmin = {"Nombre de usuario","Contraseña","Permiso de Expte.","Audiencia","Información","Asistencial","Civil"};
    private String[] titulosComisaria = {"id","Comisaría","teléfono"};
    private String[] titulosUnidadJudicial = {"id","Unidad Judicial","teléfono"};
    private String[] titulosEstupefacientes = {"","estupefaciente"};
    public Menu(int mod1, int mod2, int mod3, int ad) {
        initComponents();
        inicializarComponentes(mod1,mod2,mod3,ad);
    }

    private void controlUsuario() {
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        if (adm == 1) {
            jLabel10.setText("Nombre de usuario en uso: " + usuarioFacade.getNombreUsuario(6));
            jPasswordField3.setText(usuarioFacade.getPassword(6, jLabel10.getText().substring(26)));
            permisoAsist = true;
            permisoCivil = true;
        }
        if (m1 == 1 && m2 == 1 && m3 == 1){
            jLabel10.setText("Nombre de usuario en uso: " + usuarioFacade.getNombreUsuario(4));
            jPasswordField3.setText(usuarioFacade.getPassword(4, jLabel10.getText().substring(26)));
        }
        if (m1 == 1 && m2 == 0 && m3 == 0) {
            jLabel10.setText("Nombre de usuario en uso: " + usuarioFacade.getNombreUsuario(1));
            jPasswordField3.setText(usuarioFacade.getPassword(1, jLabel10.getText().substring(26)));
        }
        if (m1 == 0 && m2 == 1 && m3 == 0) {
            jLabel10.setText("Nombre de usuario en uso: " + usuarioFacade.getNombreUsuario(2));
            jPasswordField3.setText(usuarioFacade.getPassword(2, jLabel10.getText().substring(26)));
        }
        if (m1 == 0 && m2 == 0 && m3 == 1) {
            jLabel10.setText("Nombre de usuario en uso: " + usuarioFacade.getNombreUsuario(3));
            jPasswordField3.setText(usuarioFacade.getPassword(3, jLabel10.getText().substring(26)));
        }
        if (m1 == 0 && m2 == 0 && m3 == 0) {
            jLabel10.setText("Nombre de usuario en uso: " + usuarioFacade.getNombreUsuario(5));
            jPasswordField3.setText(usuarioFacade.getPassword(5, jLabel10.getText().substring(26)));
            jMenuItem7.setEnabled(true);
            jMenuItem9.setEnabled(true);
            jMenuItem11.setEnabled(true);
            jMenuItem8.setEnabled(false);
            jMenuItem10.setEnabled(false);
            jMenuItem12.setEnabled(false);
        }
    }

    private void iniciarAyuda() {
        try {
            File fichero = new File("help/help_set.hs");
            URL hsURL = fichero.toURI().toURL();
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();
            hb.enableHelpOnButton(jMenuItem5, "inicio", helpset);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString(), "Excepcion", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ocultarBotonesVentanas() {
        jButton12.setVisible(false);
        jButton13.setVisible(false);
        jButton16.setVisible(false);
        jButton17.setVisible(false);
        jButton18.setVisible(false);
        jButton19.setVisible(false);
    }

    private void inhabilitarItems() { //inhabilita items pertenecientes a administrador
        jMenuItem1.setEnabled(false);
        jMenuItem2.setEnabled(false);
        jMenuItem3.setEnabled(false);
        jMenuItem4.setEnabled(false);
        jMenuItem14.setEnabled(false);
    }

    private void inhabilitarBotones() {
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        jButton8.setEnabled(false);
        jButton10.setEnabled(false);
        jButton14.setEnabled(false);
        jButton26.setEnabled(false);
    }

    private void habilitarModulo1(int mod1) { //habilita modulo de expedientes
        m1 = mod1;
        if (m1 == 1) {
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            jMenuItem7.setEnabled(false);
            jMenuItem10.setEnabled(false);
            jMenuItem12.setEnabled(false);
        }
    }

    private void habilitarModulo2(int mod2) { //habilita modulo de audiencias
        m2 = mod2;
        if (m2 == 1) {
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
            jMenuItem8.setEnabled(false);
            jMenuItem9.setEnabled(false);
            jMenuItem12.setEnabled(false);
        }
    }

    private void habilitarModulo3(int mod3) { //habilita modulo de informacion
        m3 = mod3;
        if (m3 == 1) {
            jButton5.setEnabled(true);
            jButton6.setEnabled(true);
            jButton26.setEnabled(true);
            jMenuItem8.setEnabled(false);
            jMenuItem10.setEnabled(false);
            jMenuItem11.setEnabled(false);
        }
    }
    
    private void habilitar3Modulos(int mod1, int mod2, int mod3, int ad) {
        if (mod1 == 1 && mod2 == 1 && mod3 == 1 && ad == 0) {
            jMenuItem8.setEnabled(true);
            jMenuItem10.setEnabled(true);
            jMenuItem12.setEnabled(true);
        }
    }

    private void habilitarAdmin(int ad) { //habilita todos los modulos
        adm = ad;
        if (adm == 1) {
            jMenuItem1.setEnabled(true);
            jMenuItem2.setEnabled(true);
            jMenuItem3.setEnabled(true);
            jMenuItem4.setEnabled(true);
            jMenuItem7.setEnabled(false);
            jMenuItem8.setEnabled(true);
            jMenuItem9.setEnabled(false);
            jMenuItem10.setEnabled(true);
            jMenuItem11.setEnabled(false);
            jMenuItem12.setEnabled(true);
            jMenuItem13.setEnabled(false);
            jMenuItem14.setEnabled(true);
            jMenuItem15.setEnabled(true);
            jMenuItem16.setEnabled(true);
        }
    }
    
    private void ocultarBotonesArchivo() { //oculta los botones para abrir archivo
        jLabel16.setVisible(false);
        jButton27.setVisible(false);
        jButton28.setVisible(false);
        jButton29.setVisible(false);
        jButton30.setVisible(false);
        jButton31.setVisible(false);
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton26 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton31 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        barraMenu = new javax.swing.JInternalFrame();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        ventanaAdmin = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jButton7 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        ventanaCria = new javax.swing.JInternalFrame();
        jPanel5 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        ventanaUj = new javax.swing.JInternalFrame();
        jPanel6 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        ventanaEstupef = new javax.swing.JInternalFrame();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jInternalFrame6 = new javax.swing.JInternalFrame();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton24 = new javax.swing.JButton();
        jInternalFrame7 = new javax.swing.JInternalFrame();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton25 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPasswordField3 = new javax.swing.JPasswordField();
        jPasswordField4 = new javax.swing.JPasswordField();
        jPasswordField5 = new javax.swing.JPasswordField();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JSeparator();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JM1 - Juzgado de Menores N° 1 - Secretaría Penal");
        setIconImages(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jButton1.setText("Alta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jButton2.setText("Consulta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jButton4.setText("Consulta");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jButton5.setText("Ingresar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jButton6.setText("Mostrar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Expedientes / Actuaciones");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Audiencias");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Información");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("de la Familia");

        jButton26.setText("Modificar");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(153, 153, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("►     Desplegar Tool-bar secretarías");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ubicarBarra(evt);
            }
        });

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Abrir archivo ...");

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos32px/icono-word.png"))); // NOI18N
        jButton27.setText("DOC");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos32px/icono-excel.png"))); // NOI18N
        jButton28.setText("XLS");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos32px/txt-icono.png"))); // NOI18N
        jButton29.setText("TXT");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos32px/icono-internet.png"))); // NOI18N
        jButton30.setText("HTM");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jToggleButton1.setText("Expedientes archivados");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos32px/icono-pdf.png"))); // NOI18N
        jButton31.setText("PDF");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jButton26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jButton31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton29, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jButton27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton28, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(38, 38, 38)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(30, 30, 30)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton26)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton27)
                    .addComponent(jButton28))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton30)
                    .addComponent(jButton29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton31)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        barraMenu.setBackground(new java.awt.Color(204, 204, 255));
        barraMenu.setTitle("Otras Secretarías");
        barraMenu.setFocusable(false);
        barraMenu.setFrameIcon(null);
        barraMenu.setNormalBounds(new java.awt.Rectangle(0, 0, 2000, 50));

        jMenu8.setText("  Asistencial  ");

        jMenuItem17.setText("Ingresar audiencia");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu8.add(jMenuItem17);

        jMenuItem18.setText("Consultar audiencias");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu8.add(jMenuItem18);

        jMenu10.setText("Expedientes archivados");

        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/word16px.png"))); // NOI18N
        jMenuItem20.setText("Abrir en Word");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu10.add(jMenuItem20);

        jMenuItem22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/excel16px.png"))); // NOI18N
        jMenuItem22.setText("Abrir en Excel");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu10.add(jMenuItem22);

        jMenuItem23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/adobe16px.png"))); // NOI18N
        jMenuItem23.setText("Abrir en PDF");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu10.add(jMenuItem23);

        jMenuItem24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/htm16px.png"))); // NOI18N
        jMenuItem24.setText("Abrir en Web");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu10.add(jMenuItem24);

        jMenu8.add(jMenu10);

        jMenuBar1.add(jMenu8);

        jMenu9.setText("  Civil  ");

        jMenuItem19.setText("Acceder");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu9.add(jMenuItem19);

        jMenu11.setText("Expedientes archivados");

        jMenuItem21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/word16px.png"))); // NOI18N
        jMenuItem21.setText("Abrir en Word");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu11.add(jMenuItem21);

        jMenuItem25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/excel16px.png"))); // NOI18N
        jMenuItem25.setText("Abrir en Excel");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu11.add(jMenuItem25);

        jMenuItem26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/adobe16px.png"))); // NOI18N
        jMenuItem26.setText("Abrir en PDF");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu11.add(jMenuItem26);

        jMenuItem27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/htm16px.png"))); // NOI18N
        jMenuItem27.setText("Abrir en Web");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu11.add(jMenuItem27);

        jMenu9.add(jMenu11);

        jMenuBar1.add(jMenu9);

        barraMenu.setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout barraMenuLayout = new javax.swing.GroupLayout(barraMenu.getContentPane());
        barraMenu.getContentPane().setLayout(barraMenuLayout);
        barraMenuLayout.setHorizontalGroup(
            barraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1984, Short.MAX_VALUE)
        );
        barraMenuLayout.setVerticalGroup(
            barraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        barraMenu.setBounds(0, 0, 2000, 50);
        jDesktopPane1.add(barraMenu, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ventanaAdmin.setClosable(true);
        ventanaAdmin.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        ventanaAdmin.setResizable(true);
        ventanaAdmin.setTitle("Administración de usuarios");
        ventanaAdmin.setFrameIcon(null);
        ventanaAdmin.setMinimumSize(new java.awt.Dimension(608, 393));
        ventanaAdmin.setNormalBounds(new java.awt.Rectangle(20, 50, 608, 393));
        ventanaAdmin.setPreferredSize(new java.awt.Dimension(608, 393));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo usuario"));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Nombre de usuario");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Contraseña");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Confirmar contraseña");

        jPasswordField1.setForeground(new java.awt.Color(153, 153, 153));
        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField1.setText("oooooo");
        jPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                borrarCampoContraseña(evt);
            }
        });

        jPasswordField2.setForeground(new java.awt.Color(153, 153, 153));
        jPasswordField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField2.setText("111111");
        jPasswordField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                borrarCampoContraseña(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Permisos"));

        jCheckBox1.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox1.setText("Módulo Expedientes");

        jCheckBox2.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox2.setText("Módulo Audiencias");

        jCheckBox3.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox3.setText("Módulo de Información");

        jCheckBox4.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox4.setText("Sec. Asistencial");

        jCheckBox5.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox5.setText("Sec. Civil");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/document_16.png"))); // NOI18N
        jButton7.setText("Nuevo");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(jPasswordField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel9.setText("Usuario");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                habilitarBoton(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/search_16.png"))); // NOI18N
        jButton8.setText("Buscar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/monitor_16.png"))); // NOI18N
        jButton9.setText("Mostrar Todos");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre de usuario", "Contraseña", "Permiso de Expte.", "Audiencia", "Información", "Asistencial", "Civil"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tomarFila(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setMinWidth(120);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(120);
        jTable1.getColumnModel().getColumn(1).setMinWidth(80);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(70);
        jTable1.getColumnModel().getColumn(2).setMinWidth(110);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(110);
        jTable1.getColumnModel().getColumn(3).setMinWidth(70);
        jTable1.getColumnModel().getColumn(3).setMaxWidth(70);
        jTable1.getColumnModel().getColumn(4).setMinWidth(70);
        jTable1.getColumnModel().getColumn(4).setMaxWidth(70);
        jTable1.getColumnModel().getColumn(5).setMinWidth(70);
        jTable1.getColumnModel().getColumn(5).setMaxWidth(70);
        jTable1.getColumnModel().getColumn(6).setMinWidth(50);
        jTable1.getColumnModel().getColumn(6).setMaxWidth(50);

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/pencil_16.png"))); // NOI18N
        jButton18.setText("Editar");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/delete_16.png"))); // NOI18N
        jButton19.setText("Borrar");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel9)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton8)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                    .addComponent(jButton9))
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jButton18)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton19))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19)
                    .addComponent(jButton18)))
        );

        javax.swing.GroupLayout ventanaAdminLayout = new javax.swing.GroupLayout(ventanaAdmin.getContentPane());
        ventanaAdmin.getContentPane().setLayout(ventanaAdminLayout);
        ventanaAdminLayout.setHorizontalGroup(
            ventanaAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaAdminLayout.createSequentialGroup()
                .addGroup(ventanaAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ventanaAdminLayout.setVerticalGroup(
            ventanaAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaAdminLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        ventanaAdmin.setBounds(10, 10, 608, 393);
        jDesktopPane1.add(ventanaAdmin, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ventanaCria.setClosable(true);
        ventanaCria.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        ventanaCria.setTitle("Administración de Comisarías");
        ventanaCria.setFrameIcon(null);
        ventanaCria.setNormalBounds(new java.awt.Rectangle(0, 0, 470, 350));
        ventanaCria.setPreferredSize(new java.awt.Dimension(470, 350));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTextField3.setFont(new java.awt.Font("Tahoma", 2, 11));
        jTextField3.setForeground(new java.awt.Color(102, 102, 102));
        jTextField3.setText("Comisaría");
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                habilitarBoton(evt);
                setearCampos(evt);
            }
        });

        jTextField7.setFont(new java.awt.Font("Tahoma", 2, 11));
        jTextField7.setForeground(new java.awt.Color(102, 102, 102));
        jTextField7.setText("Telefono");
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                setearCampos(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/document_16.png"))); // NOI18N
        jButton10.setText("Nueva");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/monitor_16.png"))); // NOI18N
        jButton11.setText("Mostrar Todas");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/delete_16.png"))); // NOI18N
        jButton12.setText("Borrar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/pencil_16.png"))); // NOI18N
        jButton13.setText("Editar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "id", "Comisaría", "Telefonos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tomarFila(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getColumn(0).setMinWidth(30);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(30);
        jTable2.getColumnModel().getColumn(2).setMinWidth(100);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(2).setMaxWidth(100);

        javax.swing.GroupLayout ventanaCriaLayout = new javax.swing.GroupLayout(ventanaCria.getContentPane());
        ventanaCria.getContentPane().setLayout(ventanaCriaLayout);
        ventanaCriaLayout.setHorizontalGroup(
            ventanaCriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaCriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ventanaCriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaCriaLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaCriaLayout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12)))
                .addContainerGap())
        );
        ventanaCriaLayout.setVerticalGroup(
            ventanaCriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaCriaLayout.createSequentialGroup()
                .addGroup(ventanaCriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaCriaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ventanaCriaLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ventanaCriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jButton13))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        ventanaCria.setBounds(0, 0, 470, 350);
        jDesktopPane1.add(ventanaCria, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ventanaUj.setClosable(true);
        ventanaUj.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        ventanaUj.setTitle("Administración de Unidades Judiciales");
        ventanaUj.setFrameIcon(null);
        ventanaUj.setMinimumSize(new java.awt.Dimension(92, 90));
        ventanaUj.setNormalBounds(new java.awt.Rectangle(0, 351, 470, 350));
        ventanaUj.setPreferredSize(new java.awt.Dimension(470, 350));
        ventanaUj.setRequestFocusEnabled(false);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTextField4.setFont(new java.awt.Font("Tahoma", 2, 11));
        jTextField4.setForeground(new java.awt.Color(102, 102, 102));
        jTextField4.setText("Unidad Judicial");
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                habilitarBoton(evt);
                setearCampos(evt);
            }
        });

        jTextField8.setFont(new java.awt.Font("Tahoma", 2, 11));
        jTextField8.setForeground(new java.awt.Color(102, 102, 102));
        jTextField8.setText("Telefono");
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                setearCampos(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/document_16.png"))); // NOI18N
        jButton14.setText("Nueva");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/monitor_16.png"))); // NOI18N
        jButton15.setText("Mostrar Todas");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "id", "Unidad Judicial", "Telefonos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tomarFila(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);
        jTable3.getColumnModel().getColumn(0).setMinWidth(30);
        jTable3.getColumnModel().getColumn(0).setMaxWidth(30);
        jTable3.getColumnModel().getColumn(2).setMinWidth(100);
        jTable3.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable3.getColumnModel().getColumn(2).setMaxWidth(100);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/delete_16.png"))); // NOI18N
        jButton16.setText("Borrar");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/pencil_16.png"))); // NOI18N
        jButton17.setText("Editar");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        javax.swing.GroupLayout ventanaUjLayout = new javax.swing.GroupLayout(ventanaUj.getContentPane());
        ventanaUj.getContentPane().setLayout(ventanaUjLayout);
        ventanaUjLayout.setHorizontalGroup(
            ventanaUjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaUjLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ventanaUjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaUjLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaUjLayout.createSequentialGroup()
                        .addComponent(jButton17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton16)))
                .addContainerGap())
        );
        ventanaUjLayout.setVerticalGroup(
            ventanaUjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaUjLayout.createSequentialGroup()
                .addGroup(ventanaUjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaUjLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ventanaUjLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ventanaUjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16)
                    .addComponent(jButton17))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        ventanaUj.setBounds(0, 350, 470, 350);
        jDesktopPane1.add(ventanaUj, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ventanaEstupef.setClosable(true);
        ventanaEstupef.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        ventanaEstupef.setTitle("Listado de estupefacientes");
        ventanaEstupef.setFrameIcon(null);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "", "estupefaciente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tomarFila(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);
        jTable4.getColumnModel().getColumn(0).setMinWidth(35);
        jTable4.getColumnModel().getColumn(0).setMaxWidth(35);

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/document_16.png"))); // NOI18N
        jButton20.setText("Nuevo");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/save_16.png"))); // NOI18N
        jButton21.setText("Guardar");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/pencil_16.png"))); // NOI18N
        jButton22.setText("Modificar");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/delete_16.png"))); // NOI18N
        jButton23.setText("Quitar");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                habilitarBoton(evt);
            }
        });

        javax.swing.GroupLayout ventanaEstupefLayout = new javax.swing.GroupLayout(ventanaEstupef.getContentPane());
        ventanaEstupef.getContentPane().setLayout(ventanaEstupefLayout);
        ventanaEstupefLayout.setHorizontalGroup(
            ventanaEstupefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaEstupefLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton23)
                .addContainerGap())
        );
        ventanaEstupefLayout.setVerticalGroup(
            ventanaEstupefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaEstupefLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addGroup(ventanaEstupefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton23)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20)
                    .addComponent(jButton21)
                    .addComponent(jButton22))
                .addContainerGap())
        );

        ventanaEstupef.setBounds(10, 480, 540, 180);
        jDesktopPane1.add(ventanaEstupef, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jInternalFrame6.setClosable(true);
        jInternalFrame6.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jInternalFrame6.setTitle("Modificar nombre de usuario");
        jInternalFrame6.setFrameIcon(null);

        jLabel10.setText("Nombre de usuario en uso:");

        jLabel11.setText("Nuevo nombre:");

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/save_16.png"))); // NOI18N
        jButton24.setText("Guardar");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrame6Layout = new javax.swing.GroupLayout(jInternalFrame6.getContentPane());
        jInternalFrame6.getContentPane().setLayout(jInternalFrame6Layout);
        jInternalFrame6Layout.setHorizontalGroup(
            jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame6Layout.setVerticalGroup(
            jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jInternalFrame6.setBounds(10, 110, 310, 150);
        jDesktopPane1.add(jInternalFrame6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jInternalFrame7.setClosable(true);
        jInternalFrame7.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jInternalFrame7.setTitle("Modificar contraseña");
        jInternalFrame7.setFrameIcon(null);

        jLabel12.setText("Contraseña en uso:");

        jLabel13.setText("Nuevo contraseña:");

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/save_16.png"))); // NOI18N
        jButton25.setText("Guardar");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });

        jLabel14.setText("Confirme contraseña:");

        jPasswordField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField3.setText("oooooo");

        jPasswordField4.setForeground(new java.awt.Color(204, 204, 204));
        jPasswordField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField4.setText("oooooo");
        jPasswordField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                borrarCampoContraseña(evt);
            }
        });

        jPasswordField5.setForeground(new java.awt.Color(204, 204, 204));
        jPasswordField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField5.setText("oooooo");
        jPasswordField5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                borrarCampoContraseña(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton25)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14))
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordField5)
                            .addComponent(jPasswordField4)
                            .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(85, 85, 85))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jPasswordField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jPasswordField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton25)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrame7Layout = new javax.swing.GroupLayout(jInternalFrame7.getContentPane());
        jInternalFrame7.getContentPane().setLayout(jInternalFrame7Layout);
        jInternalFrame7Layout.setHorizontalGroup(
            jInternalFrame7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame7Layout.setVerticalGroup(
            jInternalFrame7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jInternalFrame7.setBounds(10, 270, 310, 160);
        jDesktopPane1.add(jInternalFrame7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenu6.setText("   Módulos   ");
        jMenu6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                seleccionarOpcionMenu(evt);
            }
        });

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/folder_16.png"))); // NOI18N
        jMenu3.setText("Expedientes");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem7.setText("Abrir módulo Expedientes");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem8.setText("Cerrar módulo Expedientes");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenu6.add(jMenu3);
        jMenu6.add(jSeparator3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/calendar_16.png"))); // NOI18N
        jMenu4.setText("Audiencias");

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem9.setText("Abrir módulo Audiencias");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem10.setText("Cerrar módulo Audiencias");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenu6.add(jMenu4);
        jMenu6.add(jSeparator4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/statistics_16.png"))); // NOI18N
        jMenu5.setText("Información de flia.");

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem11.setText("Abrir módulo Información");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem12.setText("Cerrar módulo Información");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu5.add(jMenuItem12);

        jMenu6.add(jMenu5);

        jMenuBar2.add(jMenu6);

        jMenu1.setText("   Administrador   ");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/usuario.jpg"))); // NOI18N
        jMenuItem1.setText("Administrar Usuarios");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/address_16.png"))); // NOI18N
        jMenuItem2.setText("Administrar Comisarías");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/shield_16.png"))); // NOI18N
        jMenuItem3.setText("Administrar Unidades Judiciales");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Notepad.JPG"))); // NOI18N
        jMenuItem4.setText("Listado de estupefacientes");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu1.add(jMenuItem4);
        jMenu1.add(jSeparator5);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/user_16.png"))); // NOI18N
        jMenuItem13.setText("Iniciar sesión de Administrador");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu1.add(jMenuItem13);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/tick_16.png"))); // NOI18N
        jMenuItem14.setText("Cerrar sesión de Administrador");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu1.add(jMenuItem14);

        jMenuBar2.add(jMenu1);

        jMenu7.setText("   Usuarios   ");

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/label_16.png"))); // NOI18N
        jMenuItem15.setText("Modificar nombre de usuario");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu7.add(jMenuItem15);

        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/key_16.png"))); // NOI18N
        jMenuItem16.setText("Modificar contraseña");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu7.add(jMenuItem16);

        jMenuItem28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/address_16.png"))); // NOI18N
        jMenuItem28.setText("Agenda");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu7.add(jMenuItem28);

        jMenuBar2.add(jMenu7);

        jMenu2.setText("   Ayuda   ");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/help_16.png"))); // NOI18N
        jMenuItem5.setText("Instrucciones de uso");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconos16px/info_16.png"))); // NOI18N
        jMenuItem6.setText("Acerca de JM1");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escucharFuente(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-870)/2, (screenSize.height-694)/2, 870, 694);
    }// </editor-fold>//GEN-END:initComponents
/**/
private void borrarCampoContraseña(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_borrarCampoContraseña
    if (evt.getSource().equals(jPasswordField1)) {
        if (bandera == true) {
            jPasswordField1.setText("");
            jPasswordField1.setForeground(Color.BLACK);
            bandera = false;
        }
    } else if (evt.getSource().equals(jPasswordField2)) {
        if (bandera2 == true) {
            jPasswordField2.setText("");
            jPasswordField2.setForeground(Color.BLACK);
            bandera2 = false;
        }
    } else if (evt.getSource().equals(jPasswordField4)) {
        if (bandera4 == true ) {
            jPasswordField4.setText("");
            jPasswordField4.setForeground(Color.BLACK);
            bandera4 = false;
        }
    } else if (evt.getSource().equals(jPasswordField5)) {
        if (bandera5 == true ) {
            jPasswordField5.setText("");
            jPasswordField5.setForeground(Color.BLACK);
            bandera5 = false;
        }
    }
}//GEN-LAST:event_borrarCampoContraseña

private void escucharFuente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escucharFuente
    UsuarioFacade usuarioFacade = new UsuarioFacade();
    ComisariaFacade comisariaFacade = new ComisariaFacade();
    UnidadJudicialFacade unidadJudicialFacade = new UnidadJudicialFacade();
    EstupefacienteFacade estupefacienteFacade = new EstupefacienteFacade();
    if (evt.getSource().equals(jButton1)) {
        GestionExpediente ae = new GestionExpediente();
        ae.setVisible(true);
        ae.setLocationRelativeTo(this);
    } else if (evt.getSource().equals(jButton2)) {
        ConsultaExpte consul = new ConsultaExpte();
        consul.setVisible(true);
        consul.setLocationRelativeTo(this);
    } else if (evt.getSource().equals(jButton3)) {
        NuevaAudiencia na = new NuevaAudiencia(1);
        na.setVisible(true);
        na.setLocationRelativeTo(this);
    } else if (evt.getSource().equals(jButton4)) {
        ConsultaAudiencia ca = new ConsultaAudiencia(1);
        ca.setVisible(true);
        ca.setLocationRelativeTo(this);
    } else if (evt.getSource().equals(jButton5)) { //Botón de ingresar datos de grupo conviviente
        EntornoMenor em = new EntornoMenor();
        em.tipoVentana = "alta";
        em.setVisible(true);
        em.setLocationRelativeTo(this);
    } else if (evt.getSource().equals(jButton6)) {
        ConsultaInfoFlia consulFlia = new ConsultaInfoFlia();
        consulFlia.setVisible(true);
        consulFlia.setLocationRelativeTo(this);
    } else if (evt.getSource().equals(jButton7)) {
        if (!jTextField1.getText().equals("")) {
            if (usuarioFacade.buscarPorNombreUsuario(jTextField1.getText()) == null) {
                String pass1 = String.valueOf(jPasswordField1.getPassword());
                String pass2 = String.valueOf(jPasswordField2.getPassword());
                if (!pass1.equals("oooooo") && !pass1.equals("oooooo")) {
                    boolean f = false;
                    String check1 = "", check2 = "", check3 = "", check4 = "", check5 = "";
                    if (jCheckBox1.isSelected()) {
                        check1 = "Si";
                    } else {
                        check1 = "No";
                    }
                    if (jCheckBox2.isSelected()) {
                        check2 = "Si";
                    } else {
                        check2 = "No";
                    }
                    if (jCheckBox3.isSelected()) {
                        check3 = "Si";
                    } else {
                        check3 = "No";
                    }
                    if (jCheckBox4.isSelected()) {
                        check4 = "Si";
                    } else {
                        check4 = "No";
                    }
                    if (jCheckBox5.isSelected()) {
                        check5 = "Si";
                    } else {
                        check5 = "No";
                    }
                    if (pass1.equals(pass2)) { //compara strings y valida la entrada
                        f = true;
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    if (f) {
                        Usuario usuario = new Usuario();
                        usuario.setNombre(jTextField1.getText());
                        usuario.setContraseña(pass1);
                        usuario.setPermiso1(check1);
                        usuario.setPermiso2(check2);
                        usuario.setPermiso3(check3);
                        usuario.setPermiso4(check4);
                        usuario.setPermiso5(check5);
                        usuarioFacade.altaUsuario(usuario);
                        if (usuario.getId() != null) {
                            borrarCamposUsuario();
                            jTable1.repaint();
                            JOptionPane.showMessageDialog(this, "Se ha ingresado el nuevo usuario correctamente", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "No se ha ingresado el nuevo usuario. Intente de nuevo", "Resultado", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Debe ingresar una contraseña y confirmarla", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Ya existe un usuario con ese nombre de usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Debe completar Campo 'Usuario'.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else if (evt.getSource().equals(jButton8)) {
        jTable1.repaint();
        Long id = usuarioFacade.buscarPorNombreUsuario(jTextField2.getText());
        Usuario usuario = new Usuario();
        usuario = usuarioFacade.buscar(id);
        if (usuario.getId()!= null) {
            List<Usuario> listaUsuario = new ArrayList();
            listaUsuario.add(usuario);
            Constructor.cargarTabla(jTable1,7,titulosAdmin,"Usuarios",listaUsuario);
            jTextField2.setText("");
            jButton8.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se encontró el usuario especificado", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    } else if (evt.getSource().equals(jButton9)) {
        jTable1.repaint();
        if (!usuarioFacade.getTodos().isEmpty()) { 
            //en la siguiente linea construyo la tabla,indico cant.columnas,seteo titulos de columna,indico el Objeto y paso la lista
            Constructor.cargarTabla(jTable1,7,titulosAdmin,"Usuarios",usuarioFacade.getTodos());
        } else {
            JOptionPane.showMessageDialog(rootPane, "No hay usuarios cargados", "Resultado", JOptionPane.ERROR_MESSAGE);
        }
    } else if (evt.getSource().equals(jButton10)) { //ventana de administración de comisarías
        Comisaria comisaria = new Comisaria();
        comisaria.setDescripcion(jTextField3.getText());
        comisaria.setNumeroTelefono(jTextField7.getText());
        comisariaFacade.altaComisaria(comisaria);
        if (comisaria.getId() != null) { //si se efectua la correcta insercion de la comisaria
            jTextField3.setText("");
            jTextField7.setText("");
            Constructor.cargarTabla(jTable2, 2, titulosComisaria, "Comisaría", comisariaFacade.getTodos());
            jButton10.setEnabled(false);
            jTable2.clearSelection();
            jTextField3.grabFocus();
            JOptionPane.showMessageDialog(rootPane, "Se ingresó correctamente la Comisaría.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else { //si no se efectua la correcta aserción de la comisaría
            JOptionPane.showMessageDialog(rootPane, "No se ingresó la Comisaría. Reintentar la operación", "Resultado", JOptionPane.ERROR_MESSAGE);
        }
    } else if (evt.getSource().equals(jButton11)) {
        jTable2.repaint();
        if (!comisariaFacade.getTodos().isEmpty()) {
            Constructor.cargarTabla(jTable2, 3, titulosComisaria, "Comisaría", comisariaFacade.getTodos());
        } else {
            JOptionPane.showMessageDialog(rootPane, "No hay comisarías cargadas", "Resultado", JOptionPane.ERROR_MESSAGE);
        }
    } else if (evt.getSource().equals(jButton12)) {
        if (JOptionPane.showConfirmDialog(this, "¿Desea eliminar esta comisaría de la Base de Datos?", "Confirmar", JOptionPane.YES_NO_OPTION) == 0) {
            if (comisariaFacade.eliminarComisaria((Long) jTable2.getValueAt(fila, 0))) {
                if (!comisariaFacade.getTodos().isEmpty()) {
                    jTable2.repaint();
                    Constructor.cargarTabla(jTable2, 3, titulosComisaria, "Comisaría", comisariaFacade.getTodos());
                    setearCampos(1);
                    jTable2.clearSelection();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No hay comisarías cargadas", "Resultado", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se eliminó el registro seleccionado. Reintentar la operación", "Resultado", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else if (evt.getSource().equals(jButton13)) {
        Comisaria comisaria = new Comisaria();
        comisaria = comisariaFacade.buscar((Long)jTable2.getValueAt(fila, 0));
        comisaria.setDescripcion(jTextField3.getText());
        comisaria.setNumeroTelefono(jTextField7.getText());
        if (comisariaFacade.modificarComisaria(comisaria)) {
            Constructor.cargarTabla(jTable2, 3, titulosComisaria, "Comisaría", comisariaFacade.getTodos());
            setearCampos(1);
            jTable2.clearSelection();
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se modificó la Comisaría. Reintentar la operación", "Resultado", JOptionPane.ERROR_MESSAGE);
        }
    } else if (evt.getSource().equals(jButton14)) { //ventana de administración de unidades judiciales
        UnidadJudicial unidadJudicial = new UnidadJudicial();
        unidadJudicial.setDescripcion(jTextField4.getText());
        unidadJudicial.setNumeroTelefono(jTextField8.getText());
        unidadJudicialFacade.altaUnidadJudicial(unidadJudicial);
        if (unidadJudicial.getId() != null) { //si se efectua la correcta insercion de la uj
            jTextField4.setText("");
            jTextField8.setText("");
            Constructor.cargarTabla(jTable3, 3, titulosUnidadJudicial, "Unidad Judicial", unidadJudicialFacade.getTodos());
            jButton14.setEnabled(false);
            jTable3.clearSelection();
            jTextField4.grabFocus();
            JOptionPane.showMessageDialog(rootPane, "Se ingresó correctamente la Unidad Judicial.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else { //si no se efectua la correcta asercion de la uj
            JOptionPane.showMessageDialog(rootPane, "No se ingresó la Unidad Judicial. Reintentar la operación", "Resultado", JOptionPane.ERROR_MESSAGE);
        }
    } else if (evt.getSource().equals(jButton15)) {
        jTable3.repaint();
        if (!unidadJudicialFacade.getTodos().isEmpty()) {
            Constructor.cargarTabla(jTable3, 3, titulosUnidadJudicial, "Unidad Judicial", unidadJudicialFacade.getTodos());
        } else {
            JOptionPane.showMessageDialog(rootPane, "No hay unidades judiciales cargadas", "Resultado", JOptionPane.ERROR_MESSAGE);
        }
    } else if (evt.getSource().equals(jButton16)) {
        if (JOptionPane.showConfirmDialog(this, "¿Desea eliminar esta unidad judicial de la Base de Datos?", "Confirmar", JOptionPane.YES_NO_OPTION) == 0) {
            if (unidadJudicialFacade.eliminarUnidadJudicial((Long) jTable3.getValueAt(fila, 0))) {
                jTable3.repaint();
                Constructor.cargarTabla(jTable3, 3, titulosUnidadJudicial, "Unidad Judicial", unidadJudicialFacade.getTodos());
                setearCampos(2);
                jTable3.clearSelection();
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se eliminó el registro seleccionado. Reintentar la operación", "Resultado", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else if (evt.getSource().equals(jButton17)) {
        UnidadJudicial unidadJudicial = new UnidadJudicial();
        unidadJudicial = unidadJudicialFacade.buscar((Long)jTable3.getValueAt(fila, 0));
        unidadJudicial.setDescripcion(jTextField4.getText());
        unidadJudicial.setNumeroTelefono(jTextField8.getText());
        if (unidadJudicialFacade.modificarUnidadJudicial(unidadJudicial)) {
            Constructor.cargarTabla(jTable3, 3, titulosUnidadJudicial, "Unidad Judicial", unidadJudicialFacade.getTodos());
            setearCampos(2);
            jTable3.clearSelection();
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se modificó la Unidad Judicial. Reintentar la operación", "Resultado", JOptionPane.ERROR_MESSAGE);
        }
    } else if (evt.getSource().equals(jButton18)) {
        String check1, check2, check3,check4,check5, pass1, pass2;
        if (jCheckBox1.isSelected()) {
            check1 = "Si";
        } else {
            check1 = "No";
        }
        if (jCheckBox2.isSelected()) {
            check2 = "Si";
        } else {
            check2 = "No";
        }
        if (jCheckBox3.isSelected()) {
            check3 = "Si";
        } else {
            check3 = "No";
        }
        if (jCheckBox4.isSelected()) {
            check4 = "Si";
        } else {
            check4 = "No";
        }
        if (jCheckBox5.isSelected()) {
            check5 = "Si";
        } else {
            check5 = "No";
        }
        pass1 = String.valueOf(jPasswordField1.getPassword());
        pass2 = String.valueOf(jPasswordField2.getPassword());
        if (pass1.equals(pass2)) {
            Usuario usuario = new Usuario();
            usuario = usuarioFacade.buscar((Long) jTable1.getValueAt(fila, 0));
            usuario.setNombre(jTextField1.getText());
            usuario.setContraseña(pass1);
            usuario.setPermiso1(check1);
            usuario.setPermiso2(check2);
            usuario.setPermiso2(check3);
            usuario.setPermiso2(check4);
            usuario.setPermiso2(check5);
            if (usuarioFacade.modificarUsuario(usuario)) {
                borrarCamposUsuario();
                Constructor.cargarTabla(jTable1, 6, titulosAdmin, "Usuario", usuarioFacade.getTodos());
            } else {
                JOptionPane.showMessageDialog(rootPane, "La operación no se efectuó.", "Error ", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No coinciden las contraseñas ingresadas", "Resultado", JOptionPane.ERROR_MESSAGE);
        }
    } else if (evt.getSource().equals(jButton19)) {
        if (JOptionPane.showConfirmDialog(this, "¿Desea eliminar el usuario de la Base de Datos?", "Confirmar", JOptionPane.YES_NO_OPTION) == 0) {
            Long id = usuarioFacade.buscarPorNombreUsuario(jTextField1.getText());
            if (usuarioFacade.eliminarUsuario(id)) {
                for (int columna = 0; columna <= 6; columna++) {
                    jTable1.setValueAt("", fila, columna);
                }
                borrarCamposUsuario();
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se eliminó el registro seleccionado. Reintentar la operación", "Resultado", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else if (evt.getSource().equals(jButton20)) { //habilita campo de texto para ingresar un nuevo est
        jTextField5.setVisible(true);
        jTextField5.grabFocus();
        jButton20.setVisible(false);
    } else if (evt.getSource().equals(jButton21)) {
        Estupefaciente estupefaciente = new Estupefaciente();
        estupefaciente.setDescripcion(jTextField5.getText());
        estupefacienteFacade.altaEstupefaciente(estupefaciente);
        if (estupefaciente.getId() != null) {
            Constructor.cargarTabla(jTable4, 2, titulosEstupefacientes, "Estupefaciente", (List)estupefacienteFacade.getTodos());
            gestionarInterfaz();
//            jTable4.removeAll();
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se efectuó el ingreso del nuevo dato", "Resultado", JOptionPane.ERROR_MESSAGE);
        }
    } else if (evt.getSource().equals(jButton22)) {
        Estupefaciente estupefaciente = new  Estupefaciente();
        Long id = estupefacienteFacade.buscarPorNombreEstupefaciente(estu);
        estupefaciente = estupefacienteFacade.buscar(id);
        estupefaciente.setDescripcion(jTextField5.getText());
        if (estupefacienteFacade.modificarEstupefaciente(estupefaciente)) {
            Constructor.cargarTabla(jTable4, 2, titulosEstupefacientes, "Estupefaciente", (List)estupefacienteFacade.getTodos());
            gestionarInterfaz();
//            jTable4.removeAll();
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se modificó el dato seleccionado. Reintentar la operación", "Resultado", JOptionPane.ERROR_MESSAGE);
        }
    } else if (evt.getSource().equals(jButton23)) {
        Long id = estupefacienteFacade.buscarPorNombreEstupefaciente(estu);
        if (estupefacienteFacade.eliminarEstupefaciente(id)) {
            Constructor.cargarTabla(jTable4, 2, titulosEstupefacientes, "Estupefaciente", (List)estupefacienteFacade.getTodos());
            gestionarInterfaz();
//            jTable4.removeAll();
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se eliminó el dato seleccionado. Reintentar la operación", "Resultado", JOptionPane.ERROR_MESSAGE);
        }
    } else if (evt.getSource().equals(jButton24)) {
        if(!jLabel10.getText().substring(26).equals("")){
            if(!jTextField6.getText().equals("")){
                Usuario usuario = new Usuario();
                Long id = usuarioFacade.buscarPorNombreUsuario(jLabel10.getText().substring(26));
                usuario = usuarioFacade.buscar(id);
                usuario.setNombre(jTextField6.getText());
                if(usuarioFacade.modificarUsuario(usuario)){
                    jTextField6.setText("");
                    controlUsuario();
                    JOptionPane.showMessageDialog(rootPane, "La operación se realizó con éxito.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No se pudo realizar la operación. Verifique el correcto ingreso de parámetros.", "Resultado", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Debe ingresar un nombre de usuario.", "Campo Vacío", JOptionPane.ERROR_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(rootPane, "No se hace referencia a ningún nombre de usuario.", "Campo Vacío", JOptionPane.ERROR_MESSAGE);
        }
    } else if (evt.getSource().equals(jButton25)) {
        if(jPasswordField3.getPassword().toString().equals("") || !jPasswordField3.getPassword().toString().equals("oooooo")){
            if(!String.valueOf(jPasswordField4.getPassword()).equals("") && !String.valueOf(jPasswordField5.getPassword()).equals("")){
                if(String.valueOf(jPasswordField4.getPassword()).equals(String.valueOf(jPasswordField5.getPassword()))){
                    Usuario usuario = new Usuario();
/****************CORREGIR ESTE METODO, NO BUSCAR POR CONTRASEÑA, PORQUE PUEDE HABER DOS CON IGUALES CONTRASEÑAS***********************/                    
                    Long id = usuarioFacade.buscarPorPassword(String.valueOf(jPasswordField3.getPassword()));
                    usuario = usuarioFacade.buscar(id);
                    usuario.setContraseña(String.valueOf(jPasswordField4.getPassword()));
                    if (usuarioFacade.modificarUsuario(usuario)) {
                        jPasswordField4.setText("oooooo");
                        jPasswordField5.setText("oooooo");
                        controlUsuario();
                        JOptionPane.showMessageDialog(rootPane, "La operación se realizó con éxito.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Las contraseñas no coinciden. Verifique Nueva contraseña.", "Parámetro inválido", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Debe ingresar una nueva contraseña y su confirmación.", "Campo Vacío", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Asegúrese que la contraseña en uso es una contraseña válida.", "Parámetro inválido", JOptionPane.ERROR_MESSAGE);
        }
    } else if (evt.getSource().equals(jButton26)) {
        EntornoMenor entornoMenor = new EntornoMenor();
        entornoMenor.tipoVentana = "modificación";
        entornoMenor.setVisible(true);
    } else if (evt.getSource().equals(jButton27)) {
        CargadorArchivo arc = new CargadorArchivo("penal");
        arc.abrirArchivoWord();
    } else if (evt.getSource().equals(jButton28)) {
        CargadorArchivo arc = new CargadorArchivo("penal");
        arc.abrirArchivoExcel();
    } else if (evt.getSource().equals(jButton29)) {
        CargadorArchivo arc = new CargadorArchivo("penal");
        arc.abrirArchivoTxt();
    } else if (evt.getSource().equals(jButton30)) {
        CargadorArchivo arc = new CargadorArchivo("penal");
        arc.abrirArchivoHtm();
    } else if (evt.getSource().equals(jButton31)) {
        CargadorArchivo arc = new CargadorArchivo("penal");
        arc.abrirArchivoPdf();
    } else if (evt.getSource().equals(jToggleButton1)) {
        if(jToggleButton1.isSelected()) {
            jLabel16.setVisible(true);
            jButton27.setVisible(true);
            jButton28.setVisible(true);
            jButton29.setVisible(true);
            jButton30.setVisible(true);
            jButton31.setVisible(true);
            this.repaint();
        } else {
            jLabel16.setVisible(false);
            jButton27.setVisible(false);
            jButton28.setVisible(false);
            jButton29.setVisible(false);
            jButton30.setVisible(false);
            jButton31.setVisible(false);
            this.repaint();
        }
    } else if (evt.getSource().equals(jMenuItem1)) { //mostrar ventana interna de administración de usuarios
        this.ventanaAdmin.setVisible(true);
        this.borrarCamposUsuario();
        jTable1.repaint();
    } else if (evt.getSource().equals(jMenuItem2)) { //mostrar ventana interna de Comisarías
        this.ventanaCria.setVisible(true);
        this.jButton12.setVisible(false);
        this.jButton13.setVisible(false);
        jTable2.repaint();
    } else if (evt.getSource().equals(jMenuItem3)) { //mostrar ventana interna de Unidades judiciales
        this.ventanaUj.setVisible(true);
        this.jButton16.setVisible(false);
        this.jButton17.setVisible(false);
        jTable3.repaint();
    } else if (evt.getSource().equals(jMenuItem4)) { //mostrar Lista de estupefacientes
        Constructor.cargarTabla(jTable4, 2, titulosEstupefacientes, "Estupefaciente", estupefacienteFacade.getTodos());
        ventanaEstupef.setVisible(true);
        this.jTextField5.setVisible(false);
        this.jButton20.setVisible(true);
        this.jButton21.setVisible(false);
        this.jButton22.setVisible(false);
        this.jButton23.setVisible(false);
    } else if (evt.getSource().equals(jMenuItem5)) {
        iniciarAyuda();
    } else if (evt.getSource().equals(jMenuItem6)) {
        InfoSoft is = new InfoSoft();
        is.setVisible(true);
        is.setLocationRelativeTo(null);
    } else if (evt.getSource().equals(jMenuItem7)) {
        createInicio(1);
        this.dispose();
    } else if (evt.getSource().equals(jMenuItem8)) {
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jMenuItem7.setEnabled(true);
        jMenuItem8.setEnabled(false);
    } else if (evt.getSource().equals(jMenuItem9)) {
        createInicio(2);
        this.dispose();
    } else if (evt.getSource().equals(jMenuItem10)) {
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jMenuItem9.setEnabled(true);
        jMenuItem10.setEnabled(false);
    } else if (evt.getSource().equals(jMenuItem11)) {
        createInicio(3);
        this.dispose();
    } else if (evt.getSource().equals(jMenuItem12)) {
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        jMenuItem11.setEnabled(true);
        jMenuItem12.setEnabled(false);
        jButton26.setEnabled(false);
    } else if (evt.getSource().equals(jMenuItem13)) {
        createInicio(4);
        this.dispose();
        habilitarAdmin(1);
    } else if (evt.getSource().equals(jMenuItem14)) {
        inhabilitarItems();
        inhabilitarBotones();
        permisoAsist = false;
        permisoCivil = false;
        jMenuItem7.setEnabled(true);
        jMenuItem8.setEnabled(false);
        jMenuItem9.setEnabled(true);
        jMenuItem10.setEnabled(false);
        jMenuItem11.setEnabled(true);
        jMenuItem12.setEnabled(false);
        jMenuItem13.setEnabled(true);
    } else if (evt.getSource().equals(jMenuItem15)) {
        controlUsuario();
        jInternalFrame6.setVisible(true);
        jTextField6.setText("");
    } else if (evt.getSource().equals(jMenuItem16)) {
        controlUsuario();
        bandera4 = true;
        bandera5 = true;
        jInternalFrame7.setVisible(true);
        jPasswordField4.setText("oooooo");
        jPasswordField5.setText("oooooo");
        jPasswordField4.setForeground(Color.GRAY);
        jPasswordField5.setForeground(Color.GRAY);
    } else if (evt.getSource().equals(jMenuItem17)) {
        crearInicio(1);
    } else if (evt.getSource().equals(jMenuItem18)) {
        crearInicio(2);
    } else if (evt.getSource().equals(jMenuItem19)) {
        crearInicio(3);
    } else if (evt.getSource().equals(jMenuItem20)) {
        CargadorArchivo arc = new CargadorArchivo("asistencial");
        arc.abrirArchivoWord();
    } else if (evt.getSource().equals(jMenuItem21)) {
        CargadorArchivo arc = new CargadorArchivo("civil");
        arc.abrirArchivoWord();
    } else if (evt.getSource().equals(jMenuItem22)) {
        CargadorArchivo arc = new CargadorArchivo("asistencial");
        arc.abrirArchivoExcel();
    } else if (evt.getSource().equals(jMenuItem23)) {
        CargadorArchivo arc = new CargadorArchivo("asistencial");
        arc.abrirArchivoPdf();
    } else if (evt.getSource().equals(jMenuItem24)) {
        CargadorArchivo arc = new CargadorArchivo("asistencial");
        arc.abrirArchivoHtm();
    } else if (evt.getSource().equals(jMenuItem25)) {
        CargadorArchivo arc = new CargadorArchivo("civil");
        arc.abrirArchivoExcel();
    } else if (evt.getSource().equals(jMenuItem26)) {
        CargadorArchivo arc = new CargadorArchivo("civil");
        arc.abrirArchivoPdf();
    } else if (evt.getSource().equals(jMenuItem27)) {
        CargadorArchivo arc = new CargadorArchivo("civil");
        arc.abrirArchivoHtm();
    } else if (evt.getSource().equals(jMenuItem28)) {
        Agenda agenda = new Agenda();
        agenda.setVisible(true);
    }
}//GEN-LAST:event_escucharFuente

private void tomarFila(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tomarFila
    try {
        if (evt.getSource().equals(jTable1)) {
            fila = jTable1.getSelectedRow();
            if (!jTable1.getValueAt(fila, 0).equals("")) {
                jButton7.setEnabled(false);
                jButton18.setVisible(true);
                jButton19.setVisible(true);
                jTextField1.setText((String) jTable1.getValueAt(fila, 0));
                jPasswordField1.setText((String) jTable1.getValueAt(fila, 1));
                jPasswordField2.setText((String) jTable1.getValueAt(fila, 1));
                jPasswordField1.setForeground(Color.BLACK);
                jPasswordField2.setForeground(Color.BLACK);
                bandera = false;
                bandera2 = false;
                if (jTable1.getValueAt(fila, 2).equals("Si")) {
                    jCheckBox1.setSelected(true);
                } else {
                    jCheckBox1.setSelected(false);
                }
                if (jTable1.getValueAt(fila, 3).equals("Si")) {
                    jCheckBox2.setSelected(true);
                } else {
                    jCheckBox2.setSelected(false);
                }
                if (jTable1.getValueAt(fila, 4).equals("Si")) {
                    jCheckBox3.setSelected(true);
                } else {
                    jCheckBox3.setSelected(false);
                }
                if (jTable1.getValueAt(fila, 5).equals("Si")) {
                    jCheckBox4.setSelected(true);
                } else {
                    jCheckBox4.setSelected(false);
                }
                if (jTable1.getValueAt(fila, 6).equals("Si")) {
                    jCheckBox5.setSelected(true);
                } else {
                    jCheckBox5.setSelected(false);
                }
            }
        }
        if (evt.getSource().equals(jTable2)) {
            fila = jTable2.getSelectedRow();
            if (!jTable2.getValueAt(fila, 0).equals("")) {
                jButton12.setVisible(true);
                jButton13.setVisible(true);
                jTextField3.setFont(new java.awt.Font("Tahoma", 0, 11));
                jTextField3.setForeground(Color.BLACK);
                jTextField3.setText((String) jTable2.getValueAt(fila, 1));
                jTextField7.setFont(new java.awt.Font("Tahoma", 0, 11));
                jTextField7.setForeground(Color.BLACK);
                jTextField7.setText((String) jTable2.getValueAt(fila, 2));
            } else {
                setearCampos(1);
                jButton12.setVisible(false);
                jButton13.setVisible(false);
            }
        }
        if (evt.getSource().equals(jTable3)) {
            fila = jTable3.getSelectedRow();
            if (!jTable3.getValueAt(fila, 0).equals("")) {
                jButton16.setVisible(true);
                jButton17.setVisible(true);
                jTextField4.setFont(new java.awt.Font("Tahoma", 0, 11));
                jTextField4.setForeground(Color.BLACK);
                jTextField4.setText((String) jTable3.getValueAt(fila, 1));
                jTextField8.setFont(new java.awt.Font("Tahoma", 0, 11));
                jTextField8.setForeground(Color.BLACK);
                jTextField8.setText((String) jTable3.getValueAt(fila, 2));
            } else {
                setearCampos(2);
                jButton16.setVisible(false);
                jButton17.setVisible(false);
            }
        }
        if (evt.getSource().equals(jTable4)) {
            fila = jTable4.getSelectedRow();
            bandera3 = false;
            if (!jTable4.getValueAt(fila, 0).equals("")) {
                jTextField5.setVisible(true);
                jTextField5.setText((String) jTable4.getValueAt(fila, 1));
                jButton20.setVisible(false);
                jButton22.setVisible(true);
                jButton23.setVisible(true);
                estu = (String) jTable4.getValueAt(fila, 1);
            } else {
                jTextField5.setVisible(false);
                jTextField5.setText("");
                jButton20.setVisible(true);
                jButton22.setVisible(false);
                jButton23.setVisible(false);
            }
        }
    } catch (java.lang.NullPointerException e) {
        JOptionPane.showMessageDialog(rootPane, "Fila vacía. Seleccionar un registro válido", "Excepción-Puntero Nulo", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_tomarFila

private void habilitarBoton(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_habilitarBoton
    if (evt.getSource().equals(jTextField2)) {
        if (!jTextField2.getText().equals("")) {
            jButton8.setEnabled(true);
        } else {
            jButton8.setEnabled(false);
        }
    }
    if (evt.getSource().equals(jTextField3)) {
        if (!jTextField3.getText().equals("")) {
            jButton10.setEnabled(true);
        } else {
            jButton10.setEnabled(false);
        }
    }
    if (evt.getSource().equals(jTextField4)) {
        if (!jTextField4.getText().equals("")) {
            jButton14.setEnabled(true);
        } else {
            jButton14.setEnabled(false);
        }
    }
    if (evt.getSource().equals(jTextField5)) {
        if (!jTextField5.getText().equals("")) {
            if (bandera3 == true) {
                jButton21.setVisible(true);
            } else {
                jButton21.setVisible(false);
            }
        } else {
            jButton21.setVisible(false);
        }
    }
}//GEN-LAST:event_habilitarBoton

private void ubicarBarra(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ubicarBarra
    if(barraMenu.isVisible()){
        jLabel15.setText("►     Desplegar Tool-bar secretarías");
        barraMenu.setVisible(false);
    } else {
        barraMenu.setVisible(true);
        jLabel15.setText("◄        Ocultar Tool-bar secretarías");
    }
    barraMenu.setLocation(0, 0);
}//GEN-LAST:event_ubicarBarra

private void setearCampos(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_setearCampos
    if (evt.getSource().equals(jTextField3) || evt.getSource().equals(jTextField7)) {
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 11));
        jTextField3.setForeground(Color.BLACK);
        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 11));
        jTextField7.setForeground(Color.BLACK);
    } else if (evt.getSource().equals(jTextField4) || evt.getSource().equals(jTextField8)) {
        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 11));
        jTextField4.setForeground(Color.BLACK);
        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 11));
        jTextField8.setForeground(Color.BLACK);
    }
}//GEN-LAST:event_setearCampos
/**REVEER ESTE METODO PARA SELECCIONAR LOS MENUS AL POSICIONARSE SOBRE ELLOS**/
private void seleccionarOpcionMenu(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_seleccionarOpcionMenu
    if (evt.getSource().equals(jMenu6)) {
        if (jMenu6.hasFocus()) {
            jMenu6.setSelected(true);
        } else {
            jMenu6.setSelected(false);
        }
    } else if (evt.getSource().equals(jMenu1)) {
        if (jMenu1.hasFocus()) {
            jMenu1.setSelected(true);
        } else {
            jMenu1.setSelected(false);
        }
    } else if (evt.getSource().equals(jMenu2)) {
        if (jMenu2.hasFocus()) {
            jMenu2.setSelected(true);
        } else {
            jMenu2.setSelected(false);
        }
    }  else if (evt.getSource().equals(jMenu7)) {
        if (jMenu7.hasFocus()) {
            jMenu7.setSelected(true);
        } else {
            jMenu7.setSelected(false);
        }
    }
}//GEN-LAST:event_seleccionarOpcionMenu

    private void createInicio(int op) {
        Login open = new Login();
        open.setVisible(true);
        open.jButton1.setVisible(false);
        open.jButton2.setVisible(true);
        open.setDefaultCloseOperation(EXIT_ON_CLOSE);
        switch (op) {
            case 1:
                open.setTitle("Acceso a Módulo de Expedientes");
                break;
            case 2:
                open.setTitle("Acceso a Módulo de Audiencias");
                break;
            case 3:
                open.setTitle("Acceso a Módulo de Información");
                break;
            case 4:
                open.setTitle("Acceso de Administrador");
        }
    }

    private void setearCampos(int campos) {
        if (campos == 1) {
            jTextField3.setFont(new java.awt.Font("Tahoma", 2, 11));
            jTextField3.setForeground(new java.awt.Color(102, 102, 102));
            jTextField3.setText("Comisaría");
            jTextField7.setFont(new java.awt.Font("Tahoma", 2, 11));
            jTextField7.setForeground(new java.awt.Color(102, 102, 102));
            jTextField7.setText("Telefono");
        }
        if (campos == 2) {
            jTextField4.setFont(new java.awt.Font("Tahoma", 2, 11));
            jTextField4.setForeground(new java.awt.Color(102, 102, 102));
            jTextField4.setText("Unidad Judicial");
            jTextField8.setFont(new java.awt.Font("Tahoma", 2, 11));
            jTextField8.setForeground(new java.awt.Color(102, 102, 102));
            jTextField8.setText("Telefono");
        }
    }   

    private void borrarCamposUsuario() {
        jTextField1.setText("");
        jTable1.clearSelection();
        bandera = true;
        bandera2 = true;
        jPasswordField1.setForeground(Color.GRAY);
        jPasswordField2.setForeground(Color.GRAY);
        jPasswordField1.setText("oooooo");
        jPasswordField2.setText("oooooo");
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jButton7.setEnabled(true);
        jButton18.setVisible(false);
        jButton19.setVisible(false);
    }

    private void gestionarInterfaz() {
        bandera3 = true;
        jTextField5.setText("");
        jTextField5.setVisible(false);
        jButton20.setVisible(true);
        jButton21.setVisible(false);
        jButton22.setVisible(false);
        jButton23.setVisible(false);
    }
    
    private void crearInicio(int boton) {
        if (boton == 1) {
            if (permisoAsist) {
                vistas.NuevaAudiencia na = new vistas.NuevaAudiencia(2);
                na.setVisible(true);
                na.setLocationRelativeTo(this);
            } else {
                vistas.Login loginSecretAsist = new vistas.Login();
                loginSecretAsist.setVisible(true);
                loginSecretAsist.setLocationRelativeTo(this);
                loginSecretAsist.setTitle("Ingreso de usuario de sec. asistencial");
                loginSecretAsist.jButton1.setVisible(false);
                loginSecretAsist.jButton2.setVisible(false);
                loginSecretAsist.jButton3.setVisible(true);
                loginSecretAsist.jButton4.setVisible(false);
            }
        } else if (boton == 2) {
            if (permisoAsist) {
                vistas.ConsultaAudiencia ca = new vistas.ConsultaAudiencia(2);
                ca.setVisible(true);
                ca.setLocationRelativeTo(this);
            } else {
                vistas.Login loginSecretAsistencial = new vistas.Login();
                loginSecretAsistencial.setVisible(true);
                loginSecretAsistencial.setLocationRelativeTo(this);
                loginSecretAsistencial.setTitle("Ingreso de usuario de sec. asistencial");
                loginSecretAsistencial.jButton1.setVisible(false);
                loginSecretAsistencial.jButton2.setVisible(false);
                loginSecretAsistencial.jButton3.setVisible(false);
                loginSecretAsistencial.jButton4.setVisible(true);
            }
        } else if (boton == 3) {
            if (permisoCivil) {    
                vistas.VentanaSecretariaCivil secretariaCivil = new vistas.VentanaSecretariaCivil();
                secretariaCivil.setVisible(true);
                secretariaCivil.setLocationRelativeTo(this);
            } else {
                vistas.Login loginSecretariaCivil = new vistas.Login();
                loginSecretariaCivil.setVisible(true);
                loginSecretariaCivil.setLocationRelativeTo(this);
                loginSecretariaCivil.setTitle("Ingreso de usuario de sec. civil");
                loginSecretariaCivil.jButton1.setVisible(false);
                loginSecretariaCivil.jButton2.setVisible(false);
                loginSecretariaCivil.jButton3.setVisible(false);
                loginSecretariaCivil.jButton4.setVisible(false);
                loginSecretariaCivil.jButton5.setVisible(true);
            }
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu(1,1,1,1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame barraMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JInternalFrame jInternalFrame6;
    private javax.swing.JInternalFrame jInternalFrame7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JPasswordField jPasswordField4;
    private javax.swing.JPasswordField jPasswordField5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    public static javax.swing.JTable jTable1;
    public static javax.swing.JTable jTable2;
    public static javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JInternalFrame ventanaAdmin;
    private javax.swing.JInternalFrame ventanaCria;
    private javax.swing.JInternalFrame ventanaEstupef;
    private javax.swing.JInternalFrame ventanaUj;
    // End of variables declaration//GEN-END:variables

    private void inicializarComponentes(int mod1, int mod2, int mod3, int ad) {
        this.setIconImage (new ImageIcon(getClass().getResource("/iconos/iconos16px/icon_16.png")).getImage());
        SystemTrayNotif trayIcon = new SystemTrayNotif();
        trayIcon.mostrarIcono();
        jLabel15.setCursor(new Cursor(HAND_CURSOR));
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        AudienciaFacade audienciaFacade = new AudienciaFacade();
        audienciaFacade.controlarFechasAudiencias();
        inhabilitarBotones();
        inhabilitarItems();
        ocultarBotonesArchivo();
        ocultarBotonesVentanas();
        habilitarModulo1(mod1);
        habilitarModulo2(mod2);
        habilitarModulo3(mod3);
        habilitar3Modulos(mod1, mod2, mod3, ad);
        habilitarAdmin(ad);
        controlUsuario();
        this.pack();
    }
}
