package model;

/**
 * Aceasta clasa realizeaza prelucrarea comenzilor.
 *
 * @author Ionela Danci
 */
public class Order {
    public  int productID;
    public   int clientID;
    public  int quantity;

    /**
     * Aceasta metoda realizeaza instantierea comenzilor.
     */
    public  Order(){

    }
    /**
     * Aceasta metoda realizeaza instantierea comenzilor.
     * @param productID Id-ul produsului.
     * @param clientID Id-ul clientului.
     * @param quantity Cuantitatea dorita.
     */
    public Order(int productID,int clientID,int quantity){
        this.productID=productID;
        this.clientID=clientID;
        this.quantity=quantity;
    }

    /**
     * Prin aceasta metoda se obtine id-ul produsului pentru comanda curenta.
     * @return Id-ul produsului pentru comanda curenta.
     */
    public int getProductID() {
        return productID;
    }

    /**
     * Prin aceasta metoda se obtine id-ul clientului pentru comanda curenta.
     * @return Id-ul clientului pentru comanda curenta.
     */
    public int getClientID() {
        return clientID;
    }

    /**
     * Prin aceasta metoda se obtine cantitatea dorita pentru comanda curenta.
     * @return Cantitatea dorita pentru comanda curenta.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Aceasta metoda construieste un sir care contine caracteristicile comezii curente.
     * @return Stringul formal din caracteristicile comenzii curente.
     */
    @Override
    public String toString(){
        return "Order: Client id="+this.clientID+"; Product id="+this.productID+"; Quantity="+this.quantity;
    }

    /**
     * Aceasta metoda seteaza id-ul produsului din comanda curenta.
     * @param productID Id-ul pe care doriti sa-l dati comenzii curente.
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * Aceasta metoda seteaza id-ul clientului din comanda curenta.
     * @param clientID Id-ul pe care doriti sa-l dati comenzii curente.
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    /**
     * Aceasta metoda seteaza cantitatea din produs.
     * @param quantity Cantitatea pe care doriti sa o dati comenzii curente.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
