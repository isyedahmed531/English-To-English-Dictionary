/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SyedAhmed
 */
public class Database {
    public Connection openDatabase(String query, String statement) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/entries?characterEncoding=latin1&useConfigs=maxPerformance";
            con = DriverManager.getConnection(url, "root", "syed531");
        } catch (ClassNotFoundException | SQLException ex ) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    public Connection openDatabase() {
        return openDatabase(null,null);
    }
    public void closeDatabase() {
        try {
            openDatabase(null,null).close();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}