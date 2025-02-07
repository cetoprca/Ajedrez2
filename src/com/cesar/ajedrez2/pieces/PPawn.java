package com.cesar.ajedrez2.pieces;

import java.util.List;

public class PPawn extends Piece {
    public PPawn(boolean white){
        super(PieceID.PPAWN, white);
    }

    @Override
    public List<int[]> legalMoves(int[] originPos, int[] finalPos, Piece[][] board2d) {
        return super.legalMoves(originPos, finalPos, board2d);
    }

    @Override
    public String print() {
        return "E" + (this.white ? "W" : "B") + " ";
    }
}
