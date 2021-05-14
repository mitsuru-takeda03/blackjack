package com.env;

import RL.env.dealer.DealerObs;

import java.util.ArrayList;

public class Environment {
    protected Player player;
    protected Dealer dealer;
    protected CardDeck cardDeck;
    protected int bet;
    protected boolean canPlayerDraw;
    protected boolean canDealerDraw;

    public Environment(){
        player = new Player();
        dealer = new Dealer();
    }

    /**
     * 環境の初期化
     * 山札をシャッフル
     * playerとdealerの手札を初期化
     */
    public void resetEnvironment() {
        cardDeck = new CardDeck();
        cardDeck.shuffle();
        player.resetHand();
        dealer.resetHand();
        canPlayerDraw = true;
        canDealerDraw = true;
        ArrayList<Card> initCards = new ArrayList<Card>();
        for(int i = 0; i < 4; i++){
            initCards.add(cardDeck.pop());
        }
        player.drawCard(initCards.get(0));
        player.drawCard(initCards.get(1));
        dealer.drawCard(initCards.get(2));
        dealer.drawCard(initCards.get(3));
    }

    /**
     * playerの行動を環境に反映
     * @param action 0: stand, 1: Hit, 2: Double, 3: Surrender
     * @return 引いたらtrue
     */
    public boolean playerAct(Player player, int action){
        if(!canPlayerDraw) // まだ引けるか確認
            return false;

        if(action==0 || action==3) { // Stand or Surrender
            if(action==3)
                bet /= 2;
            canPlayerDraw = false;
            return false;
        }
        else if(action==1 || action==2){ //Hit or Double
            Card newCard = cardDeck.pop();
            player.drawCard(newCard);
            if(action==2) { // Double
                bet *= 2;
                canPlayerDraw = false;
            }
            if(player.checkSum()==-1) // bustしたら
                canPlayerDraw = false;
            return true;
        }
        else // invalid action
            return false;
    }
    /**
     * dealerの行動を環境に反映
     * @param action 0: stand, 1: Hit
     * @return 引いたらtrue
     */
    public boolean dealerAct(Dealer dealer, int action){
        if(!canDealerDraw) // まだ引けるか確認
            return false;

        if(action==0) // Stand
            return false;
        else if(action==1){ //Hit
            Card newCard = cardDeck.pop();
            dealer.drawCard(newCard);
            if(dealer.checkSum()==-1) // bustしたら
                canDealerDraw = false;
            return true;
        }
        else // invalid action
            return false;
    }
}
