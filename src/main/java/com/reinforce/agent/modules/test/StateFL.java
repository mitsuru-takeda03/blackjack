package com.reinforce.agent.modules.test;

import java.util.ArrayList;

public class StateFL {
    private final ArrayList<Integer> value;

    StateFL(ArrayList<Integer> value) {
        this.value = value;
        // valueの範囲をハードコーディング
        if (value.get(0) < 0)
            this.value.set(0, 0);
        else if (value.get(0) > 4)
            this.value.set(0, 3);
        if (value.get(1) < 0)
            this.value.set(1, 0);
        else if (value.get(1) > 4)
            this.value.set(1, 3);
    }

    public ArrayList<Integer> getValue() {
        return value;
    }
}
