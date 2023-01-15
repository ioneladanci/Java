import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubTest {
    @Test
    public void subTest(){
        Operatii op=new Operatii();
        Polinom p1=new Polinom();
        Polinom p2=new Polinom();
        p1.addMonom(new Monom(2,1));
        p1.addMonom(new Monom(1,4));
        p1.addMonom(new Monom(0,5));
        p2.addMonom(new Monom(1,1));
        p2.addMonom(new Monom(0,2));
        Polinom p3=op.sub(p1,p2);
        Polinom res=new Polinom();
        res.addMonom(new Monom(2,1));
        res.addMonom(new Monom(1,3));
        res.addMonom(new Monom(0,3));
        assertTrue(p3.isEqual(res),"Operatia de scadere functioneaza corect");
    }
}
