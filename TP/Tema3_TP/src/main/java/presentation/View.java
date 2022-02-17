package presentation;
import model.*;
import shop.Reflection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import java.util.List;

/**
 *  Aceasta clasa construieste interfetele pentru aplicatie
 * @author Helga Balog balog.helga@yahoo.com
 * @since 22.04 2021
 */
public class View {

    private JLabel title = new JLabel("SkinCare Shop Warehouse");
    private JLabel clientSection = new JLabel("Client Options");
    private JButton clients = new JButton("Clients");
    private JButton addClient = new JButton("Add Client");
    private JButton editClient = new JButton("Edit Client");
    private JButton deleteClient = new JButton("Delete Client");
    private JButton viewAllClients = new JButton("View all clients");
    private JLabel productSection = new JLabel("Product Options");
    private JButton products = new JButton("Products");
    private JButton addProduct = new JButton("Add Product");
    private JButton editProduct = new JButton("Edit Product");
    private JButton deleteProduct = new JButton("Delete Product");
    private JButton viewAllProducts = new JButton("View all products");
    private JLabel makeAnOrder = new JLabel("Order Section");
    private JButton orders = new JButton("Make an order");
    private JButton sendTheOrder = new JButton("Send");
    /**
     * frame este interfata pe care se va afisa una dintre cele 4 interfete: principala/ clienti /produse/ comenzi
     */
    private JFrame frame = new JFrame();
    /**
     *  mainPanel este interfata initiala, pe care se dispun 3 butoane pentru a alege cu ce tabel  dorim sa interactionam
     */
    private JPanel mainPanel = new JPanel(new GridLayout(2, 1));
    /**
     *  clientPanel este interfata care ne permita sa interactionam cu baza de date pentru clienti
     */
    private JPanel clientPanel = new JPanel(new GridLayout(8, 1));
    /**
     * productPanel este interfata care ne permita sa interactionam cu baza de date pentru produse
     */
    private JPanel productPanel = new JPanel(new GridLayout(8, 1));
    /**
     * orderPanel este interfata care ne permita sa interactionam cu baza de date pentru comenzi
     */
    private JPanel orderPanel = new JPanel(new GridLayout(6, 1));
    private JButton backToMainFrame = new JButton("<- Back");
    private JButton backToMainFrame2 = new JButton("<- Back");
    private JButton backToMainFrame3 = new JButton("<- Back");
    private JLabel idClientOrder = new JLabel(" id client:");
    private JTextField idClientOrderTF = new JTextField(5);
    private JLabel idProductOrder = new JLabel(" id product:");
    private JTextField idPorductOrderTF = new JTextField(5);
    private JLabel quantityOrder = new JLabel("quantity:");
    private JTextField quantityOrderTF = new JTextField(5);
    private JLabel id = new JLabel("id:");
    private JTextField idTF = new JTextField(5);
    private JLabel text = new JLabel("If you want to edit or to delete, enter the id, otherwise don't. ");
    private JLabel text2 = new JLabel("If you want to edit or to delete, enter the id, otherwise don't. ");
    private JLabel name = new JLabel("name:");
    private JTextField nameTF = new JTextField(15);
    private JLabel email = new JLabel("email:");
    private JTextField emailTF = new JTextField(15);
    private JLabel address = new JLabel("address:");
    private JTextField addressTF = new JTextField(15);
    private JLabel idP = new JLabel("id:");
    private JTextField idPTF = new JTextField(5);
    private JLabel nameP = new JLabel("name:");
    private JTextField namePTF = new JTextField(15);
    private JLabel description = new JLabel("descriprion:");
    private JTextField descriptionTF = new JTextField(15);
    private JLabel stock = new JLabel("stock:");
    private JTextField stockTF = new JTextField(15);
    private JButton orderEditButton = new JButton("Edit the order with the given id");
    private JLabel idOrder = new JLabel("id:");
    private JTextField idOrderTf = new JTextField(5);
    private JButton orderDeleteButton = new JButton("Delete the order with the given id");
    private JLabel idOrder2 = new JLabel("id:");
    private JTextField idOrderTf2 = new JTextField(5);
    private JButton viewallOrder = new JButton("View all the orders");
    /**
     * tableFrame este interfata pe care se va dispune tabelul cu care lucram
     */
    private JFrame tableFrame = new JFrame();
    private static int ok = 0;
    private static int ok2 = 0;
    private static int ok3 = 0;

