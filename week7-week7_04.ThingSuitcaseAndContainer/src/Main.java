
public class Main {

    public static void main(String[] args) {
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }
    
    public static void addSuitcasesFullOfBricks(Container container) {
      int brickWeight = 1;
      while(brickWeight + container.totalWeight() <= container.getMaxWeight()) {
      Thing brick = new Thing("brick", brickWeight);
      Suitcase suitcase = new Suitcase(brickWeight);
      suitcase.addThing(brick);
      container.addSuitcase(suitcase);
      brickWeight++;    
      }

    }

}
