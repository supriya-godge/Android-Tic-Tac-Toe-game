package com.example.sup33.tictactoe;

/**
 * Created by sup33 on 6/24/2017.
 */

public class Model {
    protected TicTacToe aTicTacToe;

    public Model() {
        aTicTacToe = new TicTacToe();
    }


    /* This function returns true if the player Id in the move has won*/
    public boolean isWin(PlayerMove aPlayerMove) {
        int id = aPlayerMove.getId();

        // check all the rows
        for (int iter = 0; iter < aTicTacToe.getTableSize(); iter++) {
            boolean ans = checkrow(iter, id);
            if (ans) {
                System.out.println(ans);
                return true;
            }
        }
        //Check all the columns
        for (int iter = 0; iter < aTicTacToe.getTableSize(); iter++) {
            boolean ans = checkcolumn(iter, id);

            if (ans) {
                System.out.println("winner is  " + id);
                return true;
            }
        }
        boolean win = true;

        //Check the diagonal
        for (int iter = 0; iter < aTicTacToe.getTableSize(); iter++) {
            if (aTicTacToe.getBoard(iter, iter) != 0 && id == aTicTacToe.getBoard(iter, iter)) {
                continue;
            } else {
                win = false;
                break;
            }
        }
        if (win)
            return win;

        win = true;
        int jiter = aTicTacToe.getTableSize() - 1;

        //Check the reverse diagonal
        for (int iter = 0; iter < aTicTacToe.getTableSize(); iter++) {
            if (aTicTacToe.getBoard(iter, jiter) != 0 && id == aTicTacToe.getBoard(iter, jiter)) {
                jiter--;
                continue;
            } else {
                win = false;
                jiter--;
                break;
            }

        }
        if (win)
            return win;

        return false;
    }

    /*This function checks if there are three same consecutive player id in the given row*/
    public boolean checkrow(int row, int id) {
        boolean win = true;
        for (int iter = 0; iter < aTicTacToe.getTableSize(); iter++) {

            if (aTicTacToe.getBoard(iter, row) != 0 && id == aTicTacToe.getBoard(iter, row)) {
                continue;
            } else {
                win = false;
                break;
            }
        }
        return win;
    }

    /*This function checks if there are three same consecutive player id in the given column*/
    private boolean checkcolumn(int row, int id) {
        boolean win = true;
        for (int iter = 0; iter < aTicTacToe.getTableSize(); iter++) {

            if (aTicTacToe.getBoard(row, iter) != 0 && id == aTicTacToe.getBoard(row, iter)) {
                continue;
            } else {
                win = false;
                break;
            }
        }
        return win;

    }


    /*This method checks if the game is draw*/
    public boolean isDraw() {
        for (int iter = 0; iter < aTicTacToe.getTableSize(); iter++) {
            for (int jiter = 0; jiter < aTicTacToe.getTableSize(); jiter++) {
                if (aTicTacToe.getBoard(iter, jiter) == 0)
                    return false;
            }
        }
        return true;
    }
}