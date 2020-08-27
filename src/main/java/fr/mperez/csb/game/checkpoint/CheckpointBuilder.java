package fr.mperez.csb.game.checkpoint;

import fr.mperez.csb.math.Point;

public class CheckpointBuilder {
    private Point point;

    public CheckpointBuilder setPoint(Point point) {
        this.point = point;
        return this;
    }

    public Checkpoint build() {
        return new Checkpoint(point);
    }
}