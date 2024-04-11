package BusinessLogic;

import Model.Clients;
import Model.Server;

import java.util.List;

public class ConcreteStrategyQueue implements Strategy {
    @Override
    public Server addClients(List<Server> queues, Clients c) {
        Server minQ = queues.get(0);

            for (Server i : queues) {
                    if (minQ.getQueue().size() > i.getQueue().size()) {
                        minQ = i;
                    }
                }


        if(!minQ.getQueue().contains(c))
        minQ.addTask(c);

        return minQ;
    }
}
