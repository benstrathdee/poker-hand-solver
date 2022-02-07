package org.example;

public enum FaceValue {
    T(10),
    J(11),
    Q(12),
    K(13),
    A(14);

    final int numValue;

    FaceValue (int numValue) {
        this.numValue = numValue;
    }
}
