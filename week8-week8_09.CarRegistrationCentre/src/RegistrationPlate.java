
public class RegistrationPlate {
    // don't change the code which is already given to you

    // ATTENTION: the object variable types are final, meaning that their value cannot be changed!
    private String regCode;
    private String country;

    public RegistrationPlate(String country, String regCode) {
        this.regCode = regCode;
        this.country = country;
    }

    @Override
    public String toString() {
        return getCountry() + " " + getRegCode();
    }

    /**
     * @return the regCode
     */
    public String getRegCode() {
        return regCode;
    }

    /**
     * @param regCode the regCode to set
     */
    public void setRegCode(String regCode) {
        this.regCode = regCode;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
    
    @Override
    public boolean equals(Object object) {
        if(object == null) {
            return false;
        }
        
        if (getClass() != object.getClass()) {
            return false;
        }
        
        RegistrationPlate compared = (RegistrationPlate)object;
        
        if(this.regCode != compared.regCode) {
            return false;
        }
        
        if(this.country != compared.country) {
            return false;
        }
        
        if(this.country == null || !this.regCode.equals(compared.getRegCode())) {
            return false;
        }
        
        return true;
        
    }
    
    @Override
    public int hashCode() {
        return this.country.hashCode() + this.regCode.hashCode();
    }
    
    

}
