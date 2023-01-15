package Presentation.Observer;

import BusinessLogic.Order;

public interface Observer {
    void update(Order order);
}
