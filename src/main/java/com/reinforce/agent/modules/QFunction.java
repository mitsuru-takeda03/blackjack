package com.reinforce.agent.modules;

import com.env.Action;
import com.reinforce.agent.modules.test.ActionFL;
import com.reinforce.agent.modules.test.StateFL;

/**
 * Q関数
 * Q値のテーブルを保持
 */
public class QFunction {
    private double[][] q;

    QFunction(int stateDimension, int actionDimension){
        q = new double[stateDimension][actionDimension];
    }

    /**
     * Brack Jack用のQ関数
     * @param state
     * @param action
     * @return
     */
    public double getQ(State state, Action action) {
        return q[state.getValue().get(0)][Action.action2Int(action)];
    }

    public void setQ(State state, Action action, double q) {
        this.q[state.getValue().get(0)][Action.action2Int(action)] = q;
    }

    /**
     * Froze Lake
     * @param stateFL
     * @param actionFL
     * @return
     */
    public double getQ(StateFL stateFL, ActionFL actionFL) {
        return q[stateFL.getValue().get(0)][ActionFL.actionFL2Int(actionFL)];
    }

    public void setQ(StateFL stateFL, ActionFL actionFL, double q) {
        this.q[stateFL.getValue().get(0)][ActionFL.actionFL2Int(actionFL)] = q;
    }
}
