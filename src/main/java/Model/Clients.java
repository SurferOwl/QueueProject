package Model;

public class Clients implements Comparable<Clients>{

    private Integer ID,arrivalTime,serviceTime;

    public synchronized Integer getID() {
        return ID;
    }

    public synchronized Integer getArrivalTime() {
        return arrivalTime;
    }

    public synchronized Integer getServiceTime() {
        return serviceTime;
    }

    public Clients(Integer id, Integer aT, Integer sT){
        ID = id;
        arrivalTime = aT;
        serviceTime = sT;
    }


    public synchronized int compareTo(Clients otherClient) {
        return this.arrivalTime.compareTo(otherClient.arrivalTime);
    }

    @Override
    public synchronized String toString() {
        return "Clients{" +
                "ID=" + ID +
                ", arrivalTime=" + arrivalTime +
                ", serviceTime=" + serviceTime +
                '}';
    }
}


