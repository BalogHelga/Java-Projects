package simulationManager;
import java.util.*;
import client.*;
import java.lang.*;
import java.io.FileWriter;
public class Scheduler {
    private List<Server> servers;
    private int q;
    private ConcreteStrategyQueue strategy=new ConcreteStrategyQueue();

    public Scheduler(int q, Display display, FileWriter file)
    {
        servers= new ArrayList<Server>();
        this.q=q;
        for(int i=0; i<q; i++) {
            Server server = new Server(i + 1, display, file);
            servers.add(server);
            Thread thread = new Thread(server);
            try {
                thread.sleep((i+1)*10);
            } catch (Exception e) {
                System.out.println("scheduler");
            }
            thread.start();
        }
    }
    public void dispatchClient(Client c)
    {
        strategy.addTask(servers, c);
    }
}
