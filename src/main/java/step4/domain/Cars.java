package step4.domain;

import step4.strategy.MoveStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Cars {
    private static final int START_INDEX = 0;
    private final List<RacingCar> cars;

    public Cars(final String[] carNames, List<RacingCar> cars){
        int numberOfCar = carNames.length;
        validateNumberOfCar(numberOfCar);
        this.cars = generateCars(carNames, cars);
    }

    private List<RacingCar> generateCars(final String[] carNames, List<RacingCar> cars) {
        int numberOfCar = carNames.length;
        IntStream.range(START_INDEX, numberOfCar)
                .forEach(idx -> cars.add(new RacingCar(carNames[idx])));
        return cars;
    }

    public void move(MoveStrategy moveStrategy){
        cars.stream().forEach(car -> car.move(moveStrategy));
    }

    private void validateNumberOfCar(final int numberOfCar) {
        if(numberOfCar < 1){
            throw new IllegalArgumentException("자동차는 1대 이상이어야 합니다.");
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
