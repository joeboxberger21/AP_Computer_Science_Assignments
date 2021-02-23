import java.util.ArrayList;
import java.util.Scanner;

public class PlayerTester_5Boxberger {
    public static void main(String[] args) {
        Deck deck = new Deck(true);

        Hand hand = new Hand();

        System.out.println(hand);

        System.out.println("♧ ♤ ♢ ♡");
    }
}

class Card {
    private String suit = "";
    private String cardName = "";
    private int value;

    public Card(int rank, String suit) {
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

    public String getName() {
        return cardName;
    }

    public String toString() {
        return cardName  + " of " + suit;
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
            shuffle();
        }
    }

    public Card deal() {
        return cards.remove(cards.size()-1);
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

class Hand {
    ArrayList<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getHandValue(){
        int value = 0;
        ArrayList<Card> aces = new ArrayList<>();

        for (Card card:cards) {
            if (!card.getName().equals("Ace")) {
                value += card.getValue();
            } else {
                aces.add(card);
            }
        }

        int aceTotal = aces.size() * 11;
        System.out.println(aceTotal);

        int loops = 0;
        while (value + aceTotal > 21 && loops < aces.size()) {
            aceTotal -= 10; //Equivalent to turning a full value ace into a value of 1
            System.out.println(aceTotal);                
            loops++;
        }
        return value + aceTotal;
    }

    public String toString() {
        String cardString = "";
        for (Card card: cards) {
            cardString += "[" + card + "] ";
        }
        return cardString + "\nHand Value: " + getHandValue();
    }
}

class Player {
    Hand hand = new Hand();
    String choice;

    public String getUserChoice() {
        System.out.println(hand);
        Scanner input = new Scanner(System.in);  
        System.out.println("(H)it or (S)tay: ");
        choice = input.nextLine();

        return choice;
    }
}