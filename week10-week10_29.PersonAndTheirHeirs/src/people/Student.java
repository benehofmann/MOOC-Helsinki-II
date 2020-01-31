package people;


import people.Person;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Student extends Person{
    private int credits;
    
    public Student(String fullName, String adress) {
        super(fullName, adress);
    }
    
    public int credits() {
        return credits;
    }
    
    public void study() {
        credits++;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n" + "  " + "credits " + this.credits;
    }
    
}
