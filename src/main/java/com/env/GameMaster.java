package com.env;

public class GameMaster {

    private Status status;
    private int playerScore;
    private int dealerScore;
    private String enter = System.lineSeparator();

    GameMaster() { resetState(); }

    public void resetState() { status = Status.PlayerTurn;}

    public Status getState() { return status; }

    public void setState(Status status){ this.status = status; }

    public void Judge(int playerScore, int dealerScore) {
        this.playerScore = playerScore;
        this.dealerScore = dealerScore;
        if (status.equals(Status.Judgement)) {
            if (playerScore > dealerScore)
                status = Status.PlayerWin;
            else if (playerScore == dealerScore && playerScore > 0)
                status = Status.Draw;
            else
                status = Status.DealerWin;
        }
    }

    @Override
    public String toString(){
        if (status.equals(Status.PlayerTurn) || status.equals(Status.DealerTurn))
            return status.toString();

        String string = "-------------------------------------------" + enter;
        if(playerScore > 0)
            string += "Player: " + playerScore + enter;
        else
            string += "Player: Bust" + enter;
        if(dealerScore > 0)
            string += "Dealer: " + dealerScore + enter;
        else
            string += "Dealer: Bust" + enter;
        string += "Result: " + status.toString() + enter;
        string += "-------------------------------------------";

        return string;
    }
}
