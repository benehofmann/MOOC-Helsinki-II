package boxes;

public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight) {
        if(weight < 0) throw new IllegalArgumentException("Weight cannot be negative.");
        this.name = name;
        this.weight = weight;
    }

    public Thing(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int hashCode() {
        return 3 * name.hashCode();
        
    }
    
    @Override
    public boolean equals(Object thing) {
        if(thing == null || this.getClass() != thing.getClass()) {
            return false;
        } 
        Thing otherThing = (Thing) thing;

        return (this.name != null && this.name.equals(otherThing.name));
        

    }

}
