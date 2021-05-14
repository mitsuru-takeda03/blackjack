package com.env;

/**
 * トランプのカード
 * タプルとかもっといい方法があったら教えてください。
 */
public class Card {
    private String suit;
    private int number;

    public Card(String newSuit, int newNum){
        suit = newSuit;
        number = newNum;
    }

    public void print(){
        System.out.println("suit: "+suit+" number: "+number);
    }

    public String getSuit(){
        return suit;
    }

    public int getNumber(){
        return number;
    }
}
