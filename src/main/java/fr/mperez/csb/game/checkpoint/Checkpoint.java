package fr.mperez.csb.game.checkpoint;

import fr.mperez.csb.math.Point;

public class Checkpoint {

    private final Point point;

    public Checkpoint(Point point) {
        this.point = point;
    }

    public int getX() {
        return point.getX();
    }

    public int getY() {
        return point.getY();
    }
}
