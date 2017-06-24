package com.example.sup33.tictactoe;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by sup33 on 6/23/2017.
 */

public class TicTacToe  {
    private static int tern;


    private  int tableSize=3; //The default size
    private  int[][] board = new int[tableSize][tableSize];
    public final  static String CROSS = "X";
    public final  static String ROUND = "O";

    public int getTern() {
        return tern;
    }

    public void incrementTern() {
        this.tern++;
    }

    public int getTableSize(){
        return tableSize;
    }

    /* To check if the space is free to perform the given player move*/
    public boolean isFree(PlayerMove aPlayerMove){
        if (board[aPlayerMove.getRow()][aPlayerMove.getColumn()]==0) {
            return true;
        }
        return false;
    }

    /* To check if any place is free in the board*/
    public boolean isAnyThigFree(){
        for(int iter=0;iter<board.length;iter++) {
            for(int jiter=0;jiter<board.length;jiter++) {

                if (board[iter][jiter]== 0) {
                    return true;
                }
            }
        }
        return false;
    }


    /*
        To update the board with the given player move
     */
    public void lastMove(PlayerMove aPlayerMove) {
        board[aPlayerMove.getRow()][aPlayerMove.getColumn()] = aPlayerMove.getId();

    }

    /*Set the board with the row, column and player id*/
    public void setBoard(int row, int column, int id){
        board[row][column]=id;
    }

    /*To get the value present in the board at the given  row and coulmn*/
    public int getBoard(int row, int column){
        return board[row][column];
    }

    /* To get all the free spaces where player can place their move*/
    public ArrayList<PlayerMove> getAllFreeSpaces() {
        ArrayList<PlayerMove> successors = new ArrayList<>();
        for(int iter=0;iter<board.length;iter++) {
            for(int jiter=0;jiter<board.length;jiter++) {
                if (board[iter][jiter]== 0) {
                    successors.add(new PlayerMove(iter,jiter,0));
                }
            }
        }
        return successors;

    }

    /* To remove the piece from the board given the row and column*/
    public void removePiece(int row, int column) {
        board[row][column]=0;
    }


}
