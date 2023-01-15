package BusinessLogic;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem {
    List<MenuItem> list;


    public CompositeProduct(){
        super.setTitle("");
        list=new ArrayList<>();
    }

    public void addItem(MenuItem item){
        list.add(item);
        super.setTitle(super.getTitle()+item.getTitle()+";");
        super.setRating(super.getRating()+item.getRating());
        super.setCalories(super.getCalories()+item.getCalories());
        super.setFat(super.getFat()+ item.getFat());
        super.setProtein(super.getProtein()+ item.getProtein());
        super.setSodium(super.getSodium()+item.getSodium());
        super.setPrice(super.getPrice()+item.getPrice());
    }


    public void clear(){
        list.clear();
    }

    @Override
    public String toString(){
        String s="Titles: ";
        double rating=0;int calories=0; int protein=0;int fat=0;int sodium=0;int price=0;
        for(MenuItem l:list){
            s+=l.getTitle()+", ";
            rating+=l.getRating();
            calories+=l.getCalories();
            protein+=l.getProtein();
            fat+=l.getFat();
            sodium+=l.getSodium();
            price+=l.getPrice();
        }
        s=s+" Rating="+rating+" Calories="+calories+" Protein="+protein+" Fat="+fat+" Sodium="+sodium+" Price="+price+"\n";
        return s;
    }

}
