package org.tuncerburak;


import org.tuncerburak.competitors.Ai;
import org.tuncerburak.competitors.Player;
import org.tuncerburak.indexes.Horizontal;
import org.tuncerburak.indexes.Vertical;
import org.tuncerburak.indexes.diagonal.LeftDiagonal;
import org.tuncerburak.indexes.diagonal.RightDiagonal;

import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class Game {

    public void play(){

        Board board = new Board();

        Random random = new Random();

        int size= board.gameBoardSizeChecker();

        String[][] gameBoard = new String[size][size];


        List<LeftDiagonal> leftDiagonalList = new ArrayList<>();
        List<RightDiagonal> rightDiagonalList = new ArrayList<>();
        List<Horizontal> horizontalList = new ArrayList<>();
        List<Vertical> verticalList = new ArrayList<>();

        Horizontal horizontal = new Horizontal(0,0,0,0,0,0);
        horizontalList.add(horizontal);

        Vertical vertical =new Vertical(0,0,0,0,0,0);
        verticalList.add(vertical);

        LeftDiagonal leftDiagonal = new LeftDiagonal(0,0,0,0,0,0);
        leftDiagonalList.add(leftDiagonal);

        RightDiagonal rightDiagonal = new RightDiagonal(0,0,0,0,0,0);
        rightDiagonalList.add(rightDiagonal);

        Player player = new Player();
        Ai ai = new Ai();
        int[] playerScore= new int[1];
        int[] aiScore= new int[1];

        SosChecker sosChecker = new SosChecker();

        board.initializeBoard(gameBoard);
        boolean isBoardFull=false;

        int startingOrderDeterminer=random.nextInt((1) + 1);

        if(startingOrderDeterminer==0)
            System.out.println("Player starting the game");
        else
            System.out.println("Ai starting the game");


        while (!isBoardFull){


            if(startingOrderDeterminer==0){

                player.playerMove(gameBoard);
                sosChecker.sosCheckerForPoint(gameBoard,horizontalList,verticalList,leftDiagonalList,rightDiagonalList,"Player",aiScore,playerScore);

                board.printBoard(gameBoard);
                board.displayScores(aiScore,playerScore);

                isBoardFull=board.isFinish(gameBoard);

                if(isBoardFull)
                    break;

                ai.playAI(gameBoard);

                sosChecker.sosCheckerForPoint(gameBoard,horizontalList,verticalList,leftDiagonalList,rightDiagonalList,"Ai",aiScore,playerScore);

                board.printBoard(gameBoard);
                board.displayScores(aiScore,playerScore);

                isBoardFull =board.isFinish(gameBoard);

                if(isBoardFull)
                    break;

            }

            else{

                ai.playAI(gameBoard);

                sosChecker.sosCheckerForPoint(gameBoard,horizontalList,verticalList,leftDiagonalList,rightDiagonalList,"Ai",aiScore,playerScore);

                board.printBoard(gameBoard);
                board.displayScores(aiScore,playerScore);

                isBoardFull =board.isFinish(gameBoard);

                if(isBoardFull)
                    break;

                player.playerMove(gameBoard);
                sosChecker.sosCheckerForPoint(gameBoard,horizontalList,verticalList,leftDiagonalList,rightDiagonalList,"Player",aiScore,playerScore);

                board.printBoard(gameBoard);
                board.displayScores(aiScore,playerScore);

                isBoardFull=board.isFinish(gameBoard);

                if(isBoardFull)
                    break;
            }
        }
        board.gameResult(playerScore,aiScore);

    }
}
