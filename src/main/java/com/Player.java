package com;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private ArrayList<Card> hand;
    private int sumCard;

    Player(){
        hand = new ArrayList<>();
        sumCard = 0;
    }

    public int getSumCard(){
        return sumCard;
    }

    public void drawCard(Card newCard){
        hand.add(newCard);
        checkSum();
    }

    public void checkCards(){
        System.out.println("-------------------------------");
        System.out.println("Your Hands");
        for(Card card : hand){
            System.out.println("suit: "+card.getSuit()+", number: "+card.getNumber());
        }
        System.out.println("-------------------------------");
    }

    public boolean isContinue(){
        checkCards();
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        if(inputLine.equals("yes") || inputLine.equals("Yes") || inputLine.equals("YES"))
            return true;
        else
            return false;
    }

    public int checkSum(){
        int sumCard = 0;
        for (Card card : hand){
            if (card.getNumber() > 10){
                sumCard += 10;
            }
            else{
                sumCard += card.getNumber();
            }
        }
        if(sumCard > 21)
            sumCard = -1;
        return sumCard;
    }
}
