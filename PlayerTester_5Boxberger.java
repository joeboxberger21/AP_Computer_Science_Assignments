import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * AList-A10 Player and Hand classes
 * @author Joe Boxberger
 */
public class PlayerTester_5Boxberger {
    public static void main(String[] args) {
        Player player1 = new Player();
        Deck deck = new Deck(true);
        
        Card deltCard = deck.deal();
        player1.addCard(deltCard);
        deltCard = deck.deal();
        player1.addCard(deltCard);

        System.out.println("Hand: " + player1);
        System.out.println("Hand Value: " + player1.getHandValue());

        while(player1.getUserChoice().toUpperCase().equals("H")) {
            System.out.println("Hit!\n");
            deltCard = deck.deal();
            player1.addCard(deltCard);

            System.out.println("Hand: " + player1);
            System.out.println("Hand Value: " + player1.getHandValue());
        }
        System.out.println("\n-----Thanks for playing!-----\n");
        System.out.println("Final Hand: " + player1);
        System.out.println("Final Hand Value: " + player1.getHandValue());
    }
}

/**
 * Class that represents a Blackjack player, who has a hand of cards
 */
class Player {
    private Hand hand = new Hand();
    String choice;

    public String getUserChoice() {
        Scanner input = new Scanner(System.in);  
        System.out.print("\n(H)it or (S)tay: ");
        choice = input.nextLine();

        return choice;
    }

    public Hand getHand() {
        return hand;
    }

    public int getHandValue() {
        return hand.getHandValue();
    }

    public void addCard(Card c) {
        hand.addCard(c);
    }

    public String toString() {
        return hand.toString();
    }
}

/**
 * Class that represents a hand of cards
 */
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

        int loops = 0;
        //keep turning 11 point aces into 1 point aces until under 21, aceTotal can't be less than number of aces
        while (value + aceTotal > 21 && loops < aces.size() && !(aceTotal <= aces.size())) {
            aceTotal -= 10; //Equivalent to turning a full value ace into a value of 1            
            loops++;
        }
        return value + aceTotal;
    }

    public String toString() {
        String cardString = "";
        for (Card card: cards) {
            cardString += "[" + card + "] ";
        }
        return cardString;
    }
}

/**
 * Class that represents a single card that has a suit, name, and value
 */
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
/**
 * Class representing a standard deck of 52 cards, each individual card can be accessed by a list
 */
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
        Collections.shuffle(cards);
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