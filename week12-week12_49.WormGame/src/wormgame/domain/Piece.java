/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

/**
 *
 * @author User
 */
public class Piece {

    private int x, y;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
public void setNewXY(int newX, int newY) {
    this.x = newX;
    this.y = newY;
}
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public boolean runsInto(Piece piece) {
        return this.x == piece.getX() && this.y == piece.getY();
    }
    
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

}
