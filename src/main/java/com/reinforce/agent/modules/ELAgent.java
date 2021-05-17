package com.reinforce.agent.modules;

import com.env.Action;

import java.util.ArrayList;
import java.util.Random;

public class ELAgent {
    protected double epsilon = 0.2;
    protected QFunction qFunction;
    protected ArrayList<Double> logReward;
    protected Action action;
    protected State state;

    protected ELAgent(){
        qFunction = new QFunction(Observation.getMaxStateValue(), Action.getDimension());
        logReward = new ArrayList<Double>();
    }

    public void setEpsilon(double epsilon) { this.epsilon = epsilon; }

    public void initLogReward() { logReward = new ArrayList<Double>(); }

    public void addLogReward(double reward) { logReward.add(reward); }

    /**
     * epsilon-greedy
     * @param state
     * @return
     */
    public Action policy(State state){
        if(Math.random() > epsilon){
            Random rand = new Random();
            this.action = Action.int2Action(rand.nextInt(Action.getDimension()));
        }
        else{
            double maxQ = 0;
            Action maxQAction = Action.int2Action(0);
            for(int i = 0; i < Action.getDimension(); i++){
                Action iAction = Action.int2Action(i);
                double iQ = qFunction.getQ(state, iAction);
                if(iQ > maxQ){
                    maxQ = iQ;
                    maxQAction = iAction;
                }
            }
            this.action = maxQAction;
        }
        return this.action;
    }


}