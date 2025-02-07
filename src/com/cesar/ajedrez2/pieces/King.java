package com.cesar.ajedrez2.pieces;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(boolean white){
        super(PieceID.KING, white, true, true, true);
    }

    public King(boolean white, boolean firstMove){
        super(PieceID.KING, white, true, true, firstMove);
    }

    @Override
    public List<int[]> legalMoves(int[] originPos, int[] finalPos, Piece[][] board2d) {
        return legalMoveKing(originPos, board2d);
    }

    @Override
    public String print() {
        return "K" + (this.white ? "W" : "B") + " ";
    }

    private List<int[]> legalMoveKing(int[] pos, Piece[][] board2d){
        List<int[]> legalMoves = new ArrayList<>();

        int[] newpos = {pos[0]-1, pos[1]-1};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //If two up and two left relative to the king is a valid position
                if ((newpos[0]+i > 0 && newpos[0]+i < 8) && ((newpos[1]+j > 0 && newpos[1]+j < 8))) {
                    //If said position contains VOID, PPwan or piece of the opposite team the move is legal
                    Piece target = board2d[newpos[0] + i][newpos[1] + j];
                    if (target.id == PieceID.VOID || target.id == PieceID.PPAWN || target.white != board2d[pos[0]][pos[1]].white) {
                        legalMoves.add(new int[]{newpos[0] + i, newpos[1] + j});
                    }
                }
            }
        }

        return legalMoves;
    }
}
