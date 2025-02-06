package com.cesar.ajedrez2;

import com.cesar.ajedrez2.pieces.*;
import com.cesar.ajedrez2.pieces.Void;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    public int size;
    public boolean whiteTurn;
    public boolean end;
    private List<List<Piece>> board2D;

    private List<List<Piece>> defaultBoard(){
        List<List<Piece>> board = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            board.add(List.of(new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void()));
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                switch (i){
                    case 0,7 -> {
                        switch (j){
                            case 0,7 -> board.get(i).set(j, new Tower(i==7));
                            case 1,6 -> board.get(i).set(j, new Knight(i == 7));
                            case 2,5 -> board.get(i).set(j, new Bishop(i == 7));
                        }
                    }
                    case 1,6 -> board.get(i).set(j, new Pawn(i == 6));
                    default -> board.get(i).set(j, new Void());
                }
            }
        }

        board.get(7).set(3, new Queen(true));
        board.get(0).set(3, new Queen(false));
        board.get(7).set(4, new King(true));
        board.get(0).set(4, new King(false));

        return board;
    }

    public Board(int size, boolean whiteTurn, Piece[][] board2D) {
        this.size = size;
        this.whiteTurn = whiteTurn;
        this.end = false;
        this.board2D = board2D;
    }

    public Board(boolean defaultBoard){
        this.size = 8;
        this.whiteTurn = true;
        this.end = false;
        this.board2D = defaultBoard();
    }

    public Piece[][] getBoard2D() {
        return board2D;
    }

    public void show(){
        for (int i = 0; i < size; i++) {
            StringBuilder msg = new StringBuilder();
            for (int j = 0; j < size; j++) {
                msg.append(board2D[i][j].print());
            }
            System.out.println();
        }
    }
}
