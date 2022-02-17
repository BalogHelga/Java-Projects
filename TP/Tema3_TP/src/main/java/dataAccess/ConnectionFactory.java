package dataAccess;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Aceasta clasa conecteaza aplicatia la baza de date
 * @author Helga Balog balog.helga@yahoo.com
 * @since  25.05.2021
 */
public class ConnectionFactory {

    private static final Logger LOGGER= Logger.getLogger(ConnectionFactory.class.getName());
    private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    private static final String DBURL= "jdbc:mysql://localhost:3306/warehouse?autoReconnect=true&useSSL=false";
    private static final String USER="root";
    private static final String PASS="PasswordForMysql1";

    private static ConnectionFactory singleInstance= new ConnectionFactory();

    /**
     *  Constructorul face legatura cu baza de date
     */
    private ConnectionFactory(){
        try{
            Class.forName(DRIVER);
        }catch(ClassNotFoundException e) {
            System.out.println(" ConnectionFactory");
        }
    }

    /**
     * Aceasta metoda creeaza legatura si o returneaza
     * @return conexiunea facut cu baza de date
     */
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occured while trying to connect to the database");
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * @return conexiunea cu baza de dade
     */
    public static Connection getConnection() {
        return singleInstance.createConnection();
    }

    /**
     * Acesta metoda inchide conaxiunea cu baza de date
     * @param connection este conexiunea ce va fi inchisa
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
            }
        }
    }

    /**
     * Aceasta metoda inchide un statement
     * @param statement va fi inchis de aceasta functie
     */
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
            }
        }
    }

    /**
     * Aceasta functie va inchide un set rezultat dupa aplicarea unei interogari pe baza de date
     * @param resultSet reprezinta setul ce va fi inchis
     */
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
            }
        }
    }
}




