package com.cesar.ajedrez2.pieces;

import java.util.List;

public class PPawn extends Piece {
    public PPawn(boolean white){
        super(PieceID.PPAWN, white, false, false, false);
    }

    @Override
    public List<int[]> legalMoves(int[] pos, Piece[][] board2d) {
        return super.legalMoves(pos, board2d);
    }

    @Override
    public String print() {
        return "E" + (this.white ? "W" : "B") + " ";
    }
}
