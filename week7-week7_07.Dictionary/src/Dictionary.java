
import java.util.HashMap;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Dictionary {
    private HashMap<String, String> dictionaray;
    
    public Dictionary() {
        dictionaray = new HashMap<String, String>();
    }
    
    public String translate(String word) {
        if(dictionaray.containsKey(word)) {
            return dictionaray.get(word);
        } else {
            return null;
        }
    }
    
    public void add(String word, String translation) {
        dictionaray.put(word, translation);
    }
    
    public int amountOfWords() {
        return dictionaray.size();
    }
    
    public ArrayList<String> translationList() {
        ArrayList<String> list = new ArrayList<String>();
        for(String key : dictionaray.keySet()) {
            list.add(key + " = " + dictionaray.get(key));
        }
        return list;
    }
}
