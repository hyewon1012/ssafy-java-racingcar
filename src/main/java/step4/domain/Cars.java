package step4.domain;

import step4.strategy.MoveStrategy;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private final List<RacingCar> cars;

    public Cars(final Names carNames){
        this.cars = generateCars(carNames);
    }

    private List<RacingCar> generateCars(final Names carNames) {
        return carNames.getNames().stream()
                .map(name -> new RacingCar(name))
                .collect(Collectors.toList());
    }

    public void move(MoveStrategy moveStrategy){
        cars.stream().forEach(car -> car.move(moveStrategy));
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(this.cars);
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
