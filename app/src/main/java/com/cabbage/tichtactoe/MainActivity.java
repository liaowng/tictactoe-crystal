package com.cabbage.tichtactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.cabbage.tichtactoe.presentation.BoardController;
import com.cabbage.tichtactoe.presentation.BoardView;

public class MainActivity extends AppCompatActivity
        implements BoardController {

    private BoardView boardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boardView = findViewById(R.id.game_board);
        boardView.setController(this);
    }

    @Override
    public void onGameBoardGridClicked(int index) {
        Toast.makeText(this, "TODO, onClick: " + index, Toast.LENGTH_SHORT).show();
    }
}