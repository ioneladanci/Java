package Presentation.Observer;

import BusinessLogic.Order;

public interface Subject
{
    void attach(Observer o);
    //void detach(Observer o);
     void notifyUpdate(Order order);
     int getSize();
}