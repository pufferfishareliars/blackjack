package com.elie.blackjack.models;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static com.elie.blackjack.models.Card.*;
/**
 * Created by elie on 04/09/16.
 */
public class Deck {
    private Card[] cards;
    private int topCardPointer;

    public Deck() {
        cards = new Card[52];
        topCardPointer = 0;

        for(Suit suit : Suit.values()) {
            for(Rank rank : Rank.values()) {
                cards[topCardPointer++] = new Card(suit, rank);
            }
        }
        // topCardPointer will be the length of the cards array + 1
        assert topCardPointer == 52;
    }

    public Deck(Deck deck) {
        cards = new Card[52];
        topCardPointer = 0;
        for(; topCardPointer < 52; topCardPointer++) {
            cards[topCardPointer] = deck.deal();
        }
    }

    public Deck(Card[] cards) {
        int numCards = cards.length;
        this.cards = cards;
        topCardPointer = numCards; // preserve invariant as above that topCardPointer = length + 1
    }

    public void shuffle() {
        Random randomGen = new Random();
        int index = cards.length - 1;
        // swap card at index with random card in un-touched list
        for(int i = index; i > 0; i--) {
            int toSwap = randomGen.nextInt(i);
            Card temp = cards[toSwap];
            cards[toSwap] = cards[i];
            cards[i] = temp;
        }
    }

    public Card deal() {
        if(this.isEmpty()) {
            return null;
        } else {
            return cards[--topCardPointer];
        }
    }

    public boolean isEmpty() {
        return topCardPointer == 0;
    }

    public int howManyRemaining() {
        return topCardPointer;
    }
}
