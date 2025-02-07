package com.cesar.ajedrez2.pieces;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    public Queen(boolean white){
        super(PieceID.QUEEN, white, true, true, true);
    }

    public Queen(boolean white, boolean firstMove){
        super(PieceID.QUEEN, white, true, true, firstMove);
    }

    @Override
    public List<int[]> legalMoves(int[] originPos, int[] finalPos, Piece[][] board2d) {
        List<int[]> legalMoves = new ArrayList<>();
        legalMoves.addAll(stdMoves.legalMoveDia(originPos, finalPos, board2d));
        legalMoves.addAll(stdMoves.legalMoveHor(originPos, finalPos, board2d));

        return legalMoves;
    }

    @Override
    public String print() {
        return "Q" + (this.white ? "W" : "B") + " ";
    }
}
