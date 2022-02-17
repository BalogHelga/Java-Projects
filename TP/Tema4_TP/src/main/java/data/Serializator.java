package data;
import businessLogic.*;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class Serializator implements Serializable {

    DeliveryService deliveryService;
    public Serializator(DeliveryService deliveryService)
    {
        this.deliveryService= deliveryService;
    }
    public void serializeUsers()
    {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("D:\\PT2021_30227_Balog_Helga_Assignment_4\\UserData.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(deliveryService.users);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in UserData.txt");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public void serializeProducts()
    {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("D:\\PT2021_30227_Balog_Helga_Assignment_4\\ProductsData.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(deliveryService.products);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in ProductsData.txt");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public void serializeOrders()
    {
        try {
            FileOutputStream fileOut = new FileOutputStream("D:\\PT2021_30227_Balog_Helga_Assignment_4\\OrdersData.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(deliveryService.comenzi);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in OrdersData.txt");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void deserializeUsers()
    {
        try {
            FileInputStream fileIn = new FileInputStream("D:\\PT2021_30227_Balog_Helga_Assignment_4\\UserData.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deliveryService.users = (List<User>)in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Data not found");
            c.printStackTrace();
            return;
        }
    }
    public void deserializeProducts()
    {
        try {
            FileInputStream fileIn = new FileInputStream("D:\\PT2021_30227_Balog_Helga_Assignment_4\\ProductsData.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deliveryService.products= (List<MenuItem>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Data not found");
            c.printStackTrace();
            return;
        }
    }
    public void deserializeOrders()
    {
        try {
            FileInputStream fileIn = new FileInputStream("D:\\PT2021_30227_Balog_Helga_Assignment_4\\OrdersData.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deliveryService.comenzi=(HashMap<Order, List<MenuItem>>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Data not found");
            c.printStackTrace();
            return;
        }
    }
}
