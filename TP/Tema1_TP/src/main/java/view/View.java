package view;

import javax.swing.*;
import java.awt.*;

import model.*;

import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.JComponent;
import javax.swing.text.FlowView;

public class View extends JFrame {

    private JLabel nume = new JLabel("Polynomial calculator", JLabel.CENTER);
    private JLabel label1 = new JLabel("First polynomial:");
    private JLabel label2 = new JLabel("Second polynomial :");
    private JLabel label3 = new JLabel("Quotient:");
    private JLabel label4 = new JLabel("Remainder");
    private JLabel text = new JLabel("->Please enter your polynomials in the fields below");
    private JLabel text2 = new JLabel("->Choose your operation and the results will be displayed in the fields below");
    private JTextField field1 = new JTextField(30);
    private JTextField field2 = new JTextField(30);
    private JTextField field3 = new JTextField(40);
    private JTextField field4 = new JTextField(20);
    private JTextField field5 = new JTextField(20);
    private JButton buttonAdd = new JButton("Add");

    private JButton buttonSubtract = new JButton("Subtract");
    private JButton buttonMultiply = new JButton("Multiply");
    private JButton buttonDivide = new JButton("Divide");
    private JButton buttonDerivate = new JButton("Derivate");
    private JButton buttonIntegrate = new JButton("Integrate");
    private JButton buttonClear1 = new JButton("Clear");
    private JButton buttonClear2 = new JButton("Clear");
    private JButton buttonClearAll = new JButton("Clear All");
    private Model model;


    public View(Model model) {
        model = model;
        buttonAdd.setBackground(Color.orange);
        buttonAdd.setPreferredSize(new Dimension(150, 150));
        buttonSubtract.setBackground(Color.orange);
        buttonSubtract.setPreferredSize(new Dimension(150, 150));
        buttonMultiply.setBackground(Color.orange);
        buttonMultiply.setPreferredSize(new Dimension(150, 150));
        buttonDivide.setBackground(Color.orange);
        buttonDivide.setPreferredSize(new Dimension(150, 150));
        buttonDerivate.setBackground(Color.orange);
        buttonDerivate.setPreferredSize(new Dimension(150, 150));
        buttonIntegrate.setBackground(Color.orange);
        buttonIntegrate.setPreferredSize(new Dimension(150, 150));
        text.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        text2.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        JPanel titlu = new JPanel();
        JPanel textPanel = new JPanel();
        JPanel textPanel2 = new JPanel();
        JPanel polinom1 = new JPanel();
        JPanel polinom2 = new JPanel();
        JPanel rezultat = new JPanel();
        JPanel operatii = new JPanel();
        JPanel cat = new JPanel();
        JPanel rest = new JPanel();
        JPanel clearall = new JPanel();

        titlu.setLayout(new FlowLayout());
        textPanel.setLayout((new FlowLayout(FlowLayout.LEFT)));
        textPanel2.setLayout((new FlowLayout(FlowLayout.LEFT)));
        polinom1.setLayout(new FlowLayout());
        polinom2.setLayout(new FlowLayout());
        rezultat.setLayout(new FlowLayout());
        cat.setLayout(new FlowLayout());
        rest.setLayout(new FlowLayout());
        operatii.setLayout(new GridLayout(3, 2));
        clearall.setLayout(new GridLayout(1, 1));
        nume.setFont(new Font("TimesRoman", Font.PLAIN, 25));

        titlu.add(nume);
        textPanel.add(text);
        textPanel2.add(text2);
        polinom1.add(label1);
        polinom1.add(field1);
        polinom1.add(buttonClear1);
        polinom2.add(label2);
        polinom2.add(field2);
        polinom2.add(buttonClear2);
        rezultat.add(new JLabel("Result :", SwingConstants.CENTER));
        rezultat.add(field3);
        cat.add(label3);
        cat.add(field4);
        rest.add(label4);
        rest.add(field5);
        clearall.add(buttonClearAll);
        operatii.add(buttonAdd);
        operatii.add(buttonSubtract);
        operatii.add(buttonMultiply);
        operatii.add(buttonDivide);
        operatii.add(buttonDerivate);
        operatii.add(buttonIntegrate);
        JPanel finalP = new JPanel();
        finalP.setLayout(new GridLayout(10, 1));
        finalP.add(titlu);
        finalP.add(textPanel);
        finalP.add(polinom1);
        finalP.add(polinom2);
        finalP.add(textPanel2);
        finalP.add(rezultat);
        finalP.add(cat);
        finalP.add(rest);
        finalP.add(operatii);
        finalP.add(clearall);
        rezultat.setBackground(Color.LIGHT_GRAY);
        polinom2.setBackground(Color.LIGHT_GRAY);
        polinom1.setBackground(Color.LIGHT_GRAY);
        textPanel.setBackground(Color.LIGHT_GRAY);
        textPanel2.setBackground(Color.LIGHT_GRAY);
        cat.setBackground(Color.LIGHT_GRAY);
        rest.setBackground(Color.LIGHT_GRAY);
        //  clearall.setBackground(Color.LIGHT_GRAY);
        titlu.setBackground(Color.LIGHT_GRAY);
        this.setSize(550, 650);
        this.setContentPane(finalP);
        this.setTitle("Calculator de polinoame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.red);
    }

    public void reset1() {
        field1.setText("");
    }

    public void reset2() {
        field2.setText("");
    }

    public void resetAll() {
        field1.setText("");
        field2.setText("");
        field3.setText("");
        field4.setText("");
        field5.setText("");
    }

    public void setRezultatImpartire(String quotient, String remainder) {
        this.field4.setText(quotient);
        this.field5.setText(remainder);
    }

    public void addClearListener1(ActionListener cal) {
        buttonClear1.addActionListener(cal);
    }

    public void addClearListener2(ActionListener cal) {
        buttonClear2.addActionListener(cal);
    }

    public void addClearListenerAll(ActionListener cal) {
        buttonClearAll.addActionListener(cal);
    }

    public void addAddListener(ActionListener ad) {
        buttonAdd.addActionListener(ad);
    }

    public void addSubtractListener(ActionListener ad) {
        buttonSubtract.addActionListener(ad);
    }

    public void addMultiplyListener(ActionListener ad) {
        buttonMultiply.addActionListener(ad);
    }

    public void addDerivateListener(ActionListener ad) {
        buttonDerivate.addActionListener(ad);
    }

    public void addIntegrateListener(ActionListener ad) {
        buttonIntegrate.addActionListener(ad);
    }

    public void addDivideListener(ActionListener ad) {
        buttonDivide.addActionListener(ad);
    }

    public String getUserInput1() {
        return field1.getText();
    }

    public String getUserInput2() {
        return field2.getText();
    }

    public void setRezultat(String rezultat) {
        field3.setText(rezultat);
    }

}
