package BusinessLogic;

public class MenuItem {
    private String title;
    private double rating;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private int price;

    public MenuItem() {

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public MenuItem(String title, double rating, int calories, int protein, int fat, int sodium, int price) {
        this.title=title;
        this.rating=rating;
        this.calories=calories;
        this.protein=protein;
        this.fat=fat;
        this.sodium=sodium;
        this.price=price;
    }

    public MenuItem(MenuItem selectedItem) {
        this.title=selectedItem.getTitle();
        this.rating=selectedItem.getRating();
        this.calories=selectedItem.getCalories();
        this.protein=selectedItem.getProtein();
        this.fat=selectedItem.getFat();
        this.sodium=selectedItem.getSodium();
        this.price= selectedItem.getPrice();
    }

    public static MenuItem createMenuItem(String[] data){
        String title=data[0];
        double rating= Double.parseDouble(data[1]);
        int calories= Integer.parseInt(data[2]);
        int protein= Integer.parseInt(data[3]);
        int fat= Integer.parseInt(data[4]);
        int sodium= Integer.parseInt(data[5]);
        int price= Integer.parseInt(data[6]);

        return new MenuItem(title,rating,calories,protein,fat,sodium,price);

    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getFat() {
        return fat;
    }

    public int getSodium() {
        return sodium;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return "Title="+ title+" Rating="+rating+" Calories="+calories+" Protein="+protein+" Fat="+fat+" Sodium="+sodium+" Price="+price+"\n";
    }
    public String toString2(){
        return  title+","+rating+","+calories+","+protein+","+fat+","+sodium+","+price+"\n";
    }



}
