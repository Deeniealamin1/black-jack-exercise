package com.pluralsight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    @Test
    public void testDeckSize() {

        Deck deck = new Deck();

        assertEquals(52, deck.getSize());
    }

    @Test
    public void testDealReducesSize() {

        Deck deck = new Deck();

        int before = deck.getSize();

        deck.deal();

        int after = deck.getSize();

        assertEquals(before - 1, after);
    }
}