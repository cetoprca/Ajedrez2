package com.cesar.ajedrez2.pieces;

import java.util.List;

public class Tower extends Piece {
    public Tower(boolean white){
        super(PieceID.TOWER, white, false, true);
    }

    @Override
    public List<int[]> legalMoves() {
        return super.legalMoves();
    }

    @Override
    public String print() {
        return "T" + (this.white ? "W" : "B") + " ";
    }
}
