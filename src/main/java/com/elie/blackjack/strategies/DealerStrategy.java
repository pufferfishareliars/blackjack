package com.elie.blackjack.strategies;

import java.util.List;

/**
 * Created by elie on 15/09/16.
 */
public class DealerStrategy implements BlackjackStrategy {

    public DealerStrategy() {
    }

    public boolean shouldHit(int handValue) {
        return handValue < 17;
    }
}
