package com.cesar.ajedrez2.pieces;

import java.util.List;

public class Tower extends Piece {
    public Tower(boolean white){
        super(PieceID.TOWER, white, false, true, true);
    }

    @Override
    public List<int[]> legalMoves(int[] pos, Piece[][] board2d) {
        return super.legalMoves(pos, board2d);
    }

    @Override
    public String print() {
        return "T" + (this.white ? "W" : "B") + " ";
    }
}
