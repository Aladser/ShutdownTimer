package org;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 * Главное окно
 */
public class MainFrame extends javax.swing.JFrame {
    Thread clocks; // поток для показа времени
    SimpleDateFormat formatTime = new SimpleDateFormat("dd.MM.yyyy  HH:mm:ss");
    String[] hours = {
        "00","01","02","03","04","05","06","07","08","09",
        "10","11","12","13","14","15","16","17","18","19",
        "20","21","22","23"};
    String[] minutes = {
        "00","01","02","03","04","05","06","07","08","09",
        "10","11","12","13","14","15","16","17","18","19",
        "20","21","22","23","24","25","26","27","28","29",
        "30","31","32","33","34","35","36","37","38","39",
        "40","41","42","43","44","45","46","47","48","49",
        "50","51","52","53","54","55","56","57","58","59"};
    CyclicNumberModel hourSpinModel, minSpinModel;
    boolean isTimerActived = false;
    int shutdownHours = 0, shutdownMinutes = 0;
    GregorianCalendar curTime;
    String command = "shutdown /s /t 3";
    int i=0;
    
    public MainFrame(){
        initComponents();
        hourSpinModel = new CyclicNumberModel(hours);
        minSpinModel = new CyclicNumberModel(minutes); 
        hourSpinner.setModel(hourSpinModel);
        minSpinner.setModel(minSpinModel);
        renderFrame();
        Time().start();   
    }   
    
    /** Показывает дату */ 
    private Thread Time(){
        return new Thread(() -> {
            while(true){
                timeInfoPanel.setText(formatTime.format(new Date()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.err.println("Thread Time: сломалась sleep()");
                }
            }
        });
    }
    
    /** Таймер */
    private Thread Timer(){
        return new Thread(()->{
            while(isTimerActived){
                curTime = new GregorianCalendar();
                if(curTime.get(Calendar.HOUR_OF_DAY) == shutdownHours && curTime.get(Calendar.MINUTE) == shutdownMinutes){
                    try {
                        Runtime.getRuntime().exec(command);
                        System.exit(42);
                    } 
                    catch (IOException ex) {
                        System.err.println("Thread Timer: сломалась Runtime.getRuntime()");
                    }
                }
                else
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        System.err.println("Thread Timer: сломалась sleep()");
                    }
            }
        });
    }
    
    /** Отрисовка окна */
    private void renderFrame(){
        setIconImage( new ImageIcon( getClass().getResource("logo_png.png") ).getImage() );
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        switchButton.requestFocusInWindow();
        int xCenter = (screenSize.width - 500)/2;
        int yCenter = (screenSize.height - 170)/2;
        getContentPane().setBackground(java.awt.Color.WHITE);
        setBounds(xCenter, yCenter, 500 , 170);

        JTextField hourSpinnerTextField = ((JSpinner.DefaultEditor) hourSpinner.getEditor()).getTextField();
        hourSpinnerTextField.setEditable(false);
        JTextField minSpinnerTextField = ((JSpinner.DefaultEditor) minSpinner.getEditor()).getTextField();
        minSpinnerTextField.setEditable(false);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        timeInfoPanel = new javax.swing.JLabel();
        timeInfoLabel = new javax.swing.JLabel();
        hourSpinner = new javax.swing.JSpinner();
        minSpinner = new javax.swing.JSpinner();
        pointLabel = new javax.swing.JLabel();
        switchButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Таймер выключения компьютера");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        timeInfoPanel.setFont(new java.awt.Font("Bahnschrift", 0, 28)); // NOI18N
        timeInfoPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeInfoPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        timeInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeInfoLabel.setText("Таймер");

        hourSpinner.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        hourSpinner.setFocusable(false);
        hourSpinner.setRequestFocusEnabled(false);

        minSpinner.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        minSpinner.setFocusable(false);
        minSpinner.setRequestFocusEnabled(false);

        pointLabel.setFont(new java.awt.Font("Bahnschrift", 1, 20)); // NOI18N
        pointLabel.setText(":");

        switchButton.setBackground(new java.awt.Color(255, 255, 255));
        switchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(timeInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timeInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(hourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pointLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(switchButton)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(timeInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(timeInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(minSpinner)
                            .addComponent(switchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pointLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(17, 17, 17)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void switchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchButtonActionPerformed
        if(switchButton.isSelected()){
            // смена элементов GUI
            hourSpinner.getEditor().getComponent(0).setForeground(Color.green);
            minSpinner.getEditor().getComponent(0).setForeground(Color.green);
            hourSpinModel.setEditabled(false);
            minSpinModel.setEditabled(false);
            // Активация таймера
            shutdownHours = Integer.parseInt((String)hourSpinner.getValue());
            shutdownMinutes = Integer.parseInt((String)minSpinner.getValue());
            isTimerActived = true;
            if(shutdownMinutes < 10)
                AppLoader.trayIcon.setToolTip("Выключение компьютера в "+shutdownHours+":0"+shutdownMinutes);
            else
                AppLoader.trayIcon.setToolTip("Выключение компьютера в "+shutdownHours+":"+shutdownMinutes);
            Timer().start();
        }
        else{
            hourSpinner.getEditor().getComponent(0).setForeground(Color.black);
            minSpinner.getEditor().getComponent(0).setForeground(Color.black);
            hourSpinModel.setEditabled(true);
            minSpinModel.setEditabled(true);
            isTimerActived = false;
            AppLoader.trayIcon.setToolTip("Таймер выключения компьютера неактивен");
        }
    }//GEN-LAST:event_switchButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner hourSpinner;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JSpinner minSpinner;
    private javax.swing.JLabel pointLabel;
    private javax.swing.JRadioButton switchButton;
    private javax.swing.JLabel timeInfoLabel;
    private javax.swing.JLabel timeInfoPanel;
    // End of variables declaration//GEN-END:variables
}
