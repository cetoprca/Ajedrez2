package com.cesar.ajedrez2.pieces;

import java.util.List;

public class PPawn extends Piece {
    public PPawn(boolean white){
        super(PieceID.PPWAN, white, false, false);
    }

    @Override
    public List<int[]> legalMoves() {
        return super.legalMoves();
    }

    @Override
    public String print() {
        return "E" + (this.white ? "W" : "B") + " ";
    }
}
