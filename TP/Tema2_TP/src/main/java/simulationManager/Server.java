package simulationManager;
import client.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.io.FileWriter;
import static java.lang.Thread.sleep;

public class Server implements Runnable {

    public int serverID;
    public BlockingDeque<Client> clienti;
    public Display display;
    public FileWriter file;
    public Server(int id, Display display, FileWriter file) {
        clienti = new LinkedBlockingDeque<Client>();
        this.serverID = id;
        this.display= display;
        this.file= file;
    }
    public void addClient(Client newClient) {
        clienti.add(newClient);
    }
    @Override
    public void run() {
        while (true) {
            try{
                sleep(100);
            }catch(Exception e)
            {
                System.out.println("Server");
            }
            if (!clienti.isEmpty()) {
              //  System.out.print("Queue" + this.serverID + ": ");
                try {
                    file.write("Queue" + this.serverID + ":");
                }catch(Exception e){
                    System.out.println("Probleme cu fileWriter");}
                String text=" ";
                for (Client c : clienti) {
                   // System.out.print("(" + c.getID() + ", " + c.gettArrivel() + " ," + c.gettService() + "), ");
                     text= text+"(" + c.getID() + ", " + c.gettArrivel() + " ," + c.gettService() + "),   ";
                }
                try
                {
                    file.write(text+"\n");
                }catch(Exception e)
                {
                    System.out.println("Problema cu fileWriter");
                }
                display.setQueue(text, this.serverID-1);
               // System.out.println(" ");
                if (clienti.getFirst().gettService() == 1)
                    clienti.remove(clienti.getFirst());
                else
                    clienti.getFirst().settService(clienti.getFirst().gettService() - 1);

                try {
                    sleep(1000);
                } catch (Exception e) {
                    System.out.println("Someone interrupted me in server!");
                }
            } else {
                display.setQueue("Free", this.serverID-1);
            }
        }
    }
}

