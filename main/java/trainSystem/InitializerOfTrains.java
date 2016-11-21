package trainSystem;

import trainSystem.entities.Train;
import trainSystem.entities.forCars.GlobalConstantsForCars;
import trainSystem.entities.forCars.PlaceInCar;
import trainSystem.entities.forCars.TypeOfPeopleTransportationCar;
import trainSystem.entities.forCars.cars.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that create trains and init its.
 * @author Maksym
 */
public class InitializerOfTrains {

    /**
     * Creation and initialization of all trains.
     * @return List of trains.
     */
    public ArrayList<Train> getTrains() {
        ArrayList<Train> trains = new ArrayList<>();
        trains.add(getFirstTrain());
        trains.add(getSecondTrain());
        return trains;
    }

    /**
     * Creation and initialization of train with all types of cars.
     * @return train with all types of cars.
     */
    private Train getFirstTrain() {
        List<Car> cars = new ArrayList<>();

        // creation of Lux cars and initialization some of them:
        CarForPeopleTransportation carForPeopleTransportation;
        carForPeopleTransportation = generateFreeLuxCarWithNumber(1);
        initCarForPeopleTransportation(carForPeopleTransportation);
        cars.add(carForPeopleTransportation);
        carForPeopleTransportation = generateFreeLuxCarWithNumber(2);
        cars.add(carForPeopleTransportation);
        carForPeopleTransportation = generateFreeLuxCarWithNumber(3);
        initCarForPeopleTransportation(carForPeopleTransportation);
        cars.add(carForPeopleTransportation);

        // creation of Coupe cars and initialization some of them:
        carForPeopleTransportation = generateFreeCoupeCarWithNumber(4);
        cars.add(carForPeopleTransportation);
        carForPeopleTransportation = generateFreeCoupeCarWithNumber(5);
        initCarForPeopleTransportation(carForPeopleTransportation);
        cars.add(carForPeopleTransportation);
        carForPeopleTransportation = generateFreeCoupeCarWithNumber(6);
        initCarForPeopleTransportation(carForPeopleTransportation);
        cars.add(carForPeopleTransportation);

        // creation of Cafe car and initialization it:
        CarCafe carCafe = generateFreeCafeCarWithNumber(7);
        initCafeCar(carCafe);
        cars.add(carCafe);

        // creation of Economy-class cars and initialization some of them:
        carForPeopleTransportation = generateFreeEconomyClassCarWithNumber(8);
        initCarForPeopleTransportation(carForPeopleTransportation);
        cars.add(carForPeopleTransportation);
        carForPeopleTransportation = generateFreeEconomyClassCarWithNumber(9);
        initCarForPeopleTransportation(carForPeopleTransportation);
        cars.add(carForPeopleTransportation);
        carForPeopleTransportation = generateFreeEconomyClassCarWithNumber(10);
        cars.add(carForPeopleTransportation);

        // creation of General cars and initialization some of them:
        carForPeopleTransportation = generateFreeGeneralCarWithNumber(11);
        cars.add(carForPeopleTransportation);
        carForPeopleTransportation = generateFreeGeneralCarWithNumber(12);
        initCarForPeopleTransportation(carForPeopleTransportation);
        cars.add(carForPeopleTransportation);

        // creation of car Restaurant:
        CarRestaurant carRestaurant = generateCarRestaurantWithNumber(13);
        cars.add(carRestaurant);

        // creation of Baggage car and initialization it:
        CarForBaggage carForBaggage = generateFreeCarForBaggageWithNumber(14);
        initCarForBaggage(carForBaggage);
        cars.add(carForBaggage);

        // creation of train
        return new Train(50, "Bukovel", cars);
    }

    /**
     * Creation and initialization of train with all types of cars but without name.
     * @return train with all types of cars.
     */
    private Train getSecondTrain() {
        List<Car> cars = new ArrayList<>();

        // creation of Lux cars and initialization some of them:
        CarForPeopleTransportation carForPeopleTransportation;
        carForPeopleTransportation = generateFreeLuxCarWithNumber(1);
        initCarForPeopleTransportation(carForPeopleTransportation);
        cars.add(carForPeopleTransportation);
        carForPeopleTransportation = generateFreeLuxCarWithNumber(2);
        cars.add(carForPeopleTransportation);

        // creation of Coupe car and initialization it:
        carForPeopleTransportation = generateFreeCoupeCarWithNumber(3);
        cars.add(carForPeopleTransportation);

        // creation of Cafe car and initialization it:
        CarCafe carCafe = generateFreeCafeCarWithNumber(4);
        initCafeCar(carCafe);
        cars.add(carCafe);

        // creation of Economy-class cars and initialization some of them:
        carForPeopleTransportation = generateFreeEconomyClassCarWithNumber(5);
        initCarForPeopleTransportation(carForPeopleTransportation);
        cars.add(carForPeopleTransportation);
        carForPeopleTransportation = generateFreeEconomyClassCarWithNumber(6);
        initCarForPeopleTransportation(carForPeopleTransportation);
        cars.add(carForPeopleTransportation);

        // creation of General cars and initialization some of them:
        carForPeopleTransportation = generateFreeGeneralCarWithNumber(7);
        initCarForPeopleTransportation(carForPeopleTransportation);
        cars.add(carForPeopleTransportation);

        // creation of car Restaurant:
        CarRestaurant carRestaurant = generateCarRestaurantWithNumber(8);
        cars.add(carRestaurant);

        // creation of Baggage car and initialization it:
        CarForBaggage carForBaggage = generateFreeCarForBaggageWithNumber(9);
        initCarForBaggage(carForBaggage);
        cars.add(carForBaggage);

        // створюю потяг з вагонами, номером й власною назвою
        return new Train(90, "", cars);
    }

