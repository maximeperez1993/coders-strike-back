package fr.mperez.csb;

import java.util.Scanner;

public class Player {

    public static void main(String[] args) {
        GameReader gameReader = new GameReader(new Scanner(System.in));
        gameReader.readInit();

        while (true) {
            TurnState state = gameReader.readTurn();
            CarManager car1Manager = new CarManager(state.getMyCars()[0]);
            car1Manager.update();


            CarManager car2Manager = new CarManager(state.getMyCars()[1]);
            car2Manager.update();
        }
    }
}
