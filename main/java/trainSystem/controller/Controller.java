package trainSystem.controller;

import trainSystem.model.WorkWithTrains;
import trainSystem.model.entities.Train;
import trainSystem.model.entities.car.Car;
import trainSystem.view.MenuItems;
import trainSystem.view.View;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The class provides check of input value, transferring it to model
 * and reception a result from model.
 * @author Maksym
 */
public class Controller {
    /**
     * Object that provides a mechanism of communication with user.
     */
    private View view;
    /**
     * Model with all logic of business process.
     */
    private WorkWithTrains workWithTrains;
    /**
     * Text that user can type to close the program.
     */
    private String exitLabel = "exit";

    /**
     * Constructor of the class.
     * @param view Object that provides a mechanism of communication with user.
     * @param model Model with all logic of business process.
     */
    public Controller(View view, WorkWithTrains model) {
        this.view = view;
        this.workWithTrains = model;
    }

    /**
     * Method gets input number from menu, check it, do some appropriate actions (get a result
     * from model) and continue, until user close the program.
     */
    public void mainProcess() {
        InputStream source = System.in;
        Scanner scanner = new Scanner(source);

        view.printMessage(view.GREETING);

        int intInput;
        String strInput;
        // cycle for user working with menu
        while (true) {
            view.printMessage(view.MENU);
            if (!scanner.hasNextInt()) {
                strInput = scanner.next();
                if (exitLabel.equals(strInput)) {
                    view.printMessage(view.CLOSE_OF_PROGRAM);
                    break;
                }
                view.printMessage(view.BAD_INPUT_DATA);
                continue;
            }

            // if we are here, input value is an integer
            intInput = scanner.nextInt(); // getting input number
            MenuItems menuItems = MenuItems.values()[intInput-1];
            switch (menuItems) { // doing appropriate action on inputted menu item
                case SHOW_EXISTING_TRAINS:
                    showExistingTrains();
                    break;
                case SHOW_PASSENGERS_NUMBER_IN_TRAINS:
                    showPassengersNumberInTrains();
                    break;
                case SHOW_BAGGAGE_NUMBER_IN_TRAINS:
                    showBaggageNumberInTrains();
                    break;
                case SORT_CARS_OF_TRAINS_BY_ITS_NUMBERS_AND_VIEW_IT:
                    sortCarsOfTrainsByItsNumbersAndViewIt();
                    break;
                case SORT_CARS_OF_TRAINS_BY_ITS_TYPES_AND_VIEW_IT:
                    sortCarsOfTrainsByItsTypesAndViewIt();
                    break;
                case FIND_AND_SHOW_CARS_BY_RANGE_OF_PASSENGERS:
                    findAndShowCarsByRangeOfPassengers(scanner);
                    break;
                default:
                    view.printMessage(view.BAD_INPUT_DATA);
                    continue;
            }
        }
    }

    /**
     * Showing of all existing trains.
     */
    private void showExistingTrains() {
        List<Train> trains = workWithTrains.getTrains();
        for (Train train : trains) {
            view.printTrain(train);
        }
    }

    /**
     * Showing of number of passengers in each train.
     */
    private void showPassengersNumberInTrains() {
        List<Train> trains = workWithTrains.getTrains();
        Integer generalNumberOfPassengersInTrain;
        for (Train train : trains) {
            generalNumberOfPassengersInTrain = workWithTrains.calculateGeneralNumberOfPassengersInTrain(train);
            view.printTransferredInfoAboutTrain(train.getNumberOfTrain(), train.getTrainName(),
                    view.NUMBER_OF_PASSENGERS_IN_TRAIN, generalNumberOfPassengersInTrain.toString());
        }
    }

    /**
     * Showing number of baggage in each train.
     */
    private void showBaggageNumberInTrains() {
        List<Train> trains = workWithTrains.getTrains();
        Integer generalNumberOfBaggageInTrain;
        for (Train train : trains) {
            generalNumberOfBaggageInTrain = workWithTrains.calculateGeneralNumberOfBaggageInTrain(train);
            view.printTransferredInfoAboutTrain(train.getNumberOfTrain(), train.getTrainName(),
                    view.NUMBER_OF_BAGGAGE_IN_TRAIN, generalNumberOfBaggageInTrain.toString());
        }
    }

    /**
     * Sorting cars or each train by its number and showing its.
     */
    private void sortCarsOfTrainsByItsNumbersAndViewIt() {
        List<Train> trains = workWithTrains.getTrains();
        trains.forEach(Train::sortCarsByItsNumbers);
        /*for (Train train: trains) {
            train.sortCarsByItsNumbers();
        }*/
        showExistingTrains();
    }

    /**
     * Sorting cars or each train by its type and showing its.
     */
    private void sortCarsOfTrainsByItsTypesAndViewIt() {
        List<Train> trains = workWithTrains.getTrains();
        trains.forEach(Train::sortCarsByItsType);
        /*for (Train train: trains) {
            train.sortCarsByItsType();
        }*/
        showExistingTrains();
    }

    /**
     * Getting from user range of passengers, finding and showing appropriate cars
     * by it range of passengers.
     * @param scanner input stream.
     */
    private void findAndShowCarsByRangeOfPassengers(Scanner scanner) {
        // getting range from user:
        int minLimitOfPassengers = getFromUserAnIntegerMoreThenMinLimit(view.MIN_LIMIT_OF_PASSENGERS_RANGE,
                scanner, 0);
        int maxLimitOfPassengers = getFromUserAnIntegerMoreThenMinLimit(view.MAX_LIMIT_OF_PASSENGERS_RANGE,
                scanner, minLimitOfPassengers);

        // finding and showing appropriate cars
        List<Train> trains = workWithTrains.getTrains();
        int numberOfFoundedCars = 0;
        view.printMessageWithRange("\n" + view.CAR_WITH_PASSENGERS_IN_RANGE, minLimitOfPassengers,
                maxLimitOfPassengers);
        for (Train train : trains) {
            List<Car> cars = workWithTrains.getCarsFromTrainWithNumbersOfPassengersInRange(train,
                    minLimitOfPassengers, maxLimitOfPassengers);
            if(cars.size() != 0){
                numberOfFoundedCars += cars.size();
            }
            for (Car car : cars) {
                view.printCarAndItsTrain(train.getNumberOfTrain(), train.getTrainName(), car,
                        workWithTrains.getNumberOfPassengersFromCar(car));
            }
        }
        if(numberOfFoundedCars == 0){
            view.printMessage(view.NONE);
        }
    }

    /**
     * Checking input data from input stream and getting an integer value.
     * @param message message to showing in input stream.
     * @param scanner input stream.
     * @param minLimit inputted value must be not less that this min limit.
     * @return a correct inputted integer value.
     */
    private Integer getFromUserAnIntegerMoreThenMinLimit(String message, Scanner scanner, int minLimit) {
        view.printMessage(message + minLimit);
        int intInput;
        // cycle for getting maximum range from user
        while (true) {
            if (!scanner.hasNextInt()) { // wait for entering data and if it is NOT integer:
                scanner.next(); // get value that source became clear
                view.printMessage(view.BAD_INPUT_DATA);
                view.printMessage(message + minLimit);
                continue; // go to start of loop
            }

            // if we are here, input value is an integer
            intInput = scanner.nextInt(); // getting input number
            if (intInput < minLimit) { // if inputted number is less that minimum limit of range
                view.printMessage(view.BAD_INPUT_DATA); // printing message and begin from start
                view.printMessage(message + minLimit);
            } else { // if inputted integer is good
                break; // break our cycle
            }
        }

        // if we are here, input value is correct
        return intInput;
    }
}
