package model;

import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.*;
class MonomTest {

    @org.junit.jupiter.api.Test
    void adunare() {
        Monom monom1= new Monom(5, 3);
        Monom monom2= new Monom(4, 3);
        Monom rezultat=new Monom(9, 3);
        Monom rezultatMetoda=monom1.adunare(monom2);
        assertEquals( (Object) rezultat, (Object) rezultatMetoda);
    }

    @org.junit.jupiter.api.Test
    void scadere() {
        Monom monom1= new Monom(5, 2);
        Monom monom2= new Monom(4, 2);
        Monom rezultat=new Monom(1,2);
        Monom rezultatMetoda=monom1.scadere(monom2);
        assertEquals((Object) rezultat,(Object) rezultatMetoda);
    }

    @org.junit.jupiter.api.Test
    void inmultire() {
        Monom monom1= new Monom(2, 1);
        Monom monom2= new Monom(3, 2);
        Monom rezultat=new Monom(6,3);
        Monom rezultatMetoda=monom1.inmultire(monom2);
        assertEquals((Object) rezultat, (Object) rezultatMetoda);
    }

    @org.junit.jupiter.api.Test
    void derivare() {
        Monom monom1= new Monom(7, 5);
        Monom rezultat=new Monom(35,4);
        Monom rezultatMetoda=monom1.derivare();
        assertEquals((Object) rezultat, (Object) rezultatMetoda);
    }

    @org.junit.jupiter.api.Test
    void integrate() {
        Monom monom1= new Monom(7, 6);
        Monom rezultat=new Monom(1,7);
        Monom rezultatMetoda= monom1.integrate();
        assertEquals((Object) rezultat,(Object) rezultatMetoda);
    }
}