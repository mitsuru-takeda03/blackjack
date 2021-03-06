package com.env;

/**
 * ゲームの進行状況を説明するenum
 */
public enum State {
    PlayerTurn("PlayerTurn"),
    DealerTurn("DealerTurn"),
    Judgement("Judgement"),
    PlayerWin("Player win"),
    DealerWin("Dealer win"),
    Surrender("Player surrendered"),
    Draw("Draw");

    private String string;

    State(String string) { this.string = string; }

    @Override
    public String toString(){ return string; }

}
