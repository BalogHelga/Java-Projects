package controller;
import view.*;
import simulationManager.*;
import java.awt.event.*;

public class Controller {


    private View view;
    public Controller(View view)
    {
        this.view=view;
        view.addListener(new Listener());
    }

    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
               int n= view.getn();
               int q= view.getq();
               int simulationTime= view.gettMaxSimulation();
               Interval arrivelTime =view.getArrivelText();
               Interval serviceTime= view.getServiceText();
               SimulationManager sim= new SimulationManager(n, q, simulationTime, arrivelTime, serviceTime);
               Thread thread= new Thread(sim);
               thread.start();
        }
    }

}
