package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class PokerGame {
    ArrayList<Player> players = new ArrayList<>();
    public int handSize;

    // Create all the players for the game and set the hand size
    public PokerGame(int playerCount, int handSize) {
        if (playerCount != 2) throw new IllegalArgumentException("This poker game requires two players!");
        if (handSize != 5) throw new IllegalArgumentException("There needs to be 5 cards per player");
        for (int i=0; i<playerCount; i++) {
            players.add(new Player("Player " + (i+1)));
        }
        this.handSize = handSize;
    }

    public void dealCards(String cardsAsString) throws InvalidGameString {

        // Clear all hands from previous game
        for (Player player : players) player.clearHand();

        // Take a string of cards from the txt file, split it into individual cards
        ArrayList<String> cards = new ArrayList<>(Arrays.asList(cardsAsString.split(" ")));
        if (cards.size() != players.size() * handSize) {
            throw new InvalidGameString(
                    "The game string is either invalid or it does not contain " +
                            "the right amount of cards for this many players."
            );
        }

        // For each player, deal the next (handSize) amount of cards before dealing to the next player
        for (int i=0; i<players.size(); i++) {
            for (int j=handSize*i; j<handSize*(i+1); j++) {
                players.get(i).addCard(cards.get(j));
            }
        }
    }

    public void playRound(String cardsAsString) throws InvalidGameString {
        // Create a dummy player to compare to later in order to find a winner
        Player winner = null;
        int winningRank = 0;

        // Deal out the cards
        dealCards(cardsAsString);

        // Decide who won the round
        for (Player player : players) {
            // check for which player had the highest ranking hand
            if (player.evaluateHand() > winningRank) {
                winner = player;
                winningRank = player.evaluateHand();
            } else if (player.evaluateHand() == winningRank) {
                // if the highest ranking hand is a tie, the winner is the player with the highest card value in hand
                for (int i=handSize-1; i>=0; i--) {
                    if (winner != null && player.hand.get(i).faceValue > winner.hand.get(i).faceValue) {
                        winner = player;
                        winningRank = player.evaluateHand();
                        break;
                    } else if (winner != null && player.hand.get(i).faceValue < winner.hand.get(i).faceValue) {
                        break;
                    }
                }
            }
        }

        // add a victory to the winner's total
        if (winner != null) winner.addVictory();
    }
}
