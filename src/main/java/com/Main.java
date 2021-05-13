package com;

public class Main {
    public static void main(String[] args){
        Field field = new Field();
        field.initTurn();
        while(field.playerTurn())
            continue;
        while(field.dealerTurn())
            continue;
        field.judge();
    }
}
