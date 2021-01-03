/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import static dictionary.wordList.getListOfWords;
import static dictionary.wordList.listOfWords;
import static dictionary.wordList.typeOfWords;
import java.util.Iterator;

/**
 *
 * @author isyed
 */
public class searchWord {
    String wordType = null, def = null;
    String we = null;
    //
    searchWord(String word) {
        word = word.toLowerCase();
        word = word.substring(0, 1).toUpperCase() + word.substring(1);
        Iterator i = getListOfWords().keySet().iterator();
        while(i.hasNext()) {
            String key = i.next().toString().trim();
            if(word.equals(key)){
                wordType = typeOfWords.get(key);
                def = listOfWords.get(key);
            }
        }
    }
    public String getWordType() {
        return wordType;
    }
    public String getDef() {
        return def;
    }
}
class ma {
    public static void main(String arg[]) {
       searchWord sw = new searchWord("Public"); 
       System.out.println(sw.def+" | "+sw.wordType);
    }
}
