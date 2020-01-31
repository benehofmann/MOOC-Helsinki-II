package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // test your code here

        File file = new File("src/shortList.txt");
        WordInspection wi = new WordInspection(file);
        // all words are in file src/wordList.txt
        System.out.println(wi.wordCount());
        System.out.println("---------------------");
        System.out.println("wordsContainingZ");
        System.out.println(wi.wordsContainingZ());
        System.out.println("---------------------");
        System.out.println("wordsEndingInL");
        System.out.println(wi.wordsEndingInL());
        System.out.println("---------------------");
        System.out.println("wordsWhichContainAllVowels");
        System.out.println(wi.wordsWhichContainAllVowels());
        
        System.out.println("Palindrome");
        System.out.println(wi.palindromes());
    }
}
