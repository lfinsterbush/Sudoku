package com.sample.sudokufifty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    private String path;

    public ReadFile(String file_path){
        path = file_path;
    }

    //Read file passed from main and return data in 2d array [puzzle number][puzzle data].
    public int[][] OpenFile() throws IOException {
        FileReader fileread = new FileReader(path);
        BufferedReader textreader = new BufferedReader(fileread);

        int numberOfLines = readLines();
        int sudokuSize = 81;
        int noPuzzles = 50;
        String header = "grid";
        String[] textData = new String[numberOfLines];
        int[][] sudokuData = new int[noPuzzles][sudokuSize];
        int i,j;
        int a=-1;
        int b=0;

        for (i=0; i < numberOfLines; i++){
            textData[i] = textreader.readLine();
            if (textData[i].toLowerCase().contains(header)) {
                a++;
            }
            else {
                char[] ch = textData[i].toCharArray();
                for (j=0; j < ch.length; j++){
                    sudokuData[a][b] = Character.getNumericValue(ch[j]);
                    b++;
                    if(b==sudokuSize){
                        b=0;
                    }
                }
            }
        }
        textreader.close();
        return sudokuData;
    }

    //Return total lines read from file.
    private int readLines() throws IOException{
        FileReader fr = new FileReader(path);
        BufferedReader bf = new BufferedReader(fr);

        String line;
        int totallines = 0;

        while((line = bf.readLine()) != null){
            totallines++;
        }
        bf.close();
        return totallines;
    }
}