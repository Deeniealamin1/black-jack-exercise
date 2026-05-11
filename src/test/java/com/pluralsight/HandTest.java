package com.pluralsight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HandTest {

    @Test
    public void testAddCard() {

        Hand hand = new Hand();

        int before = hand.calculateTotal();

        hand.addCard(new Card(Suit.HEARTS, Value.FIVE));

        int after = hand.calculateTotal();

        assertEquals(before + 5, after);
    }

    @Test
    public void testBlackjackTotal() {

        Hand hand = new Hand();

        hand.addCard(new Card(Suit.HEARTS, Value.KING));
        hand.addCard(new Card(Suit.SPADES, Value.ACE));

        int total = hand.calculateTotal();

        assertEquals(21, total);
    }

    @Test
    public void testAceAdjustment() {

        Hand hand = new Hand();

        hand.addCard(new Card(Suit.HEARTS, Value.ACE));
        hand.addCard(new Card(Suit.SPADES, Value.ACE));
        hand.addCard(new Card(Suit.CLUBS, Value.KING));

        int total = hand.calculateTotal();

        assertEquals(12, total);
    }
}