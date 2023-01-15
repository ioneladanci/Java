package bll.validators;

import model.Product;

/**
 * Aceasta clasa realizeaza validarea id-ului pentru produsul curent.
 *
 * @author Ionela Danci
 */
public class ProductIdValidator implements Validator<Product> {
    private static final int MIN_ID = 1;

    /**
     * Aceasta metoda realizeaza validarea id-ului pentru produsul curent.
     *
     * @param produs Produsul curent.
     */
    @Override
    public void validate(Product produs) {
        if (produs.getproductID() < MIN_ID ) {
            throw new IllegalArgumentException("The Product Id limit is not respected!");
        }
    }
}
