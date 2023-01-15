package Presentation;
import BusinessLogic.DeliveryService;
import BusinessLogic.Order;
import Presentation.Observer.Observer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;

public class EmployeeController implements ActionListener,Observer{

    EmployeeView view;
    DeliveryService deliveryService;



    public EmployeeController(EmployeeView view){

        this.view=view;

    }
    public void setDeliveryService(DeliveryService deliveryService){
        this.deliveryService=deliveryService;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source==view.getButton()){
            try {
                view.activateButton(false);
                LinkedHashMap<Integer,Order> hashMap=deliveryService.getHashMap();
                Order order = hashMap.entrySet().stream().findFirst().get().getValue();
                System.out.println("cv"+order.toString());
                try {
                    deliveryService.addInP(order);
                }catch (AssertionError assertionError){
                    view.setOptionPane("Meniul este gol");
                }
                deliveryService.remInH(order);
                for(JFrame frame:Login.listFrame){
                    ((EmployeeView)  frame).controller.procesare(frame == this.view);

                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }
    @Override
    public void update(Order order) {
        view.setOptionPane("Comanda noua: "+order.toString());

        deliveryService.addOrder(order);
        view.appendTextArea(order.toString());
    }

    public void procesare(boolean b) throws InterruptedException {


        view.setTextArea(deliveryService.hashString());
        view.setTextArea2(deliveryService.inPString());
        System.out.println(deliveryService.inPString());
        if(b){
            try {
                Thread.sleep(5000);
            } catch(Exception ignored) { }

        }


        view.setTextArea2(deliveryService.inPString());
        view.setTextArea(deliveryService.hashString());
        view.activateButton(true);

    }

    public Observer getObserver(){
        return this;
    }
}
