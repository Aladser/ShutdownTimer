package org;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;

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
    SpinnerModel hourSpinModel, minSpinModel;
    boolean isEnabled = false;
    
    public MainFrame(){
        renderFrame();
        Time().start();
        // обработка закрытия окна
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent evt){
                if(isEnabled) ConsoleMngmnt.execute("shutdown /a");
                System.exit(42);
            }
        });
    }
    
    
    /** показывает дату */ 
    private Thread Time(){
        return new Thread(() -> {
            while(true){
                timeInfoPanel.setText(formatTime.format(new Date()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    /** Отрисовка окна */
    private void renderFrame(){
        setIconImage( new ImageIcon( getClass().getResource("logo.png") ).getImage() );
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        initComponents();
        switchButton.requestFocusInWindow();
        int xCenter = (screenSize.width - 500)/2;
        int yCenter = (screenSize.height - 170)/2;
        getContentPane().setBackground(java.awt.Color.WHITE);
        setBounds(xCenter, yCenter, 500 , 170);
        
        hourSpinModel = new SpinnerListModel(hours);
        minSpinModel = new SpinnerListModel(minutes);
        hourSpinner.setModel(hourSpinModel);
        minSpinner.setModel(minSpinModel);      
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

        minSpinner.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N

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
            hourSpinner.setEnabled(false);
            minSpinner.setEnabled(false);
            // Вычисление таймера
            GregorianCalendar startTime = new GregorianCalendar();
            int startTimeInt = startTime.get(Calendar.HOUR_OF_DAY)*3600;
            startTimeInt += startTime.get(Calendar.MINUTE)*60;
            int finalTimeInt = Integer.parseInt((String)hourSpinner.getValue())*3600;
            finalTimeInt += Integer.parseInt((String)minSpinner.getValue())*60;
            int delta = finalTimeInt - startTimeInt;
            if(delta < 0) delta += 86400;
            
            ConsoleMngmnt.execute("shutdown /s /t " + delta + " /f");
            isEnabled = true; 
        }
        else{
            hourSpinner.getEditor().getComponent(0).setForeground(Color.black);
            minSpinner.getEditor().getComponent(0).setForeground(Color.black);
            hourSpinner.setEnabled(true);
            minSpinner.setEnabled(true);
            
            ConsoleMngmnt.execute("shutdown /a");
            isEnabled = false;  
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
