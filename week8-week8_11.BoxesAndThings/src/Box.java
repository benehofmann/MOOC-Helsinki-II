
import java.util.ArrayList;



public class Box implements ToBeStored {

    private ArrayList<ToBeStored> things;

    private double maxWeight;

    

    public Box(double maxWeight) {

        this.things = new ArrayList<ToBeStored>();

        this.maxWeight = maxWeight;

    }

    

    public double weight() {

        double totalWeight = 0;

        

        for (ToBeStored thing : things) {

            totalWeight += thing.weight();

        }

        

        return totalWeight;

    }

    

    public void add(ToBeStored object) {

        if (weight() + object.weight() <= maxWeight) {

            things.add(object);

        }

    }

    

    @Override

    public String toString() {

        return "Box: " + things.size() + " things, total weight " + weight() + " kg";

    }

}
