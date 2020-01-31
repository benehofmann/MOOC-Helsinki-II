
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
class PhoneBook {
     private Map<String, Set<String>> numberByName;

    private Map<String, String> nameByNumber;

    private Map<String, Address> addressByName;
    
        public PhoneBook() {

        this.numberByName = new HashMap<String, Set<String>>();

        this.nameByNumber = new HashMap<String, String>();

        this.addressByName = new HashMap<String, Address>();

    }
        
        public void addNumber(String name, String number) {
            if(!numberByName.containsKey(name)) {
                numberByName.put(name, new HashSet<String>());
            }
            
            if(!nameByNumber.containsKey(number)) {
                nameByNumber.put(number, name);
            }
            
            numberByName.get(name).add(number);
        }

    public void searchNumber(String name) {

        if (numberByName.containsKey(name)) {

            for (String number : numberByName.get(name)) {

                System.out.println(" " + number);

            }

        } else {

            System.out.println("  not found");

        }

    }

    void searchPersonByNumber(String number) {
        if(nameByNumber.containsKey(number)) {
            System.out.println(" " + nameByNumber.get(number) );
        } else {
            System.out.println("  not found");
        }
    }

    void addAddress(String name, String street, String city) {
        addressByName.put(name, new Address(street, city));
    }
    
  public void searchPersonalInfo(String name) {

        if (!addressByName.containsKey(name) && !numberByName.containsKey(name)) {

            System.out.println("  not found");

        } else {

            if (addressByName.containsKey(name)) {

                System.out.println("  address: " + addressByName.get(name));

            } else {

                System.out.println("  address unknown");

            }

            

            if (numberByName.containsKey(name)) {

                System.out.println("  phone numbers:");

                for (String number : numberByName.get(name)) {

                    System.out.println("   " + number);

                }

            } else {

                System.out.println("  phone number not found");

            }

        }

    }



 public void deletePersonalInfo(String name) {

        // Order is important because we need to access the phone numbers

        if (numberByName.containsKey(name)) {

            for (String number : numberByName.get(name)) {

                nameByNumber.remove(number);

            }



            numberByName.remove(name);

        }

        

        if (addressByName.containsKey(name)) {

            addressByName.remove(name);

        }

    }

    void filteredListing(String keyword) {
    TreeMap<String, Set<String>> numberbyNameSorted = new TreeMap<String, Set<String>>(numberByName);
    boolean isFound = false;
    
    for(String name : numberbyNameSorted.keySet()) {
             if (name.contains(keyword) || (addressByName.containsKey(name) 

                    && addressByName.get(name).addressContainsKeyword(keyword))) {
        isFound = true;
        
                System.out.println("\n " + name);

                searchPersonalInfo(name);
    }
    }
    
        if (!isFound) {

            System.out.println(" keyword not found");

        }
    }
}
