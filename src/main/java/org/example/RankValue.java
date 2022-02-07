package org.example;

public enum RankValue {
    INTERVAL(20),
    ROYAL_FLUSH(10),
    STRAIGHT_FLUSH(9),
    FOUR_OF_A_KIND(8, 4),
    FULL_HOUSE(7, 5),
    FLUSH(6),
    STRAIGHT(5),
    THREE_OF_A_KIND(4, 3),
    TWO_PAIR(3, 4),
    PAIR(2, 2),
    DEFAULT(1);

    final int numValue;
    final int length;
    RankValue (int numValue, int length) {
        this.numValue = numValue;
        this.length = length;
    }
    RankValue (int numValue) {
        this(numValue, numValue);
    }
}
