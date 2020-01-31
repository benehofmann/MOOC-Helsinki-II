package movingfigure;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        CompoundFigure duck = new CompoundFigure();
        
        duck.add(new Circle(80,50,20));
        duck.add(new Circle(85, 20, 50));
        duck.add(new Box(100, 60, 100, 50));
        duck.add(new Box(120,110,20,20));
        duck.add(new Box(160,110,20,20));

       /* truck.add(new Box(220, 110, 75, 100));
        truck.add(new Box(80, 120, 200, 100));
        truck.add(new Circle(100, 200, 50));
        truck.add(new Circle(220, 200, 50));
*/
        UserInterface ui = new UserInterface(duck);
        SwingUtilities.invokeLater(ui);
    }
}
