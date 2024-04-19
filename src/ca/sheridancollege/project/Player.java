/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;
import java.util.List;
import java.util.ArrayList;


/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Player {
    protected List<String> hand;

    public Player() {
        hand = new ArrayList<>();
    }

    public void addToHand(String card) {
        hand.add(card);
    }

    public List<String> getHand() {
        return hand;
    }

    public boolean hasCard(String card) {
        return hand.contains(card);
    }

    public String removeCard(String card) {
        if (hand.contains(card)) {
            hand.remove(card);
            return card;
        }
        return null;
    }

    public abstract String askForCard();

    public void viewHand() {
        System.out.println("Your hand:");
        for (String card : hand) {
            System.out.print(card + " ");
        }
        System.out.println();
    }
}

