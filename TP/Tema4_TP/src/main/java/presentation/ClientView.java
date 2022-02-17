package presentation;

import businessLogic.ItemsAndQuantities;
import businessLogic.MenuItem;
import businessLogic.BaseProduct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import static java.awt.BorderLayout.*;

public class ClientView {

    private JLabel title= new JLabel("Make yourself a tasty order!",SwingConstants.CENTER);
    private JButton viewTheMeniu= new JButton("View Menu");
    private JLabel searchFor= new JLabel("Search after: ", SwingConstants.CENTER);
    private JLabel keyword= new JLabel("keyword:");
    private JTextField keywordTF= new JTextField(15);
    private JLabel rating= new JLabel(", rating:");
    private  JTextField ratingTF= new JTextField(5);
    private JLabel numberOfCalories= new JLabel(", calories:");
    private JTextField numberOfCaloriesTF= new JTextField(5);
    private JLabel proteins= new JLabel(", proteins:");
    private JTextField proteinsTF= new JTextField(5);
    private JLabel fats= new JLabel(", fats:");
    private JTextField fatsTF= new JTextField(5);
    private JLabel sodium= new JLabel(", sodium:");
    private JTextField sodiumTF= new JTextField(5);
    private JLabel price= new JLabel(", price:");
    private JTextField priceTF= new JTextField(5);
    private JButton searchButton= new JButton("search");
    private JLabel select= new JLabel("Select from here the food you want:");
    private JComboBox foodCombo= new JComboBox();
    private JTextField quantity= new JTextField("1", 5);
    private JButton add= new JButton("add");
    private JPanel panelTitle= new JPanel(new FlowLayout());
    private JPanel panel= new JPanel(new FlowLayout());
    private JPanel panel2= new JPanel(new FlowLayout());
    private JPanel panel3= new JPanel(new FlowLayout());
    private JPanel panel4= new JPanel(new FlowLayout());
    private JButton back= new JButton("Log out");
    public JButton seeMyCart = new JButton("See my cart");
    public JButton sendThOrder= new JButton("Send the order");
    public JButton reload= new JButton("Reload ComboBox");
    public JButton emptyTheCart= new JButton("Empty my cart");
    public  JFrame frame;

    public List<ItemsAndQuantities> menuItems= new ArrayList<>();

    public ClientView() { }
    public void setClientView(JFrame frame)
    {
        JPanel contentPanel= new JPanel(new GridLayout(5,1));
        this.frame= frame;
        title.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        panelTitle.add(title, PAGE_START);
        viewTheMeniu.setPreferredSize(new Dimension(100, 50));
        panel.add(viewTheMeniu);
        panel.add(searchFor);
        panel.add(keyword);
        panel.add(keywordTF);
        panel.add(rating);
        panel.add(ratingTF);
        panel.add(numberOfCalories);
        panel.add(numberOfCaloriesTF);
        panel.add(proteins);
        panel.add(proteinsTF);
        panel.add(fats);
        panel.add(fatsTF);
        panel.add(sodium);
        panel.add(sodiumTF);
        panel.add(price);
        panel.add(priceTF);
        panel.add(searchButton);
        panel2.add(select);
        panel2.add(foodCombo);
        panel2.add(quantity);
        panel2.add(add);
        panel3.add(back);
        panel4.add(reload);
        panel4.add(seeMyCart);
        panel4.add(emptyTheCart);
        panel4.add(sendThOrder);
        contentPanel.add(panelTitle);
        contentPanel.add(panel);
        contentPanel.add(panel2);
        contentPanel.add(panel4);
        contentPanel.add(panel3);

        frame.setContentPane(contentPanel);
        frame.setVisible(true);
        frame.setSize(new Dimension(1300, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void backListener(ActionListener cal)
    {
        back.addActionListener(cal);
    }
    public void setAddListener(ActionListener cal)
    {
        add.addActionListener(cal);
    }
    public void setViewTheMeniu(ActionListener cal){ viewTheMeniu.addActionListener(cal);}
    public void setEmptyTheCart(ActionListener cal){ emptyTheCart.addActionListener(cal);}
    public void setSeeMyCart(ActionListener cal){ seeMyCart.addActionListener(cal);}
    public void setReload(ActionListener cal){ reload.addActionListener(cal);}
    public void setSendThOrder(ActionListener cal){ sendThOrder.addActionListener(cal);}
    public void setFoodCombo(List<MenuItem> products) {
         String[] names=new String[products.size()];
         int index=0;
         for(MenuItem menuItem:products)
         {
             names[index]=menuItem.title;
             index++;
         }

        foodCombo.setModel(new DefaultComboBoxModel(names));}
    public void setSearchButton(ActionListener cal){ searchButton.addActionListener(cal);}
    public BaseProduct getBaseProductForSearch(){
        BaseProduct baseProduct= new BaseProduct();
        if( !keywordTF.getText().equals(""))
        baseProduct.title= keywordTF.getText();
        else
            baseProduct.title="";
        if( !ratingTF.getText().equals(""))
          baseProduct.rating= Double.parseDouble(ratingTF.getText());
        else
            baseProduct.rating=-1;
        if( !numberOfCaloriesTF.getText().equals(""))
           baseProduct.calories=Double.parseDouble(numberOfCaloriesTF.getText());
        else
            baseProduct.calories=-1;
        if( !proteinsTF.getText().equals(""))
            baseProduct.proteins=Double.parseDouble(proteinsTF.getText());
        else
            baseProduct.proteins=-1;
        if( !fatsTF.getText().equals(""))
            baseProduct.fats=Double.parseDouble(fatsTF.getText());
        else
            baseProduct.fats=-1;
        if( !sodiumTF.getText().equals(""))
            baseProduct.sodium=Double.parseDouble(sodiumTF.getText());
        else
            baseProduct.sodium=-1;
        if( !priceTF.getText().equals(""))
           baseProduct.price=Double.parseDouble(priceTF.getText());
        else
            baseProduct.price=-1;
        return baseProduct;
    }
    public void showCart(MenuItem menuItem, int quantity){

        double total=0;
        JFrame cartFrame= new JFrame();
        JPanel panel= new JPanel( new FlowLayout(FlowLayout.LEFT));
        JLabel label= new JLabel(" ");
        String text="<html> My Products: <br/>";
        if(menuItem != null)
        {
            ItemsAndQuantities newItem= new ItemsAndQuantities(menuItem, quantity);
            menuItems.add(newItem);
        }
        if( !menuItems.isEmpty()) {
            int i=1;
            for (ItemsAndQuantities menuItem1 : menuItems) {
                total= total+ menuItem1.menuItem.computePrice()* menuItem1.quantity;
                text = text + i +". "+ menuItem1.menuItem.title + " x"+ menuItem1.quantity+ " ;"+"<html> <br/> <html/> ";
                i++;
            }
        }
        text=text + " Total: "+ total+"$ <html/> ";
        label.setText(text);
        panel.add(label);
        panel.setBackground(Color.WHITE);
        cartFrame.setContentPane(panel);
        cartFrame.setTitle("Cart");
        cartFrame.setSize(700, 400);
        cartFrame.setVisible(true);
    }
    public String getProduct()
    {
        return (String)foodCombo.getSelectedItem();
    }
    public int getQuantity(){ return Integer.parseInt(quantity.getText());}

}
