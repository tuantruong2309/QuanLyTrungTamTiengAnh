/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public Connection conn()
    {
         Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/trungtamngoaingu","root","");
            System.out.println("Connect Success");
        } catch (Exception ex) {
            System.out.println("connect failure!");
           
        }
        return conn;
    }
   
}
