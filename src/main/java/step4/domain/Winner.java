package step4.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Winner {
    private List<RacingCar> winners;

    public Winner(Cars cars){
        this.winners = pickWinners(cars);
    }

    public List<RacingCar> pickWinners(Cars cars){
        List<RacingCar> racingCars = cars.getRacingCars();
        //우승자의 최대 position value 찾기
        int max = racingCars.stream()
                .map(RacingCar::getPosition)
                .mapToInt(Position::getPosition)
                .max()
                .getAsInt();

        List<RacingCar> winners = racingCars.stream()
                .filter(car -> {
                    Position position = car.getPosition();
                    return position.getPosition() == max;
                }).collect(Collectors.toList());

        return winners;
    }

    public List<RacingCar> getWinner(){
        return Collections.unmodifiableList(this.winners);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Winner)){
            return false;
        }
        Winner winner = (Winner) obj;
        return Objects.equals(this.winners, winner.getWinner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.winners);
    }
}
