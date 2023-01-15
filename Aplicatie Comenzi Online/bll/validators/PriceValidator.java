package bll.validators;

import model.Product;

/**
 * Aceasta clasa realizeaza validarea pretului pentru produsul curent.
 */
public class PriceValidator implements Validator<Product> {
    private static final int MIN_P = 1;

    /**
     * Aceasta metoda realizeaza validarea pretului pentru produsul curent.
     * @param produs Produsul curent.
     */
    @Override
    public void validate(Product produs) {
        if (produs.getProductPrice() < MIN_P ) {
            throw new IllegalArgumentException("The Product Price limit is not respected!");
        }
    }
}
