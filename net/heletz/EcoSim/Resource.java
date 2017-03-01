package net.heletz.EcoSim;

import java.util.ArrayList;

/**
 * Created by Moshe on 2/26/2017.
 */
public class Resource {
    private String type;
    private String name;
    private ArrayList<String> acceptableAnimals = new ArrayList<String>();
    private int energy;
    private int xPos;
    private int yPos;
    private boolean life = true;
    public Resource(String initType, String initName, int initEnergy, int xPosition, int yPosition) {
        type = initType;
        name = initName;
        energy = initEnergy;
        xPos = xPosition;
        yPos = yPosition;

    }
    public String getName()
    {
        return name;
    }
    public String getType(){
        return "";
    }//child should override
    public int getxPos()
    {
        return xPos;
    }
    public int getyPos()
    {
        return yPos;
    }
    public int getEnergy()
    {
        return energy;
    }
    public void setDead() {
        life = false;
    }
    public boolean getLifeStatus () {
        return life;
    }
    public void addAnimal (String string) {
        acceptableAnimals.add(string);
    }
    public boolean isAcceptable (String string) {
        for(int i = 0; i < acceptableAnimals.size(); i ++) {
            if (string == acceptableAnimals.get(i)) return true;
        }
        return false;
    }
}
