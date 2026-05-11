package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {

        cards = new ArrayList<>();

        for (Suit s : Suit.values()) {

            for (Value v : Value.values()) {

                cards.add(new Card(s, v));
            }
        }
    }

    public void shuffle() {

        Collections.shuffle(cards);
    }

    public Card deal() {

        if (cards.size() > 0) {

            return cards.remove(0);
        }

        return null;
    }

    public int getSize() {

        return cards.size();
    }
}