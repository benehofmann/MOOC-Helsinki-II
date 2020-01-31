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
public class Container {
    private int maxWeight;
    private ArrayList<Suitcase> suitcases;
    
    public Container(int maxWeight) {
       this.maxWeight = maxWeight;
       this.suitcases = new ArrayList<Suitcase>();
    }
    
    public int totalWeight() {
        int totalWeight = 0;
        for(Suitcase suitcase : suitcases ) {
            totalWeight += suitcase.totalWeight();
        }
        return totalWeight;
    }
    
    public int getMaxWeight() {
        return maxWeight;
    }
    
    public void addSuitcase(Suitcase suitcase) {
        if(totalWeight() + suitcase.totalWeight() <= maxWeight) {
            suitcases.add(suitcase);
    }

    }
    @Override
    public String toString() {
                if(suitcases.isEmpty()) {
            return "empty (" +totalWeight() + "kg)";
        }
        if(suitcases.size() == 1) {
            return "1 suitcase (" + totalWeight()+ "kg)";
        }
        return suitcases.size() + " suitcases " + "(" + totalWeight() + " kg)";
    }
    
    public void printThings() {
        for(Suitcase suitcase : suitcases) {
            suitcase.printThings();
        }
    }
}
