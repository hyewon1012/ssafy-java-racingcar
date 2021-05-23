package step3.domain;

import step3.ui.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class RacingCar {
    private String trace = "";
    private final static String MARK = "-";

    public void move(){
        Random random = new Random();
        int step =  random.nextInt(10);

        StringBuilder sb = new StringBuilder(trace);
        if(step >= 4) {
            sb.append(MARK);
            this.trace = sb.toString();
        }
    }

    public String getTrace(){
        return trace;
    }
}
