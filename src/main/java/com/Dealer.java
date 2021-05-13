package com;

import java.util.Scanner;

/**
 * playerクラスを継承
 * カードの合計が16以下では降りれない
 */
public class Dealer extends Player{
    /**
     * isContinueに16以下では降りれないようにする機能を追加
     */
    @Override
    public boolean isContinue(){
        checkCards();
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        if(inputLine.equals("yes") || inputLine.equals("Yes") || inputLine.equals("YES"))
            return true;
        else if(checkSum() < 17 && checkSum() > 0){
            System.out.println("Dealer can't stay under 17");
            return true;
        }
        else
            return false;
    }
}
