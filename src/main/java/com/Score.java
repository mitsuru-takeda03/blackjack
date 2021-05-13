package com;

import java.util.ArrayList;

public class Score {
    private ArrayList<Card> initCards;
    private int playerDrawNum;
    private int dealerDrawNum;

    Score(ArrayList<Card> initCards){
        this.initCards = initCards;
        playerDrawNum = 2;
        dealerDrawNum = 2;
    }

    public void print(){
        System.out.println("-------------------------------");
        System.out.println("Player's cards: "+initCards.get(0).getNumber()+", "+initCards.get(1).getNumber());
        System.out.println("Player have drown in "+playerDrawNum+" times.");
        System.out.println("Dealer's cards: "+initCards.get(2).getNumber());
        System.out.println("Dealer have drown in "+dealerDrawNum+" times.");
        System.out.println("-------------------------------");
    }

    public void addPlayerDrawNum(){
        playerDrawNum += 1;
    }

    public void addDealerDrawNum(){
        dealerDrawNum += 1;
    }

}
