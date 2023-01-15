package Presentation;

import BusinessLogic.CompositeProduct;
import BusinessLogic.DeliveryService;
import BusinessLogic.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdministratorController implements ActionListener, WindowListener {

    private final AdministratorView view;
    private CompositeProduct compositeProduct=new CompositeProduct();
    private DeliveryService deliveryService;
    FileWriter fileMenu;
    FileWriter fileOrders;
    FileWriter fileLogs;
    public AdministratorController(AdministratorView view){
        this.view=view;
        try{
            fileMenu=new FileWriter("menu.txt");
            fileOrders=new FileWriter("orders.txt");
            fileLogs=new FileWriter("logs.txt");
        }catch (Exception ignored){}
    }

    public void setDeliveryService(DeliveryService deliveryService){
        this.deliveryService=deliveryService;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == view.getButtonImport()){
            List<MenuItem> list= DeliveryService.readFromFile("products.csv");
            for(MenuItem m:list){
                view.setCombo(m);
                deliveryService.addItem(m);
            }
        }else if(source == view.getButtonAdd()){
            if(!view.getTitleText().getText().equals("") && !view.getRatingText().getText().equals("") && !view.getCaloriesText().getText().equals("")
             && !view.getProteinText().getText().equals("") && !view.getFatText().getText().equals("") && !view.getSodiumText().getText().equals("")
            && !view.getPriceText().getText().equals("")){

                String title=view.getTitleText().getText();
                double rating=0;
                int calories=0, protein=0, fat=0,sodium=0,price=0;
                try {
                    rating= Double.parseDouble(view.getRatingText().getText());
                }catch (Exception exception){
                    view.setOptionPane("Rating-ul trebuie sa fie de tip real");
                }
                try {
                    calories= Integer.parseInt(view.getCaloriesText().getText());
                    protein=Integer.parseInt(view.getProteinText().getText());
                    fat=Integer.parseInt(view.getFatText().getText());
                    sodium=Integer.parseInt(view.getSodiumText().getText());
                    price=Integer.parseInt(view.getPriceText().getText());
                }catch (Exception exception){
                    view.setOptionPane("Cantiatea de calorii, proteine, fat, sodium si pret trebuie sa fie de tip intreg");
                }

                MenuItem m=new MenuItem(title,rating,calories,protein,fat,sodium,price);

                try{
                    deliveryService.addItem(m);
                    view.setCombo(m);
                }catch (AssertionError assertionError){
                    view.setOptionPane("Datele pentru atributele de tip real trebuie sa fie pozitive");
                }

            }else{
                view.setOptionPane("Pentru a adauga un produs nou trebuie sa introduceti valori in toate casutele text");
            }

        }else if(source == view.getButtonMod()){
            MenuItem menuItem=view.getSelectedItem();
            if(!view.getTitleText().getText().equals("") || !view.getRatingText().getText().equals("") || !view.getCaloriesText().getText().equals("")
                    || !view.getProteinText().getText().equals("") || !view.getFatText().getText().equals("") || !view.getSodiumText().getText().equals("")
                    || !view.getPriceText().getText().equals("")){

                String title=view.getTitleText().getText();
                if(title.equals("")){
                    title=menuItem.getTitle();
                }
                double rating=0;
                int calories=0, protein=0, fat=0,sodium=0,price=0;
                try {
                    if(view.getRatingText().getText().equals("")){
                        rating=menuItem.getRating();
                    }else{
                        rating= Double.parseDouble(view.getRatingText().getText());
                    }
                }catch (Exception exception){
                    view.setOptionPane("Rating-ul trebuie sa fie de tip real");
                }
                try {
                    if(view.getCaloriesText().getText().equals("")){
                        calories=menuItem.getCalories();
                    }else{
                        calories= Integer.parseInt(view.getCaloriesText().getText());
                    }
                    if(view.getProteinText().getText().equals("")){
                        protein=menuItem.getProtein();
                    }else{
                        protein=Integer.parseInt(view.getProteinText().getText());
                    }
                    if(view.getFatText().getText().equals("")){
                        fat=menuItem.getFat();
                    }else{
                        fat=Integer.parseInt(view.getFatText().getText());
                    }
                    if(view.getSodiumText().getText().equals("")){
                        sodium=menuItem.getSodium();
                    }else{
                        sodium=Integer.parseInt(view.getSodiumText().getText());
                    }
                    if(view.getPriceText().getText().equals("")){
                        price=menuItem.getPrice();
                    }else{
                        price=Integer.parseInt(view.getPriceText().getText());
                    }

                }catch (Exception exception){
                    view.setOptionPane("Cantiatea de calorii, proteine, fat, sodium si pret trebuie sa fie de tip intreg");
                }
                deliveryService.deleteItem(menuItem);
                MenuItem m=new MenuItem(title,rating,calories,protein,fat,sodium,price);
                try{
                    deliveryService.addItem(m);
                    view.modifyComboBox(m);
                }catch (AssertionError assertionError){
                    view.setOptionPane("Datele pentru atributele de tip real trebuie sa fie pozitive");
                }

               ///

            }else{
                view.setOptionPane("Pentru a modifica un produs trebuie sa introduceti valori in una dintre casutele text");
            }

        }else if(source == view.getButtonDel()){
            MenuItem menuItem=view.getSelectedItem();
            view.deleteFromComboBox();
            deliveryService.deleteItem(menuItem);
        }else if(source==view.getButtonAddMenu()){
            MenuItem m=view.getSelectedItem();
            compositeProduct.addItem(m);
            view.appendTextArea(m.toString());
        }else if(source==view.getButtonCreate()){
            view.setCombo(compositeProduct);
            deliveryService.addItem(compositeProduct);
            compositeProduct=new CompositeProduct();
            view.setTextArea("");
        }else if(source==view.getButtonGenerateR()){
            view.setGeneratePanel();
        }else if(source==view.getButtonManage()){
            view.setMenagePanel();
        }else if(source==view.getButtonG1()){
            int h1;
            int h2;
            int value1, value2,value3,day;
            try{
                 h1= Integer.parseInt(view.getT1().getText());
                 h2= Integer.parseInt(view.getT2().getText());
                 value1=Integer.parseInt(view.getT3().getText());
                value2=Integer.parseInt(view.getT4().getText());
                value3=Integer.parseInt(view.getT5().getText());
                day=Integer.parseInt(view.getT6().getText());
                view.setArea(deliveryService.timeIntervalOfTheOrd(h1,h2)+deliveryService.getProductOrderedMoreThan(value1) + deliveryService.getClientThatOrderMoreThan(value2,value3)+deliveryService.specifiedDay(day));


            }catch (Exception exception){
                view.setOptionPane("Datele trebuie sa fie intregi");
            }catch (AssertionError assertionError){
                view.setOptionPane("Toate datele trebuie sa fie pozitive\nOrele trebuie sa fie in intervalul [0,23]\nZiua trebuie sa fie in intervalul [0,6]");
            }
                }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        List<MenuItem> list=new ArrayList<>(DeliveryService.getItems());
        for(MenuItem m:list){
            view.setCombo(m);
            deliveryService.addItem(m);
        }

    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            fileMenu.write(deliveryService.toString2());
            fileMenu.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            fileOrders.write(deliveryService.inPString2());
            fileOrders.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            fileLogs.write(deliveryService.logsToString2());
            fileLogs.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try{
            FileWriter f=new FileWriter("bills.txt");
            System.out.println(deliveryService.getsFile());
            f.write(deliveryService.getsFile());
            f.close();
        }catch(Exception ignored){}

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
