package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class PokerGame {
    ArrayList<Player> players = new ArrayList<>();
    public byte handSize;

    // Create all the players for the game and set the hand size
    public PokerGame(byte playerCount, byte handSize) {
        if (playerCount <= 0) throw new IllegalArgumentException("A poker game needs more players than that!");
        if (handSize < 5) throw new IllegalArgumentException("You need at least 5 cards in a hand!");
        for (byte i=0; i<playerCount; i++) {
            players.add(new Player(String.format("Player %d", i+1)));
        }
        this.handSize = handSize;
    }

    public void playRound(String cardsAsString) throws InvalidGameString {
        // Create a dummy player to compare to later in order to find a winner
        Player winner = null;
        int winningRank = 0;

        // Clear all hands from previous game
        for (Player player : players) player.clearHand();

        // Take a string of cards from the txt file, split it into individual cards
        ArrayList<String> cards = new ArrayList<>(Arrays.asList(cardsAsString.split(" ")));
        if (cards.size() != players.size() * handSize) {
            throw new InvalidGameString(
                    "The game string either is invalid or does not contain the right amount of cards."
            );
        }

        // For each player, deal the next (handSize) amount of cards before dealing to the next player
        for (int i=0; i<players.size(); i++) {
            for (int j=handSize*i; j<handSize*(i+1); j++) {
                players.get(i).addCard(cards.get(j));
            }
        }

        for (Player player : players) {
            player.sortHand();
            // check for which player had the highest ranking hand
            if (player.evaluateHand() > winningRank) {
                winner = player;
                winningRank = player.evaluateHand();
            } else if (player.evaluateHand() == winningRank) {
                // if the highest ranking hand is a tie, the winner is the player with the highest card value in hand
                for (int i=handSize-1; i>=0; i--) {
                    if (player.hand.get(i).faceValue > winner.hand.get(i).faceValue) {
                        winner = player;
                        winningRank = player.evaluateHand();
                        break;
                    } else if (player.hand.get(i).faceValue < winner.hand.get(i).faceValue) {
                        break;
                    }
                }
            }
        }

        // add a victory to the winner's total
        winner.addVictory();
    }
}
