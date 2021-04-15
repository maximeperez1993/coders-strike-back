package fr.mperez.csb;

import fr.mperez.csb.game.car.CarBuilder;
import fr.mperez.csb.game.checkpoint.CheckpointBuilder;
import fr.mperez.csb.math.Point;
import fr.mperez.csb.math.PointReader;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameReader {

    private final Scanner in;
    private final PointReader pointReader;

    public GameReader(Scanner in) {
        this.in = in;
        this.pointReader = new PointReader(in);
    }

    public void readInit(){
        int laps = in.nextInt();
        int checkpointCount = in.nextInt();
        List<Point> checkpoints = IntStream.range(0,checkpointCount)
                .mapToObj(i -> pointReader.read())
                .collect(Collectors.toList());

    }
    public TurnState readTurn() {
        CarBuilder myCarBuilder = new CarBuilder();
        CarBuilder hisCarBuilder = new CarBuilder();
        CheckpointBuilder checkpointBuilder = new CheckpointBuilder();

        myCarBuilder.setPoint(pointReader.read());

        checkpointBuilder.setPoint(pointReader.read());

        myCarBuilder.setCheckpointDistance(in.nextInt()).setCheckpointAngle(in.nextInt());

        hisCarBuilder.setPoint(pointReader.read());

        return new TurnState(myCarBuilder.build(), hisCarBuilder.build(), checkpointBuilder.build());
    }


}
