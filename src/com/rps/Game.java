package com.rps;

import java.util.Random;
import java.util.Scanner;



class RPS{
    public static final String ROCK= "ROCK";
    public static final String SCISSORS = "SCISSORS";
    public static final String PAPER= "PAPER";

}

public class Game {

    private int totalGames;
    private int aWins; // a her zaman paper
    private int bWins;
    private int ties;

    private Random rand = new Random();
//

    public String getBMove(){
        switch (rand.nextInt(3)){
            case 2:
                return RPS.PAPER;
            case 1:
                return RPS.ROCK;
            case 0:
                return RPS.SCISSORS;

        }
        return null;
    }

    public String getAMove() {
        switch (rand.nextInt(3)) {
            case 2:
                return RPS.PAPER;
            case 1:
                return RPS.PAPER;
            case 0:
                return RPS.PAPER;
        }
        return null;
    }

    public String playRound(Scanner s) {
        String bMove = getBMove();
        System.out.println("Player  B chooses: " + bMove);
        String aMove = getAMove();
        System.out.println("Player  A chooses: " + aMove);
        String outcome = getWinner(aMove, bMove);
        return outcome;
    }

    public String getWinner(String aMove, String bMove) {
        switch (aMove) {
            case RPS.ROCK:
                switch (bMove) {
                    case RPS.ROCK:
                        return recordRound(Outcome.TIE);
                    case RPS.PAPER:
                        return recordRound(Outcome.B_WIN);
                    case RPS.SCISSORS:
                        return recordRound(Outcome.A_WIN);
                }
            case RPS.PAPER:
                switch (bMove) {
                    case RPS.ROCK:
                        return recordRound(Outcome.A_WIN);
                    case RPS.PAPER:
                        return recordRound(Outcome.TIE);
                    case RPS.SCISSORS:
                        return recordRound(Outcome.B_WIN);
                }
            case RPS.SCISSORS:
                switch (bMove) {
                    case RPS.ROCK:
                        return recordRound(Outcome.B_WIN);
                    case RPS.PAPER:
                        return recordRound(Outcome.A_WIN);
                    case RPS.SCISSORS:
                        return recordRound(Outcome.TIE);
                }
        }
        return null;
    }

    private String recordRound(Outcome aWin) {
        this.totalGames++;
        switch (aWin) {
            case B_WIN:
                this.bWins++;
                return "Player B wins!";
            case A_WIN:
                this.aWins++;
                return "Player A wins!";
            case TIE:
                this.ties++;
                return "TIE!";
        }
        return null;
    }



    public void start() {
        Scanner s = new Scanner(System.in);
        boolean play = true;
       do {
            System.out.println(playRound(s));
            System.out.println("'q' for quit or press anything  to continue: ");
            play = checkContinue(s.nextLine());
        } while (play);
        System.out.println(this.toString());
    }

    private boolean checkContinue(String choice) {
        return !choice.equalsIgnoreCase("q");
    }

    @Override
    public String toString() {
        return
                "Player A wins " + aWins +  " " + "of " +totalGames +" " + "games" +"\n"
                + "Player B wins " + bWins +   " " + "of " +totalGames +" " + "games" +"\n" +
                "Tie: " + ties + " " + "of " +totalGames +" " + "games";
    }

}