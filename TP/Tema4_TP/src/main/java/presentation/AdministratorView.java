package presentation;

import businessLogic.BaseProduct;
import businessLogic.MenuItem;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.List;

public class AdministratorView {

    private JButton importButton= new JButton("Import initial menu");
    private JLabel title= new JLabel("Welcome to administration");
    private JButton viewMeniu= new JButton("View menu");
    private JButton add= new JButton("add simple product");
    private JButton edit= new JButton("modify");
    private JButton delete= new JButton("delete");
    private JButton generateButton= new JButton("Generate report");
    private JLabel generate= new JLabel("Generate a report after the crtieria:");
    public JCheckBox checkBox1= new JCheckBox("time interval of the orders ==>");
    public JCheckBox checkBox2= new JCheckBox("the products ordered more than the specified number of times so far ==>");
    public JCheckBox checkBox3= new JCheckBox("the clients that have ordered more than a specified number of times and the value" +
            " of the order was higher than a specified amount ==>");
    public JCheckBox checkBox4= new JCheckBox("the  products  ordered  within  a  specified  day  with  the  number  of  times " +
            " they  have been ordered ==>");
    private JLabel startHour= new JLabel("start hour:");
    public JTextField startHourTF= new JTextField(3);
    private JLabel endHour= new JLabel("end hour");
    public JTextField endHourTF= new JTextField(3);
    private JLabel specifiedNumber= new JLabel("Specified Number:");
    public JTextField specifiedNumberTF= new JTextField(3);
    private JLabel specifiedNumber2= new JLabel("Specified Number:");
    public JTextField specifiedNumber2TF= new JTextField(3);
    private JLabel price= new JLabel(" price:");
    public JTextField priceTF= new JTextField(3);
    private JLabel day= new JLabel("day:");
    public JTextField dayTF= new JTextField(6);
    private JButton back= new JButton("Log out");
    private JPanel panel1= new JPanel(new FlowLayout());
    private JPanel panel2= new JPanel(new GridLayout(4,1));
    private JPanel panel3= new JPanel(new GridLayout(1,1));
    private JPanel panel4= new JPanel(new GridLayout(4,1));
    private JPanel panel41= new JPanel(new FlowLayout());
    private JPanel panel42= new JPanel(new FlowLayout());
    private JPanel panel43= new JPanel(new FlowLayout());
    private JPanel panel44= new JPanel(new FlowLayout());
    private JPanel panel5= new JPanel(new FlowLayout());
    private JLabel titleProduct= new JLabel("Title:");
    public JTextField titleProductTF= new JTextField(10);
    private JLabel rating= new JLabel("Rating:");
    private JTextField ratingTF= new JTextField(5);
    private JLabel calories= new JLabel(" Calories");
    private JTextField caloriesTF= new JTextField(5);
    private JLabel proteins= new JLabel("Proteins");
    private JTextField proteinsTF= new JTextField(5);
    private JLabel fats= new JLabel("Fats");
    private JTextField fatsTF= new JTextField(5);
    private JLabel sodium= new JLabel("Sodium");
    private JTextField sodiumTF= new JTextField(5);
    private JLabel priceProduct= new JLabel("Price");
    private JTextField priceProductTF= new JTextField(5);
    public  JFrame frame= new JFrame();
    public JFrame tableFrame= new JFrame();
    private DefaultTableModel model;
    public JTable table;
    private JPanel productPanel1= new JPanel(new FlowLayout());
    private JPanel productPanel2= new JPanel(new FlowLayout());
    private JButton addToTheList= new JButton("add base product to the list");
    private JButton addComposedProduct= new JButton("Add composedProduct");
    private JButton addNewEmployee= new JButton("Add employee");
    private JLabel username= new JLabel("Username:");
    public JTextField usernameTF= new JTextField(10);
    private JLabel password= new JLabel("Password:");
    public JTextField passwordTF= new JTextField(10);
    private JPanel panelUser= new JPanel(new FlowLayout());
    public AdministratorView(){}

