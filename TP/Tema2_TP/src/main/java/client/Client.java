package client;

public class Client implements Comparable<Client> {

    private int ID;
    private int tArrivel;
    private int tService;

    public Client() {
    }

    public int getID() {
        return this.ID;
    }

    public int gettArrivel() {
        return this.tArrivel;
    }

    public int gettService() {
        return this.tService;
    }

    public void setID(int id) {
        this.ID = id;
    }

    public void settArrivel(int timp) {
        this.tArrivel = timp;
    }

    public void settService(int timp) {
        this.tService = timp;
    }

    public int compareTo(Client c) {
       return this.tArrivel - c.tArrivel;
    }

}