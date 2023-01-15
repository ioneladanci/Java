package BusinessLogic;
import java.util.Date;

public class Order {
    private int orderID;
    private int clientID;
    private Date orderData;
    private  static int id=0;
    private int value;

    public int getValue() {
        return value;
    }

    public Order(){

    }

    public Order(int clientID,Date orderData,int value){
        id++;
        this.orderID=id;
        this.clientID=clientID;
        this.orderData=orderData;
        this.value=value;
    }

    public int getClientID() {
        return clientID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int hashCode(){
        return 11*clientID+12*orderID+orderData.hashCode();
    }

    public void setOrderData(Date orderData) {
        this.orderData = orderData;
    }

    @Override
    public String toString(){
        return "OrderId="+orderID+" ClientID="+clientID+"Date:"+orderData+"\n";
    }
    public String toString2(){
        return orderID+","+clientID+","+orderData+"\n";
    }

    public Date getOrderData() {
        return orderData;
    }




}
