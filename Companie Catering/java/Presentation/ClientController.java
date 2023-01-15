package Presentation;
import BusinessLogic.DeliveryService;
import BusinessLogic.MenuItem;
import BusinessLogic.Order;
import Presentation.Observer.Observable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ClientController implements ActionListener {

    private final ClientView view;
    private final Observable observable;
    DeliveryService deliveryService;
    List<MenuItem> order;
    int price=0;
    private static int inc=0;
    int clientID;
    public ClientController(ClientView view){
        this.view=view;
        this.observable=view.observable;
        order=new ArrayList<>();
        inc++;
        clientID=inc;

    }

    public void setCombo(){
        List<MenuItem> list=new ArrayList<>(DeliveryService.getItems());
        for(MenuItem item:list){
            view.setCombo1(item);
            view.setCombo(item);
        }
    }

    public void setDeliveryService(DeliveryService deliveryService){
        this.deliveryService=deliveryService;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        Order newOrder;
        if(source == view.getButtonViewAll()){
            view.getPanelC();
        }else if(source == view.getButtonFilter()){
            view.getPanelD();
        }else if(source == view.getButtonAdd()){
            try {
                MenuItem m = new MenuItem(view.getSelectedItem());
                price += m.getPrice();
                order.add(m);
                deliveryService.addToOrderedList(m.getTitle());
                view.appendTextArea(m +"\n");
            }catch (AssertionError | Exception assertionError){
                view.setOptionPane("Meniul este gol");

            }


        }else if(source == view.getButtonSearch()){
            List<MenuItem> list=new ArrayList<>(DeliveryService.getItems());
            List<MenuItem> list2=new ArrayList<>(DeliveryService.getItems());
            if(!view.getTitleText().getText().equals("") || !view.getRatingText().getText().equals("") || !view.getCaloriesText().getText().equals("")
                    || !view.getProteinText().getText().equals("") || !view.getFatText().getText().equals("") || !view.getSodiumText().getText().equals("")
                    || !view.getPriceText().getText().equals("")){

                List<MenuItem> p;
                List<MenuItem> r;
                List<MenuItem> c;
                List<MenuItem> prot;
                List<MenuItem> f;
                List<MenuItem> s;

                list2= list.stream().filter((MenuItem menuItem) -> menuItem.getTitle().contains(view.getTitleText().getText())).collect(Collectors.toList());

                if(!view.getRatingText().getText().equals("")){
                    r= list.stream().filter((MenuItem menuItem) -> menuItem.getRating()==(Double.parseDouble(view.getRatingText().getText()))).collect(Collectors.toList());
                    list2.retainAll(r);
                }
                if(!view.getCaloriesText().getText().equals("")){
                    c= list.stream().filter((MenuItem menuItem) -> menuItem.getCalories()==(Integer.parseInt(view.getCaloriesText().getText()))).collect(Collectors.toList());
                    list2.retainAll(c);
                }
                if(!view.getProteinText().getText().equals("")){
                    prot= list.stream().filter((MenuItem menuItem) -> menuItem.getProtein()==(Integer.parseInt(view.getProteinText().getText()))).collect(Collectors.toList());
                    list2.retainAll(prot);
                }
                if(!view.getFatText().getText().equals("")){
                    f= list.stream().filter((MenuItem menuItem) -> menuItem.getFat()==(Integer.parseInt(view.getFatText().getText()))).collect(Collectors.toList());
                    list2.retainAll(f);
                }
                if(!view.getSodiumText().getText().equals("")){
                    s=list.stream().filter((MenuItem menuItem) -> menuItem.getSodium()==(Integer.parseInt(view.getSodiumText().getText()))).collect(Collectors.toList());
                    list2.retainAll(s);
                }
                if(!view.getPriceText().getText().equals("")){
                    p=list.stream().filter((MenuItem menuItem) -> menuItem.getPrice()==(Integer.parseInt(view.getPriceText().getText()))).collect(Collectors.toList());
                    list2.retainAll(p);
                }

            }
            view.deleteAll();
            for(MenuItem item:list2){
                view.setCombo(item);
            }
        }else if(source == view.getButtonCreateOrder()){
            if(observable.getSize()>0){

                String s="Chitanta:"+"(clientdID="+clientID +") \n"+view.getTextAreaString()+"\n\nTotal="+price+"\n";


                view.removeTextArea();
                Date date=new Date();
                newOrder=new Order(this.clientID,date,price);
                price=0;

                try{
                    deliveryService.addOrder(newOrder);
                    view.setOptionPane(s);
                    observable.notifyUpdate(newOrder);
                    deliveryService.addToSFile(s);
                }catch (AssertionError assertionError){
                    view.setOptionPane("Meniul este gol");
                }

            }else{
                view.setOptionPane("Nu este nici un angajat conectat, verificati mai tarziu");
            }
        }
    }
}