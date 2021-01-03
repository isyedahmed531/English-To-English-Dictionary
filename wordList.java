/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import static dictionary.MainFrame.searchBox;
import static dictionary.MainFrame.statusResult;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;

/**
 *
 * @author isyed
 */
//This is for transfering the words into the list.
public class wordList extends Thread {
    public static String loadWords = "Loading words, Please wait!";
    public static HashMap<String, String> listOfWords = new HashMap<>();
    public static HashMap<String, String> typeOfWords = new HashMap<>();
    public static HashMap<String, String> suggestWords = new HashMap<>();
    public static Database db = new Database();
    //
    static int count = 0;
    

    public static HashMap<String, String> getListOfWords() {
        return listOfWords;
    }

    public int getCount() {
        return count;
    }
    //This method will transfer the words into the list of nodes.
    public void run() {
        try{
            Statement stmt = db.openDatabase().createStatement();
            ResultSet rs = stmt.executeQuery("select * from entries");
            //
            while(rs.next()) {
                listOfWords.put(rs.getString(1),rs.getString(3));
                typeOfWords.put(rs.getString(1),rs.getString(2));
                suggestWords.put(rs.getString(1), rs.getString(1));
                count++;
            }
            
            if(suggestWords.isEmpty()) System.out.println("Empty list"+" | Total Entries:"+count);
            else {
                loadWords = "Words loaded. ";
                System.out.println("Words inserted. "+" | Total Entries:"+count);
            }
            for(String word : suggestWords.keySet()) {
                searchBox.addItem(word);
            }
            searchBox.setSelectedItem("");
            AutoCompleteDecorator.decorate(searchBox);
        
            statusResult.setText(loadWords);
            statusResult.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 3, true));
        }
        catch(Exception e) {e.getMessage();}
    }
}
class main {
    public static void main(String arg[]) {
        //CHECK
        wordList wl = new wordList();   
        wl.start();
        System.out.println(wl.getCount());
    }
}