    /**
     * Creation of an empty car cafe.
     * @param number number of the train.
     * @return empty car cafe.
     */
    private CarCafe generateFreeCafeCarWithNumber(int number) {
        List<PlaceInCar> placesInCurrantCar = new ArrayList<>();
        for (int i = 0; i <= GlobalConstantsForCars.NUMBER_OF_PLACES_IN_CAFE_CAR; i++) {
            placesInCurrantCar.add(new PlaceInCar(i, true));
        }
        return new CarCafe(number, GlobalConstantsForCars.NUMBER_OF_PLACES_IN_CAFE_ZONE_OF_CAFE_CAR, placesInCurrantCar);
    }

    /**
     * Creation of an car restaurant.
     * @param number number of the train.
     * @return car restaurant.
     */
    private CarRestaurant generateCarRestaurantWithNumber(int number) {
        return new CarRestaurant(number, GlobalConstantsForCars.NUMBER_OF_PLACES_IN_CAR_RESTAURANT);
    }

    /**
     * Creation of an empty baggage car.
     * @param number number of the train.
     * @return empty baggage car.
     */
    private CarForBaggage generateFreeCarForBaggageWithNumber(int number) {
        return new CarForBaggage(number);
    }

    /**
     * Creation of an empty economy-class car.
     * @param number number of the train.
     * @return empty economy-class car.
     */
    private CarForPeopleTransportation generateFreeEconomyClassCarWithNumber(int number) {
        List<PlaceInCar> placesInCurrantCar = new ArrayList<>();
        for (int i = 0; i <= GlobalConstantsForCars.NUMB_OF_PLACES_IN_ECONOMY_CLASS_CAR; i++) {
            placesInCurrantCar.add(new PlaceInCar(i, true));
        }
        return new CarForPeopleTransportation(number, TypeOfPeopleTransportationCar.ECONOMY_CLASS, placesInCurrantCar);
    }

    /**
     * Creation of an empty general car.
     * @param number number of the train.
     * @return empty general car.
     */
    private CarForPeopleTransportation generateFreeGeneralCarWithNumber(int number) {
        List<PlaceInCar> placesInCurrantCar = new ArrayList<>();
        for (int i = 0; i <= GlobalConstantsForCars.NUMBER_OF_PLACES_IN_GENERAL_CAR; i++) {
            placesInCurrantCar.add(new PlaceInCar(i, true));
        }
        return new CarForPeopleTransportation(number, TypeOfPeopleTransportationCar.GENERAL, placesInCurrantCar);
    }

    /**
     * Creation of an empty Lux car.
     * @param number number of the train.
     * @return empty Lux car.
     */
    private CarForPeopleTransportation generateFreeLuxCarWithNumber(int number) {
        List<PlaceInCar> placesInCurrantCar = new ArrayList<>();
        for (int i = 0; i <= GlobalConstantsForCars.NUMB_OF_PLACES_IN_LUX_CAR; i++) {
            placesInCurrantCar.add(new PlaceInCar(i, true));
        }
        return new CarForPeopleTransportation(number, TypeOfPeopleTransportationCar.LUX, placesInCurrantCar);
    }

    /**
     * Creation of an empty coupe car.
     * @param number number of the train.
     * @return empty coupe car.
     */
    private CarForPeopleTransportation generateFreeCoupeCarWithNumber(int number) {
        List<PlaceInCar> placesInCurrantCar = new ArrayList<>();
        for (int i = 0; i <= GlobalConstantsForCars.NUMB_OF_PLACES_IN_COUPE_CAR; i++) {
            placesInCurrantCar.add(new PlaceInCar(i, true));
        }
        return new CarForPeopleTransportation(number, TypeOfPeopleTransportationCar.COUPE, placesInCurrantCar);
    }

    /**
     * Initialization of a cafe car.
     * @param carCafe empty cafe car.
     */
    private void initCafeCar(CarCafe carCafe) {
        List<PlaceInCar> placesInCar = carCafe.getPlacesInCar();
        placesInCar.get(0).setFree(false);
        placesInCar.get(2).setFree(false);
        placesInCar.get(3).setFree(false);
        placesInCar.get(7).setFree(false);
        placesInCar.get(9).setFree(false);
    }

    /**
     * Initialization of a car for people transportation
     * (any child of class CarForPeopleTransportation).
     * @param carForPeopleTransportation empty car for people transportation.
     */
    private void initCarForPeopleTransportation(CarForPeopleTransportation carForPeopleTransportation) {
        List<PlaceInCar> placesInCar = carForPeopleTransportation.getPlacesInCar();
        placesInCar.get(1).setFree(false);
        placesInCar.get(3).setFree(false);
        placesInCar.get(4).setFree(false);
        placesInCar.get(6).setFree(false);
        placesInCar.get(8).setFree(false);
    }

    /**
     * Initialization of baggage car.
     * @param carForBaggage empty baggage car.
     */
    private void initCarForBaggage(CarForBaggage carForBaggage) {
        carForBaggage.addBaggageByNumber(1);
        carForBaggage.addBaggageByNumber(2);
        carForBaggage.addBaggageByNumber(3);
        carForBaggage.addBaggageByNumber(4);
        carForBaggage.addBaggageByNumber(5);
        carForBaggage.addBaggageByNumber(6);
    }
}
