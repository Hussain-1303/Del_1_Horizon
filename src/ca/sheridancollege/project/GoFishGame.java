/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GoFishGame {

    public static final int NUM_PLAYERS = 2;
    public static final int MAX_RANK = 13;
    public static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private static final int NUM_CARDS_TO_START = 5;

    private final Deck deck;
    private final Player[] players;
    private final Scanner scanner;

    public GoFishGame() {
        deck = new Deck();
        players = new Player[NUM_PLAYERS];
        scanner = new Scanner(System.in);
    }

    public void initializeGame() {
    for (int i = 0; i < NUM_PLAYERS; i++) {
        if (i == 0) {
            players[i] = new Player1(new ArrayList<>());
        } else {
            players[i] = new Player2(new ArrayList<>());
        }
        for (int j = 0; j < GoFishGame.NUM_CARDS_TO_START; j++) {
            players[i].addToHand(deck.drawCard());
        }
    }
}

    public void playGame() {
        initializeGame();
        int currentPlayer = 0;
        while (deck.getNumberOfCards() > 0) {
            displayPlayerHand(currentPlayer);
            int opponent = (currentPlayer + 1) % NUM_PLAYERS;
            String rank = askForCard(currentPlayer);
            if (players[opponent].hasCard(rank)) {
                System.out.println("You received a " + rank + " from the opponent.");
                players[currentPlayer].addToHand(rank);
                players[opponent].removeCard(rank);
                players[currentPlayer].checkForBooks();
            } else {
                System.out.println("Go Fish! You draw a card from the deck.");
                String drawnCard = deck.drawCard();
                players[currentPlayer].addToHand(drawnCard);
                players[currentPlayer].checkForBooks();
                currentPlayer = opponent;
            }
        }
        System.out.println("Game over! All cards have been collected.");
    }

    private void displayPlayerHand(int playerIndex) {
        System.out.print("Player " + playerIndex + "'s hand: ");
        players[playerIndex].viewHand();
    }

    private String askForCard(int playerIndex) {
        System.out.print("Player " + playerIndex + ", ask opponent for which card? ");
        return scanner.next();
    }

    public static void main(String[] args) {
        GoFishGame game = new GoFishGame();
        game.playGame();
    }
}
