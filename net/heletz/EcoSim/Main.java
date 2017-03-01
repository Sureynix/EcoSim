package net.heletz.EcoSim;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Sureynix on 2/21/17.
 */
public class Main
{

    //Create animal instances
    private static Animal d;
    private static Animal c;
    private static Scanner in = new Scanner(System.in);
    private static ArrayList<PositionList> catList = new ArrayList<PositionList>();
    private static ArrayList<PositionList> dogList = new ArrayList<PositionList>();
    private static ArrayList<Resource> resourcesList = new ArrayList<Resource>();


    public static void main(String args[])
    {
        boolean run = true;
        while (run == true) {

            System.out.println("How many moves would you like to make? (int)");
            int ticks = in.nextInt();
            if (ticks <= 0) {System.out.println("Number of ticks must be higher than zero; please try again.");}
            else {
                setUp();
                tick(ticks);
                printAnimalUpdate();
                run = false;
            }

        }
    }

    /**
     * setUp initializes all animal instances and prints init states
     */
    public static void setUp()
    {
        System.out.println("Please enter a single word name for the dog:");
        String dogName = in.next();
        System.out.println("Please enter a single word name for the cat:");
        String catName = in.next();
        c = new Cat(catName, 0, 0, 100);
        d = new Dog(dogName, 0, 0, 100);
        System.out.println("Initial Positions: " +
                "\n" + d.getType() + " " + d.getName() + "(" + d.getxPos() + "," + " " + d.getyPos() + ") "
        + d.getEnergy() + "\n" + c.getType() + " " + c.getName() + "(" + c.getxPos() + "," + " " + c.getyPos() + ") " + c.getEnergy());
        dogList.add(new PositionList(d.getxPos(), d.getyPos(), d.getEnergy()));
        catList.add(new PositionList(c.getxPos(), c.getyPos(), c.getEnergy()));
        PetFood apple = new PetFood("Food", "Apple", 15, 2, 2);
        resourcesList.add(apple);
        System.out.println(c.getType());
        apple.addAnimal(c.getType());
        apple.addAnimal(d.getType());

    }

    /**
     * Calls any simulation update methods for the number of ticks specified by numOfTicks
     * Prints "OVERLAP!!!" if the animals are on the same x and y position
     * @param numOfTicks
     *
     */
    public static void tick(int numOfTicks)
    {
        for (int i = 0; i < numOfTicks; i++) {
            System.out.println("Please enter x coordinate move: (int)");
            int xMove = in.nextInt();
            System.out.println("Please enter y coordinate move: (int)");
            int yMove = in.nextInt();
            c.move(xMove, yMove);
            d.move(xMove, yMove);
            if (d.getyPos() == c.getyPos() && c.getxPos() == d.getxPos()) {
                System.out.println("Overlap!");
            }
            d.setEnergy(d.getEnergy() - (xMove / 2));
            System.out.println(d.getEnergy());
            c.setEnergy(c.getEnergy() - (xMove / 2));
            TrackForResources(c);
            TrackForResources(d);
            dogList.add(new PositionList(d.getxPos(), d.getyPos(), d.getEnergy()));
            catList.add(new PositionList(c.getxPos(), c.getyPos(), c.getEnergy()));
            System.out.println("Current Positions: " +
                    "\n" + d.getType() + " " + d.getName() + "(" + d.getxPos() + "," + " " + d.getyPos() + ") " + d.getEnergy()
                    + "\n" + c.getType() + " " + c.getName() + "(" + c.getxPos() + "," + " " + c.getyPos() + ") " + c.getEnergy());
            if (c.getEnergy() <= 0 || d.getEnergy() <= 0) {
                System.out.println("Game Over!");
                break;
            }
        }


    }

    /**
     * Print the type, name, xpos, and ypos of Animal a
     */
    public static void printAnimalUpdate()
    {
        System.out.println("\n");
        System.out.println("Your moves:");
        for (int i = 0; i < dogList.size(); i++) {
            System.out.println("Tick " + i + ":");
            System.out.println(
                    d.getType() + " " + d.getName() + "(" + dogList.get(i).getX() + "," + " " + dogList.get(i).getY() + ") " + dogList.get(i).getE()
                    + "\n" + c.getType() + " " + c.getName() + "(" + catList.get(i).getX() + "," + " " + catList.get(i).getY() + ") " + catList.get(i).getE());
        }
    }
    public static void TrackForResources (Animal animal) {
        for (int i = 0; i < resourcesList.size(); i++) {

            if (animal.getxPos() == resourcesList.get(i).getxPos() && animal.getyPos() == resourcesList.get(i).getyPos() && resourcesList.get(i).isAcceptable(animal.getType()) && resourcesList.get(i).getLifeStatus()) {
                animal.setEnergy(animal.getEnergy() + resourcesList.get(i).getEnergy());
                System.out.println("Resource name of " + resourcesList.get(i).getName() + " and type " + resourcesList.get(i).getType() + " has given "
                + resourcesList.get(i).getEnergy() + " energy. \nYour animal " + animal.getType() + " now has " + animal.getEnergy() + " energy. ");
                resourcesList.get(i).setDead();
            }
        }
    }

}