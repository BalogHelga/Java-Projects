package calculator;

import view.*;
import model.*;
import controller.*;

import javax.swing.*;

public class Calculator {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
        view.setVisible(true);
    }

}