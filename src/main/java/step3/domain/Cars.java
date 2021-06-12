package step3.domain;

import step3.strategy.MoveStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Cars {
    private final List<RacingCar> cars;

    public Cars(final int numberOfCar, List<RacingCar> cars){
        validateNumberOfCar(numberOfCar);
        this.cars = generateCars(numberOfCar, cars);
    }

    private List<RacingCar> generateCars(final int numberOfCar, List<RacingCar> cars) {
        IntStream.range(0, numberOfCar)
                .forEach(count -> cars.add(new RacingCar()));
        return cars;
    }

    public void move(MoveStrategy moveStrategy){
        cars.stream().forEach(car -> car.move(moveStrategy));
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
