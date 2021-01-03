/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SyedAhmed
 */
public class CheckRecords {
    public static Boolean duplicateRecords(String word) {
        word = word.toLowerCase();
        word = word.substring(0, 1).toUpperCase() + word.substring(1);
        //
        Boolean result = false;
        try {
            Database db = new Database();
            Statement stmt = db.openDatabase().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM entries WHERE word LIKE '"+word+"'");
            
            int count = 0;
            if(rs.next()) {
                count++;
                }
            if(count > 0) return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CheckRecords.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    //
    public static Boolean duplicateFavorite(String word) {
        Boolean result = false;
        try {
            Database db = new Database();
            Statement stmt = db.openDatabase().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM favorite WHERE word LIKE '"+word+"'");
            
            int count = 0;
            if(rs.next()) {
                count++;
                }
            if(count > 0) return true;
            
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;
    }
    public static void main(String arg[]) {
        //CHECKER
        System.out.println(duplicateFavorite("Sampl"));
    }
}
