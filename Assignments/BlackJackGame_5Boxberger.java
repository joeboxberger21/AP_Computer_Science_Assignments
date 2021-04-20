import java.util.ArrayList;
import java.util.Scanner;
/**
 * AList-A15: Blackjack Game
 * @author Joe Boxberger
 */

 /**
  * Class to test the BlackJackGame class and run its methods
  */
class BlackJackGame_5Boxberger {
    public static void main(String[] args) {
        BlackJackGame game = new BlackJackGame();
        game.displayBanner();
        game.playGame();
    }
}

/**
 * Class that holds all the instance variables and methods necessary to run a game of Blackjack
 */
class BlackJackGame {
    private Dealer dealer;
    private Deck deck;
    private ArrayList<Player> playerList;
    private boolean playing;

    /**
     * Initialize all the instance variables required to play a game of blackjack
     */
     public BlackJackGame() {
        deck = new Deck(true);
        dealer = new Dealer();
        playerList = new ArrayList<Player>();
        playing = true;
    }

    /**
     * Runs all the game logic, handles player input, and outputs UI to console to make a run Blackjack game
     */
    public void playGame() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int numPlayers = input.nextInt();
        input.nextLine();
        //Assign Each player a name and deal them their first card from the deck
        for(int i = 0; i < numPlayers; i++) {
            System.out.print("Enter Player " + (i + 1) + "'s name: ");
            String name = input.nextLine();
            playerList.add(new Player(name));
            playerList.get(i).addCard(deck.deal());
        }
        
        //Deal each player an additional card sequentially
        for(Player player : playerList) player.addCard(deck.deal());

        dealer.addCard(deck.deal());
        dealer.addCard(deck.deal());
        
        while(playing) {
            //Each person has a turn to hit or stay now that they see the dealer's hand
            for(Player player : playerList) {
                System.out.println("\n----------" + player + "'s Turn!----------");
                dealer.displayHand();
                System.out.println(player + "'s hand: \n" + player.getHand());
                while(player.getUserChoice().substring(0, 1).toUpperCase().equals("H") && player.getHandValue() < 21) {
                    System.out.println("\nHit!\n");
                    player.addCard(deck.deal());
                    dealer.displayHand();
                    System.out.println(player + "'s hand: \n" + player.getHand());
                    //if player busts or gets blackjack break out of loop without asking to hit or stand
                    if(player.getHandValue() >= 21) break;
                }
                //check outcome of player's turn
                if (player.getHandValue() > 21) {
                    System.out.println("\n" + player + " Busted!");
                } else if (player.getHandValue() == 21) {
                    System.out.println("\n" + player + " Got Blackjack!");
                }
                System.out.println("-----------------------------------\n");
            }
            
            //Once each player has finished their turn, run dealer logic to get cards
            System.out.println("\n----------Dealer's Turn----------");
            while(dealer.shouldGetCard()) {
                System.out.println("Dealer's Hand:\n" + dealer.getHand() + "\n");
                dealer.addCard(deck.deal());
            }
            System.out.println("Dealer's final hand:\n" + dealer.getHand());
            if (dealer.getHandValue() > 21) {
                System.out.println("\nThe Dealer Busted!");
            } else if (dealer.getHandValue() == 21) {
                System.out.println("\nThe Dealer Got Blackjack!");
            }
            System.out.println("---------------------------------\n");
            
            //Now that all turns are completed determine winners and losers
            for(Player player : playerList) {
                //If dealer busts, all players who didn't bust win
                if(dealer.getHandValue() > 21 && player.getHandValue() < 21) {
                    player.winRound();
                } else { //otherwise, compare each players hand to dealers hand and tally up wins
                    if(player.getHandValue() > dealer.getHandValue() && player.getHandValue() <= 21) player.winRound();
                    else dealer.winRound();
                }
            } 
            
            //Print out game results
            System.out.println("\n----------Game Results----------");
            for(Player player : playerList) {
                System.out.println(player + "'s hand:\n" + player.getHand() + "\n");
            }
            System.out.println("Dealer's Hand:\n" + dealer.getHand() + "\n");

            for(Player player : playerList) {
                System.out.println(player + " has won " + player.getWins() + " times!");
            }
            System.out.println("The Dealer has won " + dealer.getWins() + " times!");
            System.out.println("--------------------------------\n");

            //Ask to play again
            System.out.print("Would the table like to play again? (Y/N): ");
            String userDecision = input.nextLine();
            
            //If user doesn't want to play again, break out of the loop and stop playing
            if(userDecision.substring(0, 1).toUpperCase().equals("N")) {
                System.out.println("\nThanks for playing!");
                break;
            }
            //otherwise, reset deck and hands before returning to top of loop to play again
            deck = new Deck(true);
            for(Player player : playerList) {
                player.resetHand();
                player.addCard(deck.deal());
                player.addCard(deck.deal());
            }
            dealer.resetHand();
            dealer.addCard(deck.deal());
            dealer.addCard(deck.deal());
        }
    }

    /**
     * Prints out a banner to introduce the game
     */
    public void displayBanner() {
        System.out.println("----------------------------------------\n" +
        "---                                  ---\n" +
        "---         BLACK JACK GAME!         ---\n" + 
        "---                                  ---\n" + 
        "----------------------------------------");
    }
}

