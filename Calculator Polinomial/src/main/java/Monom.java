import org.apache.commons.math3.util.Precision;

public class Monom {
    private final int grad;
    private double coef;

    public Monom(int grad,double coef){
        this.grad=grad;
        this.coef= Precision.round(coef,2);
    }

    public int getGrad(){
        return grad;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public double getCoef(){
        return coef;
    }

    public String toString(){
        if(this.grad==1){
            return this.coef+"X";
        }else if(this.grad==0){
            return this.coef+"";
        }else {
            return this.coef+"X^"+this.grad;
        }
    }

    public boolean isEqual(Monom m){
        return this.coef==m.coef && this.grad==m.grad;
    }
}
