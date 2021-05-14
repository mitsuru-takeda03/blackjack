package RL.env.dealer;
import com.env.Card;

import java.util.ArrayList;

public class DealerObs {
    private ArrayList<Card> playerCards;
    private int playerCardsNum;
    private ArrayList<Card> dealerCards;
    private static int ObservationDimension = 2000;

    DealerObs(){
    }

    public void setObservation(ArrayList<Card> playerCards, int playerCardsNum, ArrayList<Card> dealerCards){
        this.playerCards = playerCards;
        this.playerCardsNum = playerCardsNum;
        this.dealerCards = dealerCards;
    }

    public int getObservation(){
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

    public static int getObservationDimension(){
        return ObservationDimension;
    }
}
