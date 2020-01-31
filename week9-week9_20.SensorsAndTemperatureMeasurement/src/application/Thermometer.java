/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author User
 */
public class Thermometer implements Sensor{
    private boolean isOn = false;
    private Random random;

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void on() {
        this.isOn = true;
    }

    @Override
    public void off() {

        this.isOn = false;
    }

    @Override
    public int measure() {
        if(isOn == false) {
            throw new IllegalStateException();
        }
        random = new Random();
        return random.nextInt(61) - 30;
    }
    
}
