import java.util.List;

public class ConcreteStrategyTime {

    public void addTask(List<Coada> cozi, Client c)
    {
        int minTime=100;
        //Auto-generated method stub
        for(Coada coada:cozi){
            if (coada.getTimpAsteptare()<minTime){
                minTime= coada.getTimpAsteptare();
            }
        }
        for(Coada coada:cozi){
            if (coada.getTimpAsteptare()==minTime){
               coada.addClient(c);
               break;
            }
        }
    }
}
