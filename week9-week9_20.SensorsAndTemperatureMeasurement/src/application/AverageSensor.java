/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author User
 */
public class AverageSensor implements Sensor{
    private List<Sensor> sensorList;    
    private List<Integer> readings;
   
    
    public AverageSensor() {
        sensorList = new LinkedList<Sensor>();
        readings = new LinkedList<Integer>();
    }
    
    public void addSensor(Sensor additional) {
     
        sensorList.add(additional);

    }

    @Override
    public boolean isOn() {
        boolean allOn = false;
        
        for(Sensor s : sensorList) {
            if(s.isOn()) {
                allOn = true;
            } else {
                allOn = false;
            }
        }
       return allOn;
    }

    @Override
    public void on() {
    for(Sensor se : sensorList) {
        se.on();
    }
    }

    @Override
    public void off() {
     for(Sensor se : sensorList) {
         se.off();
     }
    }

    @Override
    public int measure() {
        int buffer = 0;
        int counter = 0;
        int average = 0;
        boolean anyOneOn = false;
        
        for(Sensor se : sensorList) {
            if(se.isOn() == true) {
                anyOneOn = true;
                break;
            }
        }
        
        if(anyOneOn = false || sensorList.isEmpty()) {
            throw  new IllegalStateException();
        }
        
        for(Sensor s : sensorList ) {
            if(s.isOn()) {
                buffer += s.measure();
                counter++;
            }
        }
        average = buffer/counter;
        
        readings.add(average);
        return buffer / counter;
    }
    
    public List<Integer> readings() {
        return this.readings;
        
    }
    
}
