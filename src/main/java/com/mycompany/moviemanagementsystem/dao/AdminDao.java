/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moviemanagementsystem.dao;

import com.mycompany.moviemanagementsystem.helper.DatabaseHelper;
import com.mycompany.moviemanagementsystem.model.AdminModel;
import com.mycompany.moviemanagementsystem.model.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author haicd
 */
public class AdminDao {
    public AdminModel  checkLogin(String Username, String password)
        throws Exception{
 
        String sql = "select Username, password from admin " + " where Username=? and Password=?";
        try(Connection conn = DatabaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);){
            pstmt.setString(1, Username);
            pstmt.setString(2, password);
            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()){
                    AdminModel am = new AdminModel();
                    am.setAdminName(Username);
                    //um.setUserRole(rs.getString("Role"));
                    return am;
                }
            }
        }
        return null;   
        }
            
}
