package trainSystem.model.entities.car.forCar;

/**
 * Entity of Baggage.
 * @author Maksym.
 */
public class Baggage {
    /**
     * Number of baggage.
     */
    private Integer idNumber;

    /**
     * Constructor.
     * @param idNumber number of baggage.
     */
    public Baggage(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Baggage{" +
                "idNumber=" + idNumber +
                '}';
    }
}
