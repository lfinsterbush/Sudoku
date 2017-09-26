package com.sample.sudokufifty;

public class Solver {

    private int[][] unsolved;
    private int[][] basepuzzle = new int[50][81];
    private int j = 0;

    public Solver(int[][] solved){
        unsolved = solved;
    }

    public int[][] SolvePuzzle(){
        int i,k;
        int zeros = 0;

        while (j < 50) {
            for (i = 0; i < 81; i++){
                if (unsolved[j][i] == 0) {
                        zeros++;
                }
            }
            if (zeros != 0){
                zeros=0;

                for (k=0; k < 81; k++){
                    if (unsolved[j][k] == 0){
                        basepuzzle[j][k] = 0;

                        for (i=1; i <10; i++){
                            if (valid(k,i) && unsolved[j][k] != i){
                                unsolved[j][k] = i;
                                i=9;
                            } else if (i==9){
                                unsolved[j][k]=0;
                                k--;
                                while(basepuzzle[j][k] != 0){
                                    k--;
                                }
                                i=unsolved[j][k]-1;


                            }


                        }

                    } else {
                        basepuzzle[j][k] = unsolved[j][k];
                    }
                }
            }
            else{
                j++;
            }
        }
        return unsolved;
    }

    public boolean valid(int positiontocheck, int valuetocheck){
        int[] row = FindRow(positiontocheck);
        for (int i=0; i < row.length; i++){
            if (unsolved[j][row[i]] == valuetocheck){
                return false;
            }
        }

        int[] col = FindCol(positiontocheck);
        for (int i=0; i < col.length; i++){
            if (unsolved[j][col[i]] == valuetocheck){
                return false;
            }
        }

        int[] block = FindBlock(positiontocheck);
        for (int i=0; i < block.length; i++){
            if (unsolved[j][block[i]] == valuetocheck){
                return false;
            }
        }
        return true;
    }


    public int[] FindRow(int currentRow){
        int[] row1 = {0,1,2,3,4,5,6,7,8};
        int[] row2 = {9,10,11,12,13,14,15,16,17};
        int[] row3 = {18,19,20,21,22,23,24,25,26};
        int[] row4 = {27,28,29,30,31,32,33,34,35};
        int[] row5 = {36,37,38,39,40,41,42,43,44};
        int[] row6 = {45,46,47,48,49,50,51,52,53};
        int[] row7 = {54,55,56,57,58,59,60,61,62};
        int[] row8 = {63,64,65,66,67,68,69,70,71};
        int[] row9 = {72,73,74,75,76,77,78,79,80};

        for (int i=0; i < row1.length; i++){
            if (row1[i] == currentRow){
                return row1;
            }
        }

        for (int i=0; i < row2.length; i++){
            if (row2[i] == currentRow){
                return row2;
            }
        }

        for (int i=0; i < row3.length; i++){
            if (row3[i] == currentRow){
                return row3;
            }
        }
        for (int i=0; i < row4.length; i++){
            if (row4[i] == currentRow){
                return row4;
            }
        }
        for (int i=0; i < row5.length; i++){
            if (row5[i] == currentRow){
                return row5;
            }
        }
        for (int i=0; i < row6.length; i++){
            if (row6[i] == currentRow){
                return row6;
            }
        }
        for (int i=0; i < row7.length; i++){
            if (row7[i] == currentRow){
                return row7;
            }
        }
        for (int i=0; i < row8.length; i++){
            if (row8[i] == currentRow){
                return row8;
            }
        }
        for (int i=0; i < row9.length; i++){
            if (row9[i] == currentRow){
                return row9;
            }
        }
        return null;
    }

    public int[] FindCol(int currentCol){
        int[] col1 = {0,9,18,27,36,45,54,63,72};
        int[] col2 = {1,10,19,28,37,46,55,64,73};
        int[] col3 = {2,11,20,29,38,47,56,65,74};
        int[] col4 = {3,12,21,30,39,48,57,66,75};
        int[] col5 = {4,13,22,31,40,49,58,67,76};
        int[] col6 = {5,14,23,32,41,50,59,68,77};
        int[] col7 = {6,15,24,33,42,51,60,69,78};
        int[] col8 = {7,16,25,34,43,52,61,70,79};
        int[] col9 = {8,17,26,35,44,53,62,71,80};
        for (int i=0; i < col1.length; i++){
            if (col1[i] == currentCol){
                return col1;
            }
        }
        for (int i=0; i < col2.length; i++){
            if (col2[i] == currentCol){
                return col2;
            }
        }
        for (int i=0; i < col3.length; i++){
            if (col3[i] == currentCol){
                return col3;
            }
        }
        for (int i=0; i < col4.length; i++){
            if (col4[i] == currentCol){
                return col4;
            }
        }
        for (int i=0; i < col5.length; i++){
            if (col5[i] == currentCol){
                return col5;
            }
        }
        for (int i=0; i < col6.length; i++){
            if (col6[i] == currentCol){
                return col6;
            }
        }
        for (int i=0; i < col7.length; i++){
            if (col7[i] == currentCol){
                return col7;
            }
        }
        for (int i=0; i < col8.length; i++){
            if (col8[i] == currentCol){
                return col8;
            }
        }
        for (int i=0; i < col9.length; i++){
            if (col9[i] == currentCol){
                return col9;
            }
        }
        return null;
    }

    public int[] FindBlock(int currentBlock){
        int[] block1 = {0,1,2,9,10,11,18,19,20};
        int[] block2 = {3,4,5,12,13,14,21,22,23};
        int[] block3 = {6,7,8,15,16,17,24,25,26};
        int[] block4 = {27,28,29,36,37,38,45,46,47};
        int[] block5 = {30,31,32,39,40,41,48,49,50};
        int[] block6 = {33,34,35,42,43,44,51,52,53};
        int[] block7 = {54,55,56,63,64,65,72,73,74};
        int[] block8 = {57,58,59,66,67,68,75,76,77};
        int[] block9 = {60,61,62,69,70,71,78,79,80};
        for (int i=0; i < block1.length; i++){
            if (block1[i] == currentBlock){
                return block1;
            }
        }
        for (int i=0; i < block2.length; i++){
            if (block2[i] == currentBlock){
                return block2;
            }
        }
        for (int i=0; i < block3.length; i++){
            if (block3[i] == currentBlock){
                return block3;
            }
        }
        for (int i=0; i < block4.length; i++){
            if (block4[i] == currentBlock){
                return block4;
            }
        }
        for (int i=0; i < block5.length; i++){
            if (block5[i] == currentBlock){
                return block5;
            }
        }
        for (int i=0; i < block6.length; i++){
            if (block6[i] == currentBlock){
                return block6;
            }
        }
        for (int i=0; i < block7.length; i++){
            if (block7[i] == currentBlock){
                return block7;
            }
        }
        for (int i=0; i < block8.length; i++){
            if (block8[i] == currentBlock){
                return block8;
            }
        }
        for (int i=0; i < block9.length; i++){
            if (block9[i] == currentBlock){
                return block9;
            }
        }
        return null;
    }
}
