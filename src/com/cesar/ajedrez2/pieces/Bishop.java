package com.cesar.ajedrez2.pieces;

import java.util.List;

public class Bishop extends Piece {
    public Bishop(boolean white){
        super(PieceID.BISHOP, white, true, false, true);
    }

    public Bishop(boolean white, boolean firstMove){
        super(PieceID.BISHOP, white, true, false, firstMove);
    }

    @Override
    public List<int[]> legalMoves(int[] originPos, int[] finalPos, Piece[][] board2d) {
        return stdMoves.legalMoveDia(originPos,finalPos, board2d);
    }

    @Override
    public String print() {
        return "B" + (this.white ? "W" : "B") + " ";
    }
}
