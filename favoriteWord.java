/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author isyed
 */
public class favoriteWord {
    favoriteWord(String date, String word) {
        try {
            Class.forName("com.mysql.jdbc.Driver");    
            String url = "jdbc:mysql://localhost:3306/entries?characterEncoding=latin1&useConfigs=maxPerformance";
            Connection con = DriverManager.getConnection(url, "root", "syed531");
            String query = "INSERT INTO favorite VALUES (?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            //
            stmt.setString(1,date);
            stmt.setString(2, word);
            //
            int check = stmt.executeUpdate();
            if(check > 0) System.out.println("Favorite check: Word added successfully to Favorite.");
            else System.out.println("Favorite check: Fail to add word.");
                    
        }
        catch(ClassNotFoundException | SQLException e) {e.getMessage();}
    }
}
