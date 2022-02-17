package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class View extends JFrame {

     private JLabel n= new JLabel("N=");
     private JLabel q=new JLabel("Q=");
     private JLabel tMaxSimulation=new JLabel("tMax Simulation=");
     private JLabel arrivelTime= new JLabel("Minimum and maximum arrival time=");
     private JLabel serviceTime= new JLabel("Minimum and maximum service time=");
     public JTextField ntext= new JTextField(10);
     public JTextField qText= new JTextField(10);
     private JTextField tMaxSimulationText= new JTextField(15);
     private JTextField arrivelTimeText1= new JTextField(4);
     private JTextField arrivelTimeText2= new JTextField(4);
     private JTextField serviceTimeText1= new JTextField(4);
     private JTextField serviceTimeText2= new JTextField(4);
     private JButton butonStart= new JButton("START");
     private JLabel parantezas=new JLabel(" [ ");
     private JLabel virgula= new JLabel(" , ");
     private JLabel parantezad= new JLabel(" ] " );
    private JLabel parantezas2=new JLabel(" [ ");
    private JLabel virgula2= new JLabel(" , ");
    private JLabel parantezad2= new JLabel(" ] " );
     public View()
     {
         JPanel content = new JPanel();
         JPanel content2= new JPanel();
         JPanel content3= new JPanel();
         JPanel content4= new JPanel();
         JPanel content5= new JPanel();
         JPanel content6= new JPanel();
         JPanel content7=new JPanel();
         content.setLayout(new FlowLayout());
         content2.setLayout(new FlowLayout());
         content3.setLayout(new FlowLayout());
         content4.setLayout(new FlowLayout());
         content5.setLayout(new FlowLayout());
         content6.setLayout(new FlowLayout());
         content7.setLayout(new GridLayout(6, 1));
         content.add(n);
         content.add(ntext);
         content2.add(q);
         content2.add(qText);
         content3.add(tMaxSimulation);
         content3.add(tMaxSimulationText);

         content4.add(arrivelTime);
         content4.add(parantezas);
         content4.add(arrivelTimeText1);
         content4.add(virgula);
         content4.add(arrivelTimeText2);
         content4.add(parantezad);

         content5.add(serviceTime);
         content5.add(parantezas2);
         content5.add(serviceTimeText1);
         content5.add(virgula2);
         content5.add(serviceTimeText2);
         content5.add(parantezad2);
         content6.add(butonStart);

         content7.add(content);
         content7.add(content2);
         content7.add(content3);
         content7.add(content4);
         content7.add(content5);
         content7.add(content6);
         this.setContentPane(content7);
         this.pack();
         this.setSize(500, 500);
         this.setTitle("Criterii de Simulare");
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
    public void addListener(ActionListener ad) {
        butonStart.addActionListener(ad);
    }
    public void reset(){
         ntext.setText("");
         qText.setText("");
         tMaxSimulationText.setText("");
         arrivelTime.setText("");
         serviceTime.setText("");
    }
    public int getn()
    {
        return Integer.parseInt(ntext.getText());
    }
    public int getq(){ return Integer.parseInt(qText.getText()); }
    public int gettMaxSimulation()
    {
        return Integer.parseInt(tMaxSimulationText.getText());
    }
    public Interval getArrivelText()
    {
        Interval interval= new Interval( Integer.parseInt(arrivelTimeText1.getText()),  Integer.parseInt(arrivelTimeText2.getText()));
        return interval;
    }
    public Interval getServiceText()
    {
        Interval interval= new Interval( Integer.parseInt(serviceTimeText1.getText()),  Integer.parseInt(serviceTimeText2.getText()));
        return interval;
    }
}
