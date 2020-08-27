package fr.mperez.csb.math;

import java.util.Scanner;

public class PointReader {

    private final Scanner in;

    public PointReader(Scanner in) {
        this.in = in;
    }

    public Point read(){
        return new Point(in.nextInt(), in.nextInt());
    }
}
