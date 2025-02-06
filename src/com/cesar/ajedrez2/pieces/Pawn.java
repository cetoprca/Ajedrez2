package com.cesar.ajedrez2.pieces;

import java.util.List;

public class Pawn extends Piece {
    public Pawn(boolean white){
        super(PieceID.PAWN, white, false, true);
    }

    @Override
    public List<int[]> legalMoves() {
        return super.legalMoves();
    }

    @Override
    public String print() {
        return "P" + (this.white ? "W" : "B") + " ";
    }
}
