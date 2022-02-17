package simulationManager;
import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
    private JLabel time= new JLabel("Time:");
    private JLabel timeField= new JLabel("0");
    private JLabel clients= new JLabel("Clients still shopping: ");
    private JLabel actualClients= new JLabel("");
    public  JLabel labels[];
    public JLabel service= new JLabel("avg(Service)=");
    public JLabel fieldService= new JLabel(" ");
    public JLabel peakHour= new JLabel("Peak Hour:");
    public JLabel fieldPeakHour= new JLabel(" ");
    int index;
    public Display(int q)
    {
        labels= new JLabel[q];
        JPanel timePanel= new JPanel(new FlowLayout());
        timePanel.add(time);
        timePanel.add(timeField);
        JPanel queuePanel= new JPanel(new GridLayout(q, 2));
        JPanel medie= new JPanel(new FlowLayout());
        JPanel waitingClients= new JPanel( new FlowLayout());
        for(int i=0; i<q; i++)
        {
            JLabel label= new JLabel("Queue"+(i+1));
            JLabel field= new JLabel("closed");
            labels[index]=field;
            index++;
            queuePanel.add(label);
            queuePanel.add(field);
        }
        JPanel panel=new JPanel(new GridLayout(4,1));
        waitingClients.add(clients);
        waitingClients.add(actualClients);
        medie.add(service);
        medie.add(fieldService);
        medie.add(peakHour);
        medie.add(fieldPeakHour);
        panel.add(timePanel);
        panel.add(waitingClients);
        panel.add(queuePanel);
        panel.add(medie);

        this.setContentPane(panel);
        this.pack();
        this.setTitle("Simulation");
        this.setSize(500, 400);
        this.setVisible(true);
    }
    public void setTime(int time){
        timeField.setText(String.valueOf(time));
    }
    public void setQueue(String text, int indexOdQueue)
    {
        labels[indexOdQueue].setText(text);
    }
    public void waitingClients(String text)
    {
        actualClients.setText(text);
    }
    public void setMedie(float avgService, int peakHour)
    {
          fieldService.setText( String.valueOf(avgService));
          fieldPeakHour.setText(String.valueOf(peakHour));
    }
}
