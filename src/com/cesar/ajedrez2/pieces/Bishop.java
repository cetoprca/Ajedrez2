package com.cesar.ajedrez2.pieces;

import java.util.List;

public class Bishop extends Piece {
    public Bishop(boolean white){
        super(PieceID.BISHOP, white, true, false);
    }

    @Override
    public List<int[]> legalMoves() {
        return super.legalMoves();
    }

    @Override
    public String print() {
        return "B" + (this.white ? "W" : "B") + " ";
    }
}
