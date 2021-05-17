package com.reinforce.agent.modules;

import com.env.Player;
import com.env.Dealer;
import com.env.GameMaster;
import com.env.Card;

/**
 * 強化学習用
 * 環境の状態を説明するクラス
 */
public class Observation {
    private final Player player;
    private final Dealer dealer;
    private final GameMaster gameMaster;
    private static final int maxStateValue = 2000;

    /**
     * 環境の状態を説明
     * final
     * @param player
     * @param dealer
     * @param gameMaster
     */
    Observation( Player player, Dealer dealer, GameMaster gameMaster) {
        this.player = player;
        this.dealer = dealer;
        this.gameMaster = gameMaster;
    }

    public static int getMaxStateValue() { return maxStateValue; }
    /**
     * dealerの観測を返す
     * 20進数で|playerの引いた数|playerの見えている2枚の合計|dealerの合計|
     * @return 整数にエンコードした状態
     */
    public int getDealerObservation() {
        int sumPlayerCards = 0;
        int sumDealerCards = 0;
        for(int i = 0; i < 2; i++){
            sumPlayerCards += player.getHand().getHand().get(i).getNumber();
        }
        for(Card card : dealer.getHand().getHand()){
            sumDealerCards += card.getNumber();
        }
        return (player.getHand().getHand().size() - 2) * 20 * 20 + sumPlayerCards * 20 + sumDealerCards;
    }

    /**
     * playerの観測を返す
     * 20進数で|playerの引いた数|playerの合計|dealerの見えている1枚の部屋|
     * @return 整数にエンコードした状態
     */
    public int getPlayerObservation() {
        int sumPlayerCards = 0;
        for(Card card : player.getHand().getHand()){
            sumPlayerCards += card.getNumber();
        }
        return (player.getHand().getHand().size() - 2) * 20 * 20 + sumPlayerCards * 20 + dealer.getHand().getHand().get(0).getNumber();
    }
}
