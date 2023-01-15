package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Client;

/**
 * Aceasta clasa implementeaza metodele de interogare din baza de date.
 * @param <T> Tipul clasei ce corespunde unui tabel din baza de date.
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    /**
     * Aceasta moetoda instantiaza tipul clasei cu care se lucreaza.
     */
    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Aceasta metoda formeaza sirul pentru interogarea de selectare a tuturor linilor din tabelul echivalent clasei cu care se lucreaza.
     * @return Sirul ce contine interogarea de selectare a tuturor linilor tabelului.
     */
    private  String createViewAllQuery() {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM schooldb.");
        sb.append(type.getSimpleName());
        return sb.toString();
    }

    /**
     * Aceasta metoda formeaza sirul pentru interogarea de inserare a unei linii in tabelul echivalent clasei cu care se lucreaza.
     * @return Sirul ce contine interogarea de inserare a unei linii in tabel.
     */
    public String createInsertQuery(int fieldSize){
        StringBuilder sb = new StringBuilder();
        sb.append("Insert ");
        sb.append(" INTO schooldb.");
        sb.append(type.getSimpleName());
        sb.append(" VALUES (");
        for(int i=0;i< fieldSize;i++){
            sb.append( " ? ");
            if(i!=fieldSize-1){
                sb.append( ",");
            }
        }
        sb.append( ")");
        return sb.toString();
    }

    /**
     * Aceasta metoda formeaza sirul pentru interogarea de selectare a update a unei linii din tabelul echivalent clasei cu care se lucreaza.
     * @return Sirul ce contine interogarea de update a unei linii din tabel.
     */
    public  String createUpdateQuery(List<Object> field){
        StringBuilder sb = new StringBuilder();
        sb.append("Update schooldb.");
        sb.append(type.getSimpleName());
        sb.append(" SET ");
        for(int i=1;i< field.size();i++){
            sb.append(type.getDeclaredFields()[i].getName() + " =?");
            if(i!=field.size()-1){
                sb.append( ",");
            }
        }
        sb.append(" WHERE " + type.getDeclaredFields()[0].getName() + " =?");
        return sb.toString();
    }

    /**
     * Aceasta metoda formeaza sirul pentru interogarea de selectare a stergere a unei linii din tabelul echivalent clasei cu care se lucreaza.
     * @return Sirul ce contine interogarea de stergere a unei linii din tabel.
     */
    private String createDeleteQuery() {

        StringBuilder sb = new StringBuilder();
        sb.append("DELETE ");
        sb.append(" FROM schooldb.");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + type.getDeclaredFields()[0].getName() + " =?");
        return sb.toString();
    }

    /**
     * Aceasta metoda realizeaza interogarea din baza de date cu ajutorul careia se face selectia tuturor linilor.
     * @return Un vetor cu toate linile din tabel.
     */
    public Vector<T> findAll() {

        Vector<T> t=new Vector<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createViewAllQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return  createObjects(resultSet);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return t;
    }

    /**
     * Aceasta metoda creeaza obiecte ce contin raspunsul la interogari.
     * @return Un vetor cu obiectele obtinute.
     */
    private Vector<T> createObjects(ResultSet resultSet) {
        Vector<T> list = new Vector<>();
        Constructor[] ctors = type.getDeclaredConstructors();

        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];

            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    try{
                        method.invoke(instance, value);
                    }catch (Exception exception){
                        method.invoke(instance, Integer.parseInt((String)value));
                    }

                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Aceasta metoda realizeaza interogarea din baza de date cu ajutorul careia se face insertia unei linii in tabel.
     * @return Id-ul pentru obiectul inserat in tabel.
     */
    public int insert(T t) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String query = createInsertQuery(t.getClass().getDeclaredFields().length);
        int id = 0;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            int i=1;
            for (Field field : t.getClass().getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    statement.setObject(i,field.get(t));
                    i++;

                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
             statement.executeUpdate();
            resultSet=statement.getGeneratedKeys();
            //id = resultSet.getInt(1);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "Insert " + e.getMessage());
            return -1;
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return id;
    }

    /**
     * Aceasta metoda realizeaza interogarea din baza de date cu ajutorul careia se face update unei linii in tabel.
     * @return Id-ul pentru obiectul modificat in tabel.
     */
    public int update(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createUpdateQuery(List.of(Arrays.stream(t.getClass().getDeclaredFields()).toArray()));
        int id = 0;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            int i=0;
            for (Field field : t.getClass().getDeclaredFields()) {
                try {
                    if(i!=0){
                        field.setAccessible(true);
                        statement.setObject(i,field.get(t));
                    }else{
                        statement.setObject(t.getClass().getDeclaredFields().length,field.get(t));
                    }
                    i++;
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            statement.executeUpdate();
            resultSet=statement.getGeneratedKeys();
           // id = resultSet.getInt(1);
            statement.executeUpdate();
            resultSet=statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt(1);

            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:Update " + e.getMessage());
            return -1;
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return id;
    }

    /**
     * Aceasta metoda realizeaza interogarea din baza de date cu ajutorul careia se face stergerea unei linii in tabel.
     * @return Id-ul pentru obiectul sters din tabel.
     */
    public int delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String name="";
        Field field= type.getClass().getDeclaredFields()[0];
        try {
            name= field.getName();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        String query = createDeleteQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeUpdate();
            resultSet=statement.getGeneratedKeys();
            id = resultSet.getInt(1);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "Delete " + e.getMessage());
            return -1;
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return id;
    }
}
