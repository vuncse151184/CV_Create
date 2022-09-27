/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class DBUtils {

    public static Connection makeConnection() throws SQLException {
        try {
            //1.Load JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //2.Create connection

            String sqlConnectionString = "jdbc:sqlserver://localhost:1433;databaseName=StudentCV";
            Connection con = DriverManager.getConnection(sqlConnectionString, "sa", "1234567890");

            return con;
        } catch (ClassNotFoundException | SQLException e) {

        }
        return null;
    }
}
