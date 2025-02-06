package com.cesar.ajedrez2.pieces;

import java.util.List;

public class Queen extends Piece {
    public Queen(boolean white){
        super(PieceID.QUEEN, white, true, true);
    }

    @Override
    public List<int[]> legalMoves() {
        return super.legalMoves();
    }

    @Override
    public String print() {
        return "Q" + (this.white ? "W" : "B") + " ";
    }
}
