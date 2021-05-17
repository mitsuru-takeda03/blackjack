package com.reinforce.agent.modules;

import java.util.ArrayList;

public class State {
    private final ArrayList<Integer> value;

    State(ArrayList<Integer> value) {
        this.value = value;
    }

    public ArrayList<Integer> getValue() {
        return value;
    }
}
