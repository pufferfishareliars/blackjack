package com.elie.blackjack.models;

/**
 * Created by elie on 04/09/16.
 */
public class Card {
    public enum Suit {
        HEART,
        CLUB,
        DIAMOND,
        SPADE;
    }

    public enum Rank {
        ACE(11),
        KING(10),
        QUEEN(10),
        JACK(10),
        TEN(10),
        NINE(9),
        EIGHT(8),
        SEVEN(7),
        SIX(6),
        FIVE(5),
        FOUR(4),
        THREE(3),
        TWO(2);

        private int rankValue;

        Rank(int value) {
            this.rankValue = value;
        }

        public int getValue() {
            return this.rankValue;
        }
    }

    public final Suit suit;
    public final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue() {
        return rank.getValue();
    }

    public String toString() {
        return rank.toString() + " of " + suit.toString() + "S";
    }

    public boolean equals(Card cardToCompare) {
        if(cardToCompare.rank == this.rank && cardToCompare.suit == this.suit) {
            return true;
        } else {
            return false;
        }
    }
}
