/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author User
 */
public class Employees {
    
    private List<Person> employees;
    
    public Employees() {
        employees = new ArrayList<Person>();
    }
    
    public void add(Person peron) {
        employees.add(peron);
    }
    
    public void add(List<Person> persons) {
        for(Person p : persons) {
            employees.add(p);
        }
    }
    
    public void print() {
        for(Person p : employees) {
            System.out.println(p.toString());
        }
    }
    
    public void print(Education education)  {
        Iterator<Person> iterator = employees.iterator();
        
        while(iterator.hasNext()) {
            Person p = iterator.next();
            if(p.getEducation().equals(education)) {
                System.out.println(p.toString());
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> iterator = employees.iterator();
        
        while(iterator.hasNext()) {
            Person p = iterator.next();
            if(p.getEducation().equals(education)) {
                iterator.remove();
            }
        }
    }
            
    
}
