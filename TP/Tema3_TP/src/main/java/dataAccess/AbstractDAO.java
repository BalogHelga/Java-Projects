package dataAccess;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 * Aceasta clasa creeaza interogarile corespunzatoare si le aplica pe baza de date
 * @author Helga Balog balog.helga@yahoo.com
 * @since 26.04.2021
 * @param <T> poate fi Client, Produs sau Comanda
 */
public class AbstractDAO<T> {

    /**
     * variabila care conecteaza la baza de date
     */
    protected static final Logger LOGGER= Logger.getLogger(AbstractDAO.class.getName());
    /**
     *  variabila care ne va indica tipul entitatii
     */
    public final Class<T> type;

    /**
     *  Constructorul asigneaza variabilei T tipul potrivit
     */
    @SuppressWarnings("unchecked")
    public AbstractDAO()
    {
        this.type=(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Aceasta metoda creeaza un query de selectare
     * @param field este campul pe care se aplica selectare
     * @return va fi sirul de caractere care contine query-ul
     */
    public String selectQuery(String field)
    {
        String query= "SELECT * FROM warehouse."+ type.getSimpleName() +" WHERE " + field +" = ?";
        return query;
    }

    /**
     * Aceasta metoda cauta in baza de date dupa id
     * @param id este id-ul dupa care va face selectia
     * @return rezultatul aplicarii intergoarii
     */
    public T findById(int id)
   {
       Connection connection= null;
       PreparedStatement statement=null;
       ResultSet resultSet=null;
       String query=null;
       if( type.getSimpleName().equals("Order"))
             query=selectQuery("orderID");
       else
            query= selectQuery("id");
       try
       {   connection = ConnectionFactory.getConnection();
           statement= connection.prepareStatement(query);
           statement.setInt(1, id);
           resultSet = statement.executeQuery();
           return createObjects(resultSet).get(0);
       }catch( SQLException e) {
           LOGGER.log(Level.WARNING, type.getName() + " DAO : findById" + e.getMessage());
       }finally{
           ConnectionFactory.close(resultSet);
           ConnectionFactory.close(statement);
           ConnectionFactory.close(connection);
       }
       return null;
   }

    /**
     *  Aceasta metoda selecteaza toate randurile dintr-un tabel din baza de date
     * @return la final, va returna o lista cu obiectele gasite
     */
    public List<T> findAll()
    {
        String query=" SELECT * FROM warehouse."+ type.getSimpleName();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return createObjects(resultSet);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return null;
    }

    /**
     * Aceasta functie creeaza o lista cu T obiecte
     * @param resultSet este setul rezultat dupa aplicare unei interogari
     * @return lista de T obiecte
     */
   public List<T> createObjects(ResultSet resultSet)
   {
       List<T> list = new ArrayList<T>();
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
                   method.invoke(instance, value);
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
     *  Aceasta metoda creaaza o interogare de inserare, pe baza lui T
     * @param t este tipul obiectului: produs /client / order
     * @return un sir de caractere cu query-ul
     */
   public String insertQuery(T t)
   {
       String query="INSERT INTO warehouse."+ type.getSimpleName() +" ";
       Field[] field= t.getClass().getDeclaredFields();
       for(Field field1 : field)
           field1.setAccessible(true);

       query= query +" ( "+ field[1].getName()+" , "+ field[2].getName() +" , "+ field[3].getName()+" ) VALUES (? ,?, ?);";
       return query;
   }

    /**
     * Aceasta functie va adauga in baza de date un obiect de tip T
     * @param t este obiectul care se insereaza in baza de date
     */
   public void insert(T t)
   {
       String insertStatementString = insertQuery(t);
       Connection dbConnection = ConnectionFactory.getConnection();
       PreparedStatement insertStatement = null;
       try {
           insertStatement = dbConnection.prepareStatement(insertStatementString);
           Field[] field= t.getClass().getDeclaredFields();
           for(Field field1 : field) {
               field1.setAccessible(true);
           }
           insertStatement.setObject(1, (Object) field[1].get(t));
           insertStatement.setObject(2, (Object) field[2].get(t));
           insertStatement.setObject(3, (Object) field[3].get(t));

           insertStatement.executeUpdate();
       } catch (SQLException | IllegalAccessException e) {
           LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
       } finally {
           ConnectionFactory.close(insertStatement);
           ConnectionFactory.close(dbConnection);
       }
   }

    /**
     *  Aceasta metoda creaaza o interogare de editare, pe baza lui T
     * @param t este tipul obiectului: produs /client / order
     * @return un sir de caractere cu query-ul
     */
   public String updateQuery(T t )
   {
       String query="UPDATE warehouse."+ type.getSimpleName() +" SET  ";
       Field[] field= t.getClass().getDeclaredFields();
       for(Field field1 : field)
            field1.setAccessible(true);

       query= query+ field[1].getName() +" = ? , " + field[2].getName() +" = ? , "+ field[3].getName() +" = ? WHERE "+ field[0].getName()+" = ? ;";
       return query;
   }
    /**
     * Aceasta functie va edita un rand din baza de date de tip T
     * @param t este obiectul care se editeaza
     */
   public void update(T t)
   {
       String updateStatementString= updateQuery(t);
       Connection dbConnection = ConnectionFactory.getConnection();
       PreparedStatement updateStatement = null;
       try {
           updateStatement = dbConnection.prepareStatement(updateStatementString);
           Field[] field= t.getClass().getDeclaredFields();
           for(Field field1 : field) {
               field1.setAccessible(true);
           }

           updateStatement.setObject(1, (Object) field[1].get(t));
           updateStatement.setObject(2, (Object) field[2].get(t));
           updateStatement.setObject(3, (Object) field[3].get(t));
           updateStatement.setObject(4, (Object) field[0].get(t));
           updateStatement.executeUpdate();

       } catch (SQLException | IllegalAccessException e) {
           LOGGER.log(Level.WARNING, "AbstractDAO:update" + e.getMessage());
       } finally {
           ConnectionFactory.close(updateStatement);
           ConnectionFactory.close(dbConnection);
       }
   }

   /**
     *  Aceasta metoda creaaza o interogare de stergere, pe baza lui T
     * @param t este tipul obiectului: produs /client / order
     * @return un sir de caractere cu query-ul
     */
    public String deleteQuery(T t)
    {
        String query="DELETE FROM warehouse."+ type.getSimpleName()+" WHERE ";
        Field[] field= t.getClass().getDeclaredFields();
        field[0].setAccessible(true);
        String fieldName= field[0].getName();
        query= query+ field[0].getName() + "= ? ";
        return query;
    }
    /**
     * Aceasta functie va sterge din baza de date un obiect de tip T
     * @param t este obiectul care se sterge din baza de date
     */
    public void delete(T t)
    {
        String deleteStatementString= deleteQuery(t);
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString);
            Field[] field= t.getClass().getDeclaredFields();
            field[0].setAccessible(true);
            Object value= field[0].get(t);
            deleteStatement.setObject(1, value);
            deleteStatement.executeUpdate();
        } catch (SQLException | IllegalAccessException e) {
            LOGGER.log(Level.WARNING, "AbstractDAO:delete" + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

}
