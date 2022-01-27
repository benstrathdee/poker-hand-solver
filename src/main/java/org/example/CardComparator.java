package org.example;

import java.util.Comparator;

// Compares two given cards for sorting purposes
public class CardComparator implements Comparator<Card> {
    public int compare(Card card1, Card card2) {
        return card1.faceValue == card2.faceValue ?
                (card1.suitValue > card2.suitValue ? 1 : -1) :
                (card1.faceValue > card2.faceValue ? 1 : -1);
    }
}