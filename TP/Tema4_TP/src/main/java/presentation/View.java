package presentation;

import businessLogic.Role;
import businessLogic.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class View {

    private JLabel title= new JLabel("Catering Company");
    private JLabel username= new JLabel("Username:");
    private JLabel password= new JLabel("Password:");
    public JTextField usernameTF= new JTextField(30);
    public JTextField passwordTF= new JTextField(30);
    private JButton enter= new JButton("Log in");
    private JLabel account= new JLabel("You don't have an account?");
    private JButton accountButton= new JButton("Make one here");
    private JPanel panel1= new JPanel( new FlowLayout());
    private JPanel panel2= new JPanel( new FlowLayout());
    private JPanel panel3= new JPanel( new FlowLayout());
    private JPanel panel4= new JPanel( new FlowLayout());
    private JPanel panel5= new JPanel( new FlowLayout());
    JFrame frame;
    private JPanel copyPanel= new JPanel(new FlowLayout());
    private JPanel panel= new JPanel(new GridLayout(5, 1));
    public View()
    {
        frame= new JFrame();
        setPanel(frame);
    }
    public void setPanel(JFrame frame)
    {
        title.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        panel1.add(title);
        panel2.add(username);
        panel2.add(usernameTF);
        panel3.add(password);
        panel3.add(passwordTF);
        panel4.add(enter);
        panel5.add(account);
        panel5.add(accountButton);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);
        copyPanel.add(panel);
        frame.setContentPane(panel);
        frame.setTitle("Catering Company");
        frame.setVisible(true);
        frame.setSize(new Dimension(500 , 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void enter(ActionListener cal)
    {
         enter.addActionListener(cal);
    }
    public String getUsername()
    {
        return usernameTF.getText();
    }
    public String getPassword()
    {
        return passwordTF.getText();
    }
    public void setFirstFrame(JFrame frame) { setPanel(frame); }
    public void newAccount(ActionListener cal){ accountButton.addActionListener(cal); }
    public User getNewUser(){ return new User(usernameTF.getText(), passwordTF.getText(), Role.CLIENT);}
    public void addWindowListener(WindowListener win){  frame.addWindowListener(win);}
}
