package RL.env.dealer;
import com.env.*;

import java.util.ArrayList;

public class DealerEnv extends com.env.Environment{
    private Player player;
    private Dealer dealer;
    private CardDeck cardDeck;
    private int bet;
    private boolean canPlayerDraw;
    private boolean canDealerDraw;
    private DealerObs dealerObs;

    public int getDealerObs(){
        ArrayList<Card> playerCards = new ArrayList<Card>(player.getHand().subList(0,2));
        ArrayList<Card> dealerCards = dealer.getHand();
        dealerObs.setObservation(playerCards, playerCards.size(), dealerCards);
        return dealerObs.getObservation();
    }
}
