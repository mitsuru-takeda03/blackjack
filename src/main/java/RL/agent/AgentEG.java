package RL.agent;

import RL.env.Actions;

import java.util.ArrayList;
import java.util.Random;

public class AgentEG {
//    private double epsilon;
//    private QFunction qFunction;
//    private ArrayList<Double> logReward;
//    private int action;
//    private State state;
//
//    AgentEG(double epsilon){
//        this.epsilon = epsilon;
//        qFunction = new QFunction(State.getStateDimension(), Actions.getActionsDimension());
//        logReward = new ArrayList<Double>();
//    }
//
//    /**
//     * epsilon-greedy
//     * @param state
//     * @return
//     */
//    public int policy(State state){
//        if(Math.random() > epsilon){
//            Random rand = new Random();
//            this.action = rand.nextInt(Actions.getActionsDimension());
//        }
//        else{
//            double maxQ = 0;
//            int maxQAction = 0;
//            for(int action = 0; action < Actions.getActionsDimension(); action++){
//                double nextQ = qFunction.getQ(state, action);
//                if(nextQ > maxQ){
//                    maxQ = nextQ;
//                    maxQAction = action;
//                }
//            }
//            this.action = maxQAction;
//        }
//        return this.action;
//    }
//
//    public void initLogReward(){
//        logReward = new ArrayList<Double>();
//    }
//
//    public void addLogReward(double reward){
//        logReward.add(reward);
//    }
}
