package com;

import com.env.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ゲーム環境のクラス
 * Environmentのラッパーで画面出力を行う
 */
public class EnvironmentPvsP extends Environment{

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
        // print
        System.out.println(record.toString());;
    }

    /**
     * カードを引くか確認する
     * 引く場合はゲームを進行
     * @return 引いた場合にtrueを返す
     */
    public void playerTurn() {
        boolean didDraw = playerAct(player, player.inputAction());
        if(didDraw)
            System.out.println("Player drew " + player.getHand().getLastCard().toString());
    }

    /**
     * playerと同じ
     */
    public void dealerTurn(){
        boolean didDraw = dealerAct(dealer, dealer.inputAction());
        if(didDraw)
            System.out.println("Dealer drew " + dealer.getHand().getLastCard().toString());
    }

    /**
     * gameMasterの動作
     * 勝敗を決定し
     * 結果をコンソール画面に出力
     */
    public void gameMasterTurn() {
        gameMasterAct(gameMaster);
        System.out.println(gameMaster.toString());
        System.out.println("Player's money: " + player.getMoney());
        System.out.println();
    }
}
