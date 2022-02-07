package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public final class HandEvaluator {
    static String straight = "234567891011121314";

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
    public static ArrayList<Integer> getRepeatedValues(ArrayList<Card> hand) {
        sortHand(hand);
        ArrayList<Integer> handValuesArray = hand.stream()
                .map(card -> card.faceValue)
                .collect(Collectors.toCollection(ArrayList::new));
        return handValuesArray.stream()
                .filter(cardValue -> handValuesArray.indexOf(cardValue) != handValuesArray.lastIndexOf(cardValue))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // rank 10 - royal flush
    // If all cards share suit AND are consecutive values AND the last card is an Ace
    public static int hasRoyalFlush(ArrayList<Card> hand) {
        String handValuesString = getValuesAsString(hand);
        if (hand.stream().allMatch(card -> card.suitValue == hand.get(0).suitValue
                && straight.contains(handValuesString)
                && hand.get(hand.size()-1).faceValue == FaceValue.A.numValue)) {
            return RankValue.ROYAL_FLUSH.numValue * RankValue.INTERVAL.numValue;
        }
        return RankValue.DEFAULT.numValue;
    }

    // rank 9 - straight flush
    // If all cards share a suite AND are consecutive values
    public static int hasStraightFlush(ArrayList<Card> hand) {
        String handValuesString = getValuesAsString(hand);
        if (hand.stream().allMatch(card -> card.suitValue == hand.get(0).suitValue
                && straight.contains(handValuesString))) {
            return RankValue.STRAIGHT_FLUSH.numValue * RankValue.INTERVAL.numValue + hand.get(hand.size() - 1).faceValue;
        }
        return RankValue.DEFAULT.numValue;
    }

    // rank 8 - four of a kind
    // If there are four repeating values
    public static int hasFourOfAKind(ArrayList<Card> hand) {
        int length = 4;
        ArrayList<Integer> repeatedValues = getRepeatedValues(hand);
        if (repeatedValues.size() == length
                && Objects.equals(repeatedValues.get(0), repeatedValues.get(length - 1))) {
            return RankValue.FOUR_OF_A_KIND.numValue * RankValue.INTERVAL.numValue + repeatedValues.get(length - 1);
        }
        return RankValue.DEFAULT.numValue;
    }

    // rank 7 - full house
    // If there are 5 repeated values, they have to be a pair and a triple
    public static int hasFullHouse(ArrayList<Card> hand) {
        int length = 5;
        ArrayList<Integer> repeatedValues = getRepeatedValues(hand);
        if (repeatedValues.size() == length) {
            return RankValue.FULL_HOUSE.numValue * RankValue.INTERVAL.numValue + repeatedValues.get(length - 1);
        }
        return RankValue.DEFAULT.numValue;
    }

    // rank 6 - flush
    // If all cards share the same suit
    public static int hasFlush(ArrayList<Card> hand) {
        sortHand(hand);
        if (hand.stream().allMatch(card -> card.suitValue == hand.get(0).suitValue)) {
            return RankValue.FLUSH.numValue * RankValue.INTERVAL.numValue + hand.get(hand.size() - 1).faceValue;
        }
        return RankValue.DEFAULT.numValue;
    }

    // rank 5 - straight
    // If all cards are consecutively ordered
    public static int hasStraight(ArrayList<Card> hand) {
        String handValuesString = getValuesAsString(hand);
        if (straight.contains(handValuesString)) {
            return RankValue.STRAIGHT.numValue * RankValue.INTERVAL.numValue + hand.get(hand.size() - 1).faceValue;
        }
        return RankValue.DEFAULT.numValue;
    }

    // rank 4 - three of a kind
    // If there are three repeating values
    public static int hasThreeOfAKind(ArrayList<Card> hand) {
        int length = 3;
        ArrayList<Integer> repeatedValues = getRepeatedValues(hand);
        if (repeatedValues.size() == length) {
            return RankValue.THREE_OF_A_KIND.numValue * RankValue.INTERVAL.numValue + repeatedValues.get(length - 1);
        }
        return RankValue.DEFAULT.numValue;
    }

    // rank 3 - two pairs
    // If there are four repeated values, but they're not all the same
    public static int hasTwoPairs(ArrayList<Card> hand) {
        int length = 4;
        ArrayList<Integer> repeatedValues = getRepeatedValues(hand);
        if (repeatedValues.size() == length) {
            return RankValue.TWO_PAIR.numValue * RankValue.INTERVAL.numValue + repeatedValues.get(length - 1);
        }
        return RankValue.DEFAULT.numValue;
    }

    // rank 2 - single pair
    // If there are two repeated values
    public static int hasPair(ArrayList<Card> hand) {
        int length = 2;
        ArrayList<Integer> repeatedValues = getRepeatedValues(hand);
        if (repeatedValues.size() == length) {
            return RankValue.PAIR.numValue * RankValue.INTERVAL.numValue + repeatedValues.get(length - 1);
        }
        return RankValue.DEFAULT.numValue;
    }
    private HandEvaluator(){}
}
