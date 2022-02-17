package businessLogic;

import java.io.Serializable;

public class MenuItem implements Serializable {

    public String title;
    public double rating;
    public double calories;
    public double proteins;
    public double fats;
    public double sodium;
    public double price;


    public MenuItem()
    {

    }

    public double computePrice()
    {
        return this.price;
    }
    public void showList()
    {

    }
}
