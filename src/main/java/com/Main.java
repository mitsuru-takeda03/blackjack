package com;

/**
 * main
 * ゲームの初期化
 * playerの行動
 * dealerの行動
 */
public class Main {
    public static void main(String[] args){
        Field field = new Field();
        field.initTurn();
        while(field.playerTurn())
            continue;
        while(field.dealerTurn())
            continue;
        field.judge();
    }
}
