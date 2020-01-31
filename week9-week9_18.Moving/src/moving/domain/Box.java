/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 */
public class Box implements Thing{
    private int maximumCapacity;
    private List<Thing> things;
    
    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.things = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing) {
        if(this.getVolume() + thing.getVolume() <= maximumCapacity) {
            things.add(thing);
            return true;
        } else {
            return false;
        }
        
    }

    @Override
    public int getVolume() {
                int volume = 0;

        

        for (Thing t : things) {

            volume += t.getVolume();

        }

        

        return volume;
    }
}
