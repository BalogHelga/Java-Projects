package businessLogic;
import model.*;
import dataAccess.*;

import javax.swing.*;
import java.io.FileWriter;
import java.util.List;

/**
 *  Aceasta clasa se ocupa de logica din spatele operatiilor pe comenzi din baza de date
 *  @author Helga Balog  balog.helga@yahoo.com
 *  @since 25.04.2021
 */
public class OrderBll {

    /**
     * vvariabila care poate apela metodele din AbstractDAO pentru comenzi
     */
    public OrderDAO orderDAO;
    /**
     * variabila care poate apela metodele din AbstractDAO pentru poduse
     */
    public ProductDAO productDAO= new ProductDAO();
    /**
     * variabila care poate apela metodele din AbstractDAO pentru clienti
     */
    public ClientDAO  clientDAO= new ClientDAO();

    /**
     *Constructorul instantiaza variabila orderDAO
     */
    public OrderBll(){ orderDAO= new OrderDAO();}

    /**
     * Aceasta functie se ocupa de inserarea in baza de date a unei noi comenzi
     * @param order este comanda care va fi adaugata
     * @return este un intreg, care va fi verificat in controller. Pe baza acestei valori se va decide daca cantitatea este acceptata sau nu
     */
    public int insertNewOrder(Order order) {
        FileWriter file=null;
       if( clientDAO.findById(order.getClientID()) != null)
           if( productDAO.findById(order.getProductID())!= null)
               if( productDAO.findById(order.getProductID()).getStock() >= order.getQuantity())
               {
                   orderDAO.insert(order);
                   try {
                       file = new FileWriter("Order.txt");
                   }
                   catch(Exception e)
                   {
                       System.out.println("Problems with the fileWriter");
                   }
                   try {
                       file.write(" Factura \n Clientul cu numele "+ clientDAO.findById(order.getClientID()).getName() +" a comandat "+
                                productDAO.findById(order.getProductID()).getName()+", "+ order.getQuantity() +" bucati");
                   }catch(Exception e)
                   {
                       System.out.println("Problems with the fileWriter");
                   }
                   try {
                       file.close();
                   }catch(Exception e)
                   {
                       System.out.println("Probleme la inchiderea fileWriterului");
                   }
                   Product product= productDAO.findById(order.getProductID());
                   product.setStock( product.getStock() - order.getQuantity());
                   productDAO.update(product);
                   return 1;
               }

      return 0;
    }

    /**
     *  Aceasta metoda apeleaza functia care editeaza o inregistrare din tabelul pentru comenzi
     * @param order este comanda care va fi editata
     */
    public void editOrder(Order order)
    {
        Product product= productDAO.findById(order.getProductID());
        if( product.getStock() > order.getQuantity()- orderDAO.findById(order.getOrderID()).getQuantity() )
        {
            product.setStock(product.getStock()- (order.getQuantity()- orderDAO.findById(order.getOrderID()).getQuantity() ));
            orderDAO.update(order);
            productDAO.update(product);
        }
        else
            JOptionPane.showMessageDialog(new JFrame(),"we don't have enough product");
    }

    /**
     *  Aceasta metoda apeleaza functia care sterge o inregistrare din tabelul pentru comenzi
     * @param order
     */
    public void deleteOrder(Order order)
    {
        orderDAO.delete(order);
    }

    /**
     * Aceasta metoda apeleaza functia care expune tabelul pentru comenzi
     * @return
     */
    public List<Order> viewAll()
    {
        List<Order> list= orderDAO.findAll();
        return list;
    }
}
