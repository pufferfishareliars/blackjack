package com.elie.blackjack.models;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.elie.blackjack.models.Card.Suit;
import static com.elie.blackjack.models.Card.Rank;

/**
 * Created by elie on 05/09/16.
 */
public class CardTest {
    @Test
    public void testKingGetValue() {
        Card kingCard = new Card(Suit.CLUB, Rank.KING);
        int kingExpectedValue = 10;
        assertEquals(kingExpectedValue, kingCard.getValue());
    }

    @Test
    public void testAceGetValue() {
        Card aceCard = new Card(Suit.DIAMOND, Rank.ACE);
        int aceExpectedValue = 11;
        assertEquals(aceExpectedValue, aceCard.getValue());
    }

    @Test
    public void testSevenGetValue() {
        Card sevenCard = new Card(Suit.SPADE, Rank.SEVEN);
        int sevenExpectedValue = 7;
        assertEquals(sevenExpectedValue, sevenCard.getValue());
    }

    @Test
    public void testAllCardCreationDoesntThrowException() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card tempCard = new Card(suit, rank);
            }
        }
    }

    @Test
    public void testToString() {
        Card card = new Card(Suit.SPADE, Rank.KING);
        String cardAsString = card.toString();
        String cardAsStringExpected = "KING of SPADES";
        assertEquals(cardAsStringExpected, cardAsString);
    }

    @Test
    public void testEqualsWhenAre() {
        Card card1 = new Card(Suit.HEART, Rank.NINE);
        Card card2 = new Card(Suit.HEART, Rank.NINE);
        assertTrue(card1.equals(card2));
    }

    @Test
    public void testEqualsWhenNot() {
        Card card1 = new Card(Suit.CLUB, Rank.NINE);
        Card card2 = new Card(Suit.CLUB, Rank.KING);
        assertFalse(card1.equals(card2));
    }
}