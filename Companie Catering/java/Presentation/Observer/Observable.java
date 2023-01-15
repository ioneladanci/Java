package Presentation.Observer;

import BusinessLogic.Order;

import java.util.ArrayList;
import java.util.List;

public class Observable implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }


    @Override
    public void notifyUpdate(Order order) {
        for(Observer o: observers) {
            o.update(order);
        }
    }
    public int getSize(){
        return observers.size();
    }



}