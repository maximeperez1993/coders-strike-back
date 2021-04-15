package fr.mperez.csb;

import fr.mperez.csb.math.Geometry;
import fr.mperez.csb.math.Physics;

import java.util.Scanner;

public class Player {

    public static void main(String[] args) {
        GameReader gameReader = new GameReader(new Scanner(System.in));
        Physics physics = new Physics();

        gameReader.readInit();

        TurnState previousState = null;
        while (true) {
            TurnState state = gameReader.readTurn();
            Engine engine = new Engine(state, previousState, physics);
            engine.update(state.getMyCars()[0]);
            engine.update(state.getMyCars()[1]);
            previousState = state;
        }
    }
}
