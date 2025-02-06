package com.cesar.ajedrez2.pieces;

import java.util.List;

public abstract class Piece {
    protected PieceID id;
    protected boolean white;
    protected boolean diagonal;
    protected boolean horizontal;

    protected Piece(PieceID id, boolean white, boolean diagonal, boolean horizontal) {
        this.id = id;
        this.white = white;
        this.diagonal = diagonal;
        this.horizontal = horizontal;
    }

    public Piece(PieceID id) {
        this.id = id;
    }

    protected List<int[]> legalMoves(){
        return null;
    }

    abstract String print();
}
