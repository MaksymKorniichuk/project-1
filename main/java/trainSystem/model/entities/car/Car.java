package trainSystem.model.entities.car;

import trainSystem.model.entities.car.forCar.GeneralTypeOfCar;

/**
 * Abstract Entity of a car.
 * @author Maksym.
 */
public abstract class Car {
    /**
     * Number of a car.
     */
    private int numberOfCar;
    /**
     * General type of a car.
     */
    private GeneralTypeOfCar generalTypeOfCar;

    /**
     * Constructor.
     * @param numberOfCar Number of a car.
     * @param generalTypeOfCar General type of a car.
     */
    public Car(int numberOfCar, GeneralTypeOfCar generalTypeOfCar) {
        this.numberOfCar = numberOfCar;
        this.generalTypeOfCar = generalTypeOfCar;
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public void setNumberOfCar(int numberOfCar) {
        this.numberOfCar = numberOfCar;
    }

    public GeneralTypeOfCar getGeneralTypeOfCar() {
        return generalTypeOfCar;
    }

    public void setGeneralTypeOfCar(GeneralTypeOfCar generalTypeOfCar) {
        this.generalTypeOfCar = generalTypeOfCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfCar=" + numberOfCar +
                ", generalTypeOfCar=" + generalTypeOfCar +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (numberOfCar != car.numberOfCar) return false;
        return generalTypeOfCar == car.generalTypeOfCar;

    }

    @Override
    public int hashCode() {
        int result = numberOfCar;
        result = 31 * result + generalTypeOfCar.hashCode();
        return result;
    }
}