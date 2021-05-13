package com;

import java.util.Scanner;

/**
 * main
 * ゲームの初期化
 * playerの行動
 * dealerの行動
 */
public class Main {
    public static void main(String[] args){
        Field field = new Field();
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you play Another Game?");
            System.out.println("NO: 0, YES: 1");
            int isNewGame = scanner.nextInt();
            if(isNewGame==1) {
                field.initTurn();
                while (field.playerTurn())
                    continue;
                while (field.dealerTurn())
                    continue;
                field.judge();
            }
            else {
                System.out.println("See you next time!");
                break;
            }
        }
    }
}
