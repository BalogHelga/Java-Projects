package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolinomTest {

    @Test
    void adunare() {
        Polinom polinom1= new Polinom();
        Polinom polinom2= new Polinom();
        Polinom rezultat=new Polinom();
        Monom monom1Polinom1= new Monom(3,2);
        Monom monom2Polinom1= new Monom(5,1);
        Monom monom3Polinom1= new Monom(7,0);
        Monom monom1Polinom2= new Monom(5,2);
        Monom monom2Polinom2= new Monom(8,1);
        Monom monom3Polinom2= new Monom(10,0);
        Monom rezultat1= new Monom(8, 2);
        Monom rezultat2= new Monom(13, 1);
        Monom rezultat3= new Monom(17, 0);
        polinom1.adaugareMonom(monom1Polinom1);
        polinom1.adaugareMonom(monom2Polinom1);
        polinom1.adaugareMonom(monom3Polinom1);

        polinom2.adaugareMonom(monom1Polinom2);
        polinom2.adaugareMonom(monom2Polinom2);
        polinom2.adaugareMonom(monom3Polinom2);

        rezultat.adaugareMonom(rezultat1);
        rezultat.adaugareMonom(rezultat2);
        rezultat.adaugareMonom(rezultat3);
        Polinom rezultatMetoda= polinom1.adunare(polinom2);
        assertEquals(rezultat, rezultatMetoda);
    }

    @Test
    void scadere() {
        Polinom polinom1= new Polinom();
        Polinom polinom2= new Polinom();
        Polinom rezultat=new Polinom();
        Monom monom1Polinom1= new Monom(3,2);
        Monom monom2Polinom1= new Monom(8,1);
        Monom monom3Polinom1= new Monom(14,0);
        Monom monom1Polinom2= new Monom(5,2);
        Monom monom2Polinom2= new Monom(5,1);
        Monom monom3Polinom2= new Monom(10,0);
        Monom rezultat1= new Monom(-2, 2);
        Monom rezultat2= new Monom(3, 1);
        Monom rezultat3= new Monom(4, 0);
        polinom1.adaugareMonom(monom1Polinom1);
        polinom1.adaugareMonom(monom2Polinom1);
        polinom1.adaugareMonom(monom3Polinom1);

        polinom2.adaugareMonom(monom1Polinom2);
        polinom2.adaugareMonom(monom2Polinom2);
        polinom2.adaugareMonom(monom3Polinom2);

        rezultat.adaugareMonom(rezultat1);
        rezultat.adaugareMonom(rezultat2);
        rezultat.adaugareMonom(rezultat3);
        Polinom rezultatMetoda= polinom1.scadere(polinom2);
        assertEquals(rezultat, rezultatMetoda);
    }

    @Test
    void inmultire() {
        Polinom polinom1= new Polinom();
        Polinom polinom2= new Polinom();
        Polinom rezultat=new Polinom();
        Monom monom1Polinom1= new Monom(3,1);
        Monom monom2Polinom1= new Monom(8,0);
        Monom monom1Polinom2= new Monom(5,2);
        Monom monom2Polinom2= new Monom(5,0);

        Monom rezultat1= new Monom(15, 3);
        Monom rezultat2= new Monom(15, 1);
        Monom rezultat3= new Monom(40, 2);
        Monom rezultat4= new Monom(40, 0);
        polinom1.adaugareMonom(monom1Polinom1);
        polinom1.adaugareMonom(monom2Polinom1);

        polinom2.adaugareMonom(monom1Polinom2);
        polinom2.adaugareMonom(monom2Polinom2);

        rezultat.adaugareMonom(rezultat1);
        rezultat.adaugareMonom(rezultat2);
        rezultat.adaugareMonom(rezultat3);
        rezultat.adaugareMonom(rezultat4);
        Polinom rezultatMetoda= polinom1.inmultire(polinom2);
        assertEquals(rezultat, rezultatMetoda);
    }

    @Test
    void derivare() {
        Polinom polinom1= new Polinom();
        Polinom rezultat=new Polinom();
        Monom monom1Polinom1= new Monom(3,2);
        Monom monom2Polinom1= new Monom(5,1);
        Monom monom3Polinom1= new Monom(7,0);
        Monom rezultat1= new Monom(6, 1);
        Monom rezultat2= new Monom(5, 0);
        Monom rezultat3= new Monom(0, -1);
        polinom1.adaugareMonom(monom1Polinom1);
        polinom1.adaugareMonom(monom2Polinom1);
        polinom1.adaugareMonom(monom3Polinom1);
        rezultat.adaugareMonom(rezultat1);
        rezultat.adaugareMonom(rezultat2);
        rezultat.adaugareMonom(rezultat3);
        Polinom rezultatMetoda= polinom1.derivare();
        assertEquals(rezultat, rezultatMetoda);
    }

    @Test
    void integrate() {
        Polinom polinom1= new Polinom();
        Polinom rezultat=new Polinom();
        Monom monom1Polinom1= new Monom(3,2);
        Monom monom2Polinom1= new Monom(5,1);
        Monom monom3Polinom1= new Monom(7,0);
        Monom rezultat1= new Monom(1, 3);
        Monom rezultat2= new Monom((float)5/2, 2);
        Monom rezultat3= new Monom(7, 1);
        polinom1.adaugareMonom(monom1Polinom1);
        polinom1.adaugareMonom(monom2Polinom1);
        polinom1.adaugareMonom(monom3Polinom1);
        rezultat.adaugareMonom(rezultat1);
        rezultat.adaugareMonom(rezultat2);
        rezultat.adaugareMonom(rezultat3);
        Polinom rezultatMetoda= polinom1.integrate();
        assertEquals(rezultat, rezultatMetoda);
    }

    @Test
    void impartire() {
        Polinom polinom1= new Polinom();
        Polinom polinom2= new Polinom();
        Polinom cat=new Polinom();
        Polinom rest= new Polinom();
        Monom monom1Polinom1= new Monom(8,2);
        Monom monom2Polinom1= new Monom(1,1);
        Monom monom1Polinom2= new Monom(1,1);
        Monom monom2Polinom2= new Monom(1,0);

        Monom cat1= new Monom(8, 1);
        Monom cat2= new Monom(-7, 0);
        Monom rest1= new Monom(7, 0);

        polinom1.adaugareMonom(monom1Polinom1);
        polinom1.adaugareMonom(monom2Polinom1);

        polinom2.adaugareMonom(monom1Polinom2);
        polinom2.adaugareMonom(monom2Polinom2);

        cat.adaugareMonom(cat1);
        cat.adaugareMonom(cat2);
        rest.adaugareMonom(rest1);
        Polinom restMetoda=new Polinom();
        Polinom catMetoda= new Polinom();
        polinom1.impartire(polinom2, catMetoda, restMetoda);
        assertEquals(cat, catMetoda);
        assertEquals(rest, restMetoda);

    }
}