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

    /**
     * playerとdealerを初期化し山札をシャッフル
     */
    Field(){
        player = new Player();
        dealer = new Dealer();
        cardDeck = new CardDeck();
        cardDeck.shuffle();
    }

    /**
     * はじめにplayerとdealerはそれぞれ2枚引く
     * 引いたカードを公開する
     */
    public void initTurn(){
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
        Scanner scanner = new Scanner(System.in);
        boolean isContinue = player.isContinue();
        if(isContinue) {
            Card newCard = cardDeck.pop();
            player.drawCard(newCard);
            record.addPlayerDrawNum();
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * TODO
     * 名前が違うだけなのでplayerとまとめたい
     */
    public boolean dealerTurn(){
        Scanner scanner = new Scanner(System.in);
        boolean isContinue = dealer.isContinue();
        if(isContinue) {
            Card newCard = cardDeck.pop();
            dealer.drawCard(newCard);
            record.addDealerDrawNum();
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 勝敗判定
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
            System.out.println("result: Player win");
        }
        else if(playerScore == dealerScore && dealerScore > 0)
            System.out.println("result: Draw");
        else {
            System.out.println("result: Dealer win");
        }
        System.out.println("-------------------------------");
    }
}
