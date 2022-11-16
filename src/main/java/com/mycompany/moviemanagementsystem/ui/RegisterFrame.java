/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.moviemanagementsystem.ui;

import com.mycompany.moviemanagementsystem.helper.DataValidator;
import com.mycompany.moviemanagementsystem.helper.MessageDialogHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class RegisterFrame extends javax.swing.JFrame {

    /**
     * Creates new form RegisterFrame
     */
    public RegisterFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }
    String url = "jdbc:mysql://localhost/ktpm3";
    String DBuserName = "root";
    String DBpassword = "";
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usernameTXT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordTXT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fullnameTXT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        phonenumberTXT = new javax.swing.JTextField();
        signUpBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 46, 100, -1));

        usernameTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTXTActionPerformed(evt);
            }
        });
        jPanel1.add(usernameTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 43, 192, -1));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 84, 70, -1));
        jPanel1.add(passwordTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 81, 192, -1));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Full Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 119, 90, -1));
        jPanel1.add(fullnameTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 116, 192, -1));

        jLabel4.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Phone Number");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 145, 130, -1));
        jPanel1.add(phonenumberTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 145, 192, -1));

        signUpBtn.setText("Sign up");
        signUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBtnActionPerformed(evt);
            }
        });
        jPanel1.add(signUpBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 185, -1, -1));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Curtain (5).jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 310));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTXTActionPerformed

    private int getRandomId(){
        Random id = new Random();
        int number;
        number = id.nextInt();
        return number;
    }
    private void signUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtnActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(usernameTXT, sb, "username can not be empty");
        DataValidator.validateEmpty(passwordTXT, sb, "password can not be empty");
        DataValidator.validateEmpty(phonenumberTXT, sb, "phone number can not be empty");
        DataValidator.validateEmpty(fullnameTXT, sb, "your name can not be empty");
        if(sb.length()>0){
            MessageDialogHelper.showErrorDialog(this, sb.toString(),"Error");
            return;
        }
        if(sb.length()>0){
            MessageDialogHelper.showErrorDialog(this, sb.toString(),"Error");
            return;
        }
        String username = usernameTXT.getText();
        String password = passwordTXT.getText();
        String phone = phonenumberTXT.getText();
        String fullname = fullnameTXT.getText();
        
            if(!checkUsername(username)){
            PreparedStatement pss;
            ResultSet set;
            String registerQuery = "insert into users(ID, Name, Username, password, Phone, Role) value (?,?,?,?,?,?)";
            try{
            Class.forName("com.mysql.jdbc.Driver");
                Connection connect =DriverManager.getConnection(url, DBuserName, DBpassword);
                pss = connect.prepareStatement(registerQuery);
                int id = getRandomId();
                String x = String.valueOf(id);
                for(int i=0; i<100000; i++){
                    if(!checkId(id)){
                        x = String.valueOf(id);
                        break;
                    }
                    id = getRandomId();
                }
                pss.setString(1,x);
                pss.setString(2,fullname);
                pss.setString(3,username);
                pss.setString(4,password);
                pss.setString(5,phone);
                pss.setString(6,"user");
                if(pss.executeUpdate()!=0){
                    JOptionPane.showMessageDialog(null, "Your account has been created");
                    LoginFrame login = new LoginFrame();
                    login.setVisible(true);
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Error");
                }
        } catch (Exception e){
            Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, e);
        } 
        }
    }//GEN-LAST:event_signUpBtnActionPerformed
public boolean checkUsername(String username){
        boolean username_checked = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect =DriverManager.getConnection(url, DBuserName, DBpassword);
            String checkQuery = "select * from users where Username = ?";
            PreparedStatement pst = connect.prepareStatement(checkQuery);
            pst.setString(1, username);
            ResultSet reg = pst.executeQuery();
            if(reg.next()){
                username_checked=true;
                JOptionPane.showMessageDialog(null, "This username is already taken, choose another one");
            }
            
        } catch (Exception e){
            Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, e);
        }
        return username_checked;
    }
public boolean checkId(int id){
        boolean id_checked = false;
        String x = String.valueOf(id);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect =DriverManager.getConnection(url, DBuserName, DBpassword);
            String checkQuery = "select * from users where Id = ?";
            PreparedStatement pst = connect.prepareStatement(checkQuery);
            pst.setString(1, x);
            ResultSet reg = pst.executeQuery();
            if(reg.next()){
                id_checked=true;
                JOptionPane.showMessageDialog(null, "This username is already taken, choose another one");
            }
            
        } catch (Exception e){
            Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, e);
        }
        return id_checked;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fullnameTXT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField passwordTXT;
    private javax.swing.JTextField phonenumberTXT;
    private javax.swing.JButton signUpBtn;
    private javax.swing.JTextField usernameTXT;
    // End of variables declaration//GEN-END:variables
}