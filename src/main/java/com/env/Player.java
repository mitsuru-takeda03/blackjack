package com.env;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * playerクラス
 * 手札を保持し、ドロー処理、継続確認、合計を計算
 */
public class Player {
    private Hand hand;
    private int money = 1000;

    public Player() { hand = new Hand(); }

    public Hand getHand() { return hand; }

    public int getMoney(){
        return money;
    }

    public void setMoney(int money){
        this.money = money;
    }

    /**
     * 行動をコンソールで入力
     * @return 各行動のインデックス
     */
    public Action inputAction(){
        System.out.println("-------------------------------------------");
        System.out.println("Player's Hands");
        System.out.println(hand.toString());
        System.out.println("-------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Decide your action.");
        System.out.println("0: Stand");
        System.out.println("1: Hit");
        System.out.println("2: Double");
        System.out.println("3: Surrender");
        int action = scanner.nextInt();
        if(action == 0)
            return Action.Stand;
        else if(action == 1)
            return Action.Hit;
        else if(action == 2)
            return Action.Double;
        else if(action == 3)
            return Action.Surrender;
        else{
            System.out.println("Invalid action");
            return Action.Invalid;
        }
    }
}
