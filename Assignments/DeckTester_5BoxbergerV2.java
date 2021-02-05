import java.util.ArrayList;

public class DeckTester_5BoxbergerV2 {
    public static void main(String[] args) {
        System.out.println("Testing Deck: "); 

        Deck deck = new Deck(true);
        deck.shuffle();
        for (int i = 0; i < 52; i++) {
            System.out.println(deck.deal());
        }
    }
}

class Card {
    private String suit = "";
    private int rank;
    private String cardName = "";
    private int value;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
        if (rank == 1) {
            cardName = "Ace";
            value = 11;
        } else if (rank == 11) {
            cardName = "Jack";
            value = 10;
        } else if (rank == 12) {
            cardName = "Queen";
            value = 10;
        } else if (rank == 13) {
            cardName = "King";
            value = 10;
        } else {
            cardName = rank + "";
            value = rank;
        }   
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return cardName + " of " + suit + " (" + value + "pts)";
    }
}

class Deck {
    private ArrayList<Card> cards = new ArrayList<>();
    private String[] suits = {"Clubs", "Hearts", "Spades", "Diamonds"};
    private String suit = suits[0];

    public Deck() {
        for (int i = 0; i < suits.length; i++) {
            suit = suits[i];
            for (int f = 1; f <= 13; f++) {
                Card card = new Card(f, suit);
                cards.add(card);
            }
        }
    }
    
    public Deck(boolean shuffled) {
        for (int i = 0; i < suits.length; i++) {
            suit = suits[i];
            for (int f = 1; f <= 13; f++) {
                Card card = new Card(f, suit);
                cards.add(card);
            }
        }
        
        if (shuffled) {
            ArrayList<Card> temp = new ArrayList<>();
            for (Card card:cards) {
                temp.add(card);
            }
            cards.clear();
            for (int i = 0; i < 52; i++) {
                int randomCardIndex = (int)(Math.random()*temp.size());
                cards.add(temp.get(randomCardIndex));
                temp.remove(randomCardIndex);
            }
        }
    }

    public Card deal() {
        Card card = cards.get(cards.size()-1);
        cards.remove(cards.size()-1);
        return card;
    }

    public void shuffle() {
        ArrayList<Card> temp = new ArrayList<>();
        for (Card card:cards) {
            temp.add(card);
        }
        cards.clear();
        for (int i = 0; i < 52; i++) {
            int randomCardIndex = (int)(Math.random()*temp.size());
            cards.add(temp.get(randomCardIndex));
            temp.remove(randomCardIndex);
        }
    }

    public String toString() {
        String string = "";
        for (Card card:cards) {
            string += card + "\n";
        }
        return string;
    }
}