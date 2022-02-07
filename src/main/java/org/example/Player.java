package org.example;

import java.util.ArrayList;

public class Player {
    public String name;
    public ArrayList<Card> hand = new ArrayList<>();
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

    //Use the HandEvaluator to determine what rank the player's hand achieves
    public int evaluateHand() {
        int finalRank = 1;
        int[] potentialRanks = new int[] {
            HandEvaluator.hasPair(hand),
            HandEvaluator.hasTwoPairs(hand),
            HandEvaluator.hasThreeOfAKind(hand),
            HandEvaluator.hasStraight(hand),
            HandEvaluator.hasFlush(hand),
            HandEvaluator.hasFullHouse(hand),
            HandEvaluator.hasFourOfAKind(hand),
            HandEvaluator.hasStraightFlush(hand),
            HandEvaluator.hasRoyalFlush(hand)
        };
        for (int i : potentialRanks) finalRank = Math.max(finalRank, i);
        return finalRank;
    }

    public void addVictory() {
        this.victories ++;
    }

    @Override
    public String toString() {
        return name + ": " + victories;
    }

    public Player(String name) {
        this.name = name;
    }
}