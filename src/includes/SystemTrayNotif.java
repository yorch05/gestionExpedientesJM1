package includes;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.InfoSoft;

public class SystemTrayNotif {

    public static TrayIcon trayIcon = null;
    public static SystemTray tray = null;
    public static String urlImage = "src/menores/imagenes/icon_128.png";

    //public static void main(String[] args) throws Exception {
    public void mostrarIcono() {
        if (!SystemTray.isSupported()) {
            System.err.println("not supported");
            System.exit(0);
        }
        try {
            tray = SystemTray.getSystemTray();
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            final Image image = toolkit.getImage(SystemTrayNotif.urlImage);
            PopupMenu Popup = new PopupMenu();
            final MenuItem itemInfo = new MenuItem("Acerca de JM1");
            itemInfo.addActionListener(new ActionListener() {
                public void actionPerformed(final ActionEvent e) {
                    InfoSoft infoSoft = new InfoSoft();
                    infoSoft.setVisible(true);
                    infoSoft.setLocationRelativeTo(null);
                }
            });
            final MenuItem itemCerrar = new MenuItem("Cerrar");
            itemCerrar.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            Popup.add(itemInfo);
            Popup.add(itemCerrar);
            trayIcon = new TrayIcon(image, null, Popup);
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("Iniciado");
            tray.add(trayIcon);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}