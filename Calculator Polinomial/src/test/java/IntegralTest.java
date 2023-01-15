import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegralTest {
    @Test
    public void integralTest(){
        Operatii op=new Operatii();
        Polinom p1=new Polinom();
        p1.addMonom(new Monom(2,3));
        p1.addMonom(new Monom(1,4));
        p1.addMonom(new Monom(0,5));

        Polinom p3=op.integrare(p1);
        Polinom res=new Polinom();
        res.addMonom(new Monom(3,1));
        res.addMonom(new Monom(2,2));
        res.addMonom(new Monom(1,5));


        assertTrue(p3.isEqual(res),"Operatia de integrare functioneaza corect");

    }
}
