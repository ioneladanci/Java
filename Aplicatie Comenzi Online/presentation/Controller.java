package presentation;


import bll.ClientBLL;
import bll.ProductBLL;
import bll.OrderBLL;
import model.Client;
import model.Product;
import model.Order;
import start.Reflection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;


/**
 * Aceasta clasa controleaza evenimentele ce se produc in cadrul interfetei.
 *
 * @author Ionela Danci
 */
public class Controller implements ActionListener, MouseListener {

    private final View view;
    int rowC=-1;
    int rowP=-1;
    int rowCO=-1;
    int rowPO=-1;
    private String fisier = " ";


    /**
     * Aceast metoda initializeaza clasa.
     * @param v Partea vizuala a interfetei.
     */
    public Controller(View v){
        this.view = v;
        setTableOrder();
        setTableCO();
        setTablePO();
        setTableC();
        setTableP();
    }
    ClientBLL clientBLL=new ClientBLL();
    ProductBLL productBLL=new ProductBLL();
    OrderBLL orderBLL=new OrderBLL();
    int i=0;
    int j=0;
    int i2=0;
    int j2=0;
    int j3=0;

    /**
     * Aceast metoda scrie intr-un fisier.
     */
    private void writeInFile(){
        try {
            FileWriter myWriter = new FileWriter("fisier.txt");
            myWriter.write(fisier);
            myWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Aceasta metoda adauga valorile din baza de date din tabelul Client in tabelul ce va afisa clientii in interfata.
     */
    public void setTableC(){
        Vector<Client> obj=clientBLL.viewALlC();
        if(i==0){
            view.addRow1(Reflection.getFirstLine(new Client(0,"1","1")));
            for(Client c:obj){
                view.addRow1(Reflection.retrieveProperties(c));
            }
            i++;
        }
    }

    /**
     * Aceasta metoda adauga valorile din baza de date din tabelul Product in tabelul ce va afisa produsele in interfata.
     */
    public void setTableP(){
        Vector<Product> obj=productBLL.viewAllP();
       if(j==0){
           view.addRow2(Reflection.getFirstLine(new Product(0,0,0,"1")));
           for(Product p:obj){
                view.addRow2(Reflection.retrieveProperties(p));
            }
            j++;
        }
    }

    /**
     * Aceasta metoda adauga valorile din baza de date din tabelul Client in tabelul ce va afisa produsele in interfata in panel-ul in care se fac comezile.
     */
    public void setTableCO(){
        Vector<Client> obj=clientBLL.viewALlC();
        if(i2==0) {

            //view.tableClients.setTableHeader(Reflection.getFirstLine(new Client(0,"1","1")));
            view.addRow1O(Reflection.getFirstLine(new Client(0,"1","1")));
            for (Client c : obj) {
                view.addRow1O(Reflection.retrieveProperties(c));
            }
            i2++;
        }
    }
    /**
     * Aceasta metoda adauga valorile din baza de date din tabelul Product in tabelul ce va afisa produsele in interfata in panel-ul in care se fac comezile.
     */
    public void setTablePO(){
        Vector<Product> obj=productBLL.viewAllP();
        if(j2==0) {
            view.addRow2O(Reflection.getFirstLine(new Product(0,0,0,"1")));
            for (Product p : obj) {
                view.addRow2O(Reflection.retrieveProperties(p));
            }
            j2++ ;
        }

    }

    /**
     * Aceasta metoda adauga valorile din baza de date din tabelul Order in tabelul ce va afisa comenzile in interfata.
     */
    public void setTableOrder(){
        Vector<Order> obj=orderBLL.viewAllO();
        if(j3==0){
            view.addRowOrder(Reflection.getFirstLine(new Order(0,0,0)));

            for(Order o:obj){
                view.addRowOrder(Reflection.retrieveProperties(o));
            }
            j3++;
        }
    }


    /**
     * Aceasta metoda trateaza cazurile in care apar evenimente in cadrul unuia dintre butoanele din interfata.
     * @param e Evenimentul ce s-a produs.
     */
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
         if(source == view.getButton1()){
             view.panelO2.setVisible(false);
             view.setVisible(true);
                view.setPanelClient();
        }else if(source == view.getButton2()){
             view.setVisible(true);
             view.panelO2.setVisible(false);
             view.setPanelProduct();
         }else if(source == view.getButton3()){
             view.setVisible(true);
             view.panelO2.setVisible(false);
             view.setPanelOrder();
         }else if(source == view.getButton4()){
             view.setPanelViewC();
         }else if(source == view.getButton5()){
             view.setPanelInsertC();
         }else if(source == view.getButton6()){
             view.setPanelUpdateC();
         }else if(source == view.getButton7()){
             view.setPanelDeleteC();
         } else if(source == view.getButton8()){
             view.backToMenu1();
         }else if(source == view.getButton9()){
             view.setPanelViewP();
         }else if(source == view.getButton10()){
             view.setPanelInsertP();
         }else if(source == view.getButton11()){
             view.setPanelUpdateP();
         }else if(source == view.getButton12()){
             view.setPanelDeleteP();
         }else if(source == view.getButton13()){
             view.backToMenu2();
         }else if(source == view.getButton14()){
                if(!view.getTextIdC().getText().equals("") && !view.getTextNameC().getText().equals("") ){
                    int id=0;
                    boolean ok=true;
                    try {
                        id=Integer.parseInt(view.getTextIdC().getText());
                    }catch (Exception exception){
                        view.setOptionPane("Id-ul trebuie sa fie de tip intreg");
                        ok=false;
                    }
                    if(ok){
                        String name=view.getTextNameC().getText();
                        String address=view.getTextAddressC().getText();
                        try {
                            int c=clientBLL.insertClient(new Client(id,name,address));
                            if(c>-1){
                                Vector<Object> obj=new Vector<>();
                                obj.add(id);
                                obj.add(name);
                                obj.add(address);
                                view.addRow1(obj);
                                view.addRow1O(obj);
                            }else{
                                view.setOptionPane("Id-ul inserat este deja in tabel. Alegeti un id care sa nu fie atribuit unui client deja existent.");
                            }
                        }catch (Exception exception){
                            view.setOptionPane("Id-ul trebuie sa fie pozitiv");
                        }
                    }

                }else{
                    view.setOptionPane("Id-ul si numele sunt campuri obligatorii de completat.");
                }

         }else if(source == view.getButton15()){
             if(rowC>-1 && (!view.getTextNameUpC().getText().equals("") ||  !view.getTextAddressUpC().getText().equals(""))){
                 String name=view.getTextNameUpC().getText();
                 String address=view.getTextAddressUpC().getText();
                 if(name.equals("")){
                        name=(String)view.getValueAt1(rowC,1);
                 }
                 if(address.equals("")){
                        address=(String)view.getValueAt1(rowC,2);
                 }
                 clientBLL.updateClient(new Client((int)view.tableClients.getValueAt(rowC,0),name,address));
                 view.updateRow1(rowC,name,address);
                 view.updateRow10(rowC,name,address);
                 rowC=-1;
             }else{
                 view.setOptionPane("Este obligatoriu sa selectati linia pe care doriti sa o modificati si sa aveti cel putin o casuta text completata.");
             }

         }else if(source == view.getButton16()){
             System.out.println(rowC);
             if(rowC>-1){
                 clientBLL.deleteClient((int)view.tableClients.getValueAt(rowC,0));
               System.out.println(rowC+"       "+ view.tableClients.getValueAt(rowC,0));
                 view.removeRow1(rowC);
                 view.removeRow10(rowC);
               rowC=-1;
             }else{
                 view.setOptionPane("Este obligatoriu sa selectati linia pe care doriti sa o stergeti");
             }
         }else if(source == view.getButton17()){
             if(!view.getTextIdP().getText().equals("") && !view.getTextQuantityP().getText().equals("")&& !view.getTextPriceP().getText().equals("")&& !view.getTextNameP().getText().equals("")){

                 int id=0;
                 int quantity=0;
                 int price=0;
                 boolean ok=true;
                 try{
                     id=Integer.parseInt(view.getTextIdP().getText());
                     quantity=Integer.parseInt(view.getTextQuantityP().getText());
                     price=Integer.parseInt(view.getTextPriceP().getText());

                 }catch(Exception exception){
                     view.setOptionPane("Id-ul, cantitatea si pretul trebuie sa fie intregi.");
                     ok=false;
                 }
                 if(ok){
                     String name=view.getTextNameP().getText();

                     try {
                         int c=productBLL.insertProduct(new Product(id,quantity,price,name));
                         if(c>-1){
                             Vector<Object> obj=new Vector<>();
                             obj.add(id);
                             obj.add(quantity);
                             obj.add(price);
                             obj.add(name);
                             view.addRow2(obj);
                             view.addRow2O(obj);
                         }else{
                             view.setOptionPane("Id-ul produsului trebuie sa difere de cele existente.");
                         }
                     }catch (Exception exception){
                         view.setOptionPane("Id-ul, cantitatea si pretul trebuie sa fie pozitive.");
                     }

                 }

             }else{
                 view.setOptionPane("Este obligatoriu sa completati toate campurile.");
             }

         }else if(source == view.getButton18()){
             if(rowP>-1 && (!view.getTextQuantityUpP().getText().equals("")|| !view.getTextPriceUpP().getText().equals("")|| !view.getTextNameUpP().getText().equals(""))){
                 int quantity=0;
                 int price=0;
                 boolean ok=true;
                 String q=view.getTextQuantityUpP().getText();
                 String p=view.getTextPriceUpP().getText();
                 String name=view.getTextNameUpP().getText();
                 if(q.equals("")){
                     q= view.getValueAt2(rowP,1).toString();

                 }
                 try {
                     quantity=Integer.parseInt(q);
                 }catch (Exception exception){
                     view.setOptionPane("Cantitatea trebuie sa fie de tip intreg.");
                     ok=false;
                 }
                 if(p.equals("")){
                    p=view.getValueAt2(rowP,2).toString();
                 }
                 try{
                     price=Integer.parseInt(p);
                 }catch (Exception exception){
                     view.setOptionPane("Pretul trebuie sa fie de tip intreg.");
                     ok=false;
                 }
                 if(name.equals("")){
                     name=(String)view.getValueAt2(rowP,3);
                 }
                 if(ok){
                     try{
                         int k=productBLL.updateProduct(new Product((int)view.getValueAt2(rowP,0),quantity,price,name));
                         if(k>-1){
                             view.updateRow2(rowP,quantity,price,name);
                             view.updateRow2O(rowP,quantity,price,name);
                         }
                     }catch (Exception exception){
                         view.setOptionPane("Cantitatea si pretul trebuie sa fie pozitive.");
                     }
                 }
                 rowP=-1;
             }else{
                 view.setOptionPane("Trebuie sa selectati o linie si sa aveti cel putin o casuta completata");
             }

         }else if(source == view.getButton19()){
             if(rowP>-1){
                 productBLL.deleteProduct( (int)view.getValueAt2(rowP,0) );
                 view.removeRow2(rowP);
                 view.removeRow20(rowP);
                 rowP=-1;
             }else{
                 view.setOptionPane("Este obligatoriu sa selectati linia pe care doriti sa o stergeti.");
             }
         }else if(source == view.getButton20()){
            if(rowPO>-1 && rowCO>-1 && !view.getTextQuantityO().getText().equals("")){
                int quantity=0;
                boolean ok=true;
                try {
                    quantity=Integer.parseInt(view.getTextQuantityO().getText());
                }catch (Exception exception){
                    view.setOptionPane("Cantitatea trebuie sa fie de tip intreg.");
                    ok=false;
                }
                int quantity1=quantity;
                if(ok && quantity <= (int)view.getValueAt2O(rowPO,1) && quantity>0){
                    int pretTotal=(int)view.getValueAt2O(rowPO,2)*quantity;
                    Order o=new Order((int)view.getValueAt2O(rowPO,0),(int)view.getValueAt1O(rowCO,0),quantity1);

                    quantity=(int)view.getValueAt2O(rowPO,1)-quantity;
                    if(quantity>0){
                        productBLL.updateProduct(new Product((int)view.getValueAt2O(rowPO,0),quantity,(int)view.getValueAt2O(rowPO,2),(String)view.getValueAt2O(rowPO,3)));
                    }else{
                        productBLL.deleteProduct((int)view.getValueAt2O(rowPO,0));
                    }

                    int i=orderBLL.insertOrder(o);
                    System.out.println(i);
                    if(i>-1){
                        if(quantity>0){
                            view.updateRow2O(rowPO,quantity,(int)view.getValueAt2O(rowPO,2),(String)view.getValueAt2O(rowPO,3));
                            view.updateRow2(rowPO,quantity,(int)view.getValueAt2O(rowPO,2),(String)view.getValueAt2O(rowPO,3));
                        }else{
                            view.removeRow20(rowPO);
                            view.removeRow2(rowPO);
                        }
                        fisier=fisier+o.toString()+"   Pret total= "+pretTotal+"\n";
                        writeInFile();
                        Vector<Object> obj=new Vector<>();
                        obj.add(view.getValueAt2O(rowPO,0));
                        obj.add(view.getValueAt1O(rowCO,0));
                        obj.add(quantity1);
                        view.addRowOrder(obj);
                    }else{
                        view.setOptionPane("ClientID si productID formeaza impreuna cheia primara a tabelului, acesta pereche de id-uri este deja . Alegeti alta pereche de clienti.");
                    }
                    rowPO=-1;
                    rowCO=-1;
                }
                else{
                    view.setOptionPane("Cantitatea dorita poate sa fie minim 0 si maxim cantitatea disponibila din produsul selectat");
                }
            }else{
                view.setOptionPane("Este obligatoriu sa selectati cate o linie din fiecare tabel si sa introduceti o cantitate pozitiva.");
            }
         }

    }

    /**
     * Aceasta metoda trateaza cazurile in care apar evenimente de click in cadrul tabelelor din interfata.
     * @param e Evenimentul ce s-a produs.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if(source==(view.tableClients)){
            rowC= view.tableClients.getSelectedRow();
        }else if(source==(view.tableProducts)){
            rowP= view.tableProducts.getSelectedRow();
        }else if(source==(view.tableClientsO)){
            rowCO= view.tableClientsO.getSelectedRow();
        }else if(source==(view.tableProductsO)){
            rowPO= view.tableProductsO.getSelectedRow();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
