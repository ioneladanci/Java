import org.junit.jupiter.api.Test;

//import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DivisionTest {
    @Test
    public void divTest(){
        Operatii op=new Operatii();
        Polinom p1=new Polinom();
        Polinom p2=new Polinom();
        p1.addMonom(new Monom(2,1));
        p1.addMonom(new Monom(1,4));
        p1.addMonom(new Monom(0,5));
        p2.addMonom(new Monom(1,1));
        p2.addMonom(new Monom(0,2));
        List<Polinom> list=op.div(p1,p2);
        Polinom resR=new Polinom();
        Polinom resC=new Polinom();
        Polinom rest=list.get(0);
        Polinom cat=list.get(1);

        resC.addMonom(new Monom(1,1));
        resC.addMonom(new Monom(0,2));
        resR.addMonom(new Monom(0,1));

        assertTrue(cat.isEqual(resC),"Catul este corect");
        assertTrue(rest.isEqual(resR),"Restul este corect");
    }
}
