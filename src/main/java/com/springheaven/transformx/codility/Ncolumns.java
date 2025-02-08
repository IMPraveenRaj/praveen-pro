package com.springheaven.transformx.codility;

public class Ncolumns {

    //there are N COlumns made of 1X1 blocks standing next to each other . The heigh of the consecutive columns forms non-decreasing sequence . The height of the kth colum (for within the rand of [0..N-1] IS A[K]).
    //what is the larges square made of blocks taht can be found int the sequence

    //write a function
    //given an array consising of N integer, returns the side length of the largest square that can be found in A G
    //Given an arrary int[] a =[1,2,2,4,4,5] youthat largest squate the can be found intt he sequence is marked in blue in the picture


    public static void main(String[] args) {


        int columnHeight[]={7,8,9,10,11,12};
        int maxSquaresize=0;
        int totalColumn=columnHeight.length;

        for(int i=0;i<totalColumn;i++){
            int currentHeight=columnHeight[i];
            int remainingColums=totalColumn-i;
            int posssibleSquareSize=Math.min(currentHeight,remainingColums);
            maxSquaresize=Math.max(maxSquaresize,posssibleSquareSize);
        }
        System.out.println(maxSquaresize);

        int maxsquareSolution = otherSolution(columnHeight);
        System.out.println(maxsquareSolution);
    }

    private static int otherSolution(int[] columnHeight) {

        int maxSquaresize=0;
        int totalColumn=columnHeight.length;
        for(int i=0;i<totalColumn;i++){
            int currentHeight=columnHeight[i];
            int remainingColums=totalColumn-i;

            if (currentHeight<=remainingColums){
                maxSquaresize=currentHeight;
            }else if(remainingColums > maxSquaresize){
                maxSquaresize=remainingColums;
            }

        }
        return maxSquaresize;
    }

}
