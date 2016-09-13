package com.elie.blackjack;

import com.elie.blackjack.models.Dealer;
import com.elie.blackjack.models.Deck;
import com.elie.blackjack.models.Player;
import com.elie.blackjack.strategies.DealerStrategy;
import com.elie.blackjack.strategies.ManualStrategy;
import com.elie.blackjack.utility.Wait;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String playAgainInput = null;
        String playAgainToken = "y";
        Scanner input = new Scanner(System.in);
        do {
            int playerWins = playBlackjack();
            if (playerWins == 1) {
                System.out.println("Congratulations, you won!");
            } else if (playerWins == 0) {
                System.out.println("At least you didn't lose your money");
            } else {
                System.out.println("Sorry, you lost... :(");
            }
            System.out.println("Play again? (y/n)");
            System.out.print("> ");
            playAgainInput = input.nextLine();
        } while(playAgainInput.equals(playAgainToken));

        System.out.println("Thanks for playing Elie's Blackjack");
        input.close();
    }

    /**
     * Returns 1 if player wins, 0 if player ties, and -1 if player loses
     * @return
     */
    public static int playBlackjack() {
        // initialize user input
        Scanner input = new Scanner(System.in);

        // initialize the deck
        Deck deck = new Deck();
        deck.shuffle();
        // create player
        Player player = new Player();
        player.setStrategy(new ManualStrategy());
        // create dealer
        Dealer dealer = new Dealer();
        dealer.setStrategy(new DealerStrategy());

        // deal to player and dealer
        player.takeCard(deck.deal());
        dealer.takeCard(deck.deal());
        player.takeCard(deck.deal());
        dealer.takeCard(deck.deal());

        // show hands
        System.out.println("Player hand: " + player.showHand());
        System.out.println("Player has: " + player.getHandValue());
        System.out.println("Dealer shows a " + dealer.showTopCard());
        System.out.println("================================================");

        // check for blackjacks
        if(player.getHandValue() == 21 && dealer.getHandValue() == 21) {
            System.out.println("Player shows blackjack: " + player.showHand());
            System.out.println("Dealer shows blackjack: " + dealer.showHand());
            System.out.println("Push on 21...sorry!");
            return 0;
        } else if(player.getHandValue() == 21) {
            System.out.println("Player has blackjack: " + player.showHand());
            return 1;
        }else if (dealer.getHandValue() == 21) {
            System.out.println("Dealer has blackjack: " + dealer.showHand());
            return -1;
        }
        // if not, ask if player wants to hit
        while(player.shouldHit()) {
            // if hit, give player another card
            player.takeCard(deck.deal());
            System.out.println("Player hand: " + player.showHand());
            System.out.println("Player has: " + player.getHandValue());
            // check if players busts (hand over 21)
            if(player.getHandValue() > 21) {
                System.out.println("Player busts with " + player.getHandValue());
                return -1;
            }
        }
        // Player action done and hasn't busted
        System.out.println("Dealer shows a " + dealer.showHand());
        // dealer hits until it shouldn't as defined by the dealer's strategy
        // blackjack rules are that dealers hit until their hand value is > 17
        while(dealer.shouldHit()) {
            dealer.takeCard(deck.deal());
            Wait.oneSec();
            System.out.println("Dealer hits");
            Wait.waitSec(2);
            System.out.println("Dealer hand: " + dealer.showHand());
            if(dealer.getHandValue() > 21) {
                System.out.println("Dealer busts with " + dealer.getHandValue());
                return 1;
            }
        }
        System.out.println("Player hand: " + player.getHandValue());
        System.out.println("Dealer hand: " + dealer.getHandValue());
        // neither dealer and player have busted
        // if player value > dealer value, player wins
        if(player.getHandValue() > dealer.getHandValue()) {
            System.out.println("Player beats dealer");
            return 1;
        } else if (player.getHandValue() == dealer.getHandValue()) {
            System.out.println("Player and dealer push");
            // if player value = dealer value, push
            return 0; // TODO - deal with pushes...it's not a loss
        } else {
            // else (player value < dealer value), dealer wins
            return -1;
        }
    }
}
