package simulationManager;
import java.util.*;
import client.*;
public interface Strategy {
    public void addTask(List<Server> servers, Client c);
}
