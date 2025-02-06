package com.cesar.ajedrez2.pieces;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{

    public Pawn(boolean white) {
        super(PieceID.PAWN, white, false, true, true);
    }

    @Override
    public List<int[]> legalMoves(int[] pos, Piece[][] board2d) {
        return legalMovePeon(pos, board2d);
    }

    @Override
    public String print() {
        return "P" + (this.white ? "W" : "B") + " ";
    }

    public static List<int[]> legalMovePeon(int[] pos, Piece[][] board2d){
        List<int[]> legalMoves = new ArrayList<>();

        int iteraciones = board2d[pos[0]][pos[1]].firstMove ? 2 : 1;
        if (!board2d[pos[0]][pos[1]].white){
            //Si es peon negro

            //Avanzar
            //Si es el primer movimiento, 2 iteraciones hacia abajo, en caso contrario 1
            for (int i = 1; i < iteraciones; i++) {
                if(pos[0]+i > board2d.length){
                    break;
                }
                if (board2d[pos[0]+i][pos[1]] == null){
                    int[] Cpos = {pos[0]+i, pos[1]};
                    legalMoves.add(Cpos);
                }else break;
            }

            //Atacar izquierda
            //Si la casilla tiene una pieza del otro bando la posicion se registra como valida
            if (pos[0]+1 < 8 && pos[1]-1 > -1){
                if (board2d[pos[0]+1][pos[1]-1] != null){
                    if (board2d[pos[0]+1][pos[1]-1].white != board2d[pos[0]][pos[1]].white){
                        int[] Cpos = {pos[0]+1, pos[1]-1};
                        legalMoves.add(Cpos);
                    }
                }
            }

            //Atacar derecha
            //Si la casilla tiene una pieza del otro bando la posicion se registra como valida
            if (pos[0]+1 < 8 && pos[1]+1 < 8) {
                if (board2d[pos[0]+1][pos[1] + 1] != null) {
                    if (board2d[pos[0]+1][pos[1]+1].white != board2d[pos[0]][pos[1]].white) {
                        int[] Cpos = {pos[0]+1, pos[1]+1};
                        legalMoves.add(Cpos);
                    }
                }
            }
        }else {
            //Si es peon blanco

            //Avanzar
            //Si es el primer movimiento, 2 iteraciones hacia abajo, en caso contrario 1
            for (int i = 1; i < iteraciones; i++) {
                if(pos[0]-i < 0){
                    break;
                }
                if (board2d[pos[0]-i][pos[1]] == null){
                    int[] Cpos = {pos[0]-i, pos[1]};
                    legalMoves.add(Cpos);
                }else break;
            }

            //Atacar izquierda
            //Si la casilla tiene una pieza del otro bando la posicion se registra como valida
            if (pos[0]-1 < 8 && pos[1]-1 > -1){
                if (board2d[pos[0]-1][pos[1]-1] != null){
                    if (board2d[pos[0]-1][pos[1]-1].white != board2d[pos[0]][pos[1]].white){
                        int[] Cpos = {pos[0]-1, pos[1]-1};
                        legalMoves.add(Cpos);
                    }
                }
            }

            //Atacar derecha
            //Si la casilla tiene una pieza del otro bando la posicion se registra como valida
            if (pos[0]-1 < 8 && pos[1]+1 < 8) {
                if (board2d[pos[0]-1][pos[1]+1] != null) {
                    if (board2d[pos[0]-1][pos[1]+1].white != board2d[pos[0]][pos[1]].white) {
                        int[] Cpos = {pos[0]-1, pos[1]+1};
                        legalMoves.add(Cpos);
                    }
                }
            }
        }

        return legalMoves;
    }
}
