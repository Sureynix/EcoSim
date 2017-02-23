package net.heletz.EcoSim;

/**
 * Created by Sureynix on 2/21/17.
 */
public class Animal
{
    private String name;
    private int xPos;
    private int yPos;

    public Animal(String name, int initX, int initY)
    {
        this.setName(name);
        xPos =initX;
        yPos =initY;
    }
    public void move(int x, int y){}//child should override

    public String getType(){
        return "";
    }//child should override

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public int getxPos()
    {
        return xPos;
    }

    public int getyPos()
    {
        return yPos;
    }

    public void setyPos(int yPos)
    {
        this.yPos = yPos;
    }

    public void setxPos(int xPos)
    {
        this.xPos = xPos;
    }

}

