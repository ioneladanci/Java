package Presentation.Observer;

import BusinessLogic.Order;

public class ConcreteObserver implements Observer {
    @Override
    public void update(Order order) {
        System.out.println("MessageSubscriberOne :: " + order.toString());
    }
}

