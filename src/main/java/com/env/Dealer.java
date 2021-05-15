package com.env;

import java.util.Scanner;

/**
 * Dealerクラス
 * カードの合計が16以下では降りれない
 */
public class Dealer {
    private Hand hand;
    private int money = 10000;

    /**
     * 手札を保持し、ドロー処理、継続確認、合計を計算
     */
    public Dealer() { hand = new Hand(); }

    public Hand getHand() { return hand; }

    public int getMoney(){
        return money;
    }

    public void setMoney(int money){
        this.money = money;
    }

    /**
     * コンソールでアクションを決定
     * isContinueに16以下では降りれないようにする機能を追加
     */
    public Action inputAction(){
        System.out.println("-------------------------------------------");
        System.out.println("Dealer's Hands");
        System.out.println(hand.toString());;
        System.out.println("-------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Decide your action.");
        System.out.println("0: Stand");
        System.out.println("1: Hit");
        int action = scanner.nextInt();
        if(action == 0){
            if(hand.checkSum() < 17 && hand.checkSum() > 0){
                System.out.println("Dealer can't stand under 17");
                return Action.Hit;
            }
            return Action.Stand;
        }
        else if(action == 1)
            return Action.Hit;
        else{
            System.out.println("Invalid action");
            return Action.Invalid;
        }
    }
}
