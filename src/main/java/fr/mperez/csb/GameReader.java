package fr.mperez.csb;

import fr.mperez.csb.game.car.Car;
import fr.mperez.csb.game.car.CarBuilder;
import fr.mperez.csb.math.Geometry;
import fr.mperez.csb.math.Physics;
import fr.mperez.csb.math.Point;
import fr.mperez.csb.math.PointReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameReader {

    private final Scanner in;
    private final PointReader pointReader;
    private List<Point> checkpoints;

    public GameReader(Scanner in) {
        this.in = in;
        this.pointReader = new PointReader(in);
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
        Car[] myCars = new Car[]{readCar(), readCar()};
        Car[] hisCars = new Car[]{readCar(), readCar()};

        return new TurnState(myCars, hisCars);
    }

    private Car readCar() {
        return new CarBuilder()
                .setPoint(pointReader.read())
                .setVelocity(pointReader.read())
                .setAngle(in.nextInt())
                .setCheckpoint(this.checkpoints.get(in.nextInt()))
                .build();
    }


}
