package simulation;
import view.*;
import controller.*;
public class Simulation {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setVisible(true);
    }

}
