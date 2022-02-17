package model;

/**
 *  Aceasta clasa contine datele unei comenzi
 * @author Helga Balog balog.helga@yahoo.com
 * @since  23.04.2021
 */
public class Order {

    private int orderID;
    private int clientID;
    private int productID;
    private int quantity;

    /**
     *  Acest constructor seteaza datele comenzii
     * @param orderID id-ul comenzii
     * @param clientID id-ul clientului
     * @param productID id-u; produsului
     * @param quantity cantitatea
     */
    public Order(int orderID, int clientID, int productID, int quantity)
    {
        this.orderID=orderID;
        this.clientID=clientID;
        this.productID=productID;
        this.quantity=quantity;

    }

    /**
     *  Acest constructor seteaza toate campurile, fara id-ul comenzii
     * @param clientID id-ul clientului
     * @param productID id-u; produsului
     * @param quantity cantitatea
     */
    public Order(int clientID, int productID, int quantity)
    {
        this.clientID=clientID;
        this.productID=productID;
        this.quantity=quantity;
    }
    public Order()
    {}
    /**
     * @return id-ul comenzii
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     *@param id seteaza id-ul comenzii la valorea acestui parametru
     */
    public void setOrderID(int id) {
        this.orderID = id;
    }

    /**
     *
     * @return id-ul clientului
     */
    public int getClientID() { return clientID; }

    /**
     *
     * @param clientID seteaza id-ul clientului la acest id
     */
    public void setClientID(int clientID) { this.clientID = clientID; }

    /**
     *
     * @return id-ul produslui
     */
    public int getProductID() { return productID; }

    /**
     *
     * @param productID seteaza id-ul produsului la acest id
     */
    public void setProductID(int productID) { this.productID = productID; }

    /**
     *
     * @return cantitatea
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity seteaza cantitatea la valoarea acestui parametru
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
