package com.cabbage.tichtactoe.model;

public enum Player {

    OPEN(65),
    ONE(100),
    TWO(101);

    public final int val;

    Player(int val) { this.val = val; }

    public static Player getPlayerFrom(int token) {
        for (Player player : Player.values()) {
            if (player.val == token) {
                return player;
            }
        }

        throw  new IllegalArgumentException("Unsupported value");
    }
}
