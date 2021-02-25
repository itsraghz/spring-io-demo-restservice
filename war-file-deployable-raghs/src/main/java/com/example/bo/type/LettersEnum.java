package com.example.bo.type;

public enum LettersEnum {

    A,
    E,
    I,
    O,
    U;

    public static LettersEnum getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

    public static String getRandomValue() {
        return values()[(int) (Math.random() * values().length)].toString();
    }
}
