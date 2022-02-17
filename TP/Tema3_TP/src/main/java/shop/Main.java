package shop;
import presentation.*;

/**
 *  Aceasta clasa, dupa cum zice si numele, este clasa principala care porneste aplicatia.
 * @author Helga Balog balog.helga@yahoo.com
 * since 21.04.2021
 */
public class Main {

    /**
     *  Metoda care porneste aplicatia
     * @param args este un sir de caractere
     */
    public static void main(String[] args)
    {
        /**
         *  Variabila controller interactioneaza cu clasa care se ocupa de interfetele grafice,
         *  astfel cand se apasa oricare dintre butoane, aplicatia va raspunde in mod corespunzator.
         */
        Controller controller= new Controller();
    }
}
