package org.tuncerburak;

import java.util.Arrays;
import java.util.Scanner;

public class Board {

    public  void initializeBoard(String[][] matrix){

        for(int i=0;i<matrix.length;i++){

            for (int j=0;j<matrix[0].length;j++){

                matrix[i][j]="-";
            }
        }
    }

    public  void printBoard(String mat[][])
    {

        System.out.print(" ");
        for (int row = 1; row < mat.length+1; row++) {
            System.out.print("  " + row );
        }
        System.out.println();
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                if (col < 1) {
                    System.out.print(row+1);
                    System.out.print("  " + mat[row][col]);
                } else {

                    System.out.print("  " + mat[row][col]);
                }
            }
            System.out.println();
        }

    }

    public void displayScores(int[] playerScore,int[] aiScore){


        for(int i:playerScore){
            System.out.println("Player score:"+i);
        }

        for(int i:aiScore){
            System.out.println("Ai score:"+i);
        }
    }

    public boolean isFinish(String board[][]){

        for(int i=0;i<board.length;i++){

            for (int j=0;j<board[0].length;j++){

                if(board[i][j].equals("-"))

                    return false;
            }
        }

        return true;
    }

    public int gameBoardSizeChecker(){

        Scanner scanner = new Scanner(System.in);

        int size=0;

        int control=1;

        while (control!=0){

            System.out.print("Enter size:");
            size =scanner.nextInt();

            if(!(size>=3 && size<=7)){

                System.out.println("Index must be between 3 and 7");
                continue;
            }
            control--;
        }

        return size;
    }

    public void gameResult(int[] aiScore,int[] playerScore){

        String winnerMessage="";

        if(aiScore[0]>playerScore[0])
            winnerMessage+="Ai has won the game";

        else if(aiScore[0]<playerScore[0])
            winnerMessage+="Player has won the game";
        else
            winnerMessage+="Game is drow";



        System.out.println("\n\nAi total score:"+ Arrays.toString(aiScore));
        System.out.println("Player total score"+ Arrays.toString(playerScore));
        System.out.println(winnerMessage);


    }



}
