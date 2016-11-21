package trainSystem.entities.forCars.cars;

import trainSystem.entities.forCars.GeneralTypeOfCar;

/**
 * Entity of a car restaurant.
 * @author Maksym.
 */
public class CarRestaurant extends Car {
    /**
     * Number of places for seating.
     */
    private int numberOfPlacesForSeating;

    /**
     * Constructor.
     * @param numberOfCar Number of a car.
     * @param numberOfPlacesForSeating Number of places for seating.
     */
    public CarRestaurant(int numberOfCar, int numberOfPlacesForSeating) {
        super(numberOfCar, GeneralTypeOfCar.RESTAURANT);
        this.numberOfPlacesForSeating = numberOfPlacesForSeating;
    }

    public int getNumberOfPlacesForSeating() {
        return numberOfPlacesForSeating;
    }

    public void setNumberOfPlacesForSeating(int numberOfPlacesForSeating) {
        this.numberOfPlacesForSeating = numberOfPlacesForSeating;
    }

    @Override
    public String toString() {
        return "CarRestaurant{" +
                "numberOfPlacesForSeating=" + numberOfPlacesForSeating +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarRestaurant)) return false;
        if (!super.equals(o)) return false;

        CarRestaurant that = (CarRestaurant) o;

        return numberOfPlacesForSeating == that.numberOfPlacesForSeating;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + numberOfPlacesForSeating;
        return result;
    }
}
