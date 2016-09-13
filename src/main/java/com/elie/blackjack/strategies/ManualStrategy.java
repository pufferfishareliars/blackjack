package com.elie.blackjack.strategies;

import java.util.Scanner;

/**
 * This strategy asks the user explicitly what they would like to do.
 */
public class ManualStrategy implements BlackjackStrategy {
    private Scanner userInput;

    /**
     * Default constructor.
     */
    public ManualStrategy() {
        userInput = new Scanner(System.in);
    }

    /**
     * Prompts user to ask if they would like another card.
     * @return
     */
    public boolean shouldHit(int handValue) {
        boolean askAgain = false;
        do {
            System.out.print("Would you like another card? (y/n)\n> ");
            String userInString = userInput.nextLine();
            userInString = userInString.trim().toLowerCase();
            if (userInString.equals("y")) {
                return true;
            } else if (userInString.equals("n")) {
                return false;
            } else {
                System.out.println("Please input y for yes and n for no only.");
                askAgain = true;
            }
        } while(askAgain);
        return askAgain; // need this to squash error/warning, but how else to do it?...
    }
}
