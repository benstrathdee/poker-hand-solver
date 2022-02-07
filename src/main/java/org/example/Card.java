package org.example;

public class Card {
    public int faceValue;
    public int suitValue;

    @Override
    public String toString() {
        return faceValue + "|" + suitValue;
    }

    // Takes the two values from the string representation of a card, creates a new Card object
    public Card(char faceValue, char suitValue) {
        switch (faceValue) {
            case 'T':
                this.faceValue = FaceValue.T.numValue;
                break;
            case 'J':
                this.faceValue = FaceValue.J.numValue;
                break;
            case 'Q':
                this.faceValue = FaceValue.Q.numValue;
                break;
            case 'K':
                this.faceValue = FaceValue.K.numValue;
                break;
            case 'A':
                this.faceValue = FaceValue.A.numValue;
                break;
            default:
                int intValue = Integer.parseInt(String.valueOf(faceValue));
                if (intValue < 10 && intValue > 1) {
                    this.faceValue = intValue;
                } else {
                    throw new IllegalArgumentException("An invalid character was passed to this card.");
                }
        }
        switch (suitValue) {
            case 'C':
                this.suitValue = SuitValue.C.numValue;
                break;
            case 'S':
                this.suitValue = SuitValue.S.numValue;
                break;
            case 'D':
                this.suitValue = SuitValue.D.numValue;
                break;
            case 'H':
                this.suitValue = SuitValue.H.numValue;
                break;
            default:
                throw new IllegalArgumentException("An invalid character was passed to this card.");
        }
    }
}
