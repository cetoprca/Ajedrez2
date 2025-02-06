package com.cesar.ajedrez2;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

//        Board board = new Board(8, true);
//        board.add(3,3, new Knight(true));

        board.show();
        board.move(6, 0, 5, 0, false);
        board.show();

        // TODO remake all the movement logic to use VOID instead of null
    }
}
