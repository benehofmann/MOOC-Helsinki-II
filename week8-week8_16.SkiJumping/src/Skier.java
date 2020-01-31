import java.util.ArrayList;

import java.util.List;



/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */

/**

 *

 * @author zsolt

 */

public class Skier implements Comparable<Skier> {



    private final String name;

    private int points;

    private List<Integer> jumps;



    public Skier(String name) {

        this.name = name;

        this.points = 0;

        jumps = new ArrayList<Integer>();

    }



    public void addPoints(int point, int jump) {

        this.points += point;

        jumps.add(jump);

    }



    public String getName() {

        return this.name;

    }



    public int getPoints() {

        return this.points;

    }



    public void printJumps() {

        System.out.print("jump lengths: ");

int i = 0;

        for (Integer a : jumps) {

            

            if (i < jumps.size() - 1) {

                System.out.print(a + " m, ");

              

            } else {

                System.out.print(a + " m");

            }

              i++;

        }

        System.out.println("");

    }



    @Override

    public String toString() {

        return this.getName() + " (" + this.getPoints() + " points)";

    }



    public int compareTo(Skier skier) {

        return skier.points - this.points;

    }



}