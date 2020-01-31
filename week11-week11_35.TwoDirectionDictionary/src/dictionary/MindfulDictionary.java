/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class MindfulDictionary {
    private HashMap<String, String> finnishDictionary;
    private HashMap<String, String> englishDictionary;
    private File loadedFile;
    private Scanner reader;
    
    public MindfulDictionary() {
        finnishDictionary = new HashMap<String, String>();
        englishDictionary = new HashMap<String, String>();
    }
    
    public MindfulDictionary(String file) throws FileNotFoundException {
        finnishDictionary = new HashMap<String, String>();
        englishDictionary = new HashMap<String, String>();
        
         loadedFile = new File(file);
    }
    
    public void add(String word, String translation) {
        if(!finnishDictionary.containsKey(word)) {
            finnishDictionary.put(word, translation); 
        }
       if(!englishDictionary.containsKey(word)) {
           englishDictionary.put(translation, word);
       }
        
    }

    public String translate(String searchedWord) {
        String word = null;
        if(finnishDictionary.containsKey(searchedWord)) {
            word = finnishDictionary.get(searchedWord);
        }
        if(englishDictionary.containsKey(searchedWord)) {
            word = englishDictionary.get(searchedWord);
        }
        return word;
    }
    
    public void remove(String searchedWord) {
        if(englishDictionary.containsKey(searchedWord)) {
            String translation = englishDictionary.get(searchedWord);
            englishDictionary.remove(searchedWord);
            finnishDictionary.remove(translation);
        }
        if(finnishDictionary.containsKey(searchedWord)) {
            String translation = finnishDictionary.get(searchedWord);
            finnishDictionary.remove(searchedWord);
            englishDictionary.remove(translation);
        }
    }
    
    public boolean load()  {
        try {

            Scanner reader = new Scanner(loadedFile);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] words = line.split(":");
                add(words[0], words[1]);
            }

        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }
    
    public boolean save() {
        try {
            FileWriter writer = new FileWriter(loadedFile);
            for(String word : finnishDictionary.keySet()) {
                writer.write(word + ":" + finnishDictionary.get(word) + "\n");
            }
            writer.close();
        } catch (IOException ex) {
           return false;
        }
        
        return true;
    }
}
