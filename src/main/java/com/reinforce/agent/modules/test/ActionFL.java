package com.reinforce.agent.modules.test;

import com.env.Action;

public enum ActionFL {
    Up(),
    Down(),
    Right(),
    Left(),
    Invalid();

    private static final int dimension = 4;

    public static final int getDimension() { return dimension; }

    public static ActionFL int2ActionFL(int i) {
        if ( i == 0 ) { return ActionFL.Up; }
        else if ( i == 1 ) { return ActionFL.Down; }
        else if ( i == 2 ) { return ActionFL.Right; }
        else if ( i == 3 ){ return ActionFL.Left; }
        else { return ActionFL.Invalid; }
    }

    public static int actionFL2Int(ActionFL ActionFL) {
        if ( ActionFL == ActionFL.Up ) { return 0; }
        else if ( ActionFL == ActionFL.Down ) { return 1; }
        else if ( ActionFL == ActionFL.Right ) { return 2; }
        else if ( ActionFL == ActionFL.Left ){ return 3; }
        else { return 4; }
    }
}
