package com;

import com.env.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 競技フィールドのクラス
 * ゲームの進行を行う
 */
public class EnvironmentPvsP extends Environment{
    private Record record;

    /**
     * playerとdealerを初期化し山札をシャッフル
     */
    public EnvironmentPvsP(){
        super();
        System.out.println("Player's money: "+player.getMoney());
    }

    /**
     * はじめにplayerとdealerはそれぞれ2枚引く
     * 引いたカードを公開する
     */
    public void initTurn(){
        // bet
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much money do you bet?");
        bet = scanner.nextInt();
        // deal
        super.resetEnvironment();
        // record
        ArrayList<Card> initCards = new ArrayList<Card>(player.getHand());
        initCards.add(dealer.getHand().get(0));
        record = new Record(initCards);
        record.print();
    }

    /**
     * カードを引くか確認する
     * 引く場合はゲームを進行
     * @return 引いた場合にtrueを返す
     */
    public boolean playerTurn() {
        boolean didDraw = playerAct(player, player.inputAction());
        if(didDraw)
            player.getHand().get(player.getHand().size()-1).print();
        if(!canPlayerDraw)
            return false;
        return true;
    }

    /**
     * playerと同じ
     */
    public boolean dealerTurn(){
        boolean didDraw = dealerAct(dealer, dealer.inputAction());
        if(didDraw)
            dealer.getHand().get(dealer.getHand().size()-1).print();
        if(!canDealerDraw)
            return false;
        return true;
    }

    /**
     * 勝敗判定+結果表示
     */
    public void printJudge(){
        int playerScore = player.checkSum();
        int dealerScore = dealer.checkSum();
        System.out.println("-------------------------------");
        if(playerScore > 0)
            System.out.println("Player: " + playerScore);
        else
            System.out.println("Player: Bust");
        if(dealerScore > 0)
            System.out.println("Dealer: " + dealerScore);
        else
            System.out.println("Dealer: Bust");
        if(playerScore > dealerScore) {
            System.out.println("result: Player won "+bet);
            settleBet(1);
        }
        else if(playerScore == dealerScore && dealerScore > 0)
            System.out.println("result: Draw");
        else {
            System.out.println("result: Dealer collected "+bet);
            settleBet(-1);
        }
        System.out.println("-------------------------------");
    }

    public void settleBet(int didPlayerWin){
        player.setMoney(player.getMoney() + bet * didPlayerWin);
        dealer.setMoney(dealer.getMoney() + bet * didPlayerWin);
        System.out.println("player's money: "+player.getMoney());
    }
}
