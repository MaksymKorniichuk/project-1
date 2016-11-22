package trainSystem.view;

import trainSystem.model.entities.Train;
import trainSystem.model.entities.car.forCar.GeneralTypeOfCar;
import trainSystem.model.entities.car.Car;
import trainSystem.model.entities.car.CarForPeopleTransportation;

/**
 * The class contains a texts constants and methods to communicate with user.
 * @author Maksym
 */
public class View {
    // Text's constants
    public final String GREETING = "Welcome to our program TrainSystem !";
    public final String MENU = "\nYou can choose one of the next actions:\n" +
            "1) See existing trains;\n2) Get general numbers of passengers in trains;\n" +
            "3) Get general numbers of baggage in trains;\n4) Sort cars of trains by its numbers and view it;\n" +
            "5) Sort cars of trains by its types and view it;\n" +
            "6)Find cars with number of passengers between some limits." +
            "\n\nEnter necessary variant (e.g. \"1\"), or enter \"exit\" to close the program:";
    public final String BAD_INPUT_DATA = "Sorry, but your data is NOT correct. Please, try again:";
    public final String CLOSE_OF_PROGRAM = "\nThank you for using our program TrainSystem. Good luck !";
    public final String NUMBER_OF_PASSENGERS_IN_TRAIN = "Total number of passengers in train:";
    public final String NUMBER_OF_BAGGAGE_IN_TRAIN = "Total number of baggage in train:";
    public final String MIN_LIMIT_OF_PASSENGERS_RANGE = "Please, enter minimum limit of passengers range NOT less that ";
    public final String MAX_LIMIT_OF_PASSENGERS_RANGE = "Please, enter maximum limit of passengers range NOT less that ";
    public final String CAR_WITH_PASSENGERS_IN_RANGE = "All cars with number of passengers in range";
    public final String NONE = "none.";

    /**
     * Printing a message in console.
     * @param message message, that printings.
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Printing train in console.
     * @param train train, that printings.
     */
    public void printTrain(Train train) {
        // printing general info about train
        System.out.print("\nTrain #" + train.getNumberOfTrain());
        if (train.getTrainName().length() != 0) {
            System.out.print(" \"" + train.getTrainName() + "\"");
        }
        // printing info about trains cars
        System.out.println(" has next Cars:");
        GeneralTypeOfCar typeOfCurrentCar;
        CarForPeopleTransportation carForPeopleTransportation;
        for (Car car : train.getCars()) {
            typeOfCurrentCar = car.getGeneralTypeOfCar();
            System.out.print("number of car: " + car.getNumberOfCar() + ", type of car: " + typeOfCurrentCar.toString());
            if (typeOfCurrentCar.equals(GeneralTypeOfCar.FOR_PEOPLE_TRANSPORTATION)) {
                carForPeopleTransportation = (CarForPeopleTransportation) car;
                System.out.print("-" + carForPeopleTransportation.getTypeOfPeopleTransportationCar());
            }
            System.out.println();
        }
    }

    /**
     * Printing car and general info about its train.
     * @param numberOfTrain number of train.
     * @param nameOfTrain name of train.
     * @param car car.
     * @param numberOfPassengersInCar number of passengers in car.
     */
    public void printCarAndItsTrain(int numberOfTrain, String nameOfTrain, Car car, int numberOfPassengersInCar) {
        GeneralTypeOfCar typeOfCurrentCar;
        CarForPeopleTransportation carForPeopleTransportation;

        System.out.print("Train #" + numberOfTrain);
        if (nameOfTrain.length() != 0) {
            System.out.print(" " + nameOfTrain);
        }
        System.out.println();
        typeOfCurrentCar = car.getGeneralTypeOfCar();
        System.out.print("number of car: " + car.getNumberOfCar() + ", type of car: " + typeOfCurrentCar.toString());
        if (typeOfCurrentCar.equals(GeneralTypeOfCar.FOR_PEOPLE_TRANSPORTATION)) {
            carForPeopleTransportation = (CarForPeopleTransportation) car;
            System.out.print("-" + carForPeopleTransportation.getTypeOfPeopleTransportationCar());
        }
        System.out.println(" (" + numberOfPassengersInCar + "p.)");
    }

    /**
     * Printing message with some range.
     * @param message message.
     * @param minLimitOfRange min limit of range.
     * @param maxLimitOfRange max limit of range.
     */
    public void printMessageWithRange(String message, int minLimitOfRange, int maxLimitOfRange) {
        System.out.println(message + " [" + minLimitOfRange + ", " + maxLimitOfRange + "]:");
    }

    /**
     * Printing some info about train.
     * @param numberOfTrain number of train.
     * @param nameOfTrain name of train.
     * @param infoStr name of info about train.
     * @param infoValue info about train.
     */
    public void printTransferredInfoAboutTrain(int numberOfTrain, String nameOfTrain, String infoStr, String infoValue) {
        System.out.print("Train #" + numberOfTrain);
        if (nameOfTrain.length() != 0) {
            System.out.print(" " + nameOfTrain);
        }
        System.out.println(". " + infoStr + " " + infoValue);
    }

}
