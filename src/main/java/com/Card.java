package com;

/**
 * トランプのカード
 * タプルとかもっといい方法があったら教えてください。
 */
public class Card {
    private String suit;
    private int number;

    Card(String newSuit, int newNum){
        suit = newSuit;
        number = newNum;
    }

    public String getSuit(){
        return suit;
    }

    public int getNumber(){
        return number;
    }
}
