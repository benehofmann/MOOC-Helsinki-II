/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Change {
    private char charFrom;
    private char charTo;
    
    public Change(char fromCharacter, char toCharacter) {
        charFrom = fromCharacter;
        charTo = toCharacter;
    }
    
    public String change(String characterString) {
        String changedString = characterString;
        
        return changedString.replace(charFrom, charTo);
    }
}
