package businessLogic;
public class BaseProduct extends MenuItem{


    public BaseProduct()
    {

    }

   public BaseProduct(String title, double rating, double calories, double proteins, double fats, double sodium, double price)
   {
       this.title=title;
       this.rating=rating;
       this.calories=calories;
       this.proteins=proteins;
       this.fats=fats;
       this.sodium=sodium;
       this.price=price;
   }

    @Override
    public double computePrice() {
        return this.price;
    }

    @Override
    public void showList() {
        System.out.println(this.title);
    }
}
