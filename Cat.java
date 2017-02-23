package net.heletz.EcoSim;

/**
 * Created by Sureynix on 2/22/17.
 */
public class Cat extends Animal {
    public Cat (String name, int initX, int initY) {
        super(name, initX, initY);
    }
    @Override
    public void move(int x, int y) {
        x*=2;
        y*=2;
        setXpos(getXpos() + x);
        setYpos(getYpos() + y);
    }
}
