package org;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * Точка запуска
 */
public class AppLoader {

    public static void main(String args[]) throws IOException, AWTException{
        SystemTray systemTray = SystemTray.getSystemTray();
        TrayIcon trayIcon;
        MainFrame f = new MainFrame();
        BufferedImage trayIconImage = ImageIO.read(MainFrame.class.getResourceAsStream("logo.png")); 
        
        f.setVisible(true);
        
        
        // сворачивание в трей MainFrame 
        trayIcon = new TrayIcon(trayIconImage, "Shutdown Timer");
        systemTray.add(trayIcon);
        trayIcon.addActionListener((ActionEvent e) -> {
            f.setVisible(true);
            f.setState(JFrame.NORMAL);
        });
        f.addWindowStateListener((WindowEvent e) -> {
            if(e.getNewState() == JFrame.ICONIFIED)
            {
                f.setVisible(false);
                trayIcon.displayMessage("Tray test", "Window minimised to tray, double click to show", TrayIcon.MessageType.INFO);
            }
        });
        
    }
}


