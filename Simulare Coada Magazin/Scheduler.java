import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private final List<Coada> cozi;
    private final ConcreteStrategyTime strategy;

    public Scheduler(int maxNoServers){
        strategy=new ConcreteStrategyTime();
        cozi=new ArrayList<>();
        for(int i=0;i<maxNoServers;i++){
            //creare obiecte server
            Coada coada=new Coada();
            cozi.add(coada);
            //creare Thread cu obiectul
            Thread t=new Thread(coada);
            t.start();
        }
    }

    public int getNrClienti(){
        int nrClienti=0;
        for(Coada c:cozi){
            nrClienti+=c.getSize();
        }
        return nrClienti;
    }


    public void addClient(Client t){

        strategy.addTask(cozi,t);
    }

    public List<Coada> getServers(){
        return cozi;
    }


}
