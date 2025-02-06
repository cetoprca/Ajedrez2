package com.cesar.ajedrez2.pieces;

import java.util.List;

public class King extends Piece {
    public King(boolean white){
        super(PieceID.KING, white, true, true);
    }

    @Override
    public List<int[]> legalMoves() {
        return super.legalMoves();
    }

    @Override
    public String print() {
        return "Ki" + (this.white ? "W" : "B") + " ";
    }
}
