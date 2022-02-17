package controller;

import model.*;
import view.*;

import java.awt.event.*;

public class Controller {
    private Model p_model;
    private View p_view;

    public Controller(Model model, View view) {
        p_model = model;
        p_view = view;
        p_view.addClearListener1(new ClearListener1());
        p_view.addClearListener2(new ClearListener2());
        p_view.addClearListenerAll(new ClearListenerAll());
        p_view.addAddListener(new AddListener());
        p_view.addSubtractListener(new SubtractListener());
        p_view.addMultiplyListener(new MultiplyListener());
        p_view.addDerivateListener(new DerivateListener());
        p_view.addIntegrateListener(new IntegrateListener());
        p_view.addDivideListener(new DivideListener());

    }

    class ClearListener1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            p_view.reset1();
        }
    }

    class ClearListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            p_view.reset2();
        }
    }

    class ClearListenerAll implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            p_view.resetAll();
        }
    }

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput1 = p_view.getUserInput1();
            String userInput2 = p_view.getUserInput2();
            Polinom polinom1 = p_model.getPolinom(userInput1);
            Polinom polinom2 = p_model.getPolinom(userInput2);
            Polinom polinomRezultat = new Polinom();
            polinomRezultat = polinom1.adunare(polinom2);
            p_view.setRezultat(p_model.polinomToString(polinomRezultat));
        }
    }

    class SubtractListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput1 = p_view.getUserInput1();
            String userInput2 = p_view.getUserInput2();
            Polinom polinom1 = p_model.getPolinom(userInput1);
            Polinom polinom2 = p_model.getPolinom(userInput2);
            Polinom polinomRezultat = new Polinom();
            polinomRezultat = polinom1.scadere(polinom2);
            p_view.setRezultat(p_model.polinomToString(polinomRezultat));
        }
    }

    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput1 = p_view.getUserInput1();
            String userInput2 = p_view.getUserInput2();
            Polinom polinom1 = p_model.getPolinom(userInput1);
            Polinom polinom2 = p_model.getPolinom(userInput2);
            Polinom polinomRezultat = new Polinom();
            polinomRezultat = polinom1.inmultire(polinom2);
            p_view.setRezultat(p_model.polinomToString(polinomRezultat));
        }
    }

    class DerivateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput1 = p_view.getUserInput1();
            Polinom polinom1 = p_model.getPolinom(userInput1);
            Polinom polinomRezultat = new Polinom();
            polinomRezultat = polinom1.derivare();
            p_view.setRezultat(p_model.polinomToString(polinomRezultat));
        }
    }

    class IntegrateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput1 = p_view.getUserInput1();
            Polinom polinom1 = p_model.getPolinom(userInput1);
            Polinom polinomRezultat = new Polinom();
            polinomRezultat = polinom1.integrate();
            p_view.setRezultat(p_model.polinomToString(polinomRezultat));
        }
    }

    class DivideListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput1 = p_view.getUserInput1();
            String userInput2 = p_view.getUserInput2();
            Polinom polinom1 = p_model.getPolinom(userInput1);
            Polinom polinom2 = p_model.getPolinom(userInput2);
            Polinom quotient = new Polinom();
            Polinom remainder = new Polinom();
            polinom1.impartire(polinom2, quotient, remainder);
            String quotientString = new String(p_model.polinomToString(quotient));
            String remainderString = new String(p_model.polinomToString(remainder));
            p_view.setRezultatImpartire(quotientString, remainderString);

        }
    }
}
