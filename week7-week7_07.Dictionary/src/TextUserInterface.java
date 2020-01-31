
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;
    
    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
        }
    
    public void add(String newWord, String translation) {
       dictionary.add(newWord, translation);
    }
    
    public String translate(String word) {
        return dictionary.translate(word);
    }
    
    public String shortenInput(String word) {
        String wordInLowerCases = word.toLowerCase();
        String trimmedWord = wordInLowerCases.trim();
        return trimmedWord;
    }
    
    public void start() {
        System.out.println("Statements: ");
        System.out.println("quit - quit the text user interface");
        System.out.println("add - adds a word pair to the dictionary");
        System.out.println("translate - ask a word and prints its translation");
        
        
        while(true) {
            System.out.print("Statement: ");
            String userInput = reader.nextLine();
            userInput = shortenInput(userInput);
            
            if(userInput.equals("quit")) {
                System.out.println("Cheers!");
                break;
            } else if(userInput.equals("add")) {
                System.out.println("In Finnish: ");
                String finnishWord = reader.nextLine();
                finnishWord = shortenInput(finnishWord);
                System.out.println("Translation");
                String translation = reader.nextLine();
                translation = shortenInput(translation);
                add(finnishWord, translation);
                        
            } else if(userInput.equals("translate")) {
                System.out.println("Give a word: ");
                String wordToTranslate = reader.nextLine();
                wordToTranslate = shortenInput(wordToTranslate);
                System.out.println("Translation: " + translate(wordToTranslate)); 
            }
            
            else {
                System.out.println("Unknown statement");
            }
        }
        }
    }

