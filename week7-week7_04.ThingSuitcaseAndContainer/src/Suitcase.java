
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Suitcase {
    private int maxWeight;
private ArrayList<Thing> things;
    
    
    public Suitcase(int maxWeight){
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
    }
    
    public void addThing(Thing thing) {
       if(totalWeight() + thing.getWeight() <= maxWeight) {
        things.add(thing);   
       }
        
    }
    
    public int totalWeight() {
        int totalWeight = 0;
        for(Thing thing : things) {
            totalWeight += thing.getWeight();
        }
        return totalWeight;
    }
    
    public String toString() {
        if(things.isEmpty()) {
            return "empty (" +totalWeight() + "kg)";
        }
        if(things.size() == 1) {
            return "1 thing (" + totalWeight() + "kg)";
        }
        return things.size() + " things " + "(" + totalWeight() + " kg)";
    }
    
    public void printThings() {
       // System.out.println("Your suitcase contains the following things:");
        for(Thing thing : things) {
            System.out.println(thing.toString());  
        }
    }
    
    public Thing heaviestThing() {
        if(things.isEmpty()) {
            return null;
        }
        Thing heaviest = things.get(0);
        
        for(Thing thing : things ) {
            if(thing.getWeight() > heaviest.getWeight()) {
              heaviest = thing; 
            }
            
        }
        return heaviest;
    }
}
