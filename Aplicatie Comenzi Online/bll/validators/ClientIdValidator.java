package bll.validators;

import model.Client;

/**
 * Aceasta clasa realizeaza validarea id-ului pentru clienti.
 *
 * @author Ionela Danci
 */
public class ClientIdValidator implements Validator<Client> {
    private static final int MIN_ID = 1;

    /**
     * Prin aceasta metoda se realizeaza validarea id-ului pentru client.
     * @param client Clientul curent.
     */
    @Override
    public void validate(Client client) {
        if (client.getClientID() < MIN_ID ) {
            throw new IllegalArgumentException("The Client Id limit is not respected!");
        }
    }
}
