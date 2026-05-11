package com.pluralsight;

public class Card {

    private Suit suit;
    private Value value;
    private boolean isFaceUp;

    public Card(Suit suit, Value value) {

        this.suit = suit;
        this.value = value;
        this.isFaceUp = false;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    public int getPointValue() {

        if (isFaceUp) {

            if (value == Value.KING || value == Value.QUEEN || value == Value.JACK || value == Value.TEN) {

                return 10;

            } else if (value == Value.ACE) {

                return 11;

            } else {

                // Maps enum order to numeric value (TWO is index 0, so +2 = 2)
                return value.ordinal() + 2;
            }

        } else {

            return 0;
        }
    }

    public boolean isFaceUp() {

        return isFaceUp;
    }

    public void flip() {

        isFaceUp = !isFaceUp;
    }

    @Override
    public String toString() {

        if (isFaceUp) {

            return value + " of " + suit;

        } else {

            return "Hidden Card";
        }
    }
}