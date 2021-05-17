package com.reinforce.agent.modules.test;

import java.awt.geom.FlatteningPathIterator;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 強化学習エージェントのテスト環境
 * Frozen Lake
 */
public class EnvironmentFL {
    private final ArrayList<ArrayList<FloorPanel>> floorMap;
    private final double slipRate = 0.3;
    private StateFL stateFL;
    private StatusFL statusFL;
    private int step = 0;

    EnvironmentFL() {
        // SOOO
        // OXOX
        // OOOX
        // XOOG
        floorMap = new ArrayList();
        floorMap.add(new ArrayList<>(Arrays.asList(FloorPanel.Start, FloorPanel.Normal, FloorPanel.Normal, FloorPanel.Normal)));
        floorMap.add(new ArrayList<>(Arrays.asList(FloorPanel.Normal, FloorPanel.Hole, FloorPanel.Normal, FloorPanel.Hole)));
        floorMap.add(new ArrayList<>(Arrays.asList(FloorPanel.Normal, FloorPanel.Normal, FloorPanel.Normal, FloorPanel.Hole)));
        floorMap.add(new ArrayList<>(Arrays.asList(FloorPanel.Hole, FloorPanel.Normal, FloorPanel.Normal, FloorPanel.Goal)));
    }

    /**
     * スタート地点(S)に戻る
     */
    public void reset() {
        stateFL = new StateFL(new ArrayList<>(Arrays.asList(0, 0)));
        statusFL = StatusFL.Start;
        step = 0;
    }

    /**
     * 現在の状態で取りうる行動を返す
     * @return 現在の状態で可能なaction
     */
    public ArrayList<ActionFL> getActionOptions() {
        int state_x = stateFL.getValue().get(0);
        int state_y = stateFL.getValue().get(1);
        ArrayList<ActionFL> actionOptions = new ArrayList<>(Arrays.asList(ActionFL.Up, ActionFL.Down, ActionFL.Right, ActionFL.Left));
        if (state_x == 0)
            actionOptions.remove(actionOptions.indexOf(ActionFL.Left));
        else if (state_x == 3)
            actionOptions.remove(actionOptions.indexOf(ActionFL.Right));
        if (state_y == 0)
            actionOptions.remove(actionOptions.indexOf(ActionFL.Up));
        else if (state_y == 3)
            actionOptions.remove(actionOptions.indexOf(ActionFL.Down));
        return actionOptions;
    }

    public StatusFL actAgent(ActionFL actionFL) {
        step += 1;
        int isSlip = Math.random() > slipRate ? 1 : -1;
        int state_x = stateFL.getValue().get(1);
        int state_y = stateFL.getValue().get(0);
        if (actionFL == ActionFL.Up)
            state_y -= 1 * isSlip;
        else if (actionFL == ActionFL.Down)
            state_y += 1 * isSlip;
        else if (actionFL == ActionFL.Right)
            state_x += 1 * isSlip;
        else if (actionFL == ActionFL.Left)
            state_x -= 1 * isSlip;
        stateFL = new StateFL(new ArrayList<>(Arrays.asList(state_x, state_y)));
        return getStatusFL(stateFL);
    }

    public StatusFL getStatusFL() { return statusFL; }

    public StatusFL getStatusFL(StateFL stateFL) {
        FloorPanel floorPanelNow = floorMap.get(stateFL.getValue().get(1)).get(stateFL.getValue().get(0));
        if (floorPanelNow == FloorPanel.Hole) {
            statusFL = StatusFL.Fail;
        }
        else if (floorPanelNow == FloorPanel.Goal) {
            statusFL = StatusFL.Success;
        }
        return statusFL;
    }

    public double getReward(){ return statusFL.getReward(); }
}
