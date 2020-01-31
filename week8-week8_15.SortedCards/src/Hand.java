import java.util.ArrayList;



import java.util.Collections;



import java.util.List;







public class Hand implements Comparable<Hand> {







    private List<Card> cards;







    public Hand() {



        cards = new ArrayList<Card>();



    }







    public void add(Card card) {



        cards.add(card);



    }







    public void print() {



        for (Card card : cards) {



            System.out.println(card);



        }



    }







    public void sort() {



        Collections.sort(cards);



    }







    @Override



    public int compareTo(Hand hand) {



        int thisTotal, otherTotal;



        thisTotal = otherTotal = 0;







        for (Card card : this.cards) {



            thisTotal += card.getValue();



        }







        for (Card card : hand.cards) {



            otherTotal += card.getValue();



        }







        return thisTotal - otherTotal;



    }







    public void sortAgainstSuit() {



        Collections.sort(cards, new SortAgainstSuitAndValue());



    }



}