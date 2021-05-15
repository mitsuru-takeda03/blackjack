package com.env;

import com.env.Card;

import java.util.ArrayList;

/**
 * 場に公開している情報を持つクラス
 * カードと各プレイヤーが何回引いたかを保持する
 */
public class Record {
    private ArrayList<Card> initCards;
    private int playerDrawNum;
    private int dealerDrawNum;
    String enter = System.lineSeparator();

    public Record(ArrayList<Card> initCards){
        this.initCards = initCards;
        playerDrawNum = 2;
        dealerDrawNum = 2;
    }

    @Override
    public String toString(){
        String string = "-------------------------------------------" + enter;
        string += "Player's cards: " + initCards.get(0).toString() + ", " + initCards.get(1).getNumber() + enter;
        string += "Player have drown in " + playerDrawNum + " times." + enter;
        string += "Dealer's cards: " + initCards.get(2).toString() + ", " + enter;
        string += "Dealer have drown in " + dealerDrawNum + " times." + enter;
        string += "-------------------------------------------";
        return string;
    }

    public void addPlayerDrawNum(){
        playerDrawNum += 1;
    }

    public void addDealerDrawNum(){
        dealerDrawNum += 1;
    }

}
