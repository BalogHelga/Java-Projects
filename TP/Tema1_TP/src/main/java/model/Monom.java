package model;

import java.util.Objects;

public class Monom {

    public float coeficient;
    public int putere;

    public Monom() {
    }

    public Monom(float coeficient, int putere) {
        this.coeficient = coeficient;
        this.putere = putere;
    }

    public Monom adunare(Monom monom) {
        Monom monomRezultat = new Monom(this.coeficient + monom.coeficient, putere);
        return monomRezultat;
    }

    public Monom scadere(Monom monom) {
        Monom monomRezultat = new Monom(this.coeficient - monom.coeficient, putere);
        return monomRezultat;
    }

    public Monom inmultire(Monom monom) {
        Monom monomRezultat = new Monom(this.coeficient * monom.coeficient, this.putere + monom.putere);
        return monomRezultat;
    }

    public Monom derivare() {
        Monom monomRezultat = new Monom(this.coeficient * this.putere, this.putere - 1);
        return monomRezultat;
    }

    public Monom integrate() {
        Monom monomRezultat = new Monom((float) this.coeficient / (this.putere + 1), this.putere + 1);
        return monomRezultat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monom monom = (Monom) o;
        return Float.compare(monom.coeficient, coeficient) == 0 && putere == monom.putere;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coeficient, putere);
    }
}
