package trainSystem;

import trainSystem.controller.Controller;
import trainSystem.model.WorkWithTrains;
import trainSystem.view.View;

/**
 * Class, that initializes and run program.
 * @author Maksym
 */
public class Main {
    /**
     * Method, that initializes and run program.
     * @param args arguments from command line.
     */
    public static void main(String[] args) {
        // Initialization
        InitializerOfTrains testInitializerOfTrains = new InitializerOfTrains();
        View view = new View();
        WorkWithTrains workWithTrains = new WorkWithTrains(testInitializerOfTrains.getTrains());
        Controller controller = new Controller(view, workWithTrains);

        // Run
        controller.mainProcess();
    }
}

