package start;

import java.lang.reflect.Field;
import java.util.Vector;


/**
 * Aceasta clasa este folosita pentru a obtine atat valorile,cat si denumirea atributelor din tabele.
 *
 * @author Ionela Danci
 */
public class Reflection {

    /**
     * Aceasta metoda creeaza un sir cu numele atributelor din tabel.
     * @param object Clasa care corespunde unui tabel.
     * @return Un vector cu sirul de nume ale atributelor din tabel.
     */
    public static Vector<Object> getFirstLine(Object object) {
        Vector<Object> s=new Vector<>();
        for(int i=0;i<object.getClass().getDeclaredFields().length;i++){
            Field field=object.getClass().getDeclaredFields()[i];
            field.setAccessible(true);
            try {
                s.add(field.getName());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return s;
    }

    /**
     * Aceasta metoda creeaza un sir cu valorile atributelor din tabel la o anumita linie.
     * @param object Clasa care corespunde unui tabel.
     * @return Un vector cu sirul de valori ale atributelor din tabel din cadrul unui linii.
     */
    public static Vector<Object> retrieveProperties(Object object) {
        Vector<Object> s=new Vector<>();
        for (Field field : object.getClass().getDeclaredFields()) {

            field.setAccessible(true); // set modifier to public
            Object value;
            
            try {
                value = field.get(object);
                s.add(value);

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return s;

    }
}
