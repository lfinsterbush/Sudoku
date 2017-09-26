package com.sample.sudokufifty;

import java.io.IOException;

public class SudokuFifty {

    public static void main(String[] args) throws IOException {
        String filename = "C:/sudokuList.txt";

        try {
            ReadFile file = new ReadFile(filename);
            int[][] outLines = file.OpenFile();

            Solver fifty = new Solver(outLines);
            int[][] solvedPuzzles = fifty.SolvePuzzle();

            //Output solution to Project Euler Problem 96, Summation of all 3 digit numbers found in the top left corner
            //of all 50 solved Sudoku puzzles.
            int total = 0;
            for (int c = 0; c < 50; c++){
                int subtotal = Integer.valueOf(String.valueOf(solvedPuzzles[c][0])+ String.valueOf(solvedPuzzles[c][1])+ String.valueOf(solvedPuzzles[c][2]));
                total = total + subtotal;
            }
            System.out.println("The sum of the 3 digit number in the top left corner for all 50 puzzles is: " + total);

            for (int i = 0; i < outLines.length; i++) {
                for (int j = 0; j < 81; j++) {
                    System.out.print(outLines[i][j]);
                }
                System.out.println();
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}