    /**
     * Contructorul View afiseaza prima interfata, pe care se poate alege cu ce
     * sa se lucreze: client/product/order
     */
    public View() {
        JPanel titlePanel = new JPanel(new FlowLayout());
        JPanel buttons = new JPanel(new FlowLayout());
        title.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        titlePanel.add(title);
        titlePanel.setBackground(Color.lightGray);
        clients.setPreferredSize(new Dimension(100, 50));
        clients.setBackground(Color.orange);
        buttons.add(clients);
        products.setPreferredSize(new Dimension(100, 50));
        products.setBackground(Color.orange);
        buttons.add(products);
        orders.setPreferredSize(new Dimension(200, 50));
        orders.setBackground(Color.orange);
        buttons.add(orders);
        buttons.setBackground(Color.lightGray);
        mainPanel.add(titlePanel);
        mainPanel.add(buttons);
        frame.setContentPane(mainPanel);
        frame.setSize(600, 300);
        frame.setTitle("Warehouse");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Aceasta metoda pregateste interfata pentru manipularea tabelului cu clienti
     * din baza de date
     */
    public void prepareClientsFrame() {
        JPanel titlePanel = new JPanel(new FlowLayout());
        JPanel p1 = new JPanel(new FlowLayout());
        p1.setBackground(Color.lightGray);
        p1.add(text2);
        p1.add(id);
        p1.add(idTF);
        JPanel p2 = new JPanel(new FlowLayout());
        p2.setBackground(Color.lightGray);
        p2.add(name);
        p2.add(nameTF);
        JPanel p3 = new JPanel(new FlowLayout());
        p3.setBackground(Color.lightGray);
        p3.add(email);
        p3.add(emailTF);
        JPanel p4 = new JPanel(new FlowLayout());
        p4.setBackground(Color.lightGray);
        p4.add(address);
        p4.add(addressTF);
        JPanel buttons1 = new JPanel(new FlowLayout());
        JPanel buttons2 = new JPanel(new FlowLayout());
        JPanel back = new JPanel(new FlowLayout());
        clientSection.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        titlePanel.add(clientSection);
        titlePanel.setBackground(Color.lightGray);
        addClient.setBackground(Color.orange);
        addClient.setPreferredSize(new Dimension(150, 50));
        buttons1.add(addClient);
        editClient.setBackground(Color.orange);
        editClient.setPreferredSize(new Dimension(150, 50));
        buttons1.add(editClient);
        deleteClient.setBackground(Color.orange);
        deleteClient.setPreferredSize(new Dimension(150, 50));
        buttons1.setBackground(Color.lightGray);
        buttons2.add(deleteClient);
        viewAllClients.setBackground(Color.orange);
        viewAllClients.setPreferredSize(new Dimension(150, 50));
        buttons2.add(viewAllClients);
        backToMainFrame.setBackground(Color.orange);
        backToMainFrame.setPreferredSize(new Dimension(150, 50));
        buttons2.setBackground(Color.lightGray);
        back.add(backToMainFrame);
        back.setBackground(Color.lightGray);
        clientPanel.add(titlePanel);
        clientPanel.add(p1);
        clientPanel.add(p2);
        clientPanel.add(p3);
        clientPanel.add(p4);
        clientPanel.add(buttons1);
        clientPanel.add(buttons2);
        clientPanel.add(back);
        ok = 1;
    }

    /**
     * Aceasta metoda pregateste interfata pentru manipularea tabelului cu produse
     * din baza de date
     */
    public void prepareProductsFrame() {
        JPanel titlePanel = new JPanel(new FlowLayout());
        JPanel p1 = new JPanel(new FlowLayout());
        p1.setBackground(Color.lightGray);
        p1.add(text);
        p1.add(idP);
        p1.add(idPTF);
        JPanel p2 = new JPanel(new FlowLayout());
        p2.setBackground(Color.lightGray);
        p2.add(nameP);
        p2.add(namePTF);
        JPanel p3 = new JPanel(new FlowLayout());
        p3.setBackground(Color.lightGray);
        p3.add(description);
        p3.add(descriptionTF);
        JPanel p4 = new JPanel(new FlowLayout());
        p4.setBackground(Color.lightGray);
        p4.add(stock);
        p4.add(stockTF);
        JPanel buttons1 = new JPanel(new FlowLayout());
        JPanel buttons2 = new JPanel(new FlowLayout());
        JPanel back = new JPanel(new FlowLayout());
        productSection.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        titlePanel.add(productSection);
        titlePanel.setBackground(Color.lightGray);
        addProduct.setBackground(Color.orange);
        addProduct.setPreferredSize(new Dimension(150, 50));
        buttons1.add(addProduct);
        editProduct.setBackground(Color.orange);
        editProduct.setPreferredSize(new Dimension(150, 50));
        buttons1.add(editProduct);
        deleteProduct.setBackground(Color.orange);
        deleteProduct.setPreferredSize(new Dimension(150, 50));
        buttons1.setBackground(Color.lightGray);
        buttons2.add(deleteProduct);
        viewAllProducts.setBackground(Color.orange);
        viewAllProducts.setPreferredSize(new Dimension(150, 50));
        buttons2.add(viewAllProducts);
        backToMainFrame2.setBackground(Color.orange);
        backToMainFrame2.setPreferredSize(new Dimension(150, 50));
        buttons2.setBackground(Color.lightGray);
        back.add(backToMainFrame2);
        back.setBackground(Color.lightGray);
        productPanel.add(titlePanel);
        productPanel.add(p1);
        productPanel.add(p2);
        productPanel.add(p3);
        productPanel.add(p4);
        productPanel.add(buttons1);
        productPanel.add(buttons2);
        productPanel.add(back);
        ok2 = 1;
    }

    /**
     * Aceasta metoda pregateste interfata pentru manipularea tabelului care contine comenzile
     */
    public void prepareOrderFrame() {
        JPanel titlePanel = new JPanel(new FlowLayout());
        JPanel buttons = new JPanel(new FlowLayout());
        JPanel newb1 = new JPanel(new FlowLayout());
        JPanel newb2 = new JPanel(new FlowLayout());
        JPanel newb3 = new JPanel(new FlowLayout());
        JPanel back = new JPanel(new FlowLayout());
        makeAnOrder.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        titlePanel.add(makeAnOrder);
        titlePanel.setBackground(Color.lightGray);
        buttons.add(idClientOrder);
        buttons.add(idClientOrderTF);
        buttons.add(idProductOrder);
        buttons.add(idPorductOrderTF);
        orderEditButton.setBackground(Color.orange);
        orderDeleteButton.setBackground(Color.orange);
        viewallOrder.setBackground(Color.orange);
        viewallOrder.setPreferredSize(new Dimension(150, 30));
        buttons.add(quantityOrder);
        buttons.add(quantityOrderTF);
        newb1.add(orderEditButton);
        newb1.add(idOrder);
        newb1.add(idOrderTf);
        newb1.setBackground(Color.lightGray);
        newb2.add(orderDeleteButton);
        newb2.add(idOrder2);
        newb2.add(idOrderTf2);
        newb2.setBackground(Color.lightGray);
        newb3.add(viewallOrder);
        newb3.setBackground(Color.lightGray);
        sendTheOrder.setBackground(Color.orange);
        sendTheOrder.setPreferredSize(new Dimension(80, 30));
        buttons.add(sendTheOrder);
        buttons.setBackground(Color.lightGray);
        backToMainFrame3.setBackground(Color.orange);
        backToMainFrame3.setPreferredSize(new Dimension(150, 50));
        back.setBackground(Color.lightGray);
        back.add(backToMainFrame3);
        orderPanel.add(titlePanel);
        orderPanel.add(buttons);
        orderPanel.add(newb1);
        orderPanel.add(newb2);
        orderPanel.add(newb3);
        orderPanel.add(back);
        ok3 = 1;
    }

    /**
     * Aceasta metoda schimba interfata initiala cu interfata pentru clienti
     */
    public void setClients() {
        if (ok == 0)
            prepareClientsFrame();

        frame.setContentPane(clientPanel);
        frame.setSize(600, 500);
        frame.setTitle("Warehouse");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Aceasta metoda schimba interfata initiala cu interfata pentru produse
     */
    public void setProducts() {
        if (ok2 == 0)
            prepareProductsFrame();

        frame.setContentPane(productPanel);
        frame.setSize(600, 500);
        frame.setTitle("Warehouse");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Aceasta metoda schimba interfata initiala cu interfata pentru comenzi
     */
    public void setOrders() {
        if (ok3 == 0)
            prepareOrderFrame();

        frame.setContentPane(orderPanel);
        frame.setSize(600, 500);
        frame.setTitle("Warehouse");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Aceasta metoda seteaza interfata la cea initiala
     */
    public void setMainFrame() {
        frame.setContentPane(mainPanel);
        frame.setSize(600, 300);
        frame.setTitle("Warehouse");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Aceasta metoda adauga un Listener pentru butonul de Clienti de pe pagina initala
     *
     * @param cal sesizeaza cand este apasat butonul
     */
    public void addClientsListener(ActionListener cal) {
        clients.addActionListener(cal);
    }

    /**
     * Aceasta metoda adauga un Listener pentru butonul add Client de pe interfata pentru clienti
     *
     * @param cal sesizeaza cand este apasat butonul
     */
    public void addClientsBListener(ActionListener cal) {
        addClient.addActionListener(cal);
    }

    /**
     * Aceasta metoda adauga un Listener pentru butonul edit Client de pe interfata pentru clienti
     *
     * @param cal sesizeaza cand este apasat butonul
     */
    public void addEditClientsListener(ActionListener cal) {
        editClient.addActionListener(cal);
    }

    /**
     * Aceasta metoda adauga un Listener pentru butonul delete Client de pe interfata pentru clienti
     *
     * @param cal sesizeaza cand este apasat butonul
     */
    public void addDeleteClientsListener(ActionListener cal) {
        deleteClient.addActionListener(cal);
    }

    /**
     * Aceasta metoda adauga un Listener pentru butonul View all Clients de pe interfata pentru clienti
     *
     * @param cal sesizeaza cand este apasat butonul
     */
    public void addViewAllClientsListener(ActionListener cal) {
        viewAllClients.addActionListener(cal);
    }

    /**
     * Aceasta metoda citeste datele clientului pe care dorim sa-l inseram/ editam / stergem din tabel
     *
     * @param i ne zice daca citim si id-ul clientului sau nu
     * @return metoda returneaza Clientul citit
     */
    public Client getClient(int i) {
        Client newClient = null;
        if (i == 1)
            newClient = new Client(Integer.parseInt(idTF.getText()), nameTF.getText(), emailTF.getText(), addressTF.getText());
        if (i == 0)
            newClient = new Client(nameTF.getText(), emailTF.getText(), addressTF.getText());
        if (i == 2)
            newClient = new Client(Integer.parseInt(idTF.getText()));
        return newClient;
    }

    /**
     * Acesta metoda adauga Listener pentru butonul de Produse de pe interfata initiala
     *
     * @param cal sesizeaza daca se apasa butonul
     */
    public void addProductsListener(ActionListener cal) {
        products.addActionListener(cal);
    }

    /**
     * Aceasta metoda adauga un Listener pentru butonul add Product de pe interfata pentru produse.
     *
     * @param cal sesizeaza cand se apasa butonul
     */
    public void addProductsButtonListener(ActionListener cal) {
        addProduct.addActionListener(cal);
    }

    /**
     * Aceasta metoda adauga un Listener pentru butonul edit Product de pe interfata pentru produse.
     *
     * @param cal sesizeaza cand se apasa butonul
     */
    public void addEditProductListener(ActionListener cal) {
        editProduct.addActionListener(cal);
    }

    /**
     * Aceasta metoda adauga un Listener pentru butonul delete Product de pe interfata pentru produse.
     *
     * @param cal sesizeaza cand se apasa butonul
     */
    public void addDeleteProductsListener(ActionListener cal) {
        deleteProduct.addActionListener(cal);
    }

    /**
     * Aceasta metoda adauga un Listener pentru butonul view all Products de pe interfata pentru produse.
     *
     * @param cal sesizeaza cand se apasa butonul
     */
    public void addViewAllProductsListener(ActionListener cal) {
        viewAllProducts.addActionListener(cal);
    }

    /**
     * Aceasta metoda citeste datele produsului pe care dorim sa-l inseram/stergem/editam
     *
     * @param i ne zice daca citim si id-ul produsului sau nu
     * @return metoda returneaza Produsul citit
     */
    public Product getProduct(int i) {
        Product newProduct = null;
        if (i == 1)
            newProduct = new Product(Integer.parseInt(idPTF.getText()), namePTF.getText(), descriptionTF.getText(), Integer.parseInt(stockTF.getText()));
        if (i == 0)
            newProduct = new Product(namePTF.getText(), descriptionTF.getText(), Integer.parseInt(stockTF.getText()));
        if (i == 2)
            newProduct = newProduct = new Product(Integer.parseInt(idPTF.getText()));
        return newProduct;
    }

    /**
     * Acesta metoda adauga Listener pentru butonul de Make an order de pe interfata initiala
     *
     * @param cal sesizeaza cand se apasa butonul
     */
    public void addOrderListener(ActionListener cal) {
        orders.addActionListener(cal);
    }

    /**
     * Aceasta metoda adauga Listener pentru butonul de send de pe interfata de comenzi
     *
     * @param cal sesizeaza cand se apasa butonul
     */
    public void addSendOrderListener(ActionListener cal) {
        sendTheOrder.addActionListener(cal);
    }

    /**
     * Aceasta metoda adauga Listener pentru butonul de editaare de pe interfata de comenzi
     * @param cal sesizeaza cand se apasa butonul
     */
    public void addEditOrderListener(ActionListener cal) {
        orderEditButton.addActionListener(cal);
    }

    /**
     * Aceasta metoda adauga Listener pentru butonul de stergere de pe interfata de comenzi
     * @param cal sesizeaza cand se apasa butonul
     */
    public void addDeleteOrderListener(ActionListener cal) {
        orderDeleteButton.addActionListener(cal);
    }

    /**
     * Aceasta metoda adauga Listener pentru butonul de vizualizare de pe interfata de comenzi
     * @param cal sesizeaza cand se apasa butonul
     */
    public void addViewAllOrdersListener(ActionListener cal) {
        viewallOrder.addActionListener(cal);
    }


    /**
     * Aceasta metoda adauga Listener pentru butonul Back de pe interfata pentru clienti
     *
     * @param cal sesizeaza cand se apasa butonul
     */
    public void addBackListener1(ActionListener cal) {
        backToMainFrame.addActionListener(cal);
    }

    /**
     * Aceasta metoda adauga Listener pentru butonul Back de pe interfata pentru produse
     *
     * @param cal sesizeaza cand se apasa butonul
     */
    public void addBackListener2(ActionListener cal) {
        backToMainFrame2.addActionListener(cal);
    }

    /**
     * Aceasta metoda adauga Listener pentru butonul Back de pe interfata pentru comenzi
     *
     * @param cal sesizeaza cand se apasa butonul
     */
    public void addBackListener3(ActionListener cal) {
        backToMainFrame3.addActionListener(cal);
    }

    /**
     * Aceasta metoda citeste datele pentru comanda pe care vrem sa o inseram in tabel
     *
     * @return metoda returneaza comanda citita
     */
    public Order getOrder(int i) {
        Order newOrder = null;
        if (i == 0)
            newOrder = new Order(Integer.parseInt(idClientOrderTF.getText()), Integer.parseInt(idPorductOrderTF.getText()), Integer.parseInt(quantityOrderTF.getText()));
        if (i == 1)
            newOrder = new Order(Integer.parseInt(idOrderTf.getText()), Integer.parseInt(idClientOrderTF.getText()), Integer.parseInt(idPorductOrderTF.getText()), Integer.parseInt(quantityOrderTF.getText()));
        if (i == 2)
            newOrder = new Order(Integer.parseInt(idOrderTf2.getText()), 0, 0, 0);
        return newOrder;
    }

    /**
     *  Aceasta metoda  afiseaza pe un frame separat tabelul primit ca si paramtreu. Tabelul poate fi pentru client/ produse sau comenzi
     * @param list este lista de obiecte care este mai apoi transmita la clasa Reflection
     */

    public void showTable(List<Object> list) {

        Reflection ref= new Reflection();
        JTable table= ref.retrieveProperties(list);
        tableFrame.getContentPane().removeAll();
        tableFrame.add(new JScrollPane(table));
        tableFrame.pack();
        tableFrame.setTitle("Table");
        tableFrame.setSize(500, 300);
        tableFrame.setVisible(true);

        }
    }

