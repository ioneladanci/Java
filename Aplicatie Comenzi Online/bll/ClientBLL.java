package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

import bll.validators.ClientIdValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import model.Client;

/**
 * Aceasta clasa realizeaza domeniul de afaceri pentru instructiunile realizate in pachetul DAO pentru tabelul Client.
 *
 * @author Ionela Danci
 */
public class ClientBLL {

    private final List<Validator<Client>> validators;
    ClientDAO cl=new ClientDAO();

    /**
     * Aceasta metoda realizeaza instantierea atributelor de validare si a clasei
     */
    public ClientBLL() {
        validators = new ArrayList<>();
        validators.add(new ClientIdValidator());

    }

    /**
     * Prin aceasta metoda se obtin toate linile din cadrul tabelului Client.
     * @return Un vector care contine toti clientii din tabel.
     */
    public Vector<Client> viewALlC() {
        Vector<Client> st =  cl.findAll();
        if (st == null) {
            throw new NoSuchElementException("The client"  + " was not found!");
        }
        return st;
    }

    /**
     * Prin aceasta metoda de insereaza un client in tabelul Client.
     * @param client Clientul pe care doriti sa-l inserati.
     * @return Id-ul clientului inserat.
     */
    public int insertClient(Client client) {
        for (Validator<Client> v : validators) {
            v.validate(client);
        }
        return cl.insert(client);
    }

    /**
     * Prin aceasta metoda se face update la o linie din tabel.
     * @param client Clientul pe care doriti sa il modificati, cu modificarile dorite(Id-ul trebuie sa fie acelasi).
     * @return Id-ul clientului modificat.
     */
    public int updateClient(Client client) {
        for (Validator<Client> v : validators) {
            v.validate(client);
        }
        int update = cl.update(client);
        return update;
    }

    /**
     * Prin aceast metoda se sterge un client din tabelul Client.
     * @param id Id-ul clientului pe care doriti sa-l stergeti.
     * @return Id-ul clientului sters.
     */
    public int deleteClient(int id) {

        int delete;
        delete = cl.delete(id);
        return delete;
    }
}

