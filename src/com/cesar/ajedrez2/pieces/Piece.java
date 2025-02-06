package com.cesar.ajedrez2.pieces;

import java.util.List;

public abstract class Piece {
    protected PieceID id;
    protected boolean white;
    protected boolean diagonal;
    protected boolean horizontal;
    protected boolean firstMove;

    protected Piece(PieceID id, boolean white, boolean diagonal, boolean horizontal, boolean firstMove) {
        this.id = id;
        this.white = white;
        this.diagonal = diagonal;
        this.horizontal = horizontal;
        this.firstMove = firstMove;
    }

    public Piece(PieceID id) {
        this.id = id;
    }

    public List<int[]> legalMoves(int[] pos, Piece[][] board2d){
        return null;
    }

    public String print(){
        return "";
    }

    public PieceID getId() {
        return id;
    }

    public boolean isWhite() {
        return white;
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }
}
