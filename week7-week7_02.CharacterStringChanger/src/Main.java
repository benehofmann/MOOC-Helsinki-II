public class Main {
    public static void main(String[] args) {
        // Test your program here
  String word = "carrot";
  Change change1 = new Change('a', 'b');
  word = change1.change(word);

  System.out.println(word);

  Change Change2 = new Change('r', 'x');
  word = Change2.change(word);

  System.out.println(word);
    }
}
