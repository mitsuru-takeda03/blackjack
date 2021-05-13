package RL.env;
import com.Card;

import java.util.ArrayList;

public class State {
    private ArrayList<Card> playerCards;
    private int playerCardsNum;
    private ArrayList<Card> dealerCards;
    private static int stateDimension = 2000;

    State(){
    }

    public void setState(ArrayList<Card> playerCards, int playerCardsNum, ArrayList<Card> dealerCards){
        this.playerCards = playerCards;
        this.playerCardsNum = playerCardsNum;
        this.dealerCards = dealerCards;
    }

    public int getState(){
        int sumPlayerCards = 0;
        int sumDealerCards = 0;
        for(Card card : playerCards){
            sumPlayerCards += card.getNumber();
        }
        for(Card card : dealerCards){
            sumDealerCards += card.getNumber();
        }
        return playerCardsNum * 20 * 20 + sumPlayerCards * 20 + sumDealerCards;
    }

    public static int getStateDimension(){
        return stateDimension;
    }
}
