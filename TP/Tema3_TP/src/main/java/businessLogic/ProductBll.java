package businessLogic;
import dataAccess.*;
import model.*;

import java.util.List;

/**
 *  Aceasta clasa se ocupa de logica din spatele operatiilor pe produse din baza de date
 *  @author Helga Balog  balog.helga@yahoo.com
 *  @since 25.04.2021
 */
public class ProductBll {

    /**
     *  variabila care poate apela metodele din AbstractDAO pentru produse
     */
    public ProductDAO productDAO;

    /**
     * Constructorul instantiaza variabila productDAO
     */
    public ProductBll() { productDAO= new ProductDAO(); }

    /**
     * Aceasta functie apleaza metoda de inserare in baza de date
     * @param product va fi inserat in baza de date
     */
    public void insertNewProduct(Product product) { productDAO.insert(product); }

    /**
     * Aceasta functie apleaza metoda de ediatare in baza de date
     * @param product va fi editat in baza de date
     */
    public void editProduct(Product product) { productDAO.update(product); }

    /**
     * Aceasta functie apleaza metoda de stergere din baza de date
     * @param product va fi sters din baza de date
     */
    public void deleteProduct(Product product){ productDAO.delete(product);}

    /**
     * Aceasta functie apleaza metoda de vizualizare a bazazei de date
     * @return este lista de obiecte din care se vor extrage datele
     */
    public List<Product> viewAll()
    {
        return productDAO.findAll();
    }
}
