package com.cabbage.tichtactoe.logic;

import com.cabbage.tichtactoe.model.Match;
import com.cabbage.tichtactoe.model.Player;

public class MatchCoordinator {

    private final Match mMatch;

    public MatchCoordinator(Match match) {
        mMatch = match;
    }

    public boolean moveMade(int gridIndex) {


//        if (boardStatus[index] == Player.OPEN.val) {
//            boardStatus[index] = currentPlayer.val;
//            boardView.setPlayerOnGrid(index, currentPlayer);
//
//            if (currentPlayer == Player.ONE) {
//                currentPlayer = Player.TWO;
//            } else {
//                currentPlayer = Player.ONE;
//            }
//        }


        final boolean valid = isValidMove(gridIndex);

        if (!valid) return false;

        updateMatch();
        calculateWinner();

        return true;
    }

    private boolean isValidMove(int gridIndex) {
        return false;
    }

    private void updateMatch() {

    }

    private void calculateWinner() {

    }

    public Player getWinner() {
        return Player.OPEN;
    }
}