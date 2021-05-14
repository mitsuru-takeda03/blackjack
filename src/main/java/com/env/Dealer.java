package com.env;

import java.util.Scanner;

/**
 * playerクラスを継承
 * カードの合計が16以下では降りれない
 */
public class Dealer extends Player {
    /**
     * isContinueに16以下では降りれないようにする機能を追加
     */
    protected int money = 10000;
    @Override
    public int inputAction(){
        printHand();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Decide your action.");
        System.out.println("0: Stand");
        System.out.println("1: Hit");
        int action = scanner.nextInt();
        if(checkSum() < 17 && checkSum() > 0 && action == 0){
            System.out.println("Dealer can't stand under 17");
            return 1;
        }
        else if(action == 0 || action == 1)
            return action;
        else{
            System.out.println("Invalid action");
            return -1;
        }
    }
}
