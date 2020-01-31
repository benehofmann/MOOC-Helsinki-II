/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class AtLeastOne implements Criterion{
    
    private ArrayList<Criterion> criterion;
    
    public AtLeastOne(Criterion... criterion) {
        this.criterion = new ArrayList<Criterion>();
        
        for(Criterion c : criterion) {
            this.criterion.add(c);
        }
    }

    @Override
    public boolean complies(String line) {
        int counter = 0;
        
        for(Criterion c : this.criterion) {
            if(c.complies(line)) {
                counter++;
            }
        }
        
        return counter > 0;
    }
    
    
    
}
