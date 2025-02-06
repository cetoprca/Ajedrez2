package com.cesar.ajedrez2.pieces;

import java.util.List;

public class Knight extends Piece {
    public Knight(boolean white){
        super(PieceID.KNIGHT, white, false, false);
    }

    @Override
    public List<int[]> legalMoves() {
        return super.legalMoves();
    }

    @Override
    public String print() {
        return "H" + (this.white ? "W" : "B") + " ";
    }
}
