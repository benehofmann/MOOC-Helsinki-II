/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Dungeon {
    private Scanner reader;
    private int length, height, vampires, moves;
    private boolean vampiresMove;
    private List<Vampire> vampireList;
    private Random generator;
    private Player player;
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.vampiresMove = vampiresMove;
        this.player = new Player(moves);
        reader = new Scanner(System.in);

        generator = new Random();
        vampireList = new ArrayList<Vampire>();
    }
     private void printMap() {
      for (int j = 0; j < height; j++) {

            for (int i = 0; i < length; i++) {
                if (isThePlayerHere(i, j)) {
                    System.out.print("@");
                } else if (isVampireHere(i, j)) {
                    System.out.print("v");
                } else {
                    System.out.print(".");
                }
            }
            System.out.print("\n");
        }
    }

        
public void run() {

        this.generateVampires(vampires);

        while (true) {
            if (player.getMovesLeft() == 0) {
                System.out.println("YOU LOSE");
                break;
            }

            this.printStats();
            player.reduceMovesLeftByOne();
            System.out.print("\n");
            this.printMap();
            String inputMoves = this.whichWayToGo(reader);
            movePlayer(createMoveList(inputMoves));
            if (vampireList.isEmpty()) {
                System.out.println("YOU WIN");
                break;
            }
            if (vampiresMove) {
                this.moveVampires(inputMoves.length());
            }

        }



    }

    private void generateVampires(int amount) {
            for(int i = 0; i != amount; i++) {
                int x = generator.nextInt(length);
                int y = generator.nextInt(height);
                
                if(!isOccupied(x,y)) {
                    vampireList.add(new Vampire(x, y));
                } else
                    i--;
            }
    }

    private void printStats() {
        System.out.println(player.getMovesLeft());
        System.out.println("\n" + "@ " + player.getX() + " " + player.getY());
        for(Vampire v : vampireList) {
            System.out.println("v " + v.getX() + " " + v.getY());
        }
    }
    
    private boolean isThePlayerHere(int x, int y) {
        return player.getX() == x && player.getY() == y;
    }
    
    private boolean isVampireHere(int x, int y) {
        for(Vampire v : vampireList) {
            if(v.getX() == x && v.getY() == y) return true;
        }
        return false;
    }
    
    private String whichWayToGo(Scanner reader) {
        return reader.nextLine();
    }
    
    private boolean isPlayerOnVampire(Vampire vampire) {
        return vampire.getX() == player.getX() && vampire.getY() == player.getY();
    }
    
    public int killVampire() {
        for(Vampire v : vampireList) {
            if(isPlayerOnVampire(v)) {
                vampireList.remove(v);
                return 1;
            }
        }
        return -1;
    }

    private boolean isOccupied(int x, int y) {
        if(player.getX() == x && player.getY() == y) {
            return true;
        } else
            return isVampireHere(x, y);
    }
    
    private boolean isOutOfPlayArea(Movable movable) {
        int x = movable.getX();
        int y = movable.getY();
        
         return x < 0 || y < 0 || x >= length || y >= length;
    }
    
    private List<Character> createMoveList(String moves) {
        List<Character> moveList = new ArrayList<Character>();
        for(int i = 0; i != moves.length(); i++) {
            moveList.add(moves.charAt(i));
        }
        return moveList;
    }
    
    private void movePlayer(List<Character> list) {
        for(char movingDirection : list) {
            int beforeWasMovedX = player.getX();
            int beforeWasMovedY = player.getY();
            
            switch (movingDirection) {
                case 'w' :
                    player.goUp();
                    break;
                case 'd' : 
                    player.goRight();
                    break;
                case 's' :
                    player.goDown();
                    break;
                case 'a' :
                    player.goLeft();
                    break;
            }
            
            if(isOutOfPlayArea(player)) {
                player.setX(beforeWasMovedX);
                player.setY(beforeWasMovedY);
            } else if (hasPlayerFoundAVampire()) {
                killVampire();
            }
               
        } 
    }
    
    private void moveVampires(int howOften) {
for (Vampire vampire : vampireList) {

            for (int i = 0; i < howOften; i++) {
                int direction = generator.nextInt(4);
                int posBeforeMovingX = vampire.getX();
                int posBeforeMovingY = vampire.getY();

                switch (direction) {

                    case 0:

                        vampire.goUp();
                        break;

                    case 1:

                        vampire.goLeft();
                        break;

                    case 2:

                        vampire.goRight();
                        break;

                    case 3:

                        vampire.goDown();
                        break;
                }

                if (isOutOfPlayArea(vampire)) {
                    vampire.setX(posBeforeMovingX);
                    vampire.setY(posBeforeMovingY);
                    i--;

                }

            }

        }
    }

    private boolean hasPlayerFoundAVampire() {
        for(Vampire v : vampireList) {
            if(isPlayerOnVampire(v)) {
                return true;
            }
        }
        return false;
    }

    
    

    
}
