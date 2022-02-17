package businessLogic;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class DeliveryService implements IDeliveryServiceProcessing {

    public transient List<User> users= new ArrayList<>();
    public transient List<MenuItem> products= new ArrayList<>();
    public transient Map<Order, List<MenuItem>> comenzi= new HashMap<>();
    public List<MenuItem> produsePentruComanda= new ArrayList<>();
    public List<MenuItem> listForTheComposedItems= new ArrayList<>();

    public DeliveryService() { }

    public int decide(String username, String password)
    {
        for(User user: users) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    if (user.getRole().equals(Role.ADMIN))
                        return 0;
                    if (user.getRole().equals(Role.CLIENT))
                        return 1;
                    if (user.getRole().equals(Role.EMPLOYEE))
                        return 2;
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Wrong user or password");
                    return 4;
                } } }
        return 3;
    }
    //pentru metoda wellFormed verific daca lista de produse nu este goala
    public boolean wellFormed(){
        if(products.size() != 0)
            return true;
        else
            return false;
    }
    @Override
    public void importProducts() {

        File tempFile = new File( "D:\\PT2021_30227_Balog_Helga_Assignment_4\\products.csv" );
        assert  tempFile.exists():"The file doesn't exists";
        List<String> list=null;
        try
        { list= Files.lines(Paths.get("D:\\PT2021_30227_Balog_Helga_Assignment_4\\products.csv"))
                .distinct()
                .collect(Collectors.toList());
        }catch(Exception e)
        {
            System.out.println("Error");
        }
        list.remove(0);
        for(String string: list)
        {
            String[] parts=string.split(",");
            BaseProduct baseProduct= new BaseProduct();
            baseProduct.title=parts[0];
            baseProduct.rating=Double.parseDouble(parts[1]);
            baseProduct.calories=Double.parseDouble(parts[2]);
            baseProduct.proteins = Double.parseDouble(parts[3]);
            baseProduct.fats= Double.parseDouble(parts[4]);
            baseProduct.sodium=Double.parseDouble(parts[5]);
            baseProduct.price=Double.parseDouble(parts[6]);
            products.add(baseProduct);
        }
        assert products.size()!=0:"Products.size()!=0 !";
    }
    @Override
    public void addProduct(BaseProduct baseProduct) {
        assert !baseProduct.title.equals(""):"The title can't be an empty string";
        assert baseProduct.rating>0:"The rating must be greater than 0";
        assert baseProduct.calories>0:"The calories must be greater than 0";
        assert baseProduct.proteins>0:"The proteins must be greater than 0";
        assert baseProduct.fats>0:"The fats must be greater than 0";
        assert baseProduct.sodium>0:"The sodium must be greater than 0";
        assert baseProduct.price>0:"The price must be greater than 0";
        products.add(baseProduct);
        JOptionPane.showMessageDialog(new JFrame(), "You have successfully added a new base product");
        assert wellFormed():"The products list is empty";
    }
    @Override
    public void editProduct(MenuItem menuItem, MenuItem menuItem2) {

        MenuItem itemFromTheList = getItemFromTheList(menuItem);
        if (!menuItem2.title.equals(""))
            itemFromTheList.title = menuItem2.title;
        if (menuItem2.rating != -1) {
            assert menuItem2.rating > 0 : "The rating must be greater than 0";
            itemFromTheList.rating = menuItem2.rating;
        }
        if (menuItem2.calories != -1) {
            assert menuItem2.calories > 0 : "The calories must be greater than 0";
            itemFromTheList.calories = menuItem2.calories;
        }
        if (menuItem2.proteins != -1) {
            assert menuItem2.proteins>0:"The proteins must be greater than 0";
            itemFromTheList.proteins = menuItem2.proteins;
          }
         if(menuItem2.fats !=-1) {   assert menuItem2.fats>0:"The fats must be greater than 0";
             itemFromTheList.fats = menuItem2.fats;
         }
         if(menuItem2.sodium != -1) {   assert menuItem2.sodium>0:"The sodium must be greater than 0";
             itemFromTheList.sodium = menuItem2.sodium;
         }
         if(menuItem2.price !=-1) {   assert menuItem2.price>0:"The price must be greater than 0";
             itemFromTheList.price = menuItem2.price;
         }
        assert wellFormed():"The products list is empty";
    }
    @Override
    public void deleteProduct(MenuItem menuItem) {

        MenuItem itemfromTheProducts= getItemFromTheList(menuItem);
        products.remove(itemfromTheProducts);
        assert wellFormed():"The products list is empty";
    }
    @Override
    public void generateReport1(int start,int end) {

        assert start>=0 && start<=23:"The startHour must be greater or equal to 0 and less or equal to 23";
        assert end>=0 && end<=23:"The endHour must be greater or equal to 0 and less or equal to 23";
        Map<Order, List<MenuItem>> orders;

        orders= comenzi.entrySet()
                       .stream()
                       .filter(p->p.getKey().orderDate.getHours()>= start && p.getKey().orderDate.getHours()<=end)
                       .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

       String text="Report 1";
       for(Order order:orders.keySet())
           text=text + order.ClientName +", order id:"+ order.idOrder+" at: "+ order.orderDate+" \n";

       FileWriter file=null;
        try {
            file = new FileWriter("Raport1.txt");
        } catch(Exception e) {
            System.out.println("Probleme cu deschiderea fileWriterului");
        }try {
            file.write(text);
        }catch(Exception e) {
            System.out.println("Probleme cu scrierea in raport2");  }
        try {
            file.close();
        }catch(Exception e)
        {
            System.out.println("Probleme la inchiderea fileWriterului");
        }
        JOptionPane.showMessageDialog(new JFrame(), "The report was generated");
        assert wellFormed():"The products list is empty";
    }
    @Override
    public void generateReport2(int howManyTimes){
        long count=0;
        FileWriter file=null;
        assert howManyTimes>0:"The specified number must be greater than 0";
        String text="Raport de tip 2 \n";
        List<MenuItem> namesToLookAfter=new ArrayList<>();
        for(Order order:comenzi.keySet()){
            for(MenuItem menuItem: comenzi.get(order))
                namesToLookAfter.add(menuItem);}

        List<MenuItem> namesWithoutDuplicates= new ArrayList<>(new HashSet<>(namesToLookAfter));
        for(int k=0; k<namesWithoutDuplicates.size(); k++){
            count=0;
          for(Order order:comenzi.keySet()) {
              int finalK= k;
              count=count+ comenzi.get(order).stream().filter(p->p.equals(namesWithoutDuplicates.get(finalK))).count();
          }
          if(count > howManyTimes)
              text= text + namesWithoutDuplicates.get(k).title+"\n";
        }

        try {
            file = new FileWriter("Raport2.txt");
        } catch(Exception e) {
            System.out.println("Probleme cu deschiderea fileWriterului");
        }try {
            file.write(text);
        }catch(Exception e) {
            System.out.println("Probleme cu scrierea in raport2");  }
        try {
            file.close();
        }catch(Exception e)
        {
            System.out.println("Probleme la inchiderea fileWriterului");
        }
        JOptionPane.showMessageDialog(new JFrame(), "The report was generated");
        assert wellFormed():"The products list is empty";
    }
    @Override
    public void generateReport3(int howManyTimes, int value) {
        String text="Raport 3 \n";
        assert howManyTimes>0:"The specified number must be greater than 0";
        assert value>10:"The specified value must be greater than 10";
        List<String> users= new ArrayList<>();
        for(Order order:comenzi.keySet())
            users.add(order.ClientName);
        FileWriter file=null;
        List<String> usersWithoutDuplicates= new ArrayList<>(new HashSet<>(users));
        for(int k=0; k<usersWithoutDuplicates.size(); k++){
            long count=0;
            int finalK= k;
            count= count+ comenzi.keySet().stream().filter(p->p.ClientName.equals(usersWithoutDuplicates.get(finalK)) && p.total>value).count();

            if(count > howManyTimes)
                text= text + usersWithoutDuplicates.get(k)+"\n";
        }
        try {
            file = new FileWriter("Raport3.txt");
        } catch(Exception e) {
            System.out.println("Probleme cu deschiderea fileWriterului");
        }try {
            file.write(text);
        }catch(Exception e) {
            System.out.println("Probleme cu scrierea in raport2");  }
        try {
            file.close();
        }catch(Exception e)
        {
            System.out.println("Probleme la inchiderea fileWriterului");
        }
        JOptionPane.showMessageDialog(new JFrame(), "The report was generated");
        assert wellFormed():"The products list is empty";

    }
    @Override
    public void generateReport4(int day) {
        long count=0;
        FileWriter file=null;
        String text="Raport de tip 4 \n";
        Map<Order, List<MenuItem>> orders= (Map<Order, List<MenuItem>>) comenzi.entrySet()
                 .stream()
                 .filter(map ->map.getKey().orderDate.getDay()==day)
                 .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

        List<String> namesToLookAfter=new ArrayList<>();
        for(Order order: orders.keySet())
             for(MenuItem menuItem: orders.get(order))
                 namesToLookAfter.add(menuItem.title);

        List<String> namesWithoutDuplicates= new ArrayList<>(new HashSet<>(namesToLookAfter));

        for(int k=0; k<namesWithoutDuplicates.size(); k++){
            count=0;
            for(Order order2:orders.keySet()) {
                int finalK= k;
                count=count+ orders.get(order2).stream().filter(p->p.title.equals(namesWithoutDuplicates.get(finalK))).count();
            }
            text = text + namesWithoutDuplicates.get(k) + " de " + count + " ori" + "\n";
        }
        try {
            file = new FileWriter("Raport4.txt");
        } catch(Exception e) {
            System.out.println("Probleme cu deschiderea fileWriterului");
        }try {
            file.write(text);
        }catch(Exception e) {
            System.out.println("Probleme cu scrierea in raport2");  }
        try {
            file.close();
        }catch(Exception e)
        {
            System.out.println("Probleme la inchiderea fileWriterului");
        }
        JOptionPane.showMessageDialog(new JFrame(), "The report was generated");
        assert wellFormed():"The products list is empty";
    }
    @Override
    public List<MenuItem> search(BaseProduct baseProduct) {

          List<MenuItem> searchResult=products;
          assert searchResult.size()==products.size():"The searchList is not equal to the products list";
          if(! baseProduct.title.equals(""))
             searchResult= searchResult.stream().filter(p->p.title.contains(baseProduct.title)).collect(Collectors.toList());
          if( baseProduct.rating >0)
            searchResult= searchResult.stream().filter(p->p.rating == baseProduct.rating).collect(Collectors.toList());
          if( baseProduct.calories >0)
              searchResult= searchResult.stream().filter(p->p.calories == baseProduct.calories).collect(Collectors.toList());
          if( baseProduct.proteins >0)
            searchResult= searchResult.stream().filter(p->p.proteins == baseProduct.proteins).collect(Collectors.toList());
          if( baseProduct.fats >0)
            searchResult= searchResult.stream().filter(p->p.fats == baseProduct.fats).collect(Collectors.toList());
          if( baseProduct.sodium >0)
            searchResult= searchResult.stream().filter(p->p.sodium == baseProduct.sodium).collect(Collectors.toList());
          if( baseProduct.price >0)
            searchResult= searchResult.stream().filter(p->p.price == baseProduct.price).collect(Collectors.toList());

        assert wellFormed():"The products list is empty";
          if(searchResult.size() ==0) {
              JOptionPane.showMessageDialog(new JFrame(), "We didn't find it in our meniu. We are sorry.");
              return null; }
          else
              return searchResult;
    }
    @Override
    public void createNewOrder(String name) {
        assert !name.equals(""):"The name of the client must be different from empty string";
        if(produsePentruComanda.isEmpty())
        {
            JOptionPane.showMessageDialog(new JFrame(), "Your cart is empty.");
            return;
        }
        Order order= new Order(name, new Date());
        double total=0;
        FileWriter file=null;
        for(MenuItem menuItem: produsePentruComanda)
            total += menuItem.computePrice();
        order.setTotal(total);
        comenzi.put(order, produsePentruComanda);
        try {
            file = new FileWriter("Order.txt");
        }
        catch(Exception e)
        {
            System.out.println("Problems with the fileWriter");
        }
        try {
            file.write(" Factura "+ order.orderDate +"\n Clientul cu numele "+ order.ClientName+" a plasat comanda cu id-ul: " +order.idOrder+". Total:"+ order.total+"$\n");
            for(MenuItem menuItem: produsePentruComanda)
            {
                file.write( menuItem.title+"\n");
            }
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
        assert wellFormed():"The products list is empty";
    }
    public MenuItem getItemFromTheList(MenuItem menuItem) {
        MenuItem itemFromTheList;
        itemFromTheList= products.stream().filter(p->p.rating == menuItem.rating &&
                p.proteins == menuItem.proteins &&
                p.title.equals(menuItem.title) &&
                p.calories == menuItem.calories &&
                p.fats == menuItem.fats &&
                p.sodium == menuItem.sodium &&
                p.price== menuItem.price).findFirst().get();
        return  itemFromTheList;
    }
    public void addUser( User user) {
        users.add(user);
    }
    public void addToTheCart(MenuItem menuItem, int quantity) {
        for(int i=0; i<quantity; i++)
           produsePentruComanda.add(menuItem);
    }
    public void addToTheComposedList(MenuItem menuItem) {
        listForTheComposedItems.add(menuItem);
    }
    @Override
    public void addComposedProduct(String title) {
        MenuItem menuItem= new MenuItem();
        assert !title.equals(""):"The title can't be empty";
        menuItem.title=title;
        menuItem.sodium =menuItem.calories=menuItem.proteins=menuItem.price=menuItem.fats=0;
        for(MenuItem menuItem1:listForTheComposedItems)
        {
            menuItem.calories+=menuItem1.calories;
            menuItem.proteins+=menuItem1.calories;
            menuItem.fats+=menuItem1.fats;
            menuItem.sodium+=menuItem1.sodium;
            menuItem.rating+=menuItem1.rating;
            menuItem.price+= menuItem1.computePrice();
        }

        menuItem.rating/=listForTheComposedItems.size();
        listForTheComposedItems.removeAll(listForTheComposedItems);
        products.add(menuItem);
        assert wellFormed():"The products list is empty";
        JOptionPane.showMessageDialog(new JFrame(), "You have successfully added a new composite product");
    }
    public int decideDay(String day) {
        if(day.equals("Sunday"))
            return 0;
        if(day.equals("Monday"))
            return 1;
        if(day.equals("Tuesday"))
            return 2;
        if(day.equals("Wednesday"))
            return 3;
        if(day.equals("Thursday"))
            return 4;
        if(day.equals("Friday"))
            return 5;
        if(day.equals("Saturday"));
            return 6;
    }
    public void addNewEmployee(String username, String password) {
        User user= new User(username, password, Role.EMPLOYEE);
        users.add(user);
    }

}
