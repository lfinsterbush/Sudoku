package com.sample.sudokufifty;

import java.io.IOException;

public class SudokuFifty {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello, World!");

        String file_name = "C:/sudokuList.txt";


        try {
            ReadFile file = new ReadFile(file_name);
            int[][] outLines = file.OpenFile();

            Solver fifty = new Solver(outLines);
            int[][] solvedPuzzles = fifty.SolvePuzzle();

            System.out.println(solvedPuzzles[0][2]+solvedPuzzles[1][0]);

            int i, j;
            for (i = 0; i < outLines.length; i++) {
                for (j = 0; j < 81; j++) {
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
