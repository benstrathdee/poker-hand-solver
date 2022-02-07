package org.example;

public enum SuitValue {
    C(0),
    S(1),
    D(2),
    H(3);

    final int numValue;
    SuitValue (int numValue) {
        this.numValue = numValue;
    }
}
