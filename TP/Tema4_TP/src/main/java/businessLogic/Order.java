package businessLogic;
import java.util.Random;
import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    public int id;
    public int idOrder;
    public String ClientName;
    public double total;
    public Date orderDate;
    Random rand = new Random();

    public Order(String clientName, Date orderDate)
    {
        this.idOrder=hashCode(id);
        this.ClientName= clientName;
        this.orderDate= orderDate;
    }

    public void setTotal(double total)
    {
        this.total=total;
    }
    public int hashCode(int i)
    {
        return rand.nextInt(10000);
    }
}
