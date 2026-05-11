package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deck deck = new Deck();
        deck.shuffle();

        System.out.println("--- Welcome to Blackjack ---");

        System.out.print("How many players? ");
        int playerCount = scanner.nextInt();
        scanner.nextLine();

        ArrayList<String> playerNames = new ArrayList<>();
        ArrayList<Hand> playerHands = new ArrayList<>();

        for (int i = 0; i < playerCount; i++) {

            System.out.print("Enter player " + (i + 1) + " name: ");
            String name = scanner.nextLine();

            playerNames.add(name);

            Hand hand = new Hand();

            hand.addCard(deck.deal());
            hand.addCard(deck.deal());

            playerHands.add(hand);
        }

        for (int i = 0; i < playerHands.size(); i++) {

            Hand playerHand = playerHands.get(i);
            String userName = playerNames.get(i);

            boolean playerTurn = true;

            while (playerTurn) {

                System.out.println("\n" + userName + "'s Hand:");
                playerHand.showHand();

                if (playerHand.calculateTotal() > 21) {

                    System.out.println("BUST! You went over 21.");
                    break;
                }

                System.out.print("Hit or Stay (h/s): ");
                String action = scanner.nextLine().trim().toLowerCase();

                if (action.equals("h")) {

                    Card dealtCard = deck.deal();

                    if (dealtCard != null) {

                        playerHand.addCard(dealtCard);

                    } else {

                        System.out.println("No more cards in the deck!");
                        playerTurn = false;
                    }

                } else if (action.equals("s")) {

                    playerTurn = false;

                } else {

                    System.out.println("Invalid input. Please type 'h' to Hit or 's' to Stay.");
                }
            }
        }

        int winningScore = 0;
        String winner = "";

        System.out.println("\n--- Final Scores ---");

        for (int i = 0; i < playerHands.size(); i++) {

            int total = playerHands.get(i).calculateTotal();

            System.out.println(playerNames.get(i) + ": " + total);

            if (total <= 21 && total > winningScore) {

                winningScore = total;
                winner = playerNames.get(i);
            }
        }

        if (winner.equals("")) {

            System.out.println("Everyone busted.");

        } else {

            System.out.println("Winner: " + winner);
        }

        System.out.println("Thanks for playing!");
    }
}