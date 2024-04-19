/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class Deck {
    private List<String> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for (int i = 0; i < GoFishGame.MAX_RANK; i++) {
            for (int j = 0; j < GoFishGame.NUM_PLAYERS; j++) {
                cards.add(GoFishGame.RANKS[i]);
            }
        }
        Collections.shuffle(cards);
    }

    public String drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }

    public int getNumberOfCards() {
        return cards.size();
    }
}
