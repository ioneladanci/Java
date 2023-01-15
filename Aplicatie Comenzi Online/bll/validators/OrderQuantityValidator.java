package bll.validators;

import model.Order;

/**
 * Aceasta clasa realizeaza validarea cantitatii pentru comanda curenta.
 *
 * @author Ionela Danci
 */
public class OrderQuantityValidator implements Validator<Order> {
    private static final int MIN_Q = 1;

    /**
     * Aceasta metoda realizeaza validarea cantitatii prodului din cadrul comenzii curente.
     * @param order Comanda curent
     */
    @Override
    public void validate(Order order) {
        if (order.getQuantity() < MIN_Q ) {
            throw new IllegalArgumentException("The order quantity limit is not respected!");
        }
    }
}
