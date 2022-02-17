package presentation;
import model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import businessLogic.*;
import javax.swing.*;


/**
 *  Aceasta clasa se ocupa de controlul interfetelor, respectiv de comunicarea intre aplicatia si interfete
 * @author Helga Balog balog.helga@yahoo.com
 * @since 22.04 2021
 */
public class Controller {

    /**
     *  variabila view leaga aceasta clasa de clasa View, facand astfel posibila interactiunea dintre cele doua
     */
    private View view;
    /**
     *  variabila bll1 ne  ajuta sa apelam metoda pentru clienti
     */
    private ClientBll bll1;
    /**
     * variabila bll2 ne ajuta sa apelam metoda pentru proddus
     */
    private ProductBll  bll2;
    /**
     *  variabila bll3 ne ajuta sa apelam metoda pentru comenzi
     */
    private OrderBll bll3;

    /**
     *  Constructorul clasei instantiaza un view, un bl1, bll2, si un bll3, respectiv adauga Listneri pentru view
     */
    public Controller()
    {
        this.view= new View();
        view.addClientsListener(new ClientsListenner());
        view.addClientsBListener(new AddClientListenner());
        view.addEditClientsListener(new EditClientListenner());
        view.addDeleteClientsListener(new DeleteClientListenner());
        view.addViewAllClientsListener(new ViewAllClientListenner());
        view.addProductsListener(new ProductsListenner());
        view.addProductsButtonListener(new AddProductListenner());
        view.addEditProductListener(new EditProductListenner());
        view.addDeleteProductsListener(new DeleteProductListenner());
        view.addViewAllProductsListener(new ViewAllProductsListenner());
        view.addOrderListener(new OrderListenner());
        view.addSendOrderListener(new SendOrderListener());
        view.addEditOrderListener(new EditOrderListener());
        view.addDeleteOrderListener(new DeleteOrderListener());
        view.addViewAllOrdersListener( new ViewAllOrdersListenner());
        view.addBackListener1(new BackListener());
        view.addBackListener2(new BackListener());
        view.addBackListener3(new BackListener());

        bll1= new ClientBll();
        bll2= new ProductBll();
        bll3= new OrderBll();
    }

    /**
     *  Aceasta clasa implementeaza actionListener si in cazul in care s-a apasat butonul , se seteaza interfata corecta
     */
    class ClientsListenner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.setClients();
        }
    }

    /**
     * Aceasta clasa implementeaza actionListener si in cazul in care s-a apasat butonul , se citeste un client si se inseareaza
     * in baza de date
     */
    class AddClientListenner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           Client newClient= view.getClient(0);
           bll1.insertNewClient(newClient);

        }
    }

    /**
     * Aceasta clasa implementeaza actionListener si in cazul in care s-a apasat butonul , se editeaza clientul, cu id-ul dat, cu datele
     *  citite
     */
    class EditClientListenner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Client newClient= view.getClient(1);
            bll1.editClient(newClient);
        }
    }

    /**
     * Aceasta clasa implementeaza actionListener si in cazul in care s-a apasat butonul , se sterge clientul cu acel id
     */
    class DeleteClientListenner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Client newClient= view.getClient(2);
            bll1.deleteClient(newClient);
        }
    }

    /**
     * Aceasta clasa implementeaza actionListener si in cazul in care s-a apasat butonul , se seteaza afiseaza tabelul pentru clienti
     */
    class ViewAllClientListenner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JTable table= new JTable();
            List<Object> list= new ArrayList<Object>();
            List<Client> clientList= bll1.viewAll();
            for(Client client: clientList)
            {
                list.add((Object)client);
            }
            view.showTable(list);
        }
    }

    /**
     * Aceasta clasa implementeaza actionListener si in cazul in care s-a apasat butonul , se seteaza interfata corecta
     */
    class ProductsListenner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.setProducts();
        }
    }

    /**
     * Aceasta clasa implementeaza actionListener si in cazul in care s-a apasat butonul , citeste un produs si il insereaza in tabel
     */
    class AddProductListenner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Product newProduct= view.getProduct(0);
            bll2.insertNewProduct(newProduct);
        }
    }

    /**
     * Aceasta clasa implementeaza actionListener si in cazul in care s-a apasat butonul , se editeaza  produsul cu acel id, cu datele
     * citite
     */
    class EditProductListenner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Product newProduct= view.getProduct(1);
            bll2.editProduct(newProduct);
        }
    }

    /**
     * Aceasta clasa implementeaza actionListener si in cazul in care s-a apasat butonul , se sterge produsul cu acel id
     */
    class DeleteProductListenner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Product newProduct= view.getProduct(2);
            bll2.deleteProduct(newProduct);
        }
    }

    /**
     * Aceasta clasa implementeaza actionListener si in cazul in care s-a apasat butonul , se afiseaza tabelul pentru produse
     */
    class ViewAllProductsListenner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JTable table= new JTable();
            List<Object> list= new ArrayList<Object>();
            List<Product> productList= bll2.viewAll();
            for(Product product: productList)
            {
                list.add((Object)product);
            }
            view.showTable(list);
        }
    }

    /**
     * Aceasta clasa implementeaza actionListener si in cazul in care s-a apasat butonul , se seteaza interfata corecta
     */
    class OrderListenner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.setOrders();
        }
    }

    /**
     * Aceasta clasa implementeaza actionListener si in cazul in care s-a apasat butonul , citeste o comanda si o insereaza in tabel.
     */
    class SendOrderListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            Order newOrder= view.getOrder(0);
            if( bll3.insertNewOrder(newOrder) == 0)
                JOptionPane.showMessageDialog(new JFrame(),"we don't have enough product");
        }
    }

    /**
     * Aceasta clasa implementeaza actionListener si in cazul in care s-a apasat butonul , editeaza o inregistrare din baza
     * de date pentru comenzi.
     */
    class EditOrderListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            Order newOrder= view.getOrder(1);
             bll3.editOrder(newOrder);
        }
    }

    /**
     * Aceasta clasa implementeaza actionListener si in cazul in care s-a apasat butonul , sterge o inregistrare din baza
     * de date pentru comenzi.
     */
    class DeleteOrderListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            Order newOrder= view.getOrder(2);
            bll3.deleteOrder(newOrder);
        }
    }

    /**
     * Aceasta clasa implementeaza actionListener si in cazul in care s-a apasat butonul , afiseaza toate datele, sub forma de tabel
     * din baza de date pentru comenzi
     */
    class ViewAllOrdersListenner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JTable table= new JTable();
            List<Object> list= new ArrayList<Object>();
            List<Order> orderList= bll3.viewAll();
            for(Order order: orderList )
            {
                list.add((Object)order);
            }
            view.showTable(list);
        }
    }
    /**
     *   Aceasta clasa implementeaza actionListener si in cazul in care s-a apasat butonul, afiseaza interfata initiala
     */
    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.setMainFrame();
        }
    }

}
