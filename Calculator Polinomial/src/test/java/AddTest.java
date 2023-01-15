import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddTest {
    @Test
    public void addTest(){
        Operatii op=new Operatii();
        Polinom p1=new Polinom();
        Polinom p2=new Polinom();
        p1.addMonom(new Monom(2,1));
        p1.addMonom(new Monom(1,4));
        p1.addMonom(new Monom(0,5));
        p2.addMonom(new Monom(1,1));
        p2.addMonom(new Monom(0,2));
        Polinom p3=op.add(p1,p2);
        Polinom res=new Polinom();
        res.addMonom(new Monom(2,1));
        res.addMonom(new Monom(1,5));
        res.addMonom(new Monom(0,7));

        assertTrue(p3.isEqual(res),"Operatia de adunare functioneaza corect");
    }
}
