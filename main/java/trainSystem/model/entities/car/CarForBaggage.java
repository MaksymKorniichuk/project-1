package trainSystem.model.entities.car;

import trainSystem.model.entities.car.forCar.Baggage;
import trainSystem.model.entities.car.forCar.GeneralTypeOfCar;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity of baggage car.
 * @author Maksym.
 */
public class CarForBaggage extends Car {
    /**
     * List of baggage.
     */
    private List<Baggage> baggage;

    /**
     * Constructor.
     * @param numberOfCar number of car.
     */
    public CarForBaggage(int numberOfCar) {
        super(numberOfCar, GeneralTypeOfCar.BAGGAGE);
        baggage = new ArrayList<>();
    }

    /**
     * Adding baggage to list of baggage.
     * @param idNumber number of new baggage.
     */
    public void addBaggageByNumber(int idNumber) {
        baggage.add(new Baggage(idNumber));
    }

    /**
     * Deleting baggage from list of baggage.
     * @param number number of deleting baggage.
     * @return true, if this baggage was in list of baggage.
     */
    public boolean deleteBaggageByNumber(int number) {
        for (int i = 0; i < baggage.size(); i++) {
            if (baggage.get(i).getIdNumber().equals(number)) {
                baggage.remove(i);
                return true;
            }
        }

        return false;
    }

    public List<Baggage> getBaggage() {
        return baggage;
    }

    public void setBaggage(List<Baggage> baggage) {
        this.baggage = baggage;
    }

    @Override
    public String toString() {
        return "CarForBaggage{" +
                "baggage=" + baggage +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarForBaggage)) return false;
        if (!super.equals(o)) return false;

        CarForBaggage that = (CarForBaggage) o;

        return baggage != null ? baggage.equals(that.baggage) : that.baggage == null;

    }
}
