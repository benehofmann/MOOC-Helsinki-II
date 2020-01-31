/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author User
 */
public class PersonalDuplicateRemover implements DuplicateRemover {


    private List<String> list;

    public PersonalDuplicateRemover() {
        list = new ArrayList<String>();
    }

    @Override
    public void add(String characterString) {
        list.add(characterString);
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        Set<String> duplicSet = new HashSet<String>();
        int counter = 0;
        for (String s : list) {
            if (!duplicSet.add(s)) {
                counter++;
            }
        }

        return counter;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        /* returns an object which implements the interface Set<String>.
        Object should have all unique characterStrings (no duplicates!). 
        If there are no unique characterStrings, method returns an empty set. */
        Set<String> uniqueSet = new HashSet<String>();

        for (String s : list) {
            boolean result = false;
            Set<Character> charSet = new HashSet<Character>();
            for (int i = 0; i != s.length(); i++) {
                result = charSet.add(s.charAt(i));
                if (result == false) {
                    break;
                }
                uniqueSet.add(s);
            }
        }
        return uniqueSet;

    }

    @Override
    public void empty() {
        /* removes stored characterStrings and resets
        the amount of detected duplicates. */
        list.clear();
        
    }

}
