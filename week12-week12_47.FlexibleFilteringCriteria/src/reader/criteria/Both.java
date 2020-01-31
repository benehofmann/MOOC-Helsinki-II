/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

/**
 *
 * @author User
 */
public class Both implements Criterion{
    private Criterion c1, c2;
    
    public Both(Criterion c1, Criterion c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public boolean complies(String line) {
        if(!c1.complies(line)) {
            return false;
        }
        
        if(!c2.complies(line)) {
            return false;
        }
        
        return true;
    }
    
}
