package com.example.sup33.tictactoe;

import android.app.Application;

/**
 * Created by sup33 on 6/23/2017.
 */

public class TicTacToe  {
    private static int tern;

    public int getTern() {
        return tern;
    }

    public void incrementTern() {
        this.tern++;
    }
}
