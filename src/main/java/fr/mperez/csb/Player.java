package fr.mperez.csb;

import fr.mperez.csb.math.Geometry;

import java.util.Scanner;

public class Player {

    public static void main(String[] args) {
        GameReader gameReader = new GameReader(new Scanner(System.in));
        Geometry geometry = new Geometry();

        while (true) {
            GameState state = gameReader.read();
            Engine engine = new Engine(state, geometry);
            engine.update();
        }
    }
}
