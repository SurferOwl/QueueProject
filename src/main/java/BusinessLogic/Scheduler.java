package BusinessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import Model.*;
public class Scheduler {
    private List<Server> queues = new CopyOnWriteArrayList<>();
    private int maxNoQueues;
    private int maxClients;
    private Strategy strategy;

    public Scheduler(int maxSer,int maxCli){
        maxNoQueues = maxSer;
        maxClients = maxCli;

        for (int i=0;i<maxNoQueues;i++){
            Server s = new Server();
            queues.add(s);
            s.start();
        }
    }

    public void changeStrategy(SelectionPolicy policy) {
        if (policy == SelectionPolicy.SHORTEST_QUEUE) {
            strategy = new ConcreteStrategyQueue();
        }

        if (policy == SelectionPolicy.SHORTEST_TIME) {
            strategy = new ConcreteStrategyTime();
        }
    }

    public List<Server> getQueues(){
        return queues;
    }

    public Strategy getStrategy() {
        return strategy;
    }
}
