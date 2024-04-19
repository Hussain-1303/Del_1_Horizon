/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;
import java.util.List;
import java.util.Collections;


/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Player {
    protected List<String> hand;

    public Player(List<String> initialHand) {
        hand = initialHand;
    }

    public void addToHand(String card) {
        hand.add(card);
    }

    public boolean hasCard(String card) {
        return hand.contains(card);
    }

    public void removeCard(String card) {
        hand.remove(card);
    }

    public void viewHand() {
        for (String card : hand) {
            System.out.print(card + " ");
        }
        System.out.println();
    }

    public void checkForBooks() {
        for (String rank : GoFishGame.RANKS) {
            int count = Collections.frequency(hand, rank);
            if (count == 4) {
                System.out.println("Congratulations! Player has a book of " + rank + "s.");
                hand.removeAll(Collections.singleton(rank));
            }
        }
    }
}
