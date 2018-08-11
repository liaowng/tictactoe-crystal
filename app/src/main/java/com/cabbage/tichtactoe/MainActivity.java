package com.cabbage.tichtactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.cabbage.tichtactoe.logic.MatchCoordinator;
import com.cabbage.tichtactoe.model.Match;
import com.cabbage.tichtactoe.model.Player;
import com.cabbage.tichtactoe.presentation.BoardController;
import com.cabbage.tichtactoe.presentation.BoardView;

public class MainActivity extends AppCompatActivity
        implements BoardController {

    private BoardView boardView;
    private Match match = new Match();
    private MatchCoordinator matchCoordinator = new MatchCoordinator(match);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boardView = findViewById(R.id.game_board);
        boardView.setController(this);
    }

    @Override
    public void onGameBoardGridClicked(int index) {
//        Toast.makeText(this, "TODO, onClick: " + index, Toast.LENGTH_SHORT).show();

        boolean valid = matchCoordinator.moveMade(index);
        if (!valid) return;
        Log.d("dd", "");
        boardView.setPlayerOnGrid(index, match.currentPlayer);

        if (match.winner != null) {
            Toast.makeText(this, "Player " + match.winner + " win!", Toast.LENGTH_SHORT).show();
        }
    }
}