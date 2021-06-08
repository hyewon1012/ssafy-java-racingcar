package step3.domain;

import step3.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class CarsGenerator {
    private final List<RacingCar> cars;

    public CarsGenerator(final int numberOfCar, List<RacingCar> cars){
        validateNumberOfCar(numberOfCar);
        this.cars = new ArrayList<>(cars);
    }

    private void validateNumberOfCar(final int numberOfCar) {
        if(numberOfCar < 1){
            throw new IllegalArgumentException();
        }
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(this.cars);
    }
}
