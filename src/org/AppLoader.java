package org;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * Точка запуска
 */
public class AppLoader {
    public static TrayIcon trayIcon;
    
    public static void main(String args[]) throws IOException, AWTException{
        SystemTray systemTray = SystemTray.getSystemTray();
        MainFrame f = new MainFrame();
        BufferedImage trayIconImage = ImageIO.read(MainFrame.class.getResourceAsStream("logo_png.png")); 
        
        f.setVisible(true);
        
        // сворачивание в трей MainFrame 
        trayIcon = new TrayIcon(trayIconImage, "Таймер выключения компьютера неактивен");
        systemTray.add(trayIcon);
        trayIcon.addActionListener((ActionEvent e) -> {
            f.setVisible(true);
            f.setState(JFrame.NORMAL);
        });
        f.addWindowStateListener((WindowEvent e) -> {
            if(e.getNewState() == JFrame.ICONIFIED) f.setVisible(false);
        });
        
    }
}


