package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

import bll.validators.OrderQuantityValidator;
import bll.validators.Validator;
import dao.OrderDAO;
import model.Order;

/**
 * Aceasta clasa realizeaza domeniul de afaceri pentru instructiunile realizate in pachetul DAO pentru tabelul Order.
 *
 * @author Ionela Danci
 */
public class OrderBLL {

    private final List<Validator<Order>> validators;

    /**
     * Aceasta metoda realizeaza instantierea atributelor de validare si a clasei
     */
    public OrderBLL() {
        validators = new ArrayList<>();
        validators.add(new OrderQuantityValidator());
    }

    /**
     * Prin aceasta metoda se obtin toate linile din cadrul tabelului Order.
     * @return Un vector care contine toate comenzile din tabel.
     */
    public Vector<Order> viewAllO() {
        OrderDAO o=new OrderDAO();
        Vector<Order> st = o.findAll();
        if (st == null) {
            throw new NoSuchElementException("The order"  + " was not found!");
        }
        return st;
    }

    /**
     * Prin aceasta metoda de insereaza o comanda in tabelul Order.
     * @param order Comanda pe care doriti sa o inserati.
     * @return Id-ul clientului care a facut comanda inserata.
     */
    public int insertOrder(Order order) {
        OrderDAO o=new OrderDAO();
        for (Validator<Order> v : validators) {
            v.validate(order);
        }
        return o.insert(order);
    }

}

