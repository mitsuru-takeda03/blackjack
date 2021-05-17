package com.env;

/**
 * playerとdealerの行動を表すenum
 */
public enum Action {
    //
    Stand(),
    Hit(),
    Double(),
    Surrender(),
    Invalid();

    private static final int dimension = 4;

    public static final int getDimension() { return dimension; }

    public static Action int2Action(int i) {
        if (i == 0) { return Action.Stand; }
        else if (i == 1) { return Action.Hit; }
        else if (i == 2) { return Action.Double; }
        else if (i == 3) { return Action.Surrender; }
        else { return Action.Invalid; }
    }

    public static int action2Int(Action action) {
        if (action == Action.Stand) { return 0; }
        else if (action == Action.Hit) { return 1; }
        else if (action == Action.Double) { return 2; }
        else if (action == Action.Surrender) { return 3; }
        else { return 4; }
    }
}
