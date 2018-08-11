package com.cabbage.tichtactoe.model;

public class Match {

    public Match() {
        int i = 0;
        while (i < 9) {
            boardStatus[i] = Player.OPEN.val;
            i++;
        }
    }
    public int[] boardStatus = new int[9];
    public Player currentPlayer = Player.ONE;
    public Player winner = null;
}
