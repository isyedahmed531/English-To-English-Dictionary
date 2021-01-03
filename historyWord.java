/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author isyed
 */
public class historyWord {
    historyWord(String date, String word) {
        try {
            Class.forName("com.mysql.jdbc.Driver");    
            String url = "jdbc:mysql://localhost:3306/entries?characterEncoding=latin1&useConfigs=maxPerformance";
            Connection con = DriverManager.getConnection(url, "root", "syed531");
            String query = "INSERT INTO history VALUES (?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            //
            stmt.setString(1,date);
            stmt.setString(2, word);
            //
            int check = stmt.executeUpdate();
            if(check > 0) System.out.println("History updated");
            else System.out.println("History failed.");
                    
        }
        catch(ClassNotFoundException | SQLException e) {e.getMessage();}
    }
}
