/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author User
 */
public class PersonalBoard extends GameOfLifeBoard {
    private Random generator;
    

    public PersonalBoard(int width, int height) {
        super(width, height);
        
    }

    @Override
    public void initiateRandomCells(double d) {
        generator = new Random();
        
        for(int i = 0; i < super.getWidth(); i++) {
            for(int j = 0; j < super.getHeight(); j++) {
            double value = generator.nextDouble();
                if(value <= d) {
                    super.getBoard()[i][j] = true;
                } else {
                    super.getBoard()[i][j] = false;
                }
                    
        }
        }
        
        
    }

    @Override
    public boolean isAlive(int x, int y) {
        try {
            return super.getBoard()[x][y];
        } catch (IndexOutOfBoundsException ioobe) {
            return false;
        }
        
    }

    @Override
    public void turnToLiving(int x, int y) {
        if(x >= 0 && x <= super.getWidth() && y >= 0 &&  y <= super.getHeight()) {
        super.getBoard()[x][y] = true;
    }
        
    }

    @Override
    public void turnToDead(int x, int y) {
        if(x >= 0 && x <= super.getWidth() && y >= 0 &&  y <= super.getHeight()) {
        super.getBoard()[x][y] = false;
    }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int numberOfLivingNeighbours = 0;
        
        for(int i = x - 1; i <= x+1; i++) { //neighbours on x axis
            for(int j = y - 1; j <= y + 1; j++) { // neighbours on y axis
                if(isAlive(i, j)) {
                    numberOfLivingNeighbours++;
                }
            }
        }
        
        if(super.getBoard()[x][y] == true) { // decrement if middle cell == true;
            numberOfLivingNeighbours--;
        }
        return numberOfLivingNeighbours;
    }

    @Override
    public void manageCell(int x, int y, int numberOfLivingNeighbours) {
        //when current cell is dead
        if(super.getBoard()[x][y] == false && numberOfLivingNeighbours == 3) {
            super.getBoard()[x][y] = true;
        }
        
        // when less than 2 living neighbours
        if(numberOfLivingNeighbours < 2) {
            super.getBoard()[x][y] = false;
        } else if (isAlive(x, y) && (numberOfLivingNeighbours == 2 || numberOfLivingNeighbours == 3)) {
            super.getBoard()[x][y] = true;
        }
        if(numberOfLivingNeighbours > 3) {
            super.getBoard()[x][y] = false;
        }
        }
        

        
    }
    
    

