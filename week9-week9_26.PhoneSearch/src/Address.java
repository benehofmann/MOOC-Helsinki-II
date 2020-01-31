
public class Address {

    

    private String street;

    private String city;



    public Address(String street, String city) {

        this.street = street;

        this.city = city;

    }



    public String getStreet() {

        return street;

    }

    

    public String getCity() {

        return city;

    }

    

    public boolean addressContainsKeyword(String keyword) {

        if (street.contains(keyword) || city.contains(keyword)) {

            return true;

        }

        

        return false;

    }

    

    @Override

    public String toString() {

        return street + " " + city;

    }

}