    public void setAdministratorView(JFrame frame)
    {
        this.frame= frame;
        frame.getContentPane().removeAll();
        title.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        panel1.add(title);
        productPanel1.add(titleProduct); productPanel1.add(titleProductTF);
        productPanel1.add(rating);productPanel1.add(ratingTF);
        productPanel1.add(calories); productPanel1.add(caloriesTF);
        productPanel2.add(proteins); productPanel2.add(proteinsTF);
        productPanel2.add(fats);productPanel2.add(fatsTF);
        productPanel2.add(sodium); productPanel2.add(sodiumTF);
        productPanel2.add(priceProduct); productPanel2.add(priceProductTF);
        panel2.add(importButton);
        panel2.add(viewMeniu);
        panel2.add(add);
        panel2.add(edit);
        panel2.add(delete);
        panel2.add(generateButton);
        panel2.add(addToTheList);
        panel2.add(addComposedProduct);
        panel3.add(generate);
        panelUser.add(addNewEmployee);
        panelUser.add(username);
        panelUser.add(usernameTF);
        panelUser.add(password);
        panelUser.add(passwordTF);
        panel41.add(checkBox1);
        panel41.add(startHour);
        panel41.add(startHourTF);
        panel41.add(endHour);
        panel41.add(endHourTF);
        panel42.add(checkBox2);
        panel42.add(specifiedNumber);
        panel42.add(specifiedNumberTF);
        panel43.add(checkBox3);
        panel43.add(specifiedNumber2);
        panel43.add(specifiedNumber2TF);
        panel43.add(price);
        panel43.add(priceTF);
        panel44.add(checkBox4);
        panel44.add(day);
        panel44.add(dayTF);
        panel4.add(panel41);
        panel4.add(panel42);
        panel4.add(panel43);
        panel4.add(panel44);
        panel5.add(back);
        JPanel panel = new JPanel(new GridLayout(8,1));
        panel.add(panel1);
        panel.add(productPanel1);
        panel.add(productPanel2);
        panel.add(panel2);
        panel.add(panelUser);
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);
        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.setSize(new Dimension(1000, 900));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void backListener(ActionListener cal)
    {
        back.addActionListener(cal);
    }
    public void setImportButton(ActionListener cal){ importButton.addActionListener(cal);}
    public void setViewMeniu(ActionListener cal){ viewMeniu.addActionListener(cal);}
    public void setAddButton(ActionListener cal){ add.addActionListener(cal);}
    public void setEditButton(ActionListener cal){edit.addActionListener(cal);}
    public void setAddToTheListButton(ActionListener cal){addToTheList.addActionListener(cal);}
    public void setAddComposedProduct(ActionListener cal){ addComposedProduct.addActionListener(cal);}
    public void addDeleteListener(ActionListener cal){delete.addActionListener(cal);}
    public void addGenerateListener(ActionListener cal){ generateButton.addActionListener(cal);}
    public void setAddNewEmployee(ActionListener cal){ addNewEmployee.addActionListener(cal); }
    public void showMeniu(List<MenuItem> list)
    {
        String[] columnNames={"Title", "Rating", "Calories", "Proteins", "Fats", "Sodium", "Price"};
        Object[][] data=new Object[list.size()][7];
        for(int j=0; j<list.size(); j++)
        {
            data[j][0]= list.get(j).title;
            data[j][1]= list.get(j).rating;
            data[j][2]= list.get(j).calories;
            data[j][3]= list.get(j).proteins;
            data[j][4]= list.get(j).fats;
            data[j][5]= list.get(j).sodium;
            data[j][6]= list.get(j).price;
        }
        model= new DefaultTableModel(data, columnNames);
        table=new JTable( model);
        tableFrame.getContentPane().removeAll();
        tableFrame.add(new JScrollPane(table));
        tableFrame.pack();
        tableFrame.setTitle("Table");
        tableFrame.setSize(500, 300);
        tableFrame.setVisible(true);
    }
    public MenuItem getSelectedRow()
    {
        MenuItem product= new MenuItem();
        String selectedCellValue = (String) this.table.getValueAt(this.table.getSelectedRow() ,0 );
        product.title=selectedCellValue;
        Double selectedValue = (Double) this.table.getValueAt(this.table.getSelectedRow() , 1);
        product.rating=selectedValue;
        selectedValue=(Double) this.table.getValueAt(this.table.getSelectedRow() , 2);
        product.calories=selectedValue;
        selectedValue=(Double) this.table.getValueAt(this.table.getSelectedRow() , 3);
        product.proteins=selectedValue;
        selectedValue=(Double) this.table.getValueAt(this.table.getSelectedRow() , 4);
        product.fats= selectedValue;
        selectedValue=(Double) this.table.getValueAt(this.table.getSelectedRow() , 5);
        product.sodium=selectedValue;
        selectedValue=(Double) this.table.getValueAt(this.table.getSelectedRow() , 6);
        product.price= selectedValue;
        return product;
    }
    public BaseProduct getBaseProduct()
    {
        if(titleProductTF.getText().equals("") || ratingTF.getText().equals("") ||  caloriesTF.getText().equals("") ||
            proteinsTF.getText().equals("") || fatsTF.getText().equals("") || sodiumTF.getText().equals("") || priceProductTF.getText().equals("")) {
            JOptionPane.showMessageDialog(new JFrame(), "The fields can't be empty strings");
            return null;
        }
        BaseProduct newBaseProduct= new BaseProduct();
        newBaseProduct.title= titleProductTF.getText();
        newBaseProduct.rating=Double.parseDouble(ratingTF.getText());
        newBaseProduct.calories = Double.parseDouble(caloriesTF.getText());
        newBaseProduct.proteins=Double.parseDouble(proteinsTF.getText());
        newBaseProduct.fats= Double.parseDouble(fatsTF.getText());
        newBaseProduct.sodium=Double.parseDouble(sodiumTF.getText());
        newBaseProduct.price=Double.parseDouble(priceProductTF.getText());
        return newBaseProduct;
    }
    public BaseProduct getProductForEditing()
    {
        BaseProduct newBaseProduct= new BaseProduct();
        if(!titleProductTF.getText().equals(""))
           newBaseProduct.title= titleProductTF.getText();
        else
            newBaseProduct.title="";
        if(!ratingTF.getText().equals(""))
        newBaseProduct.rating=Double.parseDouble(ratingTF.getText());
        else
            newBaseProduct.rating=-1;
        if(!caloriesTF.getText().equals(""))
        newBaseProduct.calories = Double.parseDouble(caloriesTF.getText());
        else
            newBaseProduct.calories=-1;
        if(!proteinsTF.getText().equals(""))
        newBaseProduct.proteins=Double.parseDouble(proteinsTF.getText());
        else
            newBaseProduct.proteins=-1;
        if(!fatsTF.getText().equals(""))
        newBaseProduct.fats= Double.parseDouble(fatsTF.getText());
        else
            newBaseProduct.fats=-1;
        if(!sodiumTF.getText().equals(""))
        newBaseProduct.sodium=Double.parseDouble(sodiumTF.getText());
        else
            newBaseProduct.sodium=-1;
        if(!priceProductTF.getText().equals(""))
        newBaseProduct.price=Double.parseDouble(priceProductTF.getText());
        else
            newBaseProduct.price=-1;
        return newBaseProduct;
    }
}
