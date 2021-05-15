package com;

import com.env.State;

import java.util.Scanner;

/**
 * main
 * ゲームの初期化
 * playerの行動
 * dealerの行動
 */
public class Main {
    public static void main(String[] args){
        EnvironmentPvsP environmentPvsP = new EnvironmentPvsP();
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you play Another Game?");
            System.out.println("NO: 0, YES: 1");
            int isAnotherGame = scanner.nextInt();
            if(isAnotherGame==1) {
                environmentPvsP.initTurn();
                while (environmentPvsP.callGMState().equals(State.PlayerTurn))
                    environmentPvsP.playerTurn();
                while (environmentPvsP.callGMState().equals(State.DealerTurn))
                    environmentPvsP.dealerTurn();

                environmentPvsP.gameMasterTurn();
            }
            else {
                System.out.println("See you next time!");
                break;
            }
        }
    }
}
