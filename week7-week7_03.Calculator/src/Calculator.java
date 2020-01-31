/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Calculator {
 private Reader reader;
 private int numOfCalculations;
 
    public Calculator() {
        reader = new Reader();
        numOfCalculations = 0;
    }
    
    public void start() {
        while(true) {
            System.out.print("comand: ");
            String command = reader.readString();
            if(command.equals("end")) {
                break;
            }
            
            if(command.equals("sum")) {
                sum();
                numOfCalculations++;
            } else if(command.equals("difference")) {
                difference();
                numOfCalculations++;
            } else if(command.equals("product")) {
                product();
                numOfCalculations++;
            }
        }
        statistics();
    }
    
    private int[] getValues() {
        int[] values = new int[2];
        
        System.out.print("value1: ");
        values[0] = reader.readInteger();
        System.out.print("value2: ");
        values[1] = reader.readInteger();
        
        return values;
    }
    
    private void sum() {
        int[] values = getValues();
        int sum = values[0] + values[1];
 
        System.out.println("sum of the values " + sum);
        
    }
    
    private void difference() {
        int[] values = getValues();
        int difference;

             difference = values[0] - values[1];

    
        System.out.println("difference " + difference);
    }
    
    private void product() {
        int[] values = getValues();
        int product = values[0] * values[1];

        System.out.println("product: " + product);
        
        
    }
    
    private void statistics() {
        System.out.println("Calculations done: " + numOfCalculations);
    }
}
