import java.util.*;



/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */

/**

 *

 * @author zsolt

 */

public class UserInterface {



    private final Scanner reader;

    private Skier skier;

    private final List<Skier> list;

    private int round;



    public UserInterface(Scanner reader) {



        this.reader = new Scanner(System.in);

        this.list = new ArrayList();

        this.round = 1;



    }



    public void start() {

        System.out.println("Kumpula ski jumping week\n"

                + "\n"

                + "Write the names of the participants one at a time; an empty string brings you to the jumping phase.");

        while (true) {



            System.out.print("  " + "Participant name: ");

            String command = this.reader.nextLine();

            if (command.isEmpty()) {

                break;

            } else {

                this.list.add(new Skier(command));

            }

        }

        System.out.println("");



        System.out.print("The tournament begins!\n"

                + "\n"

                + "Write \"jump\" to jump; otherwise you quit: ");



        while (true) {



            String command = this.reader.nextLine();

            System.out.println("");



            if (command.equals("jump")) {



                System.out.println("Round " + round);

                System.out.println("");



                System.out.println("Jumping order: ");



                rounds();

                round = round + 1;



            } else {



                Collections.sort(list);



                System.out.println("");

                System.out.println("Thanks!\n"

                        + "\n"

                        + "Tournament results:\n"

                        + "Position    Name");

                int i = 1;

                for (Skier b : list) {

                    System.out.println(i + "           " + b);

                    System.out.print("            ");

                    b.printJumps();

                    i++;

                }



                break;



            }



        }



    }



    public void rounds() {

        Collections.sort(list);



        Collections.reverse(list);



        int i = 1;



        for (Skier a : list) {



            System.out.println("  " + i + ". " + a);

            i++;



        }



        System.out.println("Results of round " + round);



        for (Skier a : list) {

            System.out.println("  " + a.getName());



            Random random = new Random();

            int length = random.nextInt(120 + 1 - 60) + 60;

            System.out.println("    " + "length: " + length);

            List<Integer> values = new ArrayList<Integer>();

            for (int b = 0; b < 5; b++) {

                int vote = random.nextInt(20 + 1 - 10) + 10;

                values.add(vote);

            }

            System.out.println("    " + "judge votes: " + values.toString());

            Collections.sort(values);

            values.remove(0);

            values.remove(values.size() - 1);

            int sum = 0;

            for (Integer d : values) {

                sum += d;

            }



            a.addPoints(sum + length, length);

        }

        System.out.println("");

        System.out.print("Write \"jump\" to jump; otherwise you quit: ");



    }



}