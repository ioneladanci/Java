import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DerivativeTest {
    @Test
    public void derivTest(){
        Operatii op=new Operatii();
        Polinom p1=new Polinom();
        p1.addMonom(new Monom(2,1));
        p1.addMonom(new Monom(1,4));
        p1.addMonom(new Monom(0,5));

        Polinom p3=op.derivare(p1);
        Polinom res=new Polinom();

        res.addMonom(new Monom(1,2));
        res.addMonom(new Monom(0,4));

        assertTrue(p3.isEqual(res),"Operatia de derivare functioneaza corect");

    }
}
