package fr.mperez.csb;

import fr.mperez.csb.game.car.CarBuilder;
import fr.mperez.csb.game.checkpoint.CheckpointBuilder;
import fr.mperez.csb.math.PointReader;

import java.util.Scanner;

public class GameReader {

    private final Scanner in;
    private final PointReader pointReader;

    public GameReader(Scanner in) {
        this.in = in;
        this.pointReader = new PointReader(in);
    }

    public GameState read() {
        CarBuilder myCarBuilder = new CarBuilder();
        CarBuilder hisCarBuilder = new CarBuilder();
        CheckpointBuilder checkpointBuilder = new CheckpointBuilder();

        myCarBuilder.setPoint(pointReader.read());

        checkpointBuilder.setPoint(pointReader.read());

        myCarBuilder.setCheckpointDistance(in.nextInt()).setCheckpointAngle(in.nextInt());

        hisCarBuilder.setPoint(pointReader.read());

        return new GameState(myCarBuilder.build(), hisCarBuilder.build(), checkpointBuilder.build());
    }


}
