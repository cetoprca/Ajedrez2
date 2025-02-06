package com.cesar.ajedrez2.pieces;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(boolean white){
        super(PieceID.KING, white, true, true, true);
    }

    @Override
    public List<int[]> legalMoves(int[] pos, Piece[][] board2d) {
        return legalMoveKing(pos, board2d);
    }

    @Override
    public String print() {
        return "K" + (this.white ? "W" : "B") + " ";
    }

    private List<int[]> legalMoveKing(int[] pos, Piece[][] board2d){
        List<int[]> legalMoves = new ArrayList<>();

        int[] newpos = {pos[0]-2, pos[1]-2};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //If two up and two left relative to the king is a valid position
                if ((newpos[0]+i > 0 && newpos[0]+i < 8) && ((newpos[1]+j > 0 && newpos[1]+j < 8))) {
                    //If said position contains VOID, PPwan or piece of the opposite team the move is legal
                    if (board2d[newpos[0] + i][newpos[1] + j].id == PieceID.VOID || board2d[newpos[0] + i][newpos[1] + j].white != board2d[pos[0]][pos[1]].white || board2d[newpos[0] + i][newpos[1] + j].id == PieceID.PPAWN) {
                        legalMoves.add(new int[]{newpos[0] + i, newpos[1] + j});
                    }
                }
            }
        }

        return legalMoves;
    }
}
