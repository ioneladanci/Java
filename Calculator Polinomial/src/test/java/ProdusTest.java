import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProdusTest {
    @Test
    public void prodTest(){
        Operatii op=new Operatii();
        Polinom p1=new Polinom();
        Polinom p2=new Polinom();
        p1.addMonom(new Monom(2,1));
        p1.addMonom(new Monom(1,4));
        p1.addMonom(new Monom(0,5));
        p2.addMonom(new Monom(1,1));
        p2.addMonom(new Monom(0,2));
        Polinom p3=op.prod(p1,p2);
        Polinom res=new Polinom();
        res.addMonom(new Monom(3,1));
        res.addMonom(new Monom(2,6));
        res.addMonom(new Monom(1,13));
        res.addMonom(new Monom(0,10));
        assertTrue(p3.isEqual(res),"Operatia de inmultire functioneaza corect");
    }
}
