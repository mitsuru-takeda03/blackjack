package com.env;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;
    private int sumCard;
    private String enter = System.lineSeparator();

    public void reset(){
        hand = new ArrayList<>();
    }

    public void addCard(Card newCard){ hand.add(newCard); }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public Card getLastCard() {return hand.get(hand.size() - 1);}

    @Override
    public String toString(){
        String string = "";
        for(int i = 0; i < hand.size(); i++) {
            string += hand.get(i).toString();
            if(i != hand.size() - 1)
                string += enter;
        }
        return string;
    }

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
        if(sumCard > 21) // bust
            sumCard = -1;
        return sumCard;
    }
}
