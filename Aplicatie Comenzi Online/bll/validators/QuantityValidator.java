package bll.validators;

import model.Product;

/**
 * Aceasta clasa realizeaza validarea cantitatii pentru produsul curent.
 *
 */
public class QuantityValidator implements Validator<Product> {
    private static final int MIN_Q = 1;

    /** Aceasta clasa realizeaza validarea cantitatii pentru produsul curent.
     *
     * @param product Produsul curent
     */
    @Override
    public void validate(Product product) {
        if (product.getProductQuantity()< MIN_Q ) {
            throw new IllegalArgumentException("The Product quantity limit is not respected!");
        }
    }
}
