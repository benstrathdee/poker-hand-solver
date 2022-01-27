package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Player {
    public String name;
    public ArrayList<Card> hand = new ArrayList<Card>();
    public short victories = 0;

    // Takes a card as a string and creates a new card object, adds it to the player's hand
    public void addCard(String cardAsString) {
        Card card = new Card(cardAsString.toCharArray()[0], cardAsString.toCharArray()[1]);
        hand.add(card);
    }

    // Empties the player's hand for a new round
    public void clearHand() {
        hand.clear();
    }

    // Sorts the player's hand by face value, then suit value for ease of evaluation
    public void sortHand() {
        hand.sort(new CardComparator());
    }

    public int evaluateHand() {
        String straight = "234567891011121314";
        int rank = 1;

        // Sort for easier evaluation
        sortHand();

        // Note: rank is (rank number from the specs) * 20 + (value of top card in rank)
        // This allows for easier comparison when there is a tie between ranks

//        // Checking for flushes, royal flushes, and straight flushes
//        // Push all ordered face values to a string builder
//        StringBuilder handValuesString = new StringBuilder();
//        for (Card card : hand) {
//            handValuesString.append(card.faceValue);
//        }
//        // Check if all the cards are of the same suit
//        if (hand.stream().allMatch(card -> card.suitValue == hand.get(0).suitValue)) {
//            // Check if they're also in consecutive order, if not it's just a flush
//            if (straight.contains(handValuesString)) {
//                // Check if it's a royal flush, if not it's just a straight flush
//                if (hand.get(hand.size()-1).faceValue == 14) {
//                    rank = 200;
//                } else {
//                    rank = 180 + hand.get(hand.size()-1).faceValue;
//                }
//            } else {
//                rank = 120 + hand.get(hand.size()-1).faceValue;
//            }
//        }
//        // Finally, if it didn't match the rest, check if they're an ordinary straight
//        if (rank == 1 && straight.contains(handValuesString)) {
//            rank = 100 + hand.get(hand.size()-1).faceValue;
//        }
//
//        // Checking for multiple cards of the same value
//        if (rank == 1) {
//            ArrayList<Byte> handValuesArray = hand.stream()
//                    .map(card -> card.faceValue)
//                    .collect(Collectors.toCollection(ArrayList::new));
//            ArrayList<Byte> repeatedValuesArray = handValuesArray.stream()
//                    .filter(cardValue -> handValuesArray.indexOf(cardValue) != handValuesArray.lastIndexOf(cardValue))
//                    .collect(Collectors.toCollection(ArrayList::new));
//            if (repeatedValuesArray.size() == 2) {
//                rank = 40 + repeatedValuesArray.get(repeatedValuesArray.size()-1);
//            } else if (repeatedValuesArray.size() == 3) {
//                rank = 80 + repeatedValuesArray.get(repeatedValuesArray.size()-1);
//            } else if (repeatedValuesArray.size() == 4) {
//                if (repeatedValuesArray.get(0) == repeatedValuesArray.get(3)) {
//                    rank = 160 + repeatedValuesArray.get(repeatedValuesArray.size()-1);
//                } else {
//                    rank = 60 + repeatedValuesArray.get(repeatedValuesArray.size()-1);
//                }
//            } else if (repeatedValuesArray.size() == 5) {
//                rank = 140 + repeatedValuesArray.get(repeatedValuesArray.size()-1);
//            }
//        }

        // Preparing a string for comparison for straights
        StringBuilder handValuesString = new StringBuilder();
        for (Card card : hand) {
            handValuesString.append(card.faceValue);
        }
        // Preparing an array of repeated values for the other checks
        ArrayList<Byte> handValuesArray = hand.stream()
                .map(card -> card.faceValue)
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Byte> repeatedValuesArray = handValuesArray.stream()
                .filter(cardValue -> handValuesArray.indexOf(cardValue) != handValuesArray.lastIndexOf(cardValue))
                .collect(Collectors.toCollection(ArrayList::new));

        // rank 10 - royal flush
        // If all cards share suit AND are consecutive values AND the last card is an Ace
        if (hand.stream().allMatch(card -> card.suitValue == hand.get(0).suitValue
                && straight.contains(handValuesString)
                && hand.get(hand.size()-1).faceValue == 14)) {
            rank = 200;
            return rank;
        }

        // rank 9 - straight flush
        // If all cards share a suite AND are consecutive values
        if (hand.stream().allMatch(card -> card.suitValue == hand.get(0).suitValue
                && straight.contains(handValuesString))) {
            rank = 180 + hand.get(hand.size()-1).faceValue;
            return rank;
        }

        // rank 8 - four of a kind
        // If there are four repeating values
        if (repeatedValuesArray.size() == 4
                && repeatedValuesArray.get(0) == repeatedValuesArray.get(3)) {
            rank = 160 + repeatedValuesArray.get(repeatedValuesArray.size()-1);
            return rank;
        }

        // rank 7 - full house
        // If there are 5 repeated values, they have to be a pair and a triple
        if (repeatedValuesArray.size() == 5) {
            rank = 140 + repeatedValuesArray.get(repeatedValuesArray.size()-1);
            return rank;
        }

        // rank 6 - flush
        // If all cards share the same suit
        if (hand.stream().allMatch(card -> card.suitValue == hand.get(0).suitValue)) {
            rank = 120 + hand.get(hand.size()-1).faceValue;
            return rank;
        }

        // rank 5 - straight
        // If all cards are consecutively ordered
        if (rank == 1 && straight.contains(handValuesString)) {
            rank = 100 + hand.get(hand.size()-1).faceValue;
            return rank;
        }

        // rank 4 - three of a kind
        // If there are three repeating values
        if (repeatedValuesArray.size() == 3) {
            rank = 80 + repeatedValuesArray.get(repeatedValuesArray.size()-1);
            return rank;
        }

        // rank 3 - two pairs
        // If there are four repeated values, but they're not all the same
        if (repeatedValuesArray.size() == 4) {
            rank = 60 + repeatedValuesArray.get(repeatedValuesArray.size()-1);
            return rank;
        }

        // rank 2 - single pair
        // If there are two repeated values
        if (repeatedValuesArray.size() == 2) {
            rank = 40 + repeatedValuesArray.get(repeatedValuesArray.size()-1);
            return rank;
        }

        // rank 1 - default
        // No other conditions met
        return rank;
    }

    public void addVictory() {
        this.victories ++;
    }

    @Override
    public String toString() {
        return String.format("%s: %d", name, victories);
    }

    public Player(String name) {
        this.name = name;
    }
}