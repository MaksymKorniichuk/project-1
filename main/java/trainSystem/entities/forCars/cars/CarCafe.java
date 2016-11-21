package trainSystem.entities.forCars.cars;

import trainSystem.entities.forCars.GeneralTypeOfCar;
import trainSystem.entities.forCars.PlaceInCar;

import java.util.List;

/**
 * Entity of car cafe.
 * @author Maksym.
 */
public class CarCafe extends Car {
    /**
     * Number of places in cafe zone.
     */
    private int numberOfPlacesIsCafeZone;
    /**
     * List of places in car.
     */
    private List<PlaceInCar> placesInCar;

    /**
     * Constructor.
     * @param numberOfCar number of a car.
     * @param numberOfPlacesIsCafeZone Number of places in cafe zone.
     * @param placesInCar List of places in car.
     */
    public CarCafe(int numberOfCar, int numberOfPlacesIsCafeZone, List<PlaceInCar> placesInCar) {
        super(numberOfCar, GeneralTypeOfCar.CAFE);
        this.numberOfPlacesIsCafeZone = numberOfPlacesIsCafeZone;
        this.placesInCar = placesInCar;
    }

    public int getNumberOfPlacesIsCafeZone() {
        return numberOfPlacesIsCafeZone;
    }

    public void setNumberOfPlacesIsCafeZone(int numberOfPlacesIsCafeZone) {
        this.numberOfPlacesIsCafeZone = numberOfPlacesIsCafeZone;
    }

    public List<PlaceInCar> getPlacesInCar() {
        return placesInCar;
    }

    public void setPlacesInCar(List<PlaceInCar> placesInCar) {
        this.placesInCar = placesInCar;
    }

    @Override
    public String toString() {
        return "CarCafe{" +
                "numberOfPlacesIsCafeZone=" + numberOfPlacesIsCafeZone +
                ", placesInCar=" + placesInCar +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarCafe)) return false;
        if (!super.equals(o)) return false;

        CarCafe carCafe = (CarCafe) o;

        if (numberOfPlacesIsCafeZone != carCafe.numberOfPlacesIsCafeZone) return false;
        return placesInCar.equals(carCafe.placesInCar);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + numberOfPlacesIsCafeZone;
        return result;
    }
}
