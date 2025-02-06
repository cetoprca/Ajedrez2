package com.cesar.ajedrez2.pieces;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    public Knight(boolean white){
        super(PieceID.KNIGHT, white, false, false, true);
    }

    @Override
    public List<int[]> legalMoves(int[] pos, Piece[][] board2d) {
        return legalMoveKnight(pos, board2d);
    }

    @Override
    public String print() {
        return "H" + (this.white ? "W" : "B") + " ";
    }

    public static List<int[]> legalMoveKnight(int[] pos, Piece[][] board2d){
        List<int[]> legalMoves = new ArrayList<>();

        //Movimientos hard codeados

        if (pos[0]+2 < 8 && pos[1]+1 < 8) {
            if (board2d[pos[0] + 2][pos[1] + 1] == null) {
                int[] Cpos = {pos[0] + 2, pos[1] + 1};
                legalMoves.add(Cpos);
            } else if (board2d[pos[0] + 2][pos[1] + 1].white != board2d[pos[0]][pos[1]].white) {
                int[] Cpos = {pos[0] + 2, pos[1] + 1};
                legalMoves.add(Cpos);
            }else if (board2d[pos[0] + 2][pos[1] + 1].id == PieceID.PPAWN){
                int[] Cpos = {pos[0] + 2, pos[1] + 1};
                legalMoves.add(Cpos);
            }
        }

        if (pos[0]+2 < 8 && pos[1]-1 > -1){
            if (board2d[pos[0]+2][pos[1]-1] == null){
                int[] Cpos = {pos[0]+2, pos[1]-1};
                legalMoves.add(Cpos);
            }else if (board2d[pos[0]+2][pos[1]-1].white != board2d[pos[0]][pos[1]].white){
                int[] Cpos = {pos[0]+2, pos[1]-1};
                legalMoves.add(Cpos);
            }else if (board2d[pos[0]+2][pos[1]-1].id == PieceID.PAWN){
                int[] Cpos = {pos[0]+2, pos[1]-1};
                legalMoves.add(Cpos);
            }
        }

        if (pos[0]-2 > -1 && pos[1]+1 < 8) {
            if (board2d[pos[0] - 2][pos[1] + 1] == null) {
                int[] Cpos = {pos[0] - 2, pos[1] + 1};
                legalMoves.add(Cpos);
            } else if (board2d[pos[0] - 2][pos[1] + 1].white != board2d[pos[0]][pos[1]].white) {
                int[] Cpos = {pos[0] - 2, pos[1] + 1};
                legalMoves.add(Cpos);
            }else if (board2d[pos[0] - 2][pos[1] + 1].id == PieceID.PAWN) {
                int[] Cpos = {pos[0] - 2, pos[1] + 1};
                legalMoves.add(Cpos);
            }
        }

        if (pos[0]-2 > -1 && pos[1]-1 > -1) {
            if (board2d[pos[0] - 2][pos[1] - 1] == null) {
                int[] Cpos = {pos[0] - 2, pos[1] - 1};
                legalMoves.add(Cpos);
            } else if (board2d[pos[0] - 2][pos[1] - 1].white != board2d[pos[0]][pos[1]].white) {
                int[] Cpos = {pos[0] - 2, pos[1] - 1};
                legalMoves.add(Cpos);
            }else if (board2d[pos[0] - 2][pos[1] - 1].id == PieceID.PPAWN) {
                int[] Cpos = {pos[0] - 2, pos[1] - 1};
                legalMoves.add(Cpos);
            }
        }

        if (pos[0]+1 < 8 && pos[1]+2 < 8) {
            if (board2d[pos[0] + 1][pos[1] + 2] == null) {
                int[] Cpos = {pos[0] + 1, pos[1] + 2};
                legalMoves.add(Cpos);
            } else if (board2d[pos[0] + 1][pos[1] + 2].white != board2d[pos[0]][pos[1]].white) {
                int[] Cpos = {pos[0] + 1, pos[1] + 2};
                legalMoves.add(Cpos);
            }else if (board2d[pos[0] + 1][pos[1] + 2].id == PieceID.PPAWN) {
                int[] Cpos = {pos[0] + 1, pos[1] + 2};
                legalMoves.add(Cpos);
            }
        }

        if (pos[0]+1 < 8 && pos[1]-2 > -1) {
            if (board2d[pos[0] + 1][pos[1] - 2] == null) {
                int[] Cpos = {pos[0] + 1, pos[1] - 2};
                legalMoves.add(Cpos);
            } else if (board2d[pos[0] + 1][pos[1] - 2].white != board2d[pos[0]][pos[1]].white) {
                int[] Cpos = {pos[0] + 1, pos[1] - 2};
                legalMoves.add(Cpos);
            }else if (board2d[pos[0] + 1][pos[1] - 2].id == PieceID.PPAWN) {
                int[] Cpos = {pos[0] + 1, pos[1] - 2};
                legalMoves.add(Cpos);
            }
        }

        if (pos[0]-1 > -1 && pos[1]+2 < 8) {
            if (board2d[pos[0] - 1][pos[1] + 2] == null) {
                int[] Cpos = {pos[0] - 1, pos[1] + 2};
                legalMoves.add(Cpos);
            } else if (board2d[pos[0] - 1][pos[1] + 2].white != board2d[pos[0]][pos[1]].white) {
                int[] Cpos = {pos[0] - 1, pos[1] + 2};
                legalMoves.add(Cpos);
            }else if (board2d[pos[0] - 1][pos[1] + 2].id == PieceID.PPAWN) {
                int[] Cpos = {pos[0] - 1, pos[1] + 2};
                legalMoves.add(Cpos);
            }
        }

        if (pos[0]-1 > -1 && pos[1]-2 > -1) {
            if (board2d[pos[0] - 1][pos[1] - 2] == null) {
                int[] Cpos = {pos[0] - 1, pos[1] - 2};
                legalMoves.add(Cpos);
            } else if (board2d[pos[0] - 1][pos[1] - 2].white != board2d[pos[0]][pos[1]].white) {
                int[] Cpos = {pos[0] - 1, pos[1] - 2};
                legalMoves.add(Cpos);
            }else if (board2d[pos[0] - 1][pos[1] - 2].id == PieceID.PPAWN) {
                int[] Cpos = {pos[0] - 1, pos[1] - 2};
                legalMoves.add(Cpos);
            }
        }

        return legalMoves;
    }
}
