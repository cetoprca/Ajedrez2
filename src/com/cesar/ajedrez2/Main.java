package com.cesar.ajedrez2;

import com.cesar.ajedrez2.pieces.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.show();

        menu(board);
    }

    public static void menu(Board board){
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit){
            List<String> input = List.of(scanner.nextLine().toLowerCase().split(" "));

            if (board.end && !input.getFirst().equals("reset")){
                System.out.println("Please enter the reset command to make a new board");
            }else {
                switch (input.getFirst()){
                    case "move" -> {
                        try {
                            int originRow = Integer.parseInt(input.get(1));
                            int originCol = Integer.parseInt(input.get(2));
                            int finalRow = Integer.parseInt(input.get(3));
                            int finalCol = Integer.parseInt(input.get(4));

                            if (input.size() == 6) {
                                int showMoves = Integer.parseInt(input.get(5));
                                try {
                                    board.move(originRow, originCol, finalRow, finalCol, showMoves == 1);
                                }catch (Exception e){
                                    System.out.println(Arrays.toString(e.getStackTrace()));
                                }
                            } else{
                                try {
                                    board.move(originRow, originCol, finalRow, finalCol, false);
                                }catch (Exception e){
                                    System.out.println(Arrays.toString(e.getStackTrace()));
                                }
                            }
                        }catch (NumberFormatException _){
                            System.out.println("Incorrect parameters");
                        } catch (IndexOutOfBoundsException _){
                            System.out.println("Not enough arguments");
                        }
                    }
                    case "clear" -> board.clear();
                    case "reset" -> {
                        System.out.println("New board");
                        board.reset();
                        board.show();
                    }
                    case "change" -> board.whiteTurn = !board.whiteTurn;
                    case "show" -> board.show();
                    case "exit" -> exit = true;
                }
            }
        }
    }

    // TODO Add promotion
    // TODO Add documentation
}
