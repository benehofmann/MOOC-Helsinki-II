/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Group implements Movable{ 
private ArrayList<Movable> species;

    public Group() {
        species = new ArrayList<Movable>();
    }
    
    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       for(Movable m : species) {
           sb.append(m.toString());
           sb.append("\n");
       }
       return sb.toString();
    }
    
    public void addToGroup(Movable movable) {
        species.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
        for(Movable m : species) {
            m.move(dx, dy);
        }
    }
    
}
