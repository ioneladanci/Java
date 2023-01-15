package BusinessLogic;

public class OrderedProducts {
    private int day;
    private int number;
    private String name;

    public OrderedProducts(int day, int number,String name){
        this.day=day;
        this.number=number;
        this.name=name;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){return name;}

    public int getNumber() {
        return number;
    }


}
