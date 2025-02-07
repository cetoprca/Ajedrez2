package com.cesar.ajedrez2.pieces;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    public Knight(boolean white){
        super(PieceID.KNIGHT, white, false, false, true);
    }

    public Knight(boolean white, boolean firstMove){
        super(PieceID.KNIGHT, white, false, false, firstMove);
    }

    @Override
    public List<int[]> legalMoves(int[] originPos, int[] finalPos, Piece[][] board2d) {
        return legalMoveKnight(originPos, board2d);
    }

    @Override
    public String print() {
        return "H" + (this.white ? "W" : "B") + " ";
    }

    public static List<int[]> legalMoveKnight(int[] pos, Piece[][] board2d){
        List<int[]> legalMoves = new ArrayList<>();

        int[][] coords = {
                //Down 2, side 1
                {pos[0]+2, pos[0]+1}, {pos[0]+2, pos[0]-1},
                //Down 1, side 2
                {pos[0]+1, pos[0]+2}, {pos[0]+1, pos[0]-2},
                //Up 2, side 1
                {pos[0]-2, pos[0]+1}, {pos[0]-2, pos[0]-1},
                //Up 1, side 2
                {pos[0]-1, pos[0]+2}, {pos[0]-1, pos[0]-2},
        };

        for(int[] coord : coords){
            Piece target = board2d[coord[0]][coord[1]];
            if (
                    target.getId() == PieceID.VOID ||
                            target.id == PieceID.PPAWN ||
                            target.white != board2d[pos[0]][pos[1]].white
            ) {
                legalMoves.add(coord);
            }
        }

        return legalMoves;
    }
}
