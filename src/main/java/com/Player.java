package com;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private ArrayList<Card> hand;
    private int sumCard;
    private int money=1000;

    /**
     * playerクラス
     * 手札を保持し、ドロー処理、継続確認、合計を計算
     */
    Player(){
        hand = new ArrayList<>();
    }

    public void resetHand(){
        hand = new ArrayList<>();
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int money){
        this.money = money;
    }

    public void drawCard(Card newCard){
        hand.add(newCard);
        checkSum();
    }

    public void printHand(){
        System.out.println("-------------------------------");
        System.out.println("Your Hands");
        for(Card card : hand){
            System.out.println("suit: "+card.getSuit()+", number: "+card.getNumber());
        }
        System.out.println("-------------------------------");
    }

    /**
     * 行動をコンソールで入力
     * @return 各行動のインデックス
     */
    public int inputAction(){
        printHand();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Decide your action.");
        System.out.println("0: Stand");
        System.out.println("1: Hit");
        System.out.println("2: Double");
        System.out.println("3: Surrender");
        int action = scanner.nextInt();
        if(action >= 0 && action < 4)
            return action;
        else {
            System.out.println("Invalid action");
            return -1;
        }
    }

    /**
     * 合計を計算
     * @return 合計値
     */
    public int checkSum(){
        int sumCard = 0;
        int countA = 0;
        for (Card card : hand){
            if (card.getNumber() > 10) {
                sumCard += 10;
            }
            else {
                sumCard += card.getNumber();
            }
            /**
             * Aの枚数をカウント
             */
            if (card.getNumber() == 1)
                countA += 1;
        }
        /**
         * Aの処理
         * 21を超えない範囲で1を11に変換
         */
        for(int i = 0; i < countA; i++){
            if(sumCard + 10 < 21)
                sumCard += 10;
        }
        if(sumCard > 21)
            sumCard = -1;
        return sumCard;
    }
}
