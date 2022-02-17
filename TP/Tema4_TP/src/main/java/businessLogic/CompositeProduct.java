package businessLogic;

import java.awt.*;
import java.util.*;
import java.util.List;

public class CompositeProduct extends MenuItem{


    public List<MenuItem> list= new ArrayList<MenuItem>();
    public CompositeProduct(){

    }
    public CompositeProduct(String title, double rating)
    {
        this.title=title;
        this.rating=rating;
    }
    @Override
    public double computePrice() {
        double totalPrice=0;
        for( MenuItem menuItem: this.list)
        {
            totalPrice = totalPrice + menuItem.computePrice();
        }
        return totalPrice;
    }
    public void add(MenuItem menuItem)
    {
        list.add(menuItem);
    }
    public void showList()
    {
        for(MenuItem menuItem: list)
        {
            menuItem.showList();
        }
    }
}
