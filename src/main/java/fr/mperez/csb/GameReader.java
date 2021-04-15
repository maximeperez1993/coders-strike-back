package fr.mperez.csb;

import fr.mperez.csb.game.car.Car;
import fr.mperez.csb.game.car.CarBuilder;
import fr.mperez.csb.math.Point;
import fr.mperez.csb.math.PointReader;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameReader {

    private final Scanner in;
    private final PointReader pointReader;
    private final Set<Integer> availableBoostCarIndex;
    private List<Point> checkpoints;

    public GameReader(Scanner in) {
        this.in = in;
        this.pointReader = new PointReader(in);
        this.availableBoostCarIndex = IntStream.range(0,4).boxed().collect(Collectors.toSet());
        this.checkpoints = new ArrayList<>();
    }

    public void readInit() {
        int laps = in.nextInt();
        int checkpointCount = in.nextInt();
        this.checkpoints = IntStream.range(0, checkpointCount)
                .mapToObj(i -> pointReader.read())
                .collect(Collectors.toList());
    }

    public TurnState readTurn() {
        Car[] myCars = new Car[]{readCar(0), readCar(1)};
        Car[] hisCars = new Car[]{readCar(2), readCar(3)};

        return new TurnState(myCars, hisCars);
    }

    private Car readCar(int carIndex) {
        boolean hasBoost = this.availableBoostCarIndex.contains(carIndex);
        return new CarBuilder()
                .setPoint(pointReader.read())
                .setVelocity(pointReader.read())
                .setAngle(in.nextInt())
                .setCheckpoint(this.checkpoints.get(in.nextInt()))
                .setHasBoost(hasBoost)
                .onBoost(() -> this.availableBoostCarIndex.remove(carIndex))
                .build();
    }


}
