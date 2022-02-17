package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class EmployeeView extends Observer{


    public JFrame frame;
    Calendar calendar = Calendar.getInstance();
    private JLabel title= new JLabel(" Employee Department");
    private JLabel orders= new JLabel("<html> The orders: <br/> <html/>");
    private JPanel panel1= new JPanel(new FlowLayout());
    private JPanel panel2= new JPanel(new FlowLayout());
    private JPanel panel3= new JPanel(new FlowLayout());
    private JButton logOut= new JButton("Log out");
    public EmployeeView(Subject subject)
    {
        this.subject = subject;
        this.subject.attach(this);
    }
    public void setEmployeeView(JFrame frame)
    {
        this.frame=frame;
        title.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        panel1.add(title);
        panel2.add(orders);
        panel3.add(logOut);
        JPanel panel= new JPanel(new GridLayout(3,1));
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        frame.setContentPane(panel);
        frame.setSize(new Dimension(500, 500));
        frame.setTitle("Employee Department");
        frame.setVisible(true);
    }
    @Override
    public void update() {
        System.out.println("A new order has been placed at: "+ calendar.getTime());
        orders.setText(orders.getText() +"<html>A new order has been placed at:" + calendar.getTime()+" <br/><html>");
    }
    public void backListener(ActionListener cal)
    {
        logOut.addActionListener(cal);
    }
}
