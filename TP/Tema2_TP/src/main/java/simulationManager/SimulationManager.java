package simulationManager;
import view.*;
import client.*;
import java.io.FileWriter;
import java.util.*;
import java.util.List;
import static java.lang.Thread.sleep;

public class SimulationManager implements Runnable{
    public int n;
    public int q;
    public int simulation;
    public int minArrivel;
    public int maxArrivel;
    public int minService;
    public int maxService;
    public List<Client> clienti=new ArrayList<Client>();
    private Scheduler scheduler;
    public Display display;
    public FileWriter file;
    public SimulationManager(int n, int q, int simulation, Interval arrivel, Interval service)
    {
        this.n=n;
        this.q=q;
        this.simulation= simulation;
        this.maxArrivel=arrivel.max;
        this.minArrivel=arrivel.min;
        this.maxService=service.max;
        this.minService=service.min;
        display=new Display(q);
        generateRandomClients();
        try {
            file = new FileWriter("logOfEvents.txt");
        }
        catch(Exception e)
        {
            System.out.println("Problems with the fileWriter");
        }
        medie();
        scheduler= new Scheduler(q, this.display, file);

    }
    private void generateRandomClients()
    {
        for(int i=1; i<=n; i++)
        {
            Random rand=new Random();
            Client c= new Client();
            c.setID(i);
            c.settArrivel(rand.nextInt(maxArrivel-minArrivel) + minArrivel);
            c.settService(rand.nextInt(maxService-minService) + minService);
            clienti.add(c);
        }
        Collections.sort(clienti);
       /* for(int i=0; i<n; i++)
            System.out.println(clienti.get(i).getID()+","+clienti.get(i).gettArrivel()+","+ clienti.get(i).gettService());
    */}
   public void medie()
   {
       float averageServiceTime=0;
       for(Client c: clienti)
           averageServiceTime += c.gettService();

       averageServiceTime =(float) averageServiceTime/ clienti.size();

       int peakHour=0;
       for(int i=1; i<simulation; i++)
       {
              int atThisHour=  getNrClientsAtThisHour(i);
              if( atThisHour > peakHour)
                  peakHour= i;
       }

       display.setMedie(averageServiceTime, peakHour);
   }
   public int getNrClientsAtThisHour(int hour)
   {
       int nr=0;
       for(Client c:clienti)
           if(c.gettArrivel()==hour)
                nr++;

        return nr;
   }

    public void run(){
        int currentTime=0;
        while(currentTime <= simulation)
        {
            String text=" ";
            for(Client c: clienti)
            {
                text= text+ "(" + c.getID() + ", " + c.gettArrivel() + " ," + c.gettService() + "),  ";
            }
            display.waitingClients(text);
            display.setTime(currentTime);
           // System.out.println("Time:" + currentTime);
            try {
                file.write("Time:" + currentTime+"\n");
            }catch(Exception e)
            {
                System.out.println("Problems with the fileWriter");
            }
            try{
                file.write("Waiting clients:"+ text+"\n");
            }catch(Exception e)
            {
                System.out.println("Probleme la scriere");
            }
            if(!clienti.isEmpty()) {
               List<Client> c2= new ArrayList<Client>();
                for (Client c : clienti)
                    if (c.gettArrivel() == currentTime) {
                        scheduler.dispatchClient(c);
                         c2.add(c);
                    }
                for(Client c: c2)
                {
                    clienti.remove(c);
                }
                c2.removeAll(c2);
            }else
            {
                display.waitingClients(" No one is shopping right now");
            }
            currentTime++;
            try{
               sleep(1000);
            }
            catch(Exception e)
            {
              System.out.println("Someone interrupted me in SimulationManager");
            }
        }
        try {
            file.close();
        }catch(Exception e)
        {
            System.out.println("Probleme la inchiderea fileWriterului");
        }

    }
}


