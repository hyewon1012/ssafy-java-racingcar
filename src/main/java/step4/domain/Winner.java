package step4.domain;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Winner {
    private List<RacingCar> winners;

    public Winner(Cars cars){
        this.winners = pickWinners(cars);
    }

    public List<RacingCar> pickWinners(Cars cars){
        List<RacingCar> racingCars = cars.getRacingCars();
        //우승자의 최대 position value 찾기
        RacingCar racingCar = racingCars.stream()
                .max(Comparator.comparing(RacingCar::getPosition))
                .orElseThrow(NoSuchElementException::new);

        int max = racingCar.getPosition();

        List<RacingCar> winners = racingCars.stream()
                .filter(car -> car.getPosition() == max)
                .collect(Collectors.toList());

        return winners;
    }

    public List<RacingCar> getWinner(){
        return this.winners;
    }
}
