import java.util.ArrayList;
import java.util.List;

public class Operatii {
    public Operatii(){

    }

    public Polinom add(Polinom p,Polinom p1){
        Polinom p2=new Polinom();
        boolean[] y=new boolean[p.getList().size()+p1.getList().size()];int i;
        for(Monom m1:p.getList()){
            boolean x;
            x=false;
            i=0;
            for(Monom m2:p1.getList()){
                if(m1.getGrad()==m2.getGrad()){
                    if(m1.getCoef()+m2.getCoef()!=0.0){
                        p2.addMonom(new Monom(m1.getGrad(),m1.getCoef()+m2.getCoef()));
                    }
                    x=true;y[i]=true;
                }
                i++;
            }
            if(!x){
                p2.addMonom(new Monom(m1.getGrad(),m1.getCoef()));
            }
        }
        i=0;
        for(Monom m:p1.getList()){
            if(!y[i++]){
                p2.addMonom(new Monom(m.getGrad(),m.getCoef()));
            }
        }
        p2.sortare();
        //System.out.println(p2.toString());
        return p2;
    }

    public Polinom sub(Polinom p,Polinom p1){
        Polinom p2=new Polinom();
        boolean[] y=new boolean[p.getList().size()+p1.getList().size()];int i;
        for(Monom m1:p.getList()){
            boolean x;
            x=false;
            i=0;
            for(Monom m2:p1.getList()){
                if(m1.getGrad()==m2.getGrad()){
                    if(m1.getCoef()-m2.getCoef()!=0.0){
                        p2.addMonom(new Monom(m1.getGrad(),m1.getCoef()-m2.getCoef()));
                    }
                    x=true;y[i]=true;
                }
                i++;
            }
            if(!x){
                p2.addMonom(new Monom(m1.getGrad(),m1.getCoef()));
            }
        }
        i=0;
        for(Monom m:p1.getList()){
            if(!y[i++]){
                p2.addMonom(new Monom(m.getGrad(),-m.getCoef()));
            }
        }
        p2.sortare();
        //System.out.println("sub"+p2.toString());
        return p2;
    }

    public Polinom prod(Polinom p,Polinom p1){
        Polinom p2=new Polinom();
        for(Monom m1:p.getList()){
            for(Monom m2:p1.getList()){
                if(!p2.existGrad(m1.getGrad()+ m2.getGrad())){
                    p2.addMonom(new Monom(m1.getGrad()+ m2.getGrad(),m1.getCoef()*m2.getCoef()));
                }else {
                    p2.changeMonom(m1.getGrad()+ m2.getGrad(),m1.getCoef()*m2.getCoef());
                }
            }
        }
        p2.sortare();
        //System.out.println(p2.toString());
        return p2;
    }

    public Polinom derivare(Polinom p){
        Polinom p1=new Polinom();
        for(Monom m:p.getList()){
            if(m.getGrad()>=1){
                p1.addMonom(new Monom(m.getGrad()-1,m.getCoef()*m.getGrad()));
            }
        }
        p1.sortare();
        //System.out.println("Derivare: "+p1.toString());
        return p1;
    }

    public Polinom integrare(Polinom p){
        Polinom p1=new Polinom();
        for(Monom m:p.getList()){
            if(m.getGrad()>=0){
                p1.addMonom(new Monom(m.getGrad()+1,m.getCoef()/(m.getGrad()+1)));
            }
        }
        p1.sortare();
        //System.out.println("Integrare: "+p1.toString());
        return p1;
    }

    public List<Polinom> div(Polinom p1, Polinom p2){

        List<Polinom> list=new ArrayList<>();
        Operatii op=new Operatii();
        p1.sortare();
        p2.sortare();
        Monom m;
        Polinom res=new Polinom();
        while(p1.getGradMax()>=p2.getGradMax() && p1.getList().get(0).getGrad()-p2.getList().get(0).getGrad()>=0){
            m=new Monom(p1.getList().get(0).getGrad()-p2.getList().get(0).getGrad(),p1.getList().get(0).getCoef()/p2.getList().get(0).getCoef());
            Polinom q=new Polinom();
            q.addMonom(m);
            res.addMonom(m);
            Polinom p3;
            p3=op.prod(q,p2);
            p1=op.sub(p1,p3);

        }
        list.add(p1);
        list.add(res);
        return list;
    }
}
