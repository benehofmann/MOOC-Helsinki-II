/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ContainerHistory {
    private ArrayList<Double> history;
    
    public ContainerHistory() {
    history = new ArrayList<Double>();
    }
    
    public void add(double situation) {
        history.add(situation);
    }
    
    public void reset() {
        history.clear();
    }
    
    @Override
    public String toString() {
        return history.toString();
    }
    
    public double minValue() {
        double minValue;
        if(history.isEmpty()) {
            return  0;
        } else
            minValue = history.get(0);
            for(double d : history) {
                if(d < minValue) {
                    minValue = d;
                }
            }
            return minValue;
    }
    
    public double maxValue() {
        double maxValue = 0;
        if(history.isEmpty()) {
            return maxValue;
        } else 
            for(double d : history) {
                if(d > maxValue) {
                    maxValue = d;
                }
            }
        return maxValue;
    }
    
    public double average() {
        double average = 0;
        if(history.isEmpty()) {
            return average;
        } else
            for(double d : history) {
                average+= d;
            }
        return average / (double)history.size();
    }
    

    public double greatestFluctuation() {
        if (history.size() <= 1) {
           return 0;
        }

        double maxFluctuation = 0;

        for (int i = 1; i < history.size(); i++) {
            double diff = Math.abs(history.get(i) - history.get(i - 1));
                  if (diff > maxFluctuation) {
                maxFluctuation = diff;
            }

        }
        return maxFluctuation;

    }
    

    public double variance() {

        if (history.size() <= 1) {

            return 0;

        }
  
        double average = average();

        double variance = 0;

        for (Double d : history) {
            variance += Math.pow((d - average), 2);
        }
        variance /= (history.size() - 1);
        
    return variance;

    }
    
}
