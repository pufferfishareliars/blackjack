package com.elie.blackjack.models;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.elie.blackjack.models.Card.*;
import static org.junit.Assert.*;

/**
 * Created by elie on 05/09/16.
 */
public class DeckTest {
    @Test
    public void testSimpleDeal() {
        Deck deck = new Deck();
        Card dealtCard = deck.deal();
        assertTrue(dealtCard.rank != null);
        assertTrue(dealtCard.getValue() >= 2 && dealtCard.getValue() <= 11);
    }

    @Test
    public void testDealRemovesCardFromDeck() {
        Deck deck = new Deck();
        deck.deal();
        int expectedCardsLeft = 51;
        assertEquals(expectedCardsLeft, deck.howManyRemaining());
    }

    @Test
    public void testAllDealsNoRepeatCards() {
        Deck deck = new Deck();
        Card dealtCard;
        Map<Suit, Rank[]> cardChecklist = new HashMap<Suit, Rank[]>();
        // put the four suits in the checklist
        /*cardChecklist.put(Card.Suit.HEART, new Rank[12] {
            Rank.values();
        });*/
        cardChecklist.put(Card.Suit.DIAMOND, new Rank[12]);
        cardChecklist.put(Card.Suit.SPADE, new Rank[12]);
        cardChecklist.put(Card.Suit.CLUB, new Rank[12]);

/*        for(int i = 0; i < 52; i++) {
            dealtCard = deck.deal();
            short[] ranks = cardChecklist.get(dealtCard.suit);
            ranks[dealtCard.getValue()];
        }*/
    }

    @Test
    public void testDealOneCardOfOneCardDeckMakesItEmpty() {
        // set up the data
        Rank rankExpected = Rank.KING;
        Suit suitExpected = Suit.DIAMOND;
        Deck deck = new Deck(new Card[] {new Card(suitExpected, rankExpected)});
        assertFalse(deck.isEmpty());
        // deal one card
        Card dealtCard = deck.deal();
        // make sure the deck is now empty
        assertTrue(deck.isEmpty());
        // make sure the dealt card is what we expect it to be
        assertEquals(rankExpected, dealtCard.rank);
        assertEquals(suitExpected, dealtCard.suit);
    }

    @Test
    public void testShuffle() {
        boolean atLeastOneDifference = false;

        Deck deck = new Deck();
        deck.shuffle();
        // first to compare
        Deck deck1 = new Deck(deck);

        deck = new Deck();
        deck.shuffle();
        // second to compare
        Deck deck2 = new Deck(deck);

        deck = new Deck();
        deck.shuffle();
        // third to compare
        Deck deck3 = new Deck(deck);

        Card card1;
        Card card2;
        Card card3;
        while(!deck1.isEmpty()) {
            card1 = deck1.deal();
            card2 = deck2.deal();
            card3 = deck3.deal();

            if(!card1.equals(card2) ||
                    !card1.equals(card3) ||
                    !card2.equals(card3)) {
                atLeastOneDifference = true;
            }
        }

        assertTrue(atLeastOneDifference);
    }
}