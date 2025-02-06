package com.cesar.ajedrez2.pieces;

import java.util.List;

public class Bishop extends Piece {
    public Bishop(boolean white){
        super(PieceID.BISHOP, white, true, false, true);
    }

    @Override
    public List<int[]> legalMoves(int[] pos, Piece[][] board2d) {
        return super.legalMoves(pos, board2d);
    }

    @Override
    public String print() {
        return "B" + (this.white ? "W" : "B") + " ";
    }
}
