package trainSystem.entities.forCars.cars;

import trainSystem.entities.forCars.PlaceInCar;
import trainSystem.entities.forCars.GeneralTypeOfCar;
import trainSystem.entities.forCars.TypeOfPeopleTransportationCar;

import java.util.List;

/**
 * Entity of car for people transportation.
 * @author Maksym.
 */
public class CarForPeopleTransportation extends Car {
    /**
     * Type pf people transportation car.
     */
    private TypeOfPeopleTransportationCar typeOfPeopleTransportationCar;
    /**
     * List of places in car.
     */
    private List<PlaceInCar> placesInCar;

    /**
     * Constructor.
     * @param numberOfCar number of car.
     * @param typeOfPeopleTransportationCar Type pf people transportation car.
     * @param placesInCar List of places in car.
     */
    public CarForPeopleTransportation(int numberOfCar, TypeOfPeopleTransportationCar typeOfPeopleTransportationCar,
                                      List<PlaceInCar> placesInCar) {
        super(numberOfCar, GeneralTypeOfCar.FOR_PEOPLE_TRANSPORTATION);
        this.typeOfPeopleTransportationCar = typeOfPeopleTransportationCar;
        this.placesInCar = placesInCar;
    }

    public TypeOfPeopleTransportationCar getTypeOfPeopleTransportationCar() {
        return typeOfPeopleTransportationCar;
    }

    public void setTypeOfPeopleTransportationCar(TypeOfPeopleTransportationCar typeOfPeopleTransportationCar) {
        this.typeOfPeopleTransportationCar = typeOfPeopleTransportationCar;
    }

    public List<PlaceInCar> getPlacesInCar() {
        return placesInCar;
    }

    public void setPlacesInCar(List<PlaceInCar> placesInCar) {
        this.placesInCar = placesInCar;
    }

    @Override
    public String toString() {
        return "CarForPeopleTransportation{" +
                "typeOfPeopleTransportationCar=" + typeOfPeopleTransportationCar +
                ", placesInCar=" + placesInCar +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarForPeopleTransportation)) return false;
        if (!super.equals(o)) return false;

        CarForPeopleTransportation that = (CarForPeopleTransportation) o;

        if (typeOfPeopleTransportationCar != that.typeOfPeopleTransportationCar) return false;
        return placesInCar.equals(that.placesInCar);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + typeOfPeopleTransportationCar.hashCode();
        return result;
    }
}
