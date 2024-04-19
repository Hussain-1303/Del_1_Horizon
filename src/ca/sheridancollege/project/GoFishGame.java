/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;
import java.util.List;


/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GoFishGame {
    public static final int NUM_CARDS_TO_START = 5;
    public static final int NUM_PLAYERS = 2;
    public static final int MAX_RANK = 13;
    public static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    private final Deck deck;
    private final Player[] players;

    public GoFishGame() {
        deck = new Deck();
        players = new Player[NUM_PLAYERS];
        players[0] = new HumanPlayer();
        players[1] = new ComputerPlayer();
    }

    public void playGame() {
        dealInitialCards();
        int currentPlayer = 0;
        while (!deckIsEmpty()) {
            int opponent = (currentPlayer + 1) % NUM_PLAYERS;
            String rank = players[currentPlayer].askForCard();
            if (players[opponent].hasCard(rank)) {
                System.out.println("You received a " + rank + " from the opponent.");
                String receivedCard = players[opponent].removeCard(rank);
                players[currentPlayer].addToHand(receivedCard);
                checkForBooks(currentPlayer);
            } else {
                System.out.println("Go Fish! You draw a card from the deck.");
                String drawnCard = deck.drawCard();
                if (drawnCard != null) {
                    players[currentPlayer].addToHand(drawnCard);
                    checkForBooks(currentPlayer);
                }
                currentPlayer = opponent;
            }
        }
        System.out.println("Game over! All cards have been collected.");
    }

    private void dealInitialCards() {
        for (Player player : players) {
            for (int i = 0; i < NUM_CARDS_TO_START; i++) {
                String card = deck.drawCard();
                if (card != null) {
                    player.addToHand(card);
                }
            }
        }
    }

    private boolean deckIsEmpty() {
        return deck.getNumberOfCards() == 0;
    }

    private void checkForBooks(int playerIndex) {
        Player player = players[playerIndex];
        List<String> hand = player.getHand();
        for (String rank : RANKS) {
            long count = hand.stream().filter(card -> card.equals(rank)).count();
            if (count == 4) {
                System.out.println("Congratulations! You have a book of " + rank + "s.");
                hand.removeIf(card -> card.equals(rank));
            }
        }
    }

    public static void main(String[] args) {
        GoFishGame game = new GoFishGame();
        game.playGame();
    }
}

