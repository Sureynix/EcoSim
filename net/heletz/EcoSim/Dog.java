package net.heletz.EcoSim;

/**
 * Created by Sureynix on 2/22/17.
 */
public class Dog extends Animal {
    public Dog (String name, int initX, int initY) {
        super(name, initX, initY);
    }
    @Override
    public void move(int x, int y) {
        x--;
        y--;
        setxPos(getxPos() + x);
        setyPos(getyPos() + y);
    }
    @Override
    public String getType () {
        return "Dog";
    }
}
