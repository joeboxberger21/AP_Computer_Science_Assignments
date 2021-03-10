import java.util.ArrayList;
import java.util.Scanner;
/**
 * AList-A10 Player and Hand classes
 * @author Joe Boxberger
 */
public class DealerTester_5BoxbergerV2 {
    public static void main(String[] args) {
        //Loop over main three times for testing purposes
        for(int i = 0; i < 3; i++) {
            Player player1 = new Player();
            Dealer dealer = new Dealer();
            Deck deck = new Deck(true);

            //Initialize the hands of the dealer and player
            dealer.addCard(deck.deal());
            dealer.addCard(deck.deal());
            
            player1.addCard(deck.deal());
            player1.addCard(deck.deal());

            //Display hands
            dealer.displayHand();
            System.out.println("Hand: " + player1);
            System.out.println("Hand Value: " + player1.getHandValue());

            while(player1.getUserChoice().toUpperCase().equals("H")) {
                System.out.println("Hit!\n");
                player1.addCard(deck.deal());
                
                if(dealer.shouldGetCard()) {
                    dealer.addCard(deck.deal());
                }

                dealer.displayHand();
                System.out.println("Hand: " + player1);
                System.out.println("Hand Value: " + player1.getHandValue());
            }
            System.out.println("\n-----Thanks for playing!-----");
            dealer.endGame();
            System.out.println("Final Hand: " + player1);
            System.out.println("Final Hand Value: " + player1.getHandValue() + "\n----------------------------");
        }
    }
}



class Dealer {
    private Hand hand = new Hand();

    public void addCard(Card card) {
        hand.addCard(card);
    }
    /**
     * @return true if dealer should get another card
     */
    public boolean shouldGetCard() {
        if(hand.getHandValue() <= 16) {
            return true;
        } else if (hand.getHandValue() == 17) {
            for (Card card : hand.getCards()) {
                if(card.getName().equals("Ace")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void displayHand() {
        System.out.println();
        //Prints all but bottom card
        for (int i = 0; i < hand.getCards().size() - 1; i++) {
            System.out.print("[" + hand.getCards().get(i) + "] ");
        }
        //Signifies that the bottom card is hidden from the user
        System.out.print("[?]\n");
    }

    public void endGame() {
        System.out.println("Dealer Final Hand: " + hand + "\nDealer Final Hand Value: " + hand.getHandValue());
    }
}

/**
 * Class that represents a Blackjack player, who has a hand of cards
 */
class Player {
    private Hand hand = new Hand();
    String choice;

    /**
     * Ask user if they want to hit or stay
     * @return the users choice
     */
    public String getUserChoice() {
        Scanner input = new Scanner(System.in);  
        System.out.print("\n(H)it or (S)tay: ");
        choice = input.nextLine();

        return choice;
    }
    /**
     * @return return the user's hand
     */
    public Hand getHand() {
        return hand;
    }
    /**
     * @return the users hand value since hand is a private variable
     */
    public int getHandValue() {
        return hand.getHandValue();
    }

    public void addCard(Card c) {
        hand.addCard(c);
    }
    /**
     * @return the users cards in hand
     */
    public String toString() {
        return hand.toString();
    }
}

/**
 * Class that represents a hand of cards
 */
class Hand {
    private ArrayList<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }
    /**
     * @return point value of the cards in hand, calculates aces
     */
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
    /**
     * @return a string of cards listed out and formatted 
     */
    public String toString() {
        String cardString = "";
        for (Card card: cards) {
            cardString += "[" + card + "] ";
        }
        return cardString;
    }

    public ArrayList<Card> getCards() {
        return cards;
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
        for(int i = cards.size() - 1; i >= 0; i--) {
            int randNum = (int)(Math.random() * i);
            swapCards(i, randNum);
        }
    }

    public void swapCards(int firstIndex, int secondIndex) {
        Card firstCard = cards.get(firstIndex);
        cards.set(firstIndex, cards.get(secondIndex));
        cards.set(secondIndex, firstCard);
    }

    public String toString() {
        String string = "";
        for (Card card:cards) {
            string += card + "\n";
        }
        return string;
    }
}