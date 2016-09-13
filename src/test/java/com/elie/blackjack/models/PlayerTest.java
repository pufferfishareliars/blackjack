package com.elie.blackjack.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.elie.blackjack.models.Card.*;

/**
 * Created by elie on 14/09/16.
 */
public class PlayerTest {
    AbstractPlayer player;

    @Before
    public void setUp() throws Exception {
        player = new Player();
    }

    @After
    public void tearDown() throws Exception {
        player = null;
    }

    @Test
    public void testShowHand() throws Exception {
        // set up data
        Rank rankExpected = Rank.ACE;
        Suit suitExpected = Suit.DIAMOND;
        String expectedShownHand = "ACE of DIAMONDS";

        // perform the action
        player.takeCard(new Card(suitExpected, rankExpected));
        String shownHand = player.showHand();

        assertEquals(expectedShownHand, shownHand);
    }

    @Test
    public void getHandValue() throws Exception {

    }

    @Test
    public void showHand() throws Exception {

    }

}