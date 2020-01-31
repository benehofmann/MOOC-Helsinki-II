import java.util.Scanner;



public class TextUserInterface {

    private Scanner reader;

    private Airport airport;

    

    public TextUserInterface(Scanner reader, Airport airport) {

        this.reader = reader;

        this.airport = airport;

    }

    

    public void listAirportOperations() {

        System.out.println("[1] Add airplane");

        System.out.println("[2] Add flight");

        System.out.println("[x] Exit");

        System.out.print("> ");

    }

    

    public void listFlightServices() {

        System.out.println("[1] Print planes");

        System.out.println("[2] Print flights");

        System.out.println("[3] Print plane info");

        System.out.println("[x] Quit");

        System.out.print("> ");

    }

    

    public void displayAirportPanel() {

        System.out.println("Airport panel");

        System.out.println("--------------------\n");

        

        while (true) {

            System.out.println("Choose operation:");

            listAirportOperations();

            String input = reader.nextLine();

            if (input.equals("1")) {

                addPlane();

            } else if (input.equals("2")) {

                addFlight();

            } else if (input.equals("x")) {

                break;

            }

        }

    }

    

    public void displayFlightService() {

        System.out.println("Flight service");

        System.out.println("------------\n");

        

        while (true) {

            System.out.println("Choose operation:");

            listFlightServices();

            String input = reader.nextLine();

            if (input.equals("1")) {

                airport.printPlanes();

            } else if (input.equals("2")) {

                airport.printFlights();

            } else if (input.equals("3")) {

                System.out.print("Give plane ID: ");

                airport.printPlaneInfo(reader.nextLine());

            } else if (input.equals("x")) {

                break;

            }

        }

    }

    

    public void addPlane() {

        System.out.print("Give plane ID: ");

        String planeID = reader.nextLine();

        System.out.print("Give plane capacity: ");

        int capacity = Integer.parseInt(reader.nextLine());

        

        airport.addPlane(planeID, capacity);

    }

    

    public void addFlight() {

        System.out.print("Give plane ID: ");

        String planeID = reader.nextLine();

        System.out.print("Give departure airport code: ");

        String departureCode = reader.nextLine();

        System.out.print("Give destination airport code: ");

        String destinationCode = reader.nextLine();

        

        airport.addFlight(planeID, new Flight(departureCode, destinationCode));

    }

    

    public void start() {

        displayAirportPanel();

        displayFlightService();

    }

}

