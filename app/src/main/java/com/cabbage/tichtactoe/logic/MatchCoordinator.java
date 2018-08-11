package com.cabbage.tichtactoe.logic;

import android.widget.Toast;

import com.cabbage.tichtactoe.model.Match;
import com.cabbage.tichtactoe.model.Player;

public class MatchCoordinator {

    private final Match mMatch;

    public MatchCoordinator(Match match) {
        mMatch = match;
    }

    public boolean moveMade(int gridIndex) {
        final boolean valid = isValidMove(gridIndex);

        if (!valid) return false;

        updateMatch(gridIndex);
        calculateWinner();

        return true;
    }

    /**
     * find boardStatus if status returns open, return true.
     * if status returns player one or player two, return false.
     * @param gridIndex what grid it is
     * @return true if move on that is a valid move and false if move on that grid is invalid
     */
    private boolean isValidMove(int gridIndex) {
        return mMatch.boardStatus[gridIndex] == Player.OPEN.val;
    }


    private void updateMatch(int gridIndex) {
        final Player currentPlayer = mMatch.currentPlayer;
        final int[] boardStatus = mMatch.boardStatus;

        if (boardStatus[gridIndex] == Player.OPEN.val) {
            boardStatus[gridIndex] = currentPlayer.val;

            if (currentPlayer == Player.ONE) {
                mMatch.currentPlayer = Player.TWO;
            } else {
                mMatch.currentPlayer = Player.ONE;
            }
        }
    }
    private void calculateWinner() {
        boolean rowOne = checkWinner(mMatch.boardStatus[0], mMatch.boardStatus[1], mMatch.boardStatus[2]);
        if (rowOne) {
            mMatch.winner = Player.getPlayerFrom(mMatch.boardStatus[0]);
            return;
        }

        boolean rowTwo = checkWinner(mMatch.boardStatus[3], mMatch.boardStatus[4], mMatch.boardStatus[5]);
        if (rowTwo) {
            mMatch.winner = Player.getPlayerFrom(mMatch.boardStatus[3]);
            return;
        }

        boolean rowThree = checkWinner(mMatch.boardStatus[6], mMatch.boardStatus[7], mMatch.boardStatus[8]);
        if (rowThree) {
            mMatch.winner = Player.getPlayerFrom(mMatch.boardStatus[6]);
            return;
        }

        boolean columnOne = checkWinner(mMatch.boardStatus[0], mMatch.boardStatus[3], mMatch.boardStatus[6]);
        if (columnOne) {
            mMatch.winner = Player.getPlayerFrom(mMatch.boardStatus[0]);
            return;
        }


    }

    private boolean checkWinner(int gridA, int gridB, int gridC) {
        return gridA + gridB + gridC == 300
                || gridA + gridB + gridC == 303;
    }
}