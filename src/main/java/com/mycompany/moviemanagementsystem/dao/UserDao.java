/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moviemanagementsystem.dao;

import com.mycompany.moviemanagementsystem.helper.DatabaseHelper;
import com.mycompany.moviemanagementsystem.model.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author haicd
 */
public class UserDao {
    public UserModel  checkLogin(String Username, String password)
        throws Exception{
 
        String sql = "select Username, password from users " + " where Username=? and password=?";
        try(Connection conn = DatabaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);){
            pstmt.setString(1, Username);
            pstmt.setString(2, password);
            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()){
                    UserModel um = new UserModel();
                    um.setUsername(Username);
                    //um.setUserRole(rs.getString("Role"));
                    return um;
                }
            }
        }
        return null;   
        }
            
}
