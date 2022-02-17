package simulationManager;

import client.Client;

import java.util.List;

public class ConcreteStrategyQueue implements Strategy{
    @Override
    public void addTask(List<Server> servers, Client c) {
       int size2=60;
       Server server2= new Server(0, null, null);
       for(Server s: servers)
        {
            int size=s.clienti.size();
            if(size <size2)
            {
                server2=s;
                size2= size;
            }
        }
        server2.addClient(c);
    }
}
