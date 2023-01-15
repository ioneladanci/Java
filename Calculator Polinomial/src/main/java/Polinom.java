import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class Polinom {
    public List<Monom> list;

    public Polinom(){

        list=new LinkedList<>();
    }

    public void addMonom(Monom m){
        list.add(m);
    }

    public List<Monom> getList() {

        return list;
    }

    public void sortare(){
        Collections.sort(this.getList(), (m1, m2) -> -(m1.getGrad()-m2.getGrad()));
    }

    public boolean existGrad(int grad){
        for(Monom m:list){
            if(m.getGrad()==grad){
                return true;
            }
        }
        return false;
    }

    public void changeMonom(int grad,double coef){
        for(Monom m:list){
            if(m.getGrad()==grad){
                m.setCoef(coef+m.getCoef());
            }
        }
    }

    public int getGradMax(){
        int max=0;
        for(Monom m:list){
            if(m.getGrad()>max){
                max=m.getGrad();
            }
        }
        return max;
    }

    public boolean isEqual(Polinom p){
        int size2=p.getList().size();
        int size1=this.getList().size();
        if(size1==size2){
            this.sortare();
            p.sortare();
            for(int i=0;i<size1;i++){
                if(this.getList().get(i).isEqual(p.getList().get(i))){
                    return true;
                }
            }
        }
        return false;
    }

    public String toString(){
        StringBuilder s= new StringBuilder("P(x)=");
        for(Monom i:list) {
            if(s.toString().equals("P(x)=")){
                s.append(i.toString());
            }else{
                s.append(" + ").append(i.toString());
            }
        }
        return s.toString();
    }
}
