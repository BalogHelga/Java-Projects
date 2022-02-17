package businessLogic;

import dataAccess.ClientDAO;
import model.Client;
import java.util.List;


/**
 *  Aceasta clasa se ocupa de logica din spatele operatiilor pe clienti din baza de date
 *  @author Helga Balog  balog.helga@yahoo.com
 *  @since 25.04.2021
 */

public class ClientBll {

    /**
     *  variabila care poate apela metodele din AbstractDAO pentru clienti
     */
    private ClientDAO clientDAO;

    /**
     *Constructorul instantiaza variabila orderDAO
     */
    public ClientBll()
    {
        clientDAO= new ClientDAO();
    }

    /**
     * Aceasta functie apleaza metoda de inserare in baza de date
     * @param client va fi inserat in baza de date
     */
    public void insertNewClient(Client client) { clientDAO.insert(client); }
    /**
     * Aceasta functie apleaza metoda de editare in baza de date
     * @param client va fi editat in baza de date
     */
    public void deleteClient(Client client) { clientDAO.delete(client); }
    /**
     * Aceasta functie apleaza metoda de stergere din baza de date
     * @param client va fi sters din baza de date
     */
    public void editClient(Client client) { clientDAO.update(client); }

    /**
     * Aceasta functie apleaza metoda de vizualizare a bazei de date
     * @return lista de obiecte din care se vor extrage datele
     */
    public List<Client> viewAll()
    {
        List<Client> list= clientDAO.findAll();
        return list;
    }
}
