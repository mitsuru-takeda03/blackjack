package com.env;

import java.util.ArrayList;

public class Environment {
    protected Player player;
    protected Dealer dealer;
    protected GameMaster gameMaster;
    protected Record record;
    protected CardDeck cardDeck;
    protected int bet;

    public Environment(){
        player = new Player();
        dealer = new Dealer();
        gameMaster = new GameMaster();
    }

    public State callGMState(){
        return gameMaster.getState();
    }

    /**
     * 環境の初期化
     * 山札をシャッフル
     * playerとdealerの手札を初期化
     */
    public void resetEnvironment() {
        cardDeck = new CardDeck();
        cardDeck.shuffle();
        player.getHand().reset();
        dealer.getHand().reset();
        gameMaster.resetState();
        ArrayList<Card> initCards = new ArrayList<Card>();
        for(int i = 0; i < 4; i++){
            initCards.add(cardDeck.pop());
        }
        player.getHand().addCard(initCards.get(0));
        player.getHand().addCard(initCards.get(1));
        dealer.getHand().addCard(initCards.get(2));
        dealer.getHand().addCard(initCards.get(3));
        record = new Record(initCards);
    }

    /**
     * playerの行動を環境に反映
     * @param action 0: stand, 1: Hit, 2: Double, 3: Surrender
     * @return 引いたらtrue
     */
    public boolean playerAct(Player player, Action action){

        if(action.equals(Action.Stand)) {
            gameMaster.setState(State.DealerTurn);
        }
        if(action.equals(Action.Surrender)){
            bet /= 2;
            gameMaster.setState(State.Surrender);
            return false;
        }
        else if(action.equals(Action.Hit)|| action.equals(Action.Double)){ //Hit or Double
            Card newCard = cardDeck.pop();
            player.getHand().addCard(newCard);
            if(action.equals(Action.Double)) { // Double
                bet *= 2;
                gameMaster.setState(State.DealerTurn);
            }
            if(player.getHand().checkSum()==-1) // bustしたら
                gameMaster.setState(State.DealerWin);
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
    public boolean dealerAct(Dealer dealer, Action action){

        if(action.equals(Action.Stand)) { // Stand
            gameMaster.setState(State.Judgement);
            return false;
        }
        else if(action.equals(Action.Hit)){ // Hit
            Card newCard = cardDeck.pop();
            dealer.getHand().addCard(newCard);
            if(dealer.getHand().checkSum()==-1) // bustしたら
                gameMaster.setState(State.Judgement);
            return true;
        }
        else // invalid action
            return false;
    }

    public void gameMasterAct(GameMaster gameMaster) {
        gameMaster.Judge(player.getHand().checkSum(), dealer.getHand().checkSum());
        settleBet(gameMaster);
    }

    public void settleBet(GameMaster gameMaster) {
        State state = gameMaster.getState();
        if (state.equals(State.PlayerWin)) {
            player.setMoney(player.getMoney() + bet);
            dealer.setMoney(dealer.getMoney() - bet);
        }
        else if (state.equals(State.DealerWin) || state.equals(State.Surrender)) {
            player.setMoney(player.getMoney() - bet);
            dealer.setMoney(dealer.getMoney() + bet);
        }
    }
}
