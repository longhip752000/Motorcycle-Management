/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longbv.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author longh
 */
public class DBHelpers implements Serializable{
    public static Connection makeConnection()
        throws ClassNotFoundException, SQLException{
        //1. load driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2.Create connection
        String url = "jdbc:sqlserver://localhost:1433;databaseName=MotorcycleManagement;instanceName=SQLEXPRESS";
        //3.Open Connection
        Connection con = DriverManager.getConnection(url, "sa", "123456");
        
        return con;
    }
}
