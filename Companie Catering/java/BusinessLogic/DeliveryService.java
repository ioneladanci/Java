package BusinessLogic;

import Presentation.Observer.Observable;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing {
    static List<MenuItem> list;
    LinkedHashMap<Integer, Order> hashMap;
    LinkedHashMap<Integer, Order> ordInP;
    List<Log> logList;
    List<String> sFile;
    List<OrderedProducts> orders;

    public boolean invariant(){
        return list.size() != 0;
    }

    public DeliveryService(){
        list=new ArrayList<>();
        hashMap=new LinkedHashMap<>();
        logList=new ArrayList<>();
        ordInP=new LinkedHashMap<>();
        sFile=new ArrayList<>();
        orders=new ArrayList<>();
    }

    public void setDeliveryService(List<MenuItem> list, List<Log> logList){
        DeliveryService.list =list;
        this.logList=logList;
    }

    public void addItem(MenuItem item){
        assert item!=null;
        assert item.getFat()>=0 && item.getPrice()>0 && item.getCalories()>0 && item.getProtein()>=0 && item.getRating()>=0 && item.getSodium()>=0 ;
        boolean contine=false;
        for(MenuItem i:list){
            if (i.getTitle().equals(item.getTitle()) && i.getPrice() == item.getPrice() && i.getSodium() == item.getSodium() && i.getCalories() == item.getCalories() && i.getRating() == item.getRating() && i.getProtein() == item.getProtein() && i.getFat() == item.getFat()) {
                contine = true;
                break;
            }
        }
        if(!contine){
            list.add(item);
        }
        assert !list.isEmpty();
    }

    public void deleteItem(MenuItem item){
        list.removeIf((MenuItem m)-> m.getTitle().equals(item.getTitle()) && m.getProtein()== item.getProtein() && m.getRating()== item.getRating() && m.getCalories()==item.getCalories() && m.getFat()==item.getFat() && m.getSodium()==item.getSodium() ) ;
    }

    public void addLog(Log log){
        assert log!=null;
        assert !log.getUsername().equals("") && !log.getPassword().equals("") && !log.getType().equals("");
        boolean contine=false;
        for(Log l:logList){
            if(l.getUsername().equals(log.getUsername()) && l.getPassword().equals(log.getPassword()) && l.getType().equals(log.getType())){
                contine=true;
                break;
            }
        }
        if(!contine){
            logList.add(log);
        }
        assert !logList.isEmpty();
    }

    public void addInP(Order order){
        assert order!=null && invariant();
        assert order.getOrderID()>0 && order.getClientID()>=0;
        ordInP.put(order.hashCode(),order);
        assert ! ordInP.isEmpty();
    }

    public void addToSFile(String s){
        assert !s.equals("");
        assert invariant();
        sFile.add(s);
        assert !sFile.isEmpty();
    }

    public void addToOrderedList(String name){
        assert !name.equals("");
        assert invariant();
        Date d=new Date();
        int day=d.getDay();
        boolean este=false;
        for(OrderedProducts o:orders){
            if(o.getName().equals(name)){
                o.setNumber(o.getNumber()+1);
                este=true;
            }
        }
        if(orders.size()==0 || !este){
            OrderedProducts ord=new OrderedProducts(day,1,name);
            orders.add(ord);
        }
        assert !orders.isEmpty();
    }

    public void addOrder(Order order){
        assert order.getOrderID()>0 && order.getClientID()>=0;
        assert invariant();
        hashMap.put( order.hashCode(),order);
    }

    public void remInH(Order order){
        assert order!=null;
        hashMap.remove(order.hashCode());
    }

    public String getProductOrderedMoreThan(int value){
        assert value>=0 ;
        StringBuilder s= new StringBuilder("\nthe products ordered more than a specified number of times so far.\n");
        List<OrderedProducts> l=new ArrayList<>(orders);
        List<OrderedProducts> resOrd;
        resOrd= l.stream().filter((OrderedProducts order) -> order.getNumber()>=value).collect(Collectors.toList());
        for(OrderedProducts o:resOrd){
                s.append(o.getName()).append("\n");
        }
        return s.toString();
    }

    public String getClientThatOrderMoreThan(int nr,int value){
       assert nr>=0 && value>=0;
        StringBuilder s= new StringBuilder("\n\nThe clients that have ordered more than a specified number of times so far and the\nvalue of the order was higher than a specified amount.\n");
        List<Order> ord=new ArrayList<>(ordInP.values());
        List<Order> resOrd;
        List<Order> resOrd2=new ArrayList<>();
        resOrd= ord.stream().filter((Order order) -> order.getValue()>=value).collect(Collectors.toList());
        for(Order o:resOrd){
            long count=resOrd.stream().filter(c -> c.getClientID()==o.getClientID()).count();
            if(count > nr) {
                boolean contine = false;
                for (Order l : resOrd2) {
                    if (l.getClientID() == o.getClientID()) {
                        contine = true;
                        break;
                    }
                }
                if (!contine) {
                    resOrd2.add(o);
                }
            }
        }
        for(Order o:resOrd2){
            s.append("\nClientID=").append(o.getClientID());
        }
        return s.toString();
    }

    public String specifiedDay(int day){
        assert day>=0 && day<=6;
        StringBuilder s= new StringBuilder("\n\nThe products ordered within a specified day with the number of times they have\nbeen ordered.\n");
        List<OrderedProducts> resOrd;
        resOrd= orders.stream().filter((OrderedProducts order) -> order.getDay()==day).collect(Collectors.toList());
        for(OrderedProducts o:resOrd){
                s.append(o.getName()).append(" -->  ").append(o.getNumber()).append("\n");
        }
        return s.toString();
    }

    public String timeIntervalOfTheOrd(int hour1, int hour2){
        assert hour1<=23 && hour2<=23 && hour1>=0 && hour2>=0;
        StringBuilder s= new StringBuilder("\n\nTime interval of the orders\n");
        List<Order> ord=new ArrayList<>(ordInP.values());
        List<Order> resOrd;
        resOrd= ord.stream().filter((Order order) -> order.getOrderData().getHours()>=hour1 && order.getOrderData().getHours()<=hour2).collect(Collectors.toList());
        for(Order o:resOrd){
                s.append(o.toString());
        }
        return s.toString();
    }

    public String getsFile( ){
        StringBuilder s= new StringBuilder();
        for(String string:sFile){
            s.append(string);
        }
        return s.toString();
    }
    public List<Log> getLogs(){return logList;}
    public static List<MenuItem> getItems(){return list;}
    public List<MenuItem> getList() {return list;}
    public LinkedHashMap<Integer, Order> getHashMap() {return hashMap;}

    @Override
    public String toString(){
        StringBuilder s= new StringBuilder();
        for(MenuItem item:list){
            s.append(item.toString());
        }
        return s.toString();
    }
    public String toString2(){
        StringBuilder s= new StringBuilder();
        for(MenuItem item:list){
            s.append(item.toString2());
        }
        return s.toString();
    }
    public String hashString(){
        StringBuilder s= new StringBuilder();
        for(Order o:hashMap.values()){
            s.append(o.toString());
        }
        return s.toString();
    }
    public String inPString(){
        StringBuilder s= new StringBuilder();
        for(Order o:ordInP.values()){
            s.append(o.toString());
        }
        return s.toString();

    }
    public String inPString2(){
        StringBuilder s= new StringBuilder();
        for(Order o:ordInP.values()){
            s.append(o.toString2());
        }
        return s.toString();

    }
    public String logsToString2(){
        StringBuilder s= new StringBuilder();
        for(Log o:logList){
            s.append(o.toString2());
        }
        return s.toString();
    }

    /**
     * Aceasta metoda citeste din fiserul primit ca parametru elemente de tip MenuItem.
     * @param fileName Numele fisierului.
     * @return Elementele din fiser sub forma de lista.
     */
    public static List<BusinessLogic.MenuItem> readFromFile(String fileName) {
        List<BusinessLogic.MenuItem> list = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(Paths.get(String.valueOf(pathToFile)), StandardCharsets.ISO_8859_1)) {
            String line = br.readLine();
            line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                BusinessLogic.MenuItem menuItem = MenuItem.createMenuItem(attributes);
                list.add(menuItem);

                line = br.readLine();
            }
        } catch (IOException e) {e.printStackTrace();}
        return list;
    }

    /**
     * Aceasta metoda citeste din fiserul primit ca parametru elemente de tip Log.
     * @param fileName Numele fisierului.
     * @return Elementele din fiser sub forma de lista.
     */
    public static List<Log> readLogs(String fileName) {
        List<Log> list = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(Paths.get(String.valueOf(pathToFile)), StandardCharsets.ISO_8859_1)) {
            String line = br.readLine();
            line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Log log=Log.createLog(attributes);
                list.add(log);

                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getPSize(){return ordInP.size();}

    public void setList(List<MenuItem> list) {
        DeliveryService.list = list;}
}
