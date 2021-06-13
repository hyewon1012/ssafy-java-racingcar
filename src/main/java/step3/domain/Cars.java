package step3.domain;

import step3.strategy.MoveStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Cars {
    private static final int START_INDEX = 0;
    private final List<RacingCar> cars;

    public Cars(final int numberOfCar, List<RacingCar> cars){
        validateNumberOfCar(numberOfCar);
        this.cars = generateCars(numberOfCar, cars);
    }

    private List<RacingCar> generateCars(final int numberOfCar, List<RacingCar> cars) {
        IntStream.range(START_INDEX, numberOfCar)
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
        return this.cars;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(!(obj instanceof Cars)){
            return false;
        }
        Cars c = (Cars) obj;
        return Objects.equals(this.cars, c.getRacingCars());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cars);
    }
}
