package com.cesar.ajedrez2.pieces;

import java.util.ArrayList;
import java.util.List;

public class stdMoves {
    //Horizontal movement
    private static List<int[]> horizontal(int[] originPos, int[] finalPos, Piece[][] board2d, int limit){
        List<int[]> legalMoves = new ArrayList<>();

        int iterations = 0;
        int constant = 1;

        //Check if target position is up or down
        //If target position is up constant becomes -1 to loop upwards the board
        if (originPos[0] < finalPos[0]){
            //Sets the iterations depending on the distance to the border
            iterations = board2d.length- originPos[0];
        } else if (originPos[0] > finalPos[0]) {
            iterations = originPos[0]+1;
            constant = -1;
        }

        if (limit != -1){
            iterations = limit;
        }

        //Loops N times depending on iterations
        for (int i = 1; i < iterations; i++) {
            Piece origin = board2d[originPos[0]][originPos[1]];
            Piece target = board2d[originPos[0]+(i*constant)][originPos[1]];
            //If target position contains VOID, PPwan or piece of the opposite team the move is legal
            if (
                    target.getId() == PieceID.VOID ||
                    target.id == PieceID.PPAWN ||
                    origin.white != target.white
            ){
                legalMoves.add(new int[]{originPos[0]+(i*constant), originPos[1]});
                continue;
            }
            break;
        }

        iterations = 0;
        constant = 1;

        //Check if target position is left or right
        //If target position is left constant becomes -1 to loop left
        if (originPos[1] < finalPos[1]){
            //Sets the iterations depending on the distance to the border
            iterations = board2d.length- originPos[1];
        } else if (originPos[1] > finalPos[1]) {
            iterations = originPos[1]+1;
            constant = -1;
        }

        if (limit != -1){
            iterations = limit;
        }

        //Loops N times depending on iterations
        for (int i = 1; i < iterations; i++) {
            Piece origin = board2d[originPos[0]][originPos[1]];
            Piece target = board2d[originPos[0]][originPos[1]+(i*constant)];
            //If target position contains VOID, PPwan or piece of the opposite team the move is legal
            if (
                    target.getId() == PieceID.VOID ||
                            target.id == PieceID.PPAWN ||
                            origin.white != target.white
            ){
                legalMoves.add(new int[]{originPos[0], originPos[1]+(i*constant)});
                continue;
            }
            break;
        }

        return legalMoves;
    }

    private static List<int[]> diagonal(int[] originPos, int[] finalPos, Piece[][] board2d, int limit){
        List<int[]> legalMoves = new ArrayList<>();

        int iterations = 0;
        int constant1 = 1;
        int constant2 = 1;

        int distabajo = (board2d.length-1) - originPos[0];
        int distderecha = (board2d.length-1)- originPos[1];

        //Set iterations based on distance to border
        //If going up constant1 -1
        //If going left constant2 -1
        if (originPos[0] > finalPos[0] && originPos[1] > finalPos[1]){
            iterations = Math.max(originPos[0], originPos[1]) - (Math.abs(originPos[0] - originPos[1]))+1;
            constant1 = -1;
            constant2 = -1;
        }
        if (originPos[0] > finalPos[0] && originPos[1] < finalPos[1]){
            iterations = Math.max(originPos[0], distderecha) - (Math.abs(originPos[0] - distderecha))+1;
            constant1 = -1;
        }
        if (originPos[0] < finalPos[0] && originPos[1] < finalPos[1]){
            iterations = Math.max(distabajo, distderecha) - (Math.abs(distabajo - distderecha))+1;
        }
        if (originPos[0] < finalPos[0] && originPos[1] > finalPos[1]){
            iterations = Math.max(distabajo, originPos[1]) - (Math.abs(distabajo - originPos[1]))+1;
            constant2 = -1;
        }

        if (limit!=-1){
            iterations = limit;
        }

        //Loops N times depending on iterations
        for (int i = 1; i < iterations; i++) {
            Piece origin = board2d[originPos[0]][originPos[1]];
            Piece target = board2d[originPos[0]+(i*constant1)][originPos[1]+(i* constant2)];
            //If target position contains VOID, PPwan or piece of the opposite team the move is legal
            if (
                    target.id == PieceID.VOID ||
                    target.id == PieceID.PPAWN ||
                    origin.white != target.white
            ){
                legalMoves.add(new int[]{originPos[0]+(i*constant1), originPos[1]+(i* constant2)});
                continue;
            }
            break;
        }

        return legalMoves;
    }

    public static List<int[]> legalMoveHor(int[] originPos, int[] finalPos, Piece[][] board2d){
        return horizontal(originPos, finalPos, board2d, -1);
    }

    public static List<int[]> legalMoveHor(int[] originPos, int[] finalPos, Piece[][] board2d, int limit){
        return horizontal(originPos, finalPos, board2d, limit);
    }

    public static List<int[]> legalMoveDia(int[] originPos, int[] finalPos, Piece[][] board2d){
        return diagonal(originPos, finalPos, board2d, -1);
    }

    public List<int[]> legalMoveDia(int[] originPos, int[] finalPos, Piece[][] board2d, int limit){
        return diagonal(originPos, finalPos, board2d, limit);
    }
}
