package com.env;

public class GameMaster {

    private State state;
    private int playerScore;
    private int dealerScore;
    private String enter = System.lineSeparator();

    GameMaster() { resetState(); }

    public void resetState() { state = State.PlayerTurn;}

    public State getState() { return state; }

    public void setState(State state){ this.state = state; }

    public void Judge(int playerScore, int dealerScore) {
        this.playerScore = playerScore;
        this.dealerScore = dealerScore;
        if (state.equals(State.Judgement)) {
            if (playerScore > dealerScore)
                state = State.PlayerWin;
            else if (playerScore == dealerScore && playerScore > 0)
                state = State.Draw;
            else
                state = State.DealerWin;
        }
    }

    @Override
    public String toString(){
        if (state.equals(State.PlayerTurn) || state.equals(State.DealerTurn))
            return state.toString();

        String string = "-------------------------------------------" + enter;
        if(playerScore > 0)
            string += "Player: " + playerScore + enter;
        else
            string += "Player: Bust" + enter;
        if(dealerScore > 0)
            string += "Dealer: " + dealerScore + enter;
        else
            string += "Dealer: Bust" + enter;
        string += "Result: " + state.toString() + enter;
        string += "-------------------------------------------";

        return string;
    }
}
