package net.heletz.EcoSim;

/**
 * Created by Sureynix on 2/22/17.
 */
public class Cat extends Animal {
    public Cat (String name, int initX, int initY, int energy) {
        super(name, initX, initY, energy);
    }
    @Override
    public void move(int x, int y) {
        x*=2;
        y*=2;
        setxPos(getxPos() + x);
        setyPos(getyPos() + y);
    }
    @Override
    public String getType () {
        return "Cat";
    }
}
