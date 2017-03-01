package net.heletz.EcoSim;

/**
 * Created by Moshe on 2/22/2017.
 */
public class PositionList {
    int x;
    int y;
    int e;
    public PositionList (int a, int b, int c) {
        x = a;
        y = b;
        e = c;
    }
    public int getX () {
        return x;
    }
    public int getY () {
        return y;
    }
    public int getE () {
        return e;
    }

}
