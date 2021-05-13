package com;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private ArrayList<Card> hand;
    private int sumCard;

    /**
     * playerクラス
     * 手札を保持し、ドロー処理、継続確認、合計を計算
     */
    Player(){
        hand = new ArrayList<>();
    }

    public void drawCard(Card newCard){
        hand.add(newCard);
        checkSum();
    }

    public void checkCards(){
        System.out.println("-------------------------------");
        System.out.println("Your Hands");
        for(Card card : hand){
            System.out.println("suit: "+card.getSuit()+", number: "+card.getNumber());
        }
        System.out.println("-------------------------------");
    }

    /**
     * ゲームの継続確認
     * @return 継続するならtrue
     */
    public boolean isContinue(){
        checkCards();
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        if(inputLine.equals("yes") || inputLine.equals("Yes") || inputLine.equals("YES"))
            return true;
        else
            return false;
    }

    /**
     * 合計を計算
     * @return 合計値
     * TODO
     * Aの処理
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
