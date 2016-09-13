package com.elie.blackjack.models;

/**
 * Created by elie on 13/09/16.
 */
public class Dealer extends AbstractPlayer {
    public String showTopCard() {
        return hand.get(0).toString();
    }
}
