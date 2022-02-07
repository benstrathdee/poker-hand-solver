package org.example;

public class Card {
    public byte faceValue;
    public byte suitValue;

    @Override
    public String toString() {
        return faceValue + "|" + suitValue;
    }

    // Takes the two values from the string representation of a card, creates a new Card object
    public Card(char faceValue, char suitValue) {
        switch (faceValue) {
            case 'T' -> this.faceValue = (byte) 10;
            case 'J' -> this.faceValue = (byte) 11;
            case 'Q' -> this.faceValue = (byte) 12;
            case 'K' -> this.faceValue = (byte) 13;
            case 'A' -> this.faceValue = (byte) 14;
            default -> this.faceValue = Byte.parseByte(Character.toString(faceValue));
        }
        switch (suitValue) {
            case 'C' -> this.suitValue = (byte) 0;
            case 'S' -> this.suitValue = (byte) 1;
            case 'D' -> this.suitValue = (byte) 2;
            case 'H' -> this.suitValue = (byte) 3;
        }
    }
}
