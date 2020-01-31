/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Analysis {

    private File file;

    public Analysis(File file) throws Exception {
        this.file = file;
    }

    public int lines() throws Exception {
        Scanner reader = new Scanner(this.file);
        int lineCounter = 0;

        while (reader.hasNextLine()) {
            lineCounter++;
            reader.nextLine();
        }

        reader.close();
        return lineCounter;
    }
    
    public int characters() throws Exception {
        Scanner reader = new Scanner(this.file);
        int charCounter = 0;
        String line ="";
        
        while (reader.hasNextLine()) {
        line = reader.nextLine();
        charCounter += line.length() + 1;
            
        }
        
    
        reader.close();
        return charCounter;
    }
}
