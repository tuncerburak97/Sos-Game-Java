package org.tuncerburak.competitors;


import java.util.Random;
import java.util.Scanner;

public class Player {

    public void addValuePlayer(String mat[][],int row,int column){

        String value ="os";
        String[] part = value.split("");
        Random random = new Random();
        int selectValueIndex = random.nextInt((1 - 0) + 1);

        mat[row-1][column-1] = part[selectValueIndex];

        System.out.println("Player played.");

    }

    public void playerMove(String gameBoard[][]){

        Scanner scanner = new Scanner(System.in);
        boolean isUnique=true;

        while (isUnique){

            System.out.print("Please enter your row which you want to add:");
            int row = scanner.nextInt();
            System.out.print("Please enter your column which you want to add:");
            int column = scanner.nextInt();

            if (row >= gameBoard.length+1 || column >= gameBoard.length+1) {

                System.out.println("Out of index.Please check your indexes.");
                continue;
            }
            if (row==0 ||column==0){
                System.out.println("Row and column number must be bigger than 0");
                continue;
            }
            if (!gameBoard[row - 1][column - 1].equals("-")) {
                System.out.println("This spot is occupied. Please try again");
                continue;

            }
            this.addValuePlayer(gameBoard,row,column);
            isUnique=false;
        }

    }


}
