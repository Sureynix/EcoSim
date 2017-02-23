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
        c = new Cat(catName, 0, 0);
        d = new Dog(dogName, 0, 0);
        System.out.println("Initial Positions: " +
                "\n" + d.getType() + " " + d.getName() + "(" + d.getxPos() + "," + " " + d.getyPos() + ")"
        + "\n" + c.getType() + " " + c.getName() + "(" + c.getxPos() + "," + " " + c.getyPos() + ")");
        dogList.add(new PositionList(d.getxPos(), d.getyPos()));
        catList.add(new PositionList(c.getxPos(), c.getyPos()));
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
            dogList.add(new PositionList(d.getxPos(), d.getyPos()));
            catList.add(new PositionList(c.getxPos(), c.getyPos()));
            System.out.println("Current Positions: " +
                    "\n" + d.getType() + " " + d.getName() + "(" + d.getxPos() + "," + " " + d.getyPos() + ")"
                    + "\n" + c.getType() + " " + c.getName() + "(" + c.getxPos() + "," + " " + c.getyPos() + ")");
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
                    d.getType() + " " + d.getName() + "(" + dogList.get(i).getX() + "," + " " + dogList.get(i).getY() + ")"
                    + "\n" + c.getType() + " " + c.getName() + "(" + catList.get(i).getX() + "," + " " + catList.get(i).getY() + ")");
        }
    }
}