/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

/**
 *
 * @author User
 */
public class Organism implements Movable{
    private int xCoord;
    private int yCoord;
    
    public Organism(int x, int y) {
        xCoord = x;
        yCoord = y;
                
    }
    
    @Override
    public String toString() {
        return "x: " + xCoord + "; y: " + yCoord;
    }

    @Override
    public void move(int dx, int dy) {
        xCoord+= dx;
        yCoord += dy;
    }
    
}
