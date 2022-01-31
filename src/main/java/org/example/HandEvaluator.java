package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public final class HandEvaluator {
    static String straight = "234567891011121314";
    static int rankInterval = 20;
    static int defaultRank = 1;


    // Sorts the hand by face value, then suit value for ease of evaluation
    public static void sortHand(ArrayList<Card> hand) {
        hand.sort(new CardComparator());
    }

    // Create a string of card values for checking for straights
    private static String getValuesAsString(ArrayList<Card> hand) {
        sortHand(hand);
        StringBuilder handValuesString = new StringBuilder();
        for (Card card : hand) {
            handValuesString.append(card.faceValue);
        }
        return handValuesString.toString();
    }


    // Create an array of repeated values from the hand
    public static ArrayList<Byte> getRepeatedValues(ArrayList<Card> hand) {
        sortHand(hand);
        ArrayList<Byte> handValuesArray = hand.stream()
                .map(card -> card.faceValue)
                .collect(Collectors.toCollection(ArrayList::new));
        return handValuesArray.stream()
                .filter(cardValue -> handValuesArray.indexOf(cardValue) != handValuesArray.lastIndexOf(cardValue))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // rank 10 - royal flush
    // If all cards share suit AND are consecutive values AND the last card is an Ace
    public static int hasRoyalFlush(ArrayList<Card> hand) {
        int rankValue = 10;
        byte aceValue = 14;
        String handValuesString = getValuesAsString(hand);
        if (hand.stream().allMatch(card -> card.suitValue == hand.get(0).suitValue
                && straight.contains(handValuesString)
                && hand.get(hand.size()-1).faceValue == aceValue)) {
            return rankValue * rankInterval;
        }
        return defaultRank;
    }

    // rank 9 - straight flush
    // If all cards share a suite AND are consecutive values
    public static int hasStraightFlush(ArrayList<Card> hand) {
        int rankValue = 9;
        String handValuesString = getValuesAsString(hand);
        if (hand.stream().allMatch(card -> card.suitValue == hand.get(0).suitValue
                && straight.contains(handValuesString))) {
            return rankValue * rankInterval + hand.get(hand.size() - 1).faceValue;
        }
        return defaultRank;
    }

    // rank 8 - four of a kind
    // If there are four repeating values
    public static int hasFourOfAKind(ArrayList<Card> hand) {
        int rankValue = 8;
        byte length = 4;
        ArrayList<Byte> repeatedValues = getRepeatedValues(hand);
        if (repeatedValues.size() == length
                && Objects.equals(repeatedValues.get(0), repeatedValues.get(length - 1))) {
            return rankValue * rankInterval + repeatedValues.get(length - 1);
        }
        return defaultRank;
    }

    // rank 7 - full house
    // If there are 5 repeated values, they have to be a pair and a triple
    public static int hasFullHouse(ArrayList<Card> hand) {
        int rankValue = 7;
        byte length = 5;
        ArrayList<Byte> repeatedValues = getRepeatedValues(hand);
        if (repeatedValues.size() == length) {
            return rankValue * rankInterval + repeatedValues.get(length - 1);
        }
        return defaultRank;
    }

    // rank 6 - flush
    // If all cards share the same suit
    public static int hasFlush(ArrayList<Card> hand) {
        int rankValue = 6;
        sortHand(hand);
        if (hand.stream().allMatch(card -> card.suitValue == hand.get(0).suitValue)) {
            return rankValue * rankInterval + hand.get(hand.size() - 1).faceValue;
        }
        return defaultRank;
    }

    // rank 5 - straight
    // If all cards are consecutively ordered
    public static int hasStraight(ArrayList<Card> hand) {
        int rankValue = 5;
        String handValuesString = getValuesAsString(hand);
        if (straight.contains(handValuesString)) {
            return rankValue * rankInterval + hand.get(hand.size() - 1).faceValue;
        }
        return defaultRank;
    }

    // rank 4 - three of a kind
    // If there are three repeating values
    public static int hasThreeOfAKind(ArrayList<Card> hand) {
        int rankValue = 4;
        byte length = 3;
        ArrayList<Byte> repeatedValues = getRepeatedValues(hand);
        if (repeatedValues.size() == length) {
            return rankValue * rankInterval + repeatedValues.get(length - 1);
        }
        return defaultRank;
    }

    // rank 3 - two pairs
    // If there are four repeated values, but they're not all the same
    public static int hasTwoPairs(ArrayList<Card> hand) {
        int rankValue = 3;
        byte length = 4;
        ArrayList<Byte> repeatedValues = getRepeatedValues(hand);
        if (repeatedValues.size() == length) {
            return rankValue * rankInterval + repeatedValues.get(length - 1);
        }
        return defaultRank;
    }

    // rank 2 - single pair
    // If there are two repeated values
    public static int hasPair(ArrayList<Card> hand) {
        int rankValue = 2;
        byte length = 2;
        ArrayList<Byte> repeatedValues = getRepeatedValues(hand);
        if (repeatedValues.size() == length) {
            return rankValue * rankInterval + repeatedValues.get(length - 1);
        }
        return defaultRank;
    }
    private HandEvaluator(){}
}
