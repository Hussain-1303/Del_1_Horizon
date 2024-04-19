/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.Random;

/**
 *
 * @author blessedguy
 */
public class ComputerPlayer extends Player {

    public ComputerPlayer() {
        super();
    }

    @Override
    public String askForCard() {
        Random rand = new Random();
        return hand.get(rand.nextInt(hand.size()));
    }
}
