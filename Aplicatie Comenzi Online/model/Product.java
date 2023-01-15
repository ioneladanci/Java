package model;

/**
 * Aceasta clasa realizeaza prelucrarea produselor
 *
 * @author Ionela Danci
 */
public class Product {

    public  int productID;
    public  int productQuantity;
    public  int productPrice;
    public  String productName;

    /**
     * Aceasta metoda realizeaza instantierea produsului.
        */
     public Product(){

    }
    /**
     * Aceasta metoda realizeaza instantierea produsului.
     * @param productID Id-ul produsului.
     * @param productQuantity Cuantitatea produsului.
     * @param productPrice Pretul produsului.
     * @param productName Numele produsului
     */
    public Product(int productID, int productQuantity, int productPrice, String productName)
    {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    /**
     * Prin aceasta metoda se obtine id-ul produsului curent.
     * @return Id-ul produsului curent.
     */
    public int getproductID() {
        return productID;
    }
    /**
     * Prin aceasta metoda se obtine numele produsului curent.
     * @return Numele produsului curent.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Prin aceasta metoda se obtine pretul produsului curent.
     * @return Pretul produsului curent.
     */
    public int getProductPrice() {
        return productPrice;
    }

    /**
     * Prin aceasta metoda se obtine cantitatea produsului curent.
     * @return Cantitatea produsului curent.
     */
    public int getProductQuantity() {
        return productQuantity;
    }

    /**
     * Prin aceasta metoda se obtine id-ul produsului curent.
     * @return Id-ul produsului client.
     */
    public int getProductID() {
        return productID;
    }

    /**
     * Aceasta metoda seteaza id-ul produsului curent.
     * @param productID Id-ul pe care doriti sa-l atribuiti produsului.
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * Aceasta metoda seteaza cantitatea produsului curent.
     * @param productQuantity Cuantitatea pe care doriti sa o atribuiti clientului curent.
     */
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    /**
     * Aceasta metoda seteaza pretul pentru produsul curent.
     * @param productPrice Pretul pe care doriti sa-l atribuiti produsului curent.
     */
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * Aceasta metoda seteaza numele pentru produsul curent.
     * @param productName Numele pe care doriti sa-l atribuiti produsului curent.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }
}