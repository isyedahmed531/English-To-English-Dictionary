/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author isyed
 */
public class ClearRecords {
    ClearRecords(Boolean history, Boolean favorite) {
        if(history) clearHistory();
        else if(favorite) clearFavorite();
        else ;
    }
    public void clearHistory() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/entries?characterEncoding=latin1&useConfigs=maxPerformance";
            Connection con = DriverManager.getConnection(url, "root", "syed531");
            PreparedStatement stmt = con.prepareStatement("DELETE FROM history");
            stmt.execute();
        }
        catch(Exception e) {
            System.out.println("ClearRecordException:"+e);
        }
    }
    public void clearFavorite() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/entries?characterEncoding=latin1&useConfigs=maxPerformance";
            Connection con = DriverManager.getConnection(url, "root", "syed531");
            PreparedStatement stmt = con.prepareStatement("DELETE FROM favorite");
            stmt.execute();
        }
        catch(Exception e) {
            System.out.println("ClearRecordException:"+e);
        }
    }
}
