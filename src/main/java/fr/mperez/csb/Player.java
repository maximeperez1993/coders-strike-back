package fr.mperez.csb;

import fr.mperez.csb.math.Geometry;
import fr.mperez.csb.math.Physics;

import java.util.Scanner;

public class Player {

    public static void main(String[] args) {
        GameReader gameReader = new GameReader(new Scanner(System.in));
        gameReader.readInit();

        while (true) {
            TurnState state = gameReader.readTurn();
            Engine engine = new Engine();
            engine.update(state.getMyCars()[0]);
            engine.update(state.getMyCars()[1]);
        }
    }
}
