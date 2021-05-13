package com;

import java.util.ArrayList;
import java.util.Scanner;

public class Field {
    private Player player;
    private Dealer dealer;
    private CardDeck cardDeck;
    private Score score;

    Field(){
        player = new Player();
        dealer = new Dealer();
        cardDeck = new CardDeck();
        cardDeck.shuffle();
    }

    public void initTurn(){
        ArrayList<Card> initCards = new ArrayList<Card>();
        for(int i = 0; i < 4; i++){
            initCards.add(cardDeck.pop());
        }
        player.drawCard(initCards.get(0));
        player.drawCard(initCards.get(1));
        dealer.drawCard(initCards.get(2));
        dealer.drawCard(initCards.get(3));
        score = new Score(initCards);
        score.print();
    }

    public boolean playerTurn() {
        Scanner scanner = new Scanner(System.in);
        boolean isContinue = player.isContinue();
        if(isContinue) {
            Card newCard = cardDeck.pop();
            player.drawCard(newCard);
            score.addPlayerDrawNum();
            return true;
        }
        else{
            return false;
        }
    }

    public boolean dealerTurn(){
        Scanner scanner = new Scanner(System.in);
        boolean isContinue = dealer.isContinue();
        if(isContinue) {
            Card newCard = cardDeck.pop();
            dealer.drawCard(newCard);
            score.addDealerDrawNum();
            return true;
        }
        else{
            return false;
        }
    }

    public void judge(){
        int playerScore = player.checkSum();
        int dealerScore = dealer.checkSum();
        if(playerScore > dealerScore) {
            System.out.println("Player win");
        }
        else if(playerScore == -1 && dealerScore == -1)
            System.out.println("Draw");
        else {
            System.out.println("Dealer win");
        }
    }
}
