package com.cesar.ajedrez2.pieces;

import java.util.ArrayList;
import java.util.List;

public class Tower extends Piece {
    public Tower(boolean white){
        super(PieceID.TOWER, white, false, true, true);
    }

    public Tower(boolean white, boolean firstMove){
        super(PieceID.TOWER, white, false, true, firstMove);
    }

    @Override
    public List<int[]> legalMoves(int[] originPos, int[] finalPos, Piece[][] board2d) {
        return stdMoves.legalMoveHor(originPos, finalPos, board2d);
    }

    @Override
    public String print() {
        return "T" + (this.white ? "W" : "B") + " ";
    }

    public List<int[]> legalMoveTower(int[] pos, Piece[][] board2d){
        List<int[]> legalMoves = new ArrayList<>();



        return legalMoves;
    }
}
