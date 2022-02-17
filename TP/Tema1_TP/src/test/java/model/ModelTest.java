package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void getPolinom() {
        Model model1= new Model();
        String input= new String("3x^3+5x^2-3x+5");
        Polinom polinom= model1.getPolinom(input);
        Monom m1= new Monom(3,3);
        Monom m2= new Monom(5,2);
        Monom m3= new Monom(-3,1);
        Monom m4= new Monom(5,0);
        Polinom rezultat=new Polinom();
        rezultat.adaugareMonom(m1);
        rezultat.adaugareMonom(m2);
        rezultat.adaugareMonom(m3);
        rezultat.adaugareMonom(m4);
        assertEquals( (Object) rezultat, (Object) polinom );
    }

    @Test
    void polinomToString() {
        Model model1= new Model();
        Monom m1= new Monom(3,3);
        Monom m2= new Monom(5,2);
        Monom m3= new Monom(-3,1);
        Monom m4= new Monom(5,0);
        Polinom polinom=new Polinom();
        polinom.adaugareMonom(m1);
        polinom.adaugareMonom(m2);
        polinom.adaugareMonom(m3);
        polinom.adaugareMonom(m4);
        String rezultatMetoda= model1.polinomToString(polinom);
        String rezultat = new String("+3.0x^3+5.0x^2-3.0x+5.0");
        assertEquals( (Object) rezultat, (Object) rezultatMetoda );
    }
}