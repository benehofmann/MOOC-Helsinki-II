import java.util.ArrayList;

import java.util.HashMap;



public class Airport {

    private ArrayList<Plane> planes;

    private HashMap<Plane, Flight> flights;

    

    public Airport() {

        planes = new ArrayList<Plane>();

        flights = new HashMap<Plane, Flight>();

    }

    

    public void addPlane(String planeID, int capacity) {

        planes.add(new Plane(planeID, capacity));

    }

    

    public void addFlight(String planeID, Flight flight) {

        for (Plane p : planes) {

            if (p.getPlaneID().equals(planeID)) {

                Plane plane = new Plane(p.getPlaneID(), p.getCapacity());

                flights.put(plane, flight);

                break;

            }

        }

    }

    

    public void printPlanes() {

        for (Plane p : planes) {

            System.out.println(p);

        }

    }

    

    public void printFlights() {

        for (Plane p : flights.keySet()) {

            System.out.println(p + " " + flights.get(p));

        }

    }

    

    public void printPlaneInfo(String planeID) {

        for (Plane p : planes) {

            if (p.getPlaneID().equals(planeID)) {

                System.out.println(p);

            }

        }

    }

}