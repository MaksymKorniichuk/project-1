package trainSystem.model;

import org.junit.BeforeClass;
import org.junit.Test;
import trainSystem.TestInitializerOfTrains;
import trainSystem.model.entities.Train;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class WorkWithTrainsTest {
    private static ArrayList<Train> trains;
    private static WorkWithTrains workWithTrains;

    @BeforeClass
    public static void creationAndInitializationOfAllTrains() {
        trains = new TestInitializerOfTrains().getTrains();
        workWithTrains = new WorkWithTrains(trains);
    }

    @Test
    public void calculateGeneralNumberOfPassengersInNormalTrain() throws Exception {
        // 3 - Lux(5), 1 - Coupe(5), 1 - Cafe(5), 3 - Economy(5), 1 - General(5)
        assertEquals(workWithTrains.calculateGeneralNumberOfPassengersInTrain(trains.get(0)), 40, 0);
    }

    @Test
    public void calculateGeneralNumberOfPassengersInFreeTrain() throws Exception {
        assertEquals(workWithTrains.calculateGeneralNumberOfPassengersInTrain(trains.get(1)), 0, 0);
    }

    @Test
    public void calculateGeneralNumberOfBaggagesInNormalTrain() throws Exception {
        assertEquals(workWithTrains.calculateGeneralNumberOfBaggageInTrain(trains.get(0)), 6, 0);
    }

    @Test
    public void calculateGeneralNumberOfBaggagesInFreeTrain() throws Exception {
        assertEquals(workWithTrains.calculateGeneralNumberOfBaggageInTrain(trains.get(1)), 0, 0);
    }

    @Test
    public void getCarsFromNormalTrainWithNumbersOfPassengersInRange() throws Exception {
        int minLimit = 0;
        int maxLimit = 10;
        assertEquals(workWithTrains.getCarsFromTrainWithNumbersOfPassengersInRange(trains.get(0), minLimit,
                maxLimit).size(), 12, 0);
    }

    @Test
    public void getCarsFromNormalTrainWithNumbersOfPassengersInRangeAndBadArguments() throws Exception {
        int minLimit = 10;
        int maxLimit = 0;
        assertEquals(workWithTrains.getCarsFromTrainWithNumbersOfPassengersInRange(trains.get(0), minLimit,
                maxLimit).size(), 0, 0);
    }

    @Test
    public void getCarsFromFreeTrainWithNumbersOfPassengersInRange() throws Exception {
        int minLimit = 1;
        int maxLimit = 10;
        assertEquals(workWithTrains.getCarsFromTrainWithNumbersOfPassengersInRange(trains.get(1), minLimit,
                maxLimit).size(), 0, 0);
    }

    @Test
    public void getNumberOfPassengersFromNormalCar() throws Exception {
        assertEquals(workWithTrains.getNumberOfPassengersFromCar(trains.get(0).getCars().get(0)), 5, 0);
    }

    @Test
    public void getNumberOfPassengersFromFreeCar() throws Exception {
        assertEquals(workWithTrains.getNumberOfPassengersFromCar(trains.get(0).getCars().get(1)), 0, 0);
    }

}