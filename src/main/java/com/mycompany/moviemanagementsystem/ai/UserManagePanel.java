/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.moviemanagementsystem.ai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author user
 */
public class UserManagePanel extends javax.swing.JPanel {
    String url = "jdbc:mysql://localhost/ktpm3";
    String userName = "root";
    String password = "";
    String searchText;
    
    public UserManagePanel() {
        initComponents();
        autoDisplay();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchTxt = new javax.swing.JTextField();
        searchuserBtn = new javax.swing.JButton();
        deleteuserBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        usernameTable = new javax.swing.JTable();

        searchTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTxtActionPerformed(evt);
            }
        });

        searchuserBtn.setText("Search");
        searchuserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchuserBtnActionPerformed(evt);
            }
        });

        deleteuserBtn.setText("Delete");
        deleteuserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteuserBtnActionPerformed(evt);
            }
        });

        usernameTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Name", "Username"
            }
        ));
        jScrollPane1.setViewportView(usernameTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchuserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteuserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchuserBtn)
                    .addComponent(deleteuserBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTxtActionPerformed

    private String getCurrentAction(String id){
        String status ="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/ktpm3";
            String userName = "root";
            String password = "";
            Connection connn =DriverManager.getConnection(url, userName, password);
            String sql ="SELECT Action FROM admin WHERE Username = ?";
            PreparedStatement pstmt = connn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                status = rs.getString("Action");
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
            e.printStackTrace();
        }
        return status;
    }
    private String getUsername(){
        String value=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/ktpm3";
            String userName = "root";
            String password = "";
            Connection connn =DriverManager.getConnection(url, userName, password);
            String sql ="SELECT Username FROM Temp LIMIT 1";
            PreparedStatement pstmt = connn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                value = rs.getString("Username");
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
            e.printStackTrace();
        }
        return value;
    }
    private void autoDisplay(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect =DriverManager.getConnection(url, userName, password);
            String searchQuery = "select Id, Name, Username from users";
            PreparedStatement pst = connect.prepareStatement(searchQuery);
            ResultSet rsSearch = pst.executeQuery();
            usernameTable.setModel(DbUtils.resultSetToTableModel(rsSearch));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void searchuserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchuserBtnActionPerformed
        try{
            Class.forName("com.mysql.jdbc.Driver");
            searchText = searchTxt.getText();
            Connection connect =DriverManager.getConnection(url, userName, password);
            String searchQuery = "select Id, Name, Username from users where Name like '" + searchText + "%'";
            PreparedStatement pst = connect.prepareStatement(searchQuery);
            ResultSet rsSearch = pst.executeQuery();
            usernameTable.setModel(DbUtils.resultSetToTableModel(rsSearch));
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchuserBtnActionPerformed

    private void deleteuserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteuserBtnActionPerformed
        int row = usernameTable.getSelectedRow();
        String value = usernameTable.getModel().getValueAt(row, 0).toString();
        String username ="";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect =DriverManager.getConnection(url, userName, password);
            
            String deleteQuery = "select Name from users where Id="+value;
            PreparedStatement pss = connect.prepareStatement(deleteQuery); 
            ResultSet rs = pss.executeQuery();
            while(rs.next()){
                username = rs.getString("Name");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error");
        }
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect =DriverManager.getConnection(url, userName, password);
            
            String deleteQuery = "delete from users where Id="+value;
            PreparedStatement psDel = connect.prepareStatement(deleteQuery); 
            psDel.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
            autoDisplay();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error");
        }
        try{
            Date now = new Date();
            SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/YYYY hh:mm:ss a");
            
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/ktpm3";
            String userName = "root";
            String password = "";
            Connection connn =DriverManager.getConnection(url, userName, password);
            String sql = "UPDATE admin SET Action = ? WHERE Username = '"+getUsername()+"'";
            PreparedStatement pstmt = connn.prepareStatement(sql);
            pstmt.setString(1, getCurrentAction(getUsername()) + dateForm.format(now) + " deleted user : " + username +"\n");
            pstmt.executeUpdate();
            pstmt.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_deleteuserBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteuserBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JButton searchuserBtn;
    private javax.swing.JTable usernameTable;
    // End of variables declaration//GEN-END:variables
}
