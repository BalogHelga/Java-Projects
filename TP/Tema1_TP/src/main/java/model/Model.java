package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Dialog;
import javax.swing.*;

public class Model {

    public Model() {
    }

    public Polinom getPolinom(String userInput) {
        Polinom poli = new Polinom();
        Pattern p = Pattern.compile("([+-]?\\d*)x(\\^(\\d+))?|([+-]?\\d+)");
        Matcher m = p.matcher(userInput);
        float coef = 0;
        int putere = 0;
        if (esteCorectIntrodus(userInput)) {
            try {
                if (userInput.length() == 1 && userInput.equals("x")) {
                    Monom monom = new Monom(1, 1);
                    poli.adaugareMonom(monom);
                } else {
                    while (m.find()) {
                        if (m.group(4) == null) {
                            if (m.group(1) == null || m.group(1).equals("") || m.group(1).equals("+"))
                                coef = 1;
                            else {
                                if (m.group(1).equals("-"))
                                    coef = -1;
                                else
                                    coef = Float.parseFloat(m.group(1));
                            }
                            if (m.group(3) != null)
                                putere = Integer.parseInt(m.group(3));
                            else
                                putere = 1;
                        } else {
                            putere = 0;
                            coef = Integer.parseInt(m.group(4));
                        }
                        if (coef != 0) {
                            Monom monom = new Monom(coef, putere);
                            poli.adaugareMonom(monom);
                        }
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(new JFrame(), "Please enter your polynomials correctly");
                poli.monoame.clear();
            }
            return poli;
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Please enter your polynomials correctly");
            poli.monoame.clear();
            return poli;
        }
    }

    private boolean esteCorectIntrodus(String userInput) {
        char[] input = userInput.toCharArray();
        boolean ok = true;
        for (char c : input) {
            if (!(c == 'x' || c == '+' || c == '-' || c == '^' || (c >= '0' && c <= '9')))
                ok = false;
        }
        return ok;
    }

    public String polinomToString(Polinom polinom) {
        String rezultat = new String();
        while (!polinom.monoame.isEmpty()) {
            Monom monom = new Monom();
            monom = polinom.maxim();
            if (monom.coeficient != 0) {
                if (monom.putere == 0) {
                    if (monom.coeficient < 0)
                        rezultat = rezultat + monom.coeficient;
                    else
                        rezultat = rezultat + "+" + monom.coeficient;
                } else {
                    if (monom.putere == 1) {
                        if (monom.coeficient < 0) {
                            if (monom.coeficient == -1)
                                rezultat = rezultat + "-x";
                            else
                                rezultat = rezultat + monom.coeficient + "x";
                        } else {
                            if (monom.coeficient == 1)
                                rezultat = rezultat + "x";
                            else
                                rezultat = rezultat + "+" + monom.coeficient + "x";
                        }
                    } else {
                        if (monom.coeficient < 0)
                            rezultat = rezultat + monom.coeficient + "x^" + monom.putere;
                        else {
                            if (monom.coeficient == 1)
                                rezultat = rezultat + "+x^" + monom.putere;
                            else
                                rezultat = rezultat + "+" + monom.coeficient + "x^" + monom.putere;
                        }
                    }
                }
            }
            polinom.removeMonom(monom);
        }
        if (rezultat.length() == 0)
            rezultat = " 0 ";

        return rezultat;
    }

}
