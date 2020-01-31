/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.ArrayList;
import java.util.List;
import wormgame.Direction;

/**
 *
 * @author User
 */
public class Worm {
    private int originalX, originalY, wormLength;
    private Direction direction;
    private List<Piece> worm;
    private boolean grow;
    
    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.originalX = originalX;
        this.originalY = originalY;
        this.direction = originalDirection;
        worm = new ArrayList<Piece>();
        this.grow = false;
        worm.add(new Piece(originalX, originalY));
    }
    
    public Direction getDirection() {
        return direction;
    }
    
    public void setDirection(Direction dir) {
        this.direction = dir;
    }
    
    public int getLength() {
        return worm.size();
    }
    
    public List<Piece> getPieces() {
        return worm;
    }
    
    public void move() {
        int newX = worm.get(worm.size() - 1).getX();
        int newY = worm.get(worm.size()- 1).getY();
        
        if(direction == Direction.DOWN) {
            newY++;
        }
        
        if(direction == Direction.LEFT) {
            newX--;
        }
        
        if(direction == Direction.RIGHT) {
            newX++;
        }
        
        if(direction == Direction.UP) {
            newY--;
        }
        
        if(getLength() > 2 && !grow) {
            worm.remove(0); //last part removed
        }
        
        if(grow = true) {
            grow = false;
        }
        
        worm.add(new Piece(newX, newY)); //new part
    }
    
    public void grow() {
        grow = true;
    }
    
    public boolean runsInto(Piece piece) {
        for(int i = 0; i != worm.size(); i++) {
            if(worm.get(i).getX() == piece.getX() && worm.get(i).getY() == piece.getY()) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean runsIntoItself() {
        for(int i = 0; i != worm.size()-1; i++) {
            if (wormHead().getX() == worm.get(i).getX() && wormHead().getY() == worm.get(i).getY()) {
                return true;
            }
        }
        
        return false;
    }
    
    public Piece wormHead() {
        return worm.get(getLength()-1);
    }
    

}
