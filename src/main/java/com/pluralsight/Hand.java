package com.pluralsight;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;

    public Hand() {

        cards = new ArrayList<>();
    }

    public void addCard(Card card) {

        cards.add(card);
    }

    public int calculateTotal() {

        int total = 0;
        int aces = 0;

        for (Card card : cards) {

            card.flip();

            total += card.getPointValue();

            if (card.getValue() == Value.ACE) {

                aces++;
            }

            card.flip();
        }

        while (total > 21 && aces > 0) {

            total -= 10;
            aces--;
        }

        return total;
    }

    public void showHand() {

        for (Card card : cards) {

            card.flip();

            System.out.println("  -> " + card.toString());

            card.flip();
        }

        System.out.println("Current Total: " + calculateTotal());
    }
}