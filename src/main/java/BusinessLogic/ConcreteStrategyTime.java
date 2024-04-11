package BusinessLogic;

import Model.Clients;
import Model.Server;

import java.util.List;

public class ConcreteStrategyTime implements Strategy {
    @Override
    public Server addClients(List<Server> queues, Clients c) {
        Server minQ = queues.get(0);

        for (Server i : queues) {
                if (minQ.getWaitingTime().get() > i.getWaitingTime().get()) {
                    minQ = i;
                }
            }


        if(!minQ.getQueue().contains(c))
        minQ.addTask(c);

        return minQ;
    }
}
