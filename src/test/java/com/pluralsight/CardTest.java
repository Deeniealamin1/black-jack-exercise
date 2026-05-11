package com.pluralsight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void testFlip() {

        Card card = new Card(Suit.HEARTS, Value.ACE);

        boolean before = card.isFaceUp();

        card.flip();

        boolean after = card.isFaceUp();

        assertNotEquals(before, after);
    }

    @Test
    public void testPointValueFaceDown() {

        Card card = new Card(Suit.HEARTS, Value.KING);

        assertEquals(0, card.getPointValue());
    }

    @Test
    public void testPointValueFaceUp() {

        Card card = new Card(Suit.DIAMONDS, Value.TEN);

        card.flip();

        int value = card.getPointValue();

        assertEquals(10, value);
    }
}