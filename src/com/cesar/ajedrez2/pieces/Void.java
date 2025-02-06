package com.cesar.ajedrez2.pieces;

public class Void extends Piece{
    public Void() {
        super(PieceID.VOID);
    }

    @Override
    public String print() {
        return "[] ";
    }
}
