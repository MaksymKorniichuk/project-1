package trainSystem.model;

import trainSystem.entities.forCars.cars.CarForBaggage;
import trainSystem.entities.Train;
import trainSystem.entities.forCars.GeneralTypeOfCar;
import trainSystem.entities.forCars.PlaceInCar;
import trainSystem.entities.forCars.cars.Car;
import trainSystem.entities.forCars.cars.CarCafe;
import trainSystem.entities.forCars.cars.CarForPeopleTransportation;

import java.util.ArrayList;
import java.util.List;

/**
 * Class do same calculations of trains and its cars.
 * @author Maksym
 */
public class WorkWithTrains {
    /**
     * All trains.
     */
    private List<Train> trains;

    /**
     * Constructor of class.
     * @param trains all trains.
     */
    public WorkWithTrains(List<Train> trains) {
        this.trains = trains;
    }

    /**
     * Calculation of general number of passengers in train.
     * @param train train.
     * @return general number of passengers in train
     */
    public Integer calculateGeneralNumberOfPassengersInTrain(Train train) {
        List<Car> cars = train.getCars();
        int totalNumberOfPassengersInTrain = 0;

        Integer numberOfPassengersInCurrentCar;
        for (Car car : cars) {
            numberOfPassengersInCurrentCar = getNumberOfPassengersFromCar(car);
            if (numberOfPassengersInCurrentCar != null) {
                totalNumberOfPassengersInTrain += numberOfPassengersInCurrentCar;
            }
        }

        return totalNumberOfPassengersInTrain;
    }

    /**
     * Calculation of general number of baggage in train.
     * @param train train.
     * @return general number of baggage in train.
     */
    public int calculateGeneralNumberOfBaggageInTrain(Train train) {
        List<Car> cars = train.getCars();
        int totalNumberOfBaggageInTrain = 0;

        for (Car car : cars) {
            if (car instanceof CarForBaggage) {
                totalNumberOfBaggageInTrain += ((CarForBaggage) car).getBaggage().size();
            }
        }

        return totalNumberOfBaggageInTrain;
    }

    /**
     * Finding all cars of train with number of passengers ia inputted range.
     * @param train train.
     * @param milLimitOfPassengers min limit of range inclusively.
     * @param maxLimitOfPassengers max limit of range inclusively.
     * @return list of appropriate cars in current train.
     */
    public ArrayList<Car> getCarsFromTrainWithNumbersOfPassengersInRange(Train train, int milLimitOfPassengers,
                                                                         int maxLimitOfPassengers) {
        List<Car> allCarsFromTrain = train.getCars();
        ArrayList<Car> carsWithNumbersOfPassengersInGivenRange = new ArrayList<>();

        Integer numbOfPassengersInCurrentCar;
        for (Car car : allCarsFromTrain) {
            numbOfPassengersInCurrentCar = getNumberOfPassengersFromCar(car);
            if (numbOfPassengersInCurrentCar != null && numbOfPassengersInCurrentCar >= milLimitOfPassengers
                    && numbOfPassengersInCurrentCar <= maxLimitOfPassengers) {
                carsWithNumbersOfPassengersInGivenRange.add(car);
            }
        }

        return carsWithNumbersOfPassengersInGivenRange;
    }

    /**
     * Calculation number of passengers in the car.
     * @param car car.
     * @return number of passengers in the car.
     */
    public Integer getNumberOfPassengersFromCar(Car car) {
        List<PlaceInCar> placesInCar;
        Integer totalNumberOfPassengersInTrain;

        // if it is car for people transportation
        if (car.getGeneralTypeOfCar().equals(GeneralTypeOfCar.FOR_PEOPLE_TRANSPORTATION)) {
            totalNumberOfPassengersInTrain = 0;
            placesInCar = ((CarForPeopleTransportation) car).getPlacesInCar();
            for (PlaceInCar placeInCar : placesInCar) {
                if (!placeInCar.isFree()) {
                    totalNumberOfPassengersInTrain++;
                }
            }
            return totalNumberOfPassengersInTrain;
        }

        // if it is car cafe
        if (car.getGeneralTypeOfCar().equals(GeneralTypeOfCar.CAFE)) {
            totalNumberOfPassengersInTrain = 0;
            placesInCar = ((CarCafe) car).getPlacesInCar();
            for (PlaceInCar placeInCar : placesInCar) {
                if (!placeInCar.isFree()) {
                    totalNumberOfPassengersInTrain++;
                }
            }
            return totalNumberOfPassengersInTrain;
        }

        return null;
    }

    /**
     * Getter for trains.
     * @return list of trains.
     */
    public List<Train> getTrains() {
        return trains;
    }

    /**
     * Setter for trains.
     * @param trains list of trains.
     */
    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }
}
