/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.Map;
import reference.domain.Person;

/**
 *
 * @author User
 */
public class PersonComparator implements Comparator<Person>{
    
    Map<Person, Integer> peopleIdentities;
    
    public PersonComparator(Map<Person, Integer> identities) {
        peopleIdentities = identities;
    }

    @Override
    public int compare(Person p1, Person p2) {
        try {
            return peopleIdentities.get(p2) - peopleIdentities.get(p1);
        } catch (Exception e) {
            return 0;
        }
    }
    
}
