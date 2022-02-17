package presentation;
import businessLogic.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import data.*;
public class Controller {

    public View view;
    public AdministratorView administratorView;
    public ClientView clientView;
    public EmployeeView employeeView;
    public DeliveryService deliveryService;
    private List<MenuItem> products= new ArrayList<>();
    public  Serializator serializator;
    Subject subject = new Subject();
    public Controller() {
        deliveryService= new DeliveryService();
        serializator= new Serializator(deliveryService);
        serializator.deserializeUsers();
        serializator.deserializeProducts();
        serializator.deserializeOrders();
        view= new View();
        view.enter(new EnterListener());
        view.newAccount(new AddNewAccount());
        view.addWindowListener(new AddWindowListener());
        clientView= new ClientView();
        clientController();
        administratorView= new AdministratorView();
        adminController();
        employeeView= new EmployeeView(subject);
        employeeView.backListener(new BackListenerEmployee());
    }
    private void clientController() {
        clientView.backListener(new BackListenerClient());
        clientView.setSearchButton(new AddSearchListener());
        clientView.setViewTheMeniu(new ViewMeniuListener());
        clientView.setSeeMyCart(new AddSeeMyCartListener());
        clientView.setAddListener(new AddNewProductToCartListener());
        clientView.setSendThOrder(new SendTheOrder());
        clientView.setReload(new RelodComboBox());
        clientView.setEmptyTheCart(new EmptyCart());
    }
    private void adminController() {
        administratorView.backListener(new BackListenerAdmin());
        administratorView.setImportButton(new ImportProductsListener());
        administratorView.setViewMeniu(new ViewMeniuListener());
        administratorView.addDeleteListener(new DeleteProduct());
        administratorView.setAddButton(new AddProduct());
        administratorView.setEditButton(new EditProduct());
        administratorView.setAddToTheListButton(new AddProductToTheList());
        administratorView.setAddComposedProduct(new AddComposedProduct());
        administratorView.addGenerateListener(new AddGenerateReport());
        administratorView.setAddNewEmployee(new AddNewEmployee());
    }
    class AddWindowListener implements WindowListener {
        @Override
        public void windowOpened(WindowEvent e) { }
        @Override
        public void windowClosing(WindowEvent e) {
            serializator.serializeUsers();
            serializator.serializeProducts();
            serializator.serializeOrders();
        }
        @Override
        public void windowClosed(WindowEvent e) { }
        @Override
        public void windowIconified(WindowEvent e) { }
        @Override
        public void windowDeiconified(WindowEvent e) { }
        @Override
        public void windowActivated(WindowEvent e) { }
        @Override
        public void windowDeactivated(WindowEvent e) { }
    }
    class EnterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           String user=view.getUsername();
           String password= view.getPassword();
           int decideUser= deliveryService.decide(user, password);
           if(decideUser ==0) {
               administratorView.setAdministratorView(view.frame); }
           if(decideUser ==1) {
                   clientView.setClientView(view.frame);
                   clientView.setFoodCombo(deliveryService.products);
               }
           if(decideUser ==2)
                employeeView.setEmployeeView(view.frame);
           if( decideUser == 3)
               JOptionPane.showMessageDialog(new JFrame(),"This account doesn't exists. Please make one");
        }
    }
    class BackListenerAdmin implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.setFirstFrame(administratorView.frame);
            view.usernameTF.setText("");
            view.passwordTF.setText("");
        }
    }
    class BackListenerEmployee implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.setFirstFrame(employeeView.frame);
            view.usernameTF.setText("");
            view.passwordTF.setText("");
        }
    }
    class AddProduct implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(administratorView.getBaseProduct() != null)
               deliveryService.addProduct(administratorView.getBaseProduct());
        }
    }
    class AddProductToTheList implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           deliveryService.addToTheComposedList(administratorView.getSelectedRow());
        }
    }
    class AddComposedProduct implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(!administratorView.titleProductTF.getText().equals(""))
                deliveryService.addComposedProduct(administratorView.titleProductTF.getText());
            else
                JOptionPane.showMessageDialog(new JFrame(), "Please enter the title and press the button again");
        }
    }
    class EditProduct implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           deliveryService.editProduct(administratorView.getSelectedRow(), administratorView.getProductForEditing());
        }
    }
    class DeleteProduct implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            MenuItem product= administratorView.getSelectedRow();
            deliveryService.deleteProduct(product);
        }
    }
    class AddGenerateReport implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(administratorView.checkBox1.isSelected()) {
                int startTime=Integer.parseInt(administratorView.startHourTF.getText());
                int endTime=Integer.parseInt(administratorView.endHourTF.getText());
                deliveryService.generateReport1(startTime, endTime);
            }
            if(administratorView.checkBox2.isSelected()) {
               int nr=Integer.parseInt(administratorView.specifiedNumberTF.getText());
               deliveryService.generateReport2(nr);
            }
            if(administratorView.checkBox3.isSelected()) {
                int nr1=Integer.parseInt(administratorView.specifiedNumber2TF.getText());
                int nr2=Integer.parseInt(administratorView.priceTF.getText());
                deliveryService.generateReport3(nr1,nr2);
            }
            if(administratorView.checkBox4.isSelected()){
                String day= administratorView.dayTF.getText();
                int dayNumber=deliveryService.decideDay(day);
                deliveryService.generateReport4(dayNumber);
            }
        }
    }
    class RelodComboBox implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clientView.setFoodCombo(deliveryService.products);
        }
    }
    class EmptyCart implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            deliveryService.produsePentruComanda.removeAll(deliveryService.produsePentruComanda);
            clientView.menuItems.removeAll(clientView.menuItems);
        }
    }
    class SendTheOrder implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            deliveryService.createNewOrder(view.getUsername());
            clientView.menuItems.removeAll(clientView.menuItems);
            if(!deliveryService.produsePentruComanda.isEmpty())
                 subject.setState(10);
        }
    }
    class BackListenerClient implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.setFirstFrame(clientView.frame);
            view.usernameTF.setText("");
            view.passwordTF.setText("");
        }
    }
    class AddNewProductToCartListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           MenuItem menuItems;
           String title= clientView.getProduct();
           menuItems =deliveryService.products.stream().filter(p->p.title.equals(title)).findFirst().get();
           deliveryService.addToTheCart(menuItems, clientView.getQuantity());
           clientView.showCart(menuItems, clientView.getQuantity());
        }}
    class ImportProductsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           deliveryService.importProducts();
        }
    }
    class ViewMeniuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            administratorView.showMeniu(deliveryService.products);
        }
    }
    class AddNewEmployee implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           String username=administratorView.usernameTF.getText();
           String password= administratorView.passwordTF.getText();
           if(username.equals("") || password.equals(""))
           {
               JOptionPane.showMessageDialog(new JFrame(), "Please enter valid username or password");
               return;
           }
           deliveryService.addNewEmployee(username, password);
        }
    }
    class AddNewAccount implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User newUser= view.getNewUser();
            deliveryService.addUser(newUser);
            JOptionPane.showMessageDialog(new JFrame(),"The account was successfully made");
        }
    }
    class AddSearchListener implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            BaseProduct baseProduct= clientView.getBaseProductForSearch();
            List<MenuItem> searchResult= deliveryService.search(baseProduct);
            if( searchResult != null)
              clientView.setFoodCombo(searchResult);
        }
    }
    class AddSeeMyCartListener implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
           clientView.showCart(null,0);
        }
    }
}
