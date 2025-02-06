package com.cesar.ajedrez2.pieces;

import java.util.List;

public class Queen extends Piece {
    public Queen(boolean white){
        super(PieceID.QUEEN, white, true, true, true);
    }

    @Override
    public List<int[]> legalMoves(int[] pos, Piece[][] board2d) {
        return super.legalMoves(pos, board2d);
    }

    @Override
    public String print() {
        return "Q" + (this.white ? "W" : "B") + " ";
    }
}
