package BusinessLogic;

public interface IDeliveryServiceProcessing {
    boolean invariant();
    /**
     * Aceasta metoda realizeaza adaugarea unui produs in lista ce contine meniul.
     * @pre.condition Datele produsului sa fie pozitive si obiectul sa fie nenul.
     * @post.condition Lista de produse sa nu fie goala dupa inserare.
     * @param item Produsul de adaugat la lista.
     */
    void addItem(MenuItem item);
    /**
     * Aceasta metoda realizeaza adaugarea unui comenzi in lista ce contine comenzile ce sunt procesate.
     * @pre.condition Datele comenzii sa fie pozitive, obiectul sa fie nenul si trebuie sa fie produse in meniu.
     * @post.condition Lista de comenzi procesate sa nu fie goala dupa inserare.
     * @param order Comanda de adagat in lista.
     */
    void addInP(Order order);
    /**
     * Aceasta metoda realizeaza adaugarea unei chitante la lista cu chitante.
     * @pre.condition String-ul sa fie nenul si sa fie produse in meniu.
     * @post.condition Lista de cu chitante sa nu fie goala dupa inserare.
     * @param s Chitanta sub forma de string.
     */
    void addToSFile(String s);
    /**
     * Aceasta metoda realizeaza adaugarea unui comenzi in lista ce contine comenzile in curs de procesare.
     * @pre.condition Datele comenzii sa fie pozitive, obiectul sa fie nenul si sa fie produse in meniu.
     * @param order Comanda de adaugat la lista.
     */
    void addOrder(Order order);
    /**
     * Aceasta metoda realizeaza adaugarea unei persoane in lista ce contine persoanele logate.
     * @pre.condition Datele persoanei logate sa fie nenule si obiectul sa fie nenul.
     * @post.condition Lista de produse logate sa nu fie goala dupa inserare.
     * @param log Obiectul de tip log de adaugat la lista.
     */
    void addLog(Log log);
    /**
     * Aceasta metoda realizeaza adaugarea numelui produselului in lista ce contine produsele comandate.
     * @pre.condition Datele comenzii sa fie pozitive, obiectul sa fie nenul si sa fie produse in meniu.
     * @post.condition Lista de produse comandate sa nu fie goala dupa inserare.
     * @param name Numele produsului de adaugat la lista.
     */
    void addToOrderedList(String name);
    /**
     * Aceasta metoda sterge o comanda din lista de comenzi ce sunt in parcurs de procesare
     * @pre.condition Obiectul trebuie sa fie nenul.
     * @param order Comanda de adaugat la lista.
     */
    void remInH(Order order);
    /**
     * Aceasta metoda returneaza un string cu produsele ce au fost comandate de un nr mai mare de value ori.
     * @pre.condition "value" trebuie sa un numar >=0.
     * @param value Numarul minim.
     * @return stringul cu produsele.
     */
    String getProductOrderedMoreThan(int value);
    /**
     * Aceasta metoda cauta comenziile ce au fost realizate intre 2 ore
     * @pre.condition Orele trebuie sa fie in intervalul [0,23].
     * @param hour1 Ora minima
     * @param hour2 Ora maxima
     * @return un string cu comenziile gasite in acest interval.
     */
    String timeIntervalOfTheOrd(int hour1, int hour2);

    /**
     * Aceasta metoda cauta produsele comandate intr-o anumita zi si le returneaza
     * intr-un string impreuna cu numarul de cate ori o fost comandat
     * @pre.condition "day" trebuie sa fie cuprinsa intre [0,6];
     * @param day Ziua pentru care se face cautarea.
     * @return String-ul cu produsele comandate in ziua respectiva.
     */
    String specifiedDay(int day);
    /**
     *Aceasta metoda cauta clientii care au comandat mai mult de nr ori
     * si a caror valoare a cemzenzii este mai mare decat value.
     * @pre.condition Datele "nr" si "value" trebuie sa fie >=0;
     * @param nr Numarul de comenzi minim.
     * @param value Totalul comenzii minim.
     * @return stringul cu comenzi
     */
    String getClientThatOrderMoreThan(int nr,int value);

}

