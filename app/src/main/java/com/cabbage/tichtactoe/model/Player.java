package com.cabbage.tichtactoe.model;

public enum Player {

    OPEN(99),
    ONE(100),
    TWO(101);

    public final int val;

    Player(int val) { this.val = val; }
}
