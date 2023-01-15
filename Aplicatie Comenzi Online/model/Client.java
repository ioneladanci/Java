package model;

/**
 * Aceasta clasa realizeaza prelucrarea clientilor
 *
 * @author Ionela Danci
 */
public class Client {

    public  int clientID;
    public  String clientName;
    public  String clientAddress;

    /**
     * Aceasta este metoda de constructie a unui client.
     *
     * @param clientID Id-ul clientului .
     * @param clientName Numele clientului.
     * @param clientAdress Adresa clientului.
     */

    public Client(int clientID, String clientName, String clientAdress) {

        this.clientID = clientID;
        this.clientName = clientName;
        this.clientAddress = clientAdress;
    }

    /**
     * Aceasta este metoda de constructie fara parametrii a unui client.
     */
    public Client(){

    }

    /**
     * Prin aceasta metoda se obtine id-ul clientului curent.
     * @return Id-ul clientului curent.
     */
    public int getClientID() {

        return clientID;
    }

    /**
     * Prin aceasta metoda se obtine numele clientului curent.
     * @return Numele clientului curent.
     */
    public String getClientName() {
        return clientName;
    }


    /**
     * Prin aceasta metoda se obtine adresa clientului curent.
     * @return Adresa clientului curent.
     */
    public String getClientAdress() {
        return clientAddress;
    }

    /**
     * Aceasta metoda seteaza id-ul clientului curent.
     * @param clientID Id-ul pe care vreti sa-l atribuiti clientului curent.
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    /**
     * Aceasta metoda seteaza numele clientului curent.
     * @param clientName Numele  pe care vreti sa-l atribuiti clientului curent.
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * Aceasta metoda seteaza adresa clientului curent.
     * @param clientAddress Adresa pe care vreti sa o atribuiti clientului curent.
     */
    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    /**
     * Aceasta metoda seteaza adresa clientului curent.
     * @param clientAddress Adresa pe care vreti sa o atribuiti clientului curent.
     */
    public void isClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    /**
     * Prin aceasta metoda se obtine adresa clientului curent.
     * @return Adresa clientului curent.
     */
    public String getClientAddress() {
        return clientAddress;
    }
}
