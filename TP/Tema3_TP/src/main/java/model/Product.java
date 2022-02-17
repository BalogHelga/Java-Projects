package model;

/**
 *  Aceasta clasa contine datele unui produs
 * @author Helga Balog balog.helga@yahoo.com
 * @since  23.04.2021
 */
public class Product {

    private int id;
    private String name;
    private String description;
    private int stock;

    /**
     *  Constructorul seteaza atributele produsului la cele primite ca argumente
     * @param id reprezinta id-ul produsului
     * @param name reprezinta numele produsului
     * @param descripion reprezinta descrierea produsului
     * @param stock reprezinta stocul produsului
     */
    public Product(int id, String name, String descripion, int stock)
    {
        this.id=id;
        this.description=descripion;
        this.name=name;
        this.stock=stock;
    }

    /**
     *  Constroctorul suprascris este la fel ca primul, insa acesta nu are argument pentru id
     * @param name reprezinta numele produsului
     * @param descripion represinta descrierea produsului
     * @param stock reprezinta stocul produsului
     */
    public Product(String name, String descripion, int stock)
    {
        this.description=descripion;
        this.name=name;
        this.stock=stock;
    }

    /**
     *  Acest constructor este folosit pentru a creea o noua instanta la metoda CreateObjects
     */
    public Product() { }

    /**
     *  Acest constructor seteaza doar campul id al produsului
     * @param id reprezinta id-ul produsului
     */
    public Product(int id) { this.id=id; }

    /**
     *  Aceasta metoda obtine id-ul produsului
     * @return id-ul produsului
     */
    public int getId() {
        return id;
    }

    /**
     * Aceasta metoda seteaza id-ul produsului
     * @param id-ul la care setam produsul
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     *  Aceasta metoda obtine numele produsului
     * @return numele produsului
     */
    public String getName() {
        return name;
    }
    /**
     * Aceasta metoda seteaza numele produsului
     * @param  name reprezinta numele la care setam produsul
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *  Aceasta metoda obtine descrierea produsului
     * @return descrierea produsului
     */
    public String getDescription() {
        return description;
    }
    /**
     * Aceasta metoda seteaza descrierea produsului
     * @param  description reprezinta descrierea produsuliu
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     *  Aceasta metoda obtine stocul produsului
     * @return stocul produsului
     */
    public int getStock() {
        return stock;
    }
    /**
     * Aceasta metoda seteaza stocul produsului
     * @param  stock reprezinta stocul nou al produsului
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
}
