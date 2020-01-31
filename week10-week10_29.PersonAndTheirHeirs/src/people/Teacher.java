/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

/**
 *
 * @author User
 */
public class Teacher extends  Person {
    private int salary;
    
    public Teacher(String fullName, String adress, int salary) {
        super(fullName, adress);
        this.salary = salary;
    }
    
    
    @Override
    public String toString() {
        return super.toString() + "\n" + "  " + "salary " + salary + " euros/month";
    }
    
}
