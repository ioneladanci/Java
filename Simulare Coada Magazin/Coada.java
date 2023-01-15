import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Coada implements Runnable{
    private final BlockingQueue<Client> q;
    private final AtomicInteger qTime=new AtomicInteger(0);

    public Coada(){
        q=new LinkedBlockingQueue<>();
        qTime.set(0);
    }

    public void addClient(Client newClient){
        q.add(newClient);
        qTime.set(qTime.intValue()+ newClient.getTimpAsteptare());

    }

    public int getTimpAsteptare(){
        return qTime.intValue();
    }

    @Override
    public String toString(){
        String s="";
        for(Client c:q){
            s+=c.toString()+"      ";
        }
        return s;
    }

    public String toStringFisier(){
        String s="";
        for(Client c:q){
            s+=c.toStringFisier()+";";
        }
        return s;
    }

    public boolean contineClient(Client c){
        for(Client client:q){
            if(client.equals(c)){
                return true;
            }
        }
        return false;
    }

    public int getSize(){
        return q.size();
    }

    @Override
    public void run() {

        int simTime = 0;
        while(simTime< Simulation.maxSim){
            Client c;
            c=q.peek();
            if(c!=null){
                try {
                    Thread.sleep(1000*c.getTimpAsteptare());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                q.remove();
                qTime.set(qTime.intValue()-c.getTimpAsteptare());
            }

        }

    }
}
