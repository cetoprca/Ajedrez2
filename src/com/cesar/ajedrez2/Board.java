package com.cesar.ajedrez2;

import com.cesar.ajedrez2.pieces.Void;
import com.cesar.ajedrez2.pieces.*;

import java.util.Arrays;
import java.util.List;

public class Board {
    public int size;
    public boolean whiteTurn;
    public boolean end;
    private Piece[][] board2D;

    private Piece[][] defaultBoard(){
        Piece[][] board = new Piece[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                switch (i){
                    case 0,7 -> {
                        switch (j){
                            case 0,7 -> board[i][j] = new Tower(i==7);
                            case 1,6 -> board[i][j] = new Knight(i==7);
                            case 2,5 -> board[i][j] = new Bishop(i==7);
                        }
                    }
                    case 1,6 -> board[i][j] = new Pawn(i==6);
                    default -> board[i][j] = new Void();
                }
            }
        }

        board[7][3] = new Queen(true);
        board[7][4] = new King(true);
        board[0][3] = new King(true);
        board[0][4] = new Queen(true);

        return board;
    }

    private Piece[][] emptyBoard(){
        Piece[][] board = new Piece[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Void();
            }
        }

        return board;
    }

    public Board(int size, boolean whiteTurn, boolean empty) {
        this.size = size;
        this.whiteTurn = whiteTurn;
        this.end = false;
        if (empty){
            clear();
        }else {
            reset();
        }
    }

    public Board(){
        this.size = 8;
        this.whiteTurn = true;
        this.end = false;
        reset();
    }

    public Piece[][] getBoard2D() {
        return board2D;
    }

    public void move(int originRow, int originColumn, int finalRow, int finalColumn, boolean showMovesOnly){

        int[] originPos = {originRow, originColumn};
        int[] finalPos = {finalRow, finalColumn};

        //If origin pos or final pos isnt valid then return
        if (
                ((originRow > 7 || originRow < 0) || (originColumn > 7 || originColumn < 0))
                ||
                ((finalRow > 7 || finalRow < 0) || (finalColumn > 7 || finalColumn < 0))
        ) {
            System.out.println("Not a valid position");
            return;
        }

        Piece originPiece = board2D[originRow][originColumn];
        Piece finalPiece = board2D[finalRow][finalColumn];

        if (originPiece.isWhite() != whiteTurn){
            System.out.println("It's the opposite team's turn");
            return;
        }

        boolean isLegal = false;

        List<int[]> legalMoves = originPiece.legalMoves(originPos, finalPos, board2D);

        if (showMovesOnly){
            for (int[] move : legalMoves){
                System.out.println(Arrays.toString(move));
            }
            return;
        }

        for (int[] pos : legalMoves){
            if (Arrays.equals(pos, finalPos)) {
                isLegal = true;
                break;
            }
        }

        if (isLegal){
            //Remove all PPAWNs
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (board2D[i][j].getId() == PieceID.PPAWN){
                        board2D[i][j] = new Void();
                    }
                }
            }
            //If final pos had a PPAWN, set the corresponding pawn position to VOID
            if (originPiece.getId() == PieceID.PAWN && finalPiece.getId() == PieceID.PPAWN){
                board2D[finalRow+(finalPiece.isWhite() ? -1 : 1)][finalColumn] = new Void();
            }
            //If origin piece is a PAWN and has moved 2 squares, set one square before a PPAWN of the corresponding team
            if (originPiece.getId() == PieceID.PAWN && (Math.max(originRow,finalRow) - Math.min(originRow,finalRow) == 2)){
                board2D[finalRow+(originPiece.isWhite() ? 1 : -1)][finalColumn] = new PPawn(originPiece.isWhite());
            }
            //If this is the first move of the origin piece, set firstMove to false
            if (originPiece.isFirstMove()){
                originPiece.setFirstMove(false);
            }
            //If the KING is captured the game finishes and a win message gets sent
            if (finalPiece.getId() == PieceID.KING){
                System.out.println("The " + (originPiece.isWhite() ? "White" : "Black") + " team wins!");
                end = true;
            }

            board2D[finalRow][finalColumn] = originPiece;
            board2D[originRow][originColumn] = new Void();

            whiteTurn = !whiteTurn;

            show();
        }
    }

    public void add(int row, int column, Piece piece){
        board2D[row][column] = piece;
    }

    public void remove(int row, int column){
        board2D[row][column] = new Void();
    }

    public void reset(){
        this.board2D = defaultBoard();
        show();
    }

    public void clear(){
        this.board2D = emptyBoard();
        show();
    }

    public void show(){
        for (int i = 0; i < size; i++) {
            StringBuilder msg = new StringBuilder();
            for (int j = 0; j < size; j++) {
                msg.append(board2D[i][j].print());
            }
            System.out.println(msg);
        }
    }
}
