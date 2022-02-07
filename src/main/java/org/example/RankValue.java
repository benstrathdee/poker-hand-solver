package org.example;

public enum RankValue {
    INTERVAL(20),
    ROYAL_FLUSH(10),
    STRAIGHT_FLUSH(9),
    FOUR_OF_A_KIND(8),
    FULL_HOUSE(7),
    FLUSH(6),
    STRAIGHT(5),
    THREE_OF_A_KIND(4),
    TWO_PAIR(3),
    PAIR(2),
    DEFAULT(1);

    final int numValue;
    RankValue (int numValue) {
        this.numValue = numValue;
    }
}
