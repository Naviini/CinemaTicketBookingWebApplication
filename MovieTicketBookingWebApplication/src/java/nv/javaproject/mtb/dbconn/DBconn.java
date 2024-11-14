/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nv.javaproject.mtb.dbconn;
//mannually improt all method from sql package
import java.sql.*;
/**
 *
 * @author user
 */
public class DBconn {
//  Method
    public static Connection getCon() throws ClassNotFoundException, SQLException{    
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticket", "root", "Nan#3rdSqlWish.");
    }   
}
