package com.cabbage.tichtactoe.presentation;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.cabbage.tichtactoe.R;
import com.cabbage.tichtactoe.model.Player;

import java.util.ArrayList;
import java.util.List;

public class BoardView extends CardView {

    private static final String TAG = "GameBoard";

    private final List<View> gridViews = new ArrayList<>(9);

    @Nullable
    private BoardController controller = null;

    //region Res
    private int colorWhiteSmoke = ContextCompat.getColor(getContext(), R.color.colorGrey100);
    private int colorPlayer1 = ContextCompat.getColor(getContext(), R.color.player1);
    private int colorPlayer2 = ContextCompat.getColor(getContext(), R.color.player2);
    //endregion

    public BoardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        Log.d(TAG, "board: init");
        View.inflate(getContext(), R.layout.view_game_board, this);

        // Binding views
        bindGrids();

        // Setting click callbacks
        for (View view : gridViews) {
            final int gridIndex = Integer.valueOf(view.getTag().toString());
            setPlayerOnGrid(gridIndex, Player.OPEN);

            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View grid) {
                    Log.d(TAG, "board: on click index: " + gridIndex);
                    if (controller != null) {
                        controller.onGameBoardGridClicked(gridIndex);
                    }
                }
            });
        }
    }

    private void bindGrids() {
        gridViews.add(0, findViewById(R.id.btn_0));
        gridViews.add(1, findViewById(R.id.btn_1));
        gridViews.add(2, findViewById(R.id.btn_2));
        gridViews.add(3, findViewById(R.id.btn_3));
        gridViews.add(4, findViewById(R.id.btn_4));
        gridViews.add(5, findViewById(R.id.btn_5));
        gridViews.add(6, findViewById(R.id.btn_6));
        gridViews.add(7, findViewById(R.id.btn_7));
        gridViews.add(8, findViewById(R.id.btn_8));
    }

    public void setController(@Nullable BoardController callback) {
        Log.v(TAG, "board: set controller");
        this.controller = callback;
    }

    public void setPlayerOnGrid(int gridIndex, Player player) {

        if (gridIndex < 0 || gridIndex >= 9) {
            throw new IndexOutOfBoundsException("Nine grids only!");
        }

        switch (player) {
            case OPEN:
                gridViews.get(gridIndex).setBackgroundColor(colorWhiteSmoke);
                break;
            default:
                throw new UnsupportedOperationException("TODO");
        }
    }

    public void reset() {
        throw new UnsupportedOperationException("TODO");
    }
}