/**
 * Class that represents a Blackjack dealer, who has a hand of cards, and a win counter
 */
class Dealer {
    private Hand hand = new Hand();
    private int wins = 0;

    public void addCard(Card card) {
        hand.addCard(card);
    }

    /**
     * @return true if dealer should get another card based on blackjack rules
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

    /**
     * Prints out the dealers hand to the console, but hides bottom card
     */
    public void displayHand() {
        System.out.println("\nDealer's hand:");
        //Prints all but bottom card
        for (int i = 0; i < hand.getCards().size() - 1; i++) {
            System.out.print("[" + hand.getCards().get(i) + "] ");
        }
        //Signifies that the bottom card is hidden from the user
        System.out.print("[?]\n\n");
    }

    public void winRound() {
        wins++;
    }

    public void resetHand() {
        hand = new Hand();
    }

    /**
     * @return the dealer's number of wins
     */
    public int getWins() {
        return wins;
    }
    
    /**
     * @return the dealer's hand
     */
    public Hand getHand(){
        return hand;
    }
    
    /**
     * @return the dealer's hand value
     */
    public int getHandValue(){
        return hand.getHandValue();
    }
}

/**
 * Class that represents a Blackjack player, who has a hand of cards, a name, and a win counter
 */
class Player {
    private Hand hand = new Hand();
    private String name;
    private int wins;

    /**
     * @param username the name of the player
     */
    public Player(String username) {
        name = username;
    }

    /**
     * Ask user if they want to hit or stay
     * @return the users choice
     */
    public String getUserChoice() {
        Scanner input = new Scanner(System.in);  
        System.out.print("\n(H)it or (S)tay: ");

        return input.nextLine();
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

    public void winRound() {
        wins++;
    }
    
    public void resetHand() {
        hand = new Hand();
    }

    /**
     * @return the player's number of wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * @return the users cards in hand
     */
    public String toString() {
        return name;
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
     * @return point value of the cards in hand, calculates aces to be either 11 or 1 based on total hand value
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
     * @return a string of the cards in the hand listed out and formatted along with the total hand value
     */
    public String toString() {
        String cardString = "";
        for (Card card: cards) {
            cardString += "[" + card + "] ";
        }
        cardString += " (Total Point Value: " + getHandValue() +  ")";
        return cardString;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}

/**
 * Class representing a standard deck of 52 cards, with 4 suits and 12 different faces; each individual card can be accessed by a list of all the cards in the deck
 */
class Deck {
    private ArrayList<Card> cards = new ArrayList<>();
    private String[] suits = {"Clubs", "Hearts", "Spades", "Diamonds"};
    private String suit = suits[0];
    
    /**
     * When a deck is created, fill up the list of cards with 52 cards, makes 12 cards of unique faces 4 times, for each suit of the deck
     */
    public Deck() {
        for (int i = 0; i < suits.length; i++) {
            suit = suits[i];
            for (int f = 1; f <= 13; f++) {
                Card card = new Card(f, suit);
                cards.add(card);
            }
        }
    }
    
    /**
     * Alternate constructor, gives option to shuffle deck right after deck is created so shuffle method doesn't need to be called
     * @param shuffled a boolean that represents whether or not the deck should be shuffled after it is created
     */
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
    
    /**
     * Shuffles the cards around the list randomly by going one by one and swapping each card with another card at a random position in the deck
     */
    public void shuffle() {
        for(int i = cards.size() - 1; i >= 0; i--) {
            int randNum = (int)(Math.random() * i);
            swapCards(i, randNum);
        }
    }
    
    /**
     * Swaps the location of two cards (first and second) in the deck, used in the shuffle method
     * @param firstIndex the index of the first card
     * @param secondIndex the index of the second card
     */
    public void swapCards(int firstIndex, int secondIndex) {
        Card firstCard = cards.get(firstIndex);
        cards.set(firstIndex, cards.get(secondIndex));
        cards.set(secondIndex, firstCard);
    }
    
    /**
     * @return a string that lists out the card's face and suit
     */
    public String toString() {
        String string = "";
        for (Card card:cards) {
            string += card + "\n";
        }
        return string;
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