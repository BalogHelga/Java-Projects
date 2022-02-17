package model;
/**
 *  Aceasta clasa contine datele unui client
 * @author Helga Balog balog.helga@yahoo.com
 * @since  23.04.2021
 */
public class Client {

    private int id;
    private String name;
    private String email;
    private String address;

    /**
     * Constructorul seteaza datele clientului la cele primite ca argumente
     * @param id id-ul clientului
     * @param name numele clientului
     * @param email email-ul clientului
     * @param address email-ul clientului
     */
    public Client(int id, String name, String email, String address)
    {
        this.id=id;
        this.name=name;
        this.address= address;
        this.email= email;
    }

    /**
     * Constructorul seteaza numele, email-ul si adresa clientului
     * @param name numele clientului
     * @param email email-ul clientului
     * @param address email-ul clientului
     */
    public Client(String name, String email, String address)
    {
        this.id=id;
        this.name=name;
        this.address= address;
        this.email= email;
    }

    /**
     * Constructor folosit pentru in metoda createObjects
     */
    public Client() { }

    /**
     * Constructorul seteaza id-ul clientului
     * @param id id-ul clientului
     */
    public Client(int id) { this.id=id; }

    /**
     * @return id-ul clientului
     */
    public int getId() {
        return id;
    }

    /**
     * @param id seteaza id-ul clientului la  valoarea parametrului
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return numele clientului
     */
    public String getName() {
        return name;
    }

    /**
     * @param nume seteaza numele clientului la nume
     */
    public void setName(String nume) {
        this.name = nume;
    }

    /**
     * @return email-ul clientuui
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email seteaza emailul la acel  parametru
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * @return adresa clientului
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address seteaza adresa clientului la address
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
