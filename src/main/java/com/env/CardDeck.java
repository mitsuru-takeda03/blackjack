package com.env;

import com.env.Card;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 山札のクラス
 * シャッフルと一枚引くことができます。
 */
public class CardDeck {
    private ArrayList<Card> deck;

    public CardDeck(){
        deck = new ArrayList<Card>();
        for(int num = 1; num < 14; num++) {
            for (String suit : new String[]{"spade", "heart", "diamond", "club"}) {
                deck.add(new Card(suit, num));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card pop(){
        return deck.remove(0);
    }

}
