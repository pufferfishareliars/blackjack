package com.elie.blackjack.models;

import com.elie.blackjack.strategies.BlackjackStrategy;

import java.util.ArrayList;

/**
 * Created by elie on 13/09/16.
 */
public class AbstractPlayer {
    protected ArrayList<Card> hand;
    protected int handValue;
    private BlackjackStrategy strategy;

    AbstractPlayer() {
        hand = new ArrayList<Card>();
        handValue = 0;
    }

    public void setStrategy(BlackjackStrategy newStrategy) {
        this.strategy = newStrategy;
    }

    public boolean shouldHit() {
        return strategy.shouldHit(this.getHandValue());
    }

    public void takeCard(Card card) {
        hand.add(card);
        handValue += card.getValue();
    }

    public int getHandValue() {
        return handValue;
    }

    public String showHand() {
 /*       String handAsString = "";
        for(int i = 0; hand[i] != null; i++) {
            handAsString += hand[i].toString() + " ";
        }
        return handAsString;*/

        return hand.toString();
    }
}
