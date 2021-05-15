package com.env;

/**
 * トランプのカード
 * タプルとかもっといい方法があったら教えてください。
 */
public class Card {
    private final String suit;
    private final int number;

    public Card(String newSuit, int newNum){
        suit = newSuit;
        number = newNum;
    }

    public void print(){
        System.out.println("suit: "+suit+" number: "+number);
    }

    public int getNumber(){
        return number;
    }

    @Override
    public String toString(){
        return "suit: " + suit + ", number: " + number;
    }
}
