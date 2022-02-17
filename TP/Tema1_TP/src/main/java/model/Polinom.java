package model;

import java.util.*;

public class Polinom {

    public List<Monom> monoame = new ArrayList<Monom>();

    public Polinom() {
    }

    public Polinom(List<Monom> monoame) {
        this.monoame = monoame;
    }

    public void adaugareMonom(Monom monom) {
        this.monoame.add(monom);
    }

    public void removeMonom(Monom monom) {
        this.monoame.remove(monom);
    }

    public Polinom adunare(Polinom polinom2) {
        Polinom polinomRezultat = new Polinom();
        for (Monom m : this.monoame) {
            int ok = 0;
            for (Monom m2 : polinom2.monoame) {
                if (m.putere == m2.putere) {
                    polinomRezultat.adaugareMonom(m.adunare(m2));
                    ok = 1;
                }
            }
            if (ok == 0) {
                polinomRezultat.adaugareMonom(new Monom(m.coeficient, m.putere));
            }
        }
        for (Monom m : polinom2.monoame) {
            int ok = 0;
            for (Monom m2 : this.monoame) {
                if (m.putere == m2.putere) {
                    ok = 1;
                }
            }
            if (ok == 0)
                polinomRezultat.adaugareMonom(new Monom(m.coeficient, m.putere));
        }
        return polinomRezultat;

    }

    public Polinom scadere(Polinom polinom2) {
        Polinom polinomRezultat = new Polinom();
        for (Monom m : this.monoame) {
            int ok = 0;
            for (Monom m2 : polinom2.monoame) {
                if (m.putere == m2.putere) {
                    polinomRezultat.adaugareMonom(m.scadere(m2));
                    ok = 1;
                }
            }
            if (ok == 0) {
                polinomRezultat.adaugareMonom(new Monom(m.coeficient, m.putere));
            }
        }
        for (Monom m : polinom2.monoame) {
            int ok = 0;
            for (Monom m2 : this.monoame) {
                if (m.putere == m2.putere) {
                    ok = 1;
                }
            }
            if (ok == 0)
                polinomRezultat.adaugareMonom(new Monom(-m.coeficient, m.putere));
        }
        return polinomRezultat;

    }

    public Polinom inmultire(Polinom polinom2) {
        Polinom polinomRezultat = new Polinom();
        if (this.monoame.size() != 0 && polinom2.monoame.size() != 0) {
            for (Monom m : this.monoame) {
                for (Monom m2 : polinom2.monoame) {
                    polinomRezultat.adaugareMonom(m.inmultire(m2));
                }
            }
            //Dupa ce am facut inmultirea, exista monoame de acelasi grad care trebuie sa fie adunate
            Polinom polinomFinal = new Polinom();
            polinomFinal.adaugareMonom(polinomRezultat.monoame.get(0));
            polinomRezultat.removeMonom(polinomRezultat.monoame.get(0));
            for (Monom m : polinomRezultat.monoame) {
                Polinom p = new Polinom();
                p.adaugareMonom(m);
                polinomFinal = polinomFinal.adunare(p);
            }
            return polinomFinal;
        }
        polinomRezultat.adaugareMonom(new Monom(0, 0));
        return polinomRezultat;
    }

    public Polinom derivare() {
        Polinom polinomRezultat = new Polinom();
        for (Monom m : this.monoame) {
            polinomRezultat.adaugareMonom(m.derivare());
        }
        return polinomRezultat;
    }

    public Polinom integrate() {
        Polinom polinomRezultat = new Polinom();
        for (Monom m : this.monoame) {
            polinomRezultat.adaugareMonom(m.integrate());
        }
        return polinomRezultat;
    }

    public void impartire(Polinom polinom2, Polinom quotient, Polinom remainder) {
        Polinom deimpartit = new Polinom();
        Polinom impartitor = new Polinom();
        if (this.monoame.size() != 0 && polinom2.monoame.size() != 0) {
            if (this.compara(polinom2) == 1) {
                deimpartit = this;
                impartitor = polinom2;
            } else {
                deimpartit = polinom2;
                impartitor = this;
            }
            while (deimpartit.monoame.get(0).putere >= impartitor.monoame.get(0).putere) {
                float imp = (float)deimpartit.monoame.get(0).coeficient / impartitor.monoame.get(0).coeficient;
                int put = deimpartit.monoame.get(0).putere - impartitor.monoame.get(0).putere;
                quotient.adaugareMonom(new Monom(imp, put));
                Polinom cat = new Polinom();
                cat.adaugareMonom(quotient.monoame.get(quotient.monoame.size() - 1));
                deimpartit = deimpartit.scadere(impartitor.inmultire(cat));
                if (deimpartit.monoame.get(0).coeficient == 0)
                    deimpartit.removeMonom(deimpartit.monoame.get(0));
            }
            for (Monom m : deimpartit.monoame) {
                remainder.adaugareMonom(m);
            }
        } else {
            quotient.adaugareMonom(new Monom(0, 0));
            remainder.adaugareMonom(new Monom(0, 0));
        }
    }

    public int compara(Polinom p) {
        if (this.monoame.get(0).putere > p.monoame.get(0).putere)
            return 1;
        else
            return 0;
    }

    public Monom maxim() {
        int max = Integer.MIN_VALUE;
        for (Monom m : this.monoame) {
            if (m.putere > max)
                max = m.putere;
        }
        for (Monom m : this.monoame) {
            if (m.putere == max)
                return m;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polinom polinom = (Polinom) o;
        return Objects.equals(monoame, polinom.monoame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monoame);
    }
}