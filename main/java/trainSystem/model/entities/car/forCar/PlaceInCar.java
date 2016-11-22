package trainSystem.model.entities.car.forCar;

/**
 * Entity of place in car.
 */
public class PlaceInCar {
    /**
     * Number of the place.
     */
    private int numberOfPlace;
    /**
     * Is place free.
     */
    private boolean isFree;

    /**
     * Constructor.
     * @param numberOfPlace Number of the place.
     * @param isFree Is place free.
     */
    public PlaceInCar(int numberOfPlace, boolean isFree) {
        this.numberOfPlace = numberOfPlace;
        this.isFree = isFree;
    }

    public int getNumberOfPlace() {
        return numberOfPlace;
    }

    public void setNumberOfPlace(int numberOfPlace) {
        this.numberOfPlace = numberOfPlace;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    @Override
    public String toString() {
        return "PlaceInCar{" +
                "numberOfPlace=" + numberOfPlace +
                ", isFree=" + isFree +
                '}';
    }
}
