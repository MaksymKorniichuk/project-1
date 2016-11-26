package trainSystem.model.entities;

import trainSystem.model.entities.car.forCar.GeneralTypeOfCar;
import trainSystem.model.entities.car.Car;
import trainSystem.model.entities.car.CarForPeopleTransportation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Entity of train.
 * @author Maksym.
 */
public class Train {
    /**
     * Number of the train
     */
    private Integer numberOfTrain;
    /**
     * Name of the train.
     */
    private String trainName;
    /**
     * List of trains cars.
     */
    private List<Car> cars;

    /**
     * Constructor of the class.
     * @param numberOfTrain number of trains.
     * @param trainName train name.
     * @param cars list of cars.
     */
    public Train(Integer numberOfTrain, String trainName, List<Car> cars) {
        this.numberOfTrain = numberOfTrain;
        this.trainName = trainName;
        this.cars = cars;
    }

    /**
     * Sorting cars by its numbers.
     */
    public void sortCarsByItsNumbers() {
        Collections.sort(cars, (o1, o2) -> o1.getNumberOfCar() - o2.getNumberOfCar());
        /*Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getNumberOfCar() - o2.getNumberOfCar();
            }
        });*/
    }

    /**
     * Sorting cars by its types. Work with cars for people transportation (with its type)
     * and with cars NOT for people transportation.
     */
    public void sortCarsByItsType() {
        ArrayList<Car> sortedCarList = new ArrayList<>();
        ArrayList<CarForPeopleTransportation> carForPeopleTransportation;
        ArrayList<Car> carsNotForPeopleTransportation;
        carForPeopleTransportation = getAllCarsForPeopleTransportation();
        carsNotForPeopleTransportation = getAllCarsNotForPeopleTransportation();

        Collections.sort(carForPeopleTransportation,
                (o1, o2) -> o1.getTypeOfPeopleTransportationCar().ordinal()
                        - o2.getTypeOfPeopleTransportationCar().ordinal());
        /*Collections.sort(carForPeopleTransportation, new Comparator<CarForPeopleTransportation>() {
            @Override
            public int compare(CarForPeopleTransportation o1, CarForPeopleTransportation o2) {
                return o1.getTypeOfPeopleTransportationCar().ordinal() - o2.getTypeOfPeopleTransportationCar().ordinal();
            }
        });*/
        sortedCarList.addAll(carForPeopleTransportation);
        sortedCarList.addAll(carsNotForPeopleTransportation);

        setCars(sortedCarList);
    }

    /**
     * Getting all cars for people transportation.
     * @return cars for people transportation.
     */
    private ArrayList<CarForPeopleTransportation> getAllCarsForPeopleTransportation() {
        return cars.stream()
                .filter(car -> car.getGeneralTypeOfCar().equals(GeneralTypeOfCar.FOR_PEOPLE_TRANSPORTATION))
                .map(car -> (CarForPeopleTransportation) car)
                .collect(Collectors.toCollection(ArrayList::new));
        /*ArrayList<CarForPeopleTransportation> carsForPeopleTransportation = new ArrayList<>();
        for (Car car : cars) {
            if (car.getGeneralTypeOfCar().equals(GeneralTypeOfCar.FOR_PEOPLE_TRANSPORTATION)) {
                carsForPeopleTransportation.add((CarForPeopleTransportation) car);
            }
        }
        return carsForPeopleTransportation;*/
    }

    /**
     * Getting all cars NOT for people transportation.
     * @return cars NOT for people transportation.
     */
    private ArrayList<Car> getAllCarsNotForPeopleTransportation() {
        return cars.stream()
                .filter(car -> !(car instanceof CarForPeopleTransportation))
                .collect(Collectors.toCollection(ArrayList::new));
        /*ArrayList<Car> carsNotForPeopleTransportation = new ArrayList<>();
        for (Car car : cars) {
            if (!(car instanceof CarForPeopleTransportation)) {
                carsNotForPeopleTransportation.add(car);
            }
        }
        return carsNotForPeopleTransportation;*/

    }

    public Integer getNumberOfTrain() {
        return numberOfTrain;
    }

    public void setNumberOfTrain(Integer numberOfTrain) {
        this.numberOfTrain = numberOfTrain;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Train{" +
                "numberOfTrain=" + numberOfTrain +
                ", trainName='" + trainName + '\'' +
                ", cars=" + cars +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Train)) return false;

        Train train = (Train) o;

        if (!numberOfTrain.equals(train.numberOfTrain)) return false;
        if (trainName != null ? !trainName.equals(train.trainName) : train.trainName != null) return false;
        return cars.equals(train.cars);
    }

    @Override
    public int hashCode() {
        int result = numberOfTrain.hashCode();
        result = 31 * result + (trainName != null ? trainName.hashCode() : 0);
        return result;
    }
}
