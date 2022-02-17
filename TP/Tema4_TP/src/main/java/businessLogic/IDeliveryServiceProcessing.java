package businessLogic;

import java.util.List;

public interface IDeliveryServiceProcessing {


     /**
      * Aceasta metoda ia produsele din fisierul .csv si le salveaza intr-o lista
      * @pre the.csv file must exist
      * @post products.size()!=0
      */
     void importProducts();

     /**
      * Aceasta metoda adauga un produs simplu la lista de produse
      * @pre all fields must be different from null and greater than 0
      * @param baseProduct noul produs pe care il adaugam
      * @inv wellFormed
      */
     void addProduct(BaseProduct baseProduct);

     /**
      * Aceasta metoda adauga in lista de produse un produs compus
      * @pre title!= ""
      * @param title este numele produsului compus
      * @inv wellFormed
      */
     void addComposedProduct(String title);
     /**
      * Aceasta metoda modifica un produs din lista
      * @pre All the fields must be correct
      * @param menuItem produsul pe care dorim sa il modificam
      * @param menuItem2 contine datele cu care modificam
      * @inv wellFormed
      */
     void editProduct(MenuItem menuItem, MenuItem menuItem2);

     /**
      * Aceasta metoda sterge un produs din list
      * @param menuItem produsul pe care o sa il stergem
      * @inv wellFormed
      */
     void deleteProduct(MenuItem menuItem);

     /**
      * Aceasta metoda genereaza raportul de tip 1
      * @pre start and end mus be [0, 6]
      * @param start  timpul de la care se iau in considerare comenzile
      * @param end timpul pana la care se iau in considerare comenzile
      * @inv wellFormed
      */
     void generateReport1(int start,int end);

     /**
      * Aceasta metoda genereaza raportul de tip 2
      * @pre howManyTimes greater than 0
      * @param howManyTimes numar specificat de administrator
      * @inv wellFormed
      */
     void generateReport2(int howManyTimes);

     /**
      * Aceasta metoda genereaza raportul de tip 3
      * @pre howManyTimes greater than 0
      * @pre value greater than 10
      * @param howManyTimes numar specificat de administrator
      * @param value numar specificat de administrator
      * @inv wellFormed
      */
     void generateReport3(int howManyTimes,int value );

     /**
      * Aceasta metoda genereaza raportul de tip 4
      * @pre day greater or equal to 0 and day less or equal to 6
      * @param day ziua specificata de administrator
      * @inv wellFormed
      */
     void generateReport4(int day);

     /**
      * Aceasta metoda cauta in lista de produse, dupa anumite criterii
      * @pre lista pe care aplicam cautarea trebuie sa fie egala, initial, cu lista de produse
      * @param baseProduct produsul pe care il cautam
      * @return o lista de produse care contine elementele specificate
      * @inv wellFormed
      */
     List<MenuItem> search(BaseProduct baseProduct);

     /**
      * Aceasta metoda creeaza o comanda noua si o adauga la lista de comenzi
      * @pre name!=""
      * @param name este numele utilizatorului care face comanda
      * @inv wellFormed
      */
     void createNewOrder(String name);
}
