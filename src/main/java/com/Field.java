package com;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 競技フィールドのクラス
 * ゲームの進行を行う
 */
public class Field {
    private Player player;
    private Dealer dealer;
    private CardDeck cardDeck;
    private Record record;
    private int bet;

    /**
     * playerとdealerを初期化し山札をシャッフル
     */
    Field(){
        player = new Player();
        dealer = new Dealer();
        cardDeck = new CardDeck();
        cardDeck.shuffle();
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
        cardDeck = new CardDeck();
        cardDeck.shuffle();
        player.resetHand();
        dealer.resetHand();
        ArrayList<Card> initCards = new ArrayList<Card>();
        for(int i = 0; i < 4; i++){
            initCards.add(cardDeck.pop());
        }
        player.drawCard(initCards.get(0));
        player.drawCard(initCards.get(1));
        dealer.drawCard(initCards.get(2));
        dealer.drawCard(initCards.get(3));
        record = new Record(initCards);
        record.print();
    }

    /**
     * カードを引くか確認する
     * 引く場合はゲームを進行
     * @return 引いた場合にtrueを返す
     */
    public boolean playerTurn() {
        /**
         * actionは
         * Stand:0, Hit:1, Double:2, Surrender:3
         * bustなら即時終了
         * @return ターン継続ならtrue
         * ただここに書くのは気持ち悪い気がする。。。
         */
        if(player.checkSum()==-1) //bust
            return false;

        int action = player.inputAction();
        if(action==0 || action==3) { //Stand or Surrender
            if(action==3)
                bet /= 2;
            return false;
        }
        else if(action==1 || action==2){ //Hit or Double
            Card newCard = cardDeck.pop();
            newCard.print();
            player.drawCard(newCard);
            record.addPlayerDrawNum();
            if(action==2) { // Double
                bet *= 2;
                return false;
            }
            else // Hit
                return true;
        }
        else{ // invalid action
            return true;
        }
    }

    /**
     * playerとほぼ同じ
     */
    public boolean dealerTurn(){
        if(dealer.checkSum()==-1) //bust
            return false;

        int action = dealer.inputAction();
        if(action==0) //Stand
            return false;
        else if(action==1){ //Hit
            Card newCard = cardDeck.pop();
            newCard.print();
            dealer.drawCard(newCard);
            record.addDealerDrawNum();
            return true;
        }
        else{ // invalid action
            return true;
        }
    }

    /**
     * 勝敗判定+結果表示
     */
    public void judge(){
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
