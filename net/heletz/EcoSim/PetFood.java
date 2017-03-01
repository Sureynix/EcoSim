package net.heletz.EcoSim;

/**
 * Created by Moshe on 2/26/2017.
 */
public class PetFood extends Resource {
    public PetFood (String initType, String initName, int initEnergy, int xPosition, int yPosition) {
        super(initType, initName, initEnergy, xPosition, yPosition);
    }
    @Override
    public String getType () {
        return "Pet Food";
    }

}
