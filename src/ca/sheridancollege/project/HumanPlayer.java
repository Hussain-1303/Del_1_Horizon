/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.Scanner;

/**
 *
 * @author blessedguy
 */
public class HumanPlayer extends Player {
    private final Scanner scanner;

    public HumanPlayer() {
        super();
        scanner = new Scanner(System.in);
    }

    @Override
    public String askForCard() {
        System.out.print("Ask opponent for which card? ");
        return scanner.next();
    }
}
