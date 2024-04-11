package Model;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server extends Thread {
    private LinkedBlockingQueue<Clients> queue;
    private AtomicInteger waitingTime;

    public Server() {
        queue = new LinkedBlockingQueue<>();
        waitingTime = new AtomicInteger(0);
    }

    public synchronized void addTask(Clients c) {
        try {
            queue.put(c);
            waitingTime.addAndGet(c.getServiceTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public AtomicInteger getWaitingTime() {
        return waitingTime;
    }

    public LinkedBlockingQueue<Clients> getQueue() {
        return queue;
    }

    public void run() {
        while (true) {
            Clients c = null;
            c = queue.peek();
            if (c != null) {
                try {
                    Thread.sleep(1000 * c.getServiceTime());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                try {
                    queue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                    waitingTime.addAndGet(-c.getServiceTime());

            }
        }
    }
}
