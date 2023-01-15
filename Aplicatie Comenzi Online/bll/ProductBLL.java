package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

import bll.validators.PriceValidator;
import bll.validators.ProductIdValidator;
import bll.validators.QuantityValidator;
import bll.validators.Validator;
import dao.ProductDAO;
import model.Product;

/**
 * Aceasta clasa realizeaza domeniul de afaceri pentru instructiunile realizate in pachetul DAO pentru tabelul Product.
 *
 * @author Ionela Danci
 */
public class ProductBLL {

    private List<Validator<Product>> validators;
   ProductDAO p= new ProductDAO();

    /**
     * Aceasta metoda realizeaza instantierea atributelor de validare si a clasei
     */
    public ProductBLL() {
        validators = new ArrayList<Validator<Product>>();
        validators.add(new ProductIdValidator());
        validators.add(new QuantityValidator());
        validators.add(new PriceValidator());
    }

    /**
     * Prin aceasta metoda se obtin toate linile din cadrul tabelului Product.
     * @return Un vector care contine toate produsele din tabel.
     */
    public Vector<Product> viewAllP() {
        Vector<Product> st = p.findAll();
        if (st == null) {
            throw new NoSuchElementException("The Product with id =" + " was not found!");
        }
        return st;
    }

    /**
     * Prin aceasta metoda de insereaza un produs in tabelul Product.
     * @param product Produsul pe care doriti sa-l inserati.
     * @return Id-ul produsului inserat.
     */
    public int insertProduct(Product product) {
        for (Validator<Product> v : validators) {
            v.validate(product);
        }
        return p.insert(product);
    }

    /**
     * Prin aceasta metoda se face update la o linie din tabel.
     * @param product Produsul pe care doriti sa il modificati, cu modificarile dorite(Id-ul trebuie sa fie acelasi).
     * @return Id-ul produsului modificat.
     */
    public int updateProduct(Product product) {
        for (Validator<Product> v : validators) {
            v.validate(product);
        }
        return p.update(product);
    }

    /**
     * Prin aceast metoda se sterge un produs din tabelul Product.
     * @param id Id-ul produsului pe care doriti sa-l stergeti.
     * @return Id-ul produsului sters.
     */
    public int deleteProduct(int id) {
        return p.delete(id);
    }


}
