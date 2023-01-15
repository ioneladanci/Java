package BusinessLogic;

public class BaseProduct extends MenuItem {

    public BaseProduct(){
        super();
    }
    public double computePrice(){
        return this.getPrice();
    }

}
