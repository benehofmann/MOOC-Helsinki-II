/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.print.DocFlavor;

/**
 *
 * @author User
 */
public class WordInspection {

    private File file;
    private Scanner reader;

    public WordInspection(File file) throws FileNotFoundException {
        this.file = file;

    }

    public int wordCount() throws FileNotFoundException {
        reader = new Scanner(file, "UTF-8");
        int counter = 0;
        List wordList = new ArrayList();
        String word = "";
        while (reader.hasNextLine()) {

            word = reader.nextLine();

            counter++;

        }
        return counter;
    }

    public List<String> wordsContainingZ() throws FileNotFoundException {
        reader = new Scanner(file, "UTF-8");
        String word = "";
        List wordList = new ArrayList();
        while (reader.hasNextLine()) {

            word = reader.nextLine();

            if (word.contains("z")) {

                wordList.add(word);

            }

        }
        return wordList;

    }

    public List<String> wordsEndingInL() throws FileNotFoundException {
        reader = new Scanner(file, "UTF-8");
        String word = "";
        List wordList = new ArrayList();
        while (reader.hasNext()) {
            word = reader.next();

            if (word.charAt(word.length() - 1) == 'l') {

                wordList.add(word);
            }

        }

        return wordList;

    }

    public List<String> palindromes() throws FileNotFoundException {
        reader = new Scanner(file, "UTF-8");
        String word = "";
        char[] sequence;
        List wordList = new ArrayList();

        while (reader.hasNext()) {
            word = reader.next();

            if (word.equals(new StringBuilder(word).reverse().toString())) {
                wordList.add(word);
            }

        }

        return wordList;
    }

    public List<String> wordsWhichContainAllVowels() throws FileNotFoundException {
        // all Vowels aeiouyäö
        reader = new Scanner(file, "UTF-8");
        String word = "";

        List wordList = new ArrayList();

        while (reader.hasNext()) {
            word = reader.next();
            if (word.contains("a") && word.contains("e") && word.contains("i")
                    && word.contains("o") && word.contains("u") && word.contains("y")
                    && word.contains("ä") && word.contains("ö")) {
                wordList.add(word);
            }
        }
        return wordList;

    }
}
