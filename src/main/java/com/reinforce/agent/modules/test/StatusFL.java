package com.reinforce.agent.modules.test;

public enum StatusFL {
    Start(0),
    Fail(-1),
    Success(1);

    private final double reward;

    StatusFL(double reward) { this.reward = reward; }

    public double getReward() { return reward; }
}
