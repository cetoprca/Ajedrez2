package com.cesar.ajedrez2.pieces;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{

    public Pawn(boolean white) {
        super(PieceID.PAWN, white, false, true, true);
    }

    public Pawn(boolean white, boolean firstMove) {
        super(PieceID.PAWN, white, false, true, firstMove);
    }

    @Override
    public List<int[]> legalMoves(int[] originPos, int[] finalPos, Piece[][] board2d) {
        return legalMovePeon(originPos, board2d);
    }

    @Override
    public String print() {
        return "P" + (this.white ? "W" : "B") + " ";
    }

    public static List<int[]> legalMovePeon(int[] pos, Piece[][] board2d) {
        List<int[]> legalMoves = new ArrayList<>();

        Piece origin = board2d[pos[0]][pos[1]];
        int iteraciones = board2d[pos[0]][pos[1]].firstMove ? 3 : 2;

        //Go forward
        //If piece team == white go upwards, else go downwards
        for (int i = 1; i < iteraciones; i++) {
            //If target row is inbounds
            if (pos[0] + (origin.white ? i*(-1) : i) > -1 && pos[0] + (origin.white ? i*(-1) : i) < 8) {
                //If target piece == VOID add position as legal
                if (board2d[pos[0] + (origin.white ? i*(-1) : i)][pos[1]].getId() == PieceID.VOID) {
                    legalMoves.add(new int[]{pos[0] + (origin.white ? i*(-1) : i), pos[1]});
                } else break;
            }
        }

        // Attack
        //If i == 0 attack left, else attack right
        //If piece team == white, attack upwards, else attack downwards
        for (int i = 0; i < 2; i++) {
            //If target row inbounds and target column inbounds
            if (
                    (pos[0]+(origin.white ? -1 : 1) < 8 && pos[0]+(origin.white ? -1 : 1) > -1)
                    &&
                    (pos[1]+(i==0 ? 1 : -1) < 8 && pos[1]+(i==0 ? 1 : -1) > -1)
            ){
                Piece target = board2d[pos[0]+(origin.white ? -1 : 1)][pos[1]+(i==0 ? 1 : -1)];
                //If target team != origin team and target isnt void, add position as legal
                if (target.white != origin.white && target.id != PieceID.VOID){
                    legalMoves.add(new int[]{pos[0]+(origin.white ? -1 : 1), pos[1]+(i==0 ? 1 : -1)});
                }
            }
        }

        return legalMoves;
    }
}
