package net.heletz.EcoSim;

/**
 * Created by Sureynix on 2/21/17.
 */
public class Animal
{
    private String name;
    private int xpos;
    private int ypos;

    public Animal(String name, int initX, int initY)
    {
        this.setName(name);
        xpos=initX;
        ypos=initY;
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

    public int getXpos()
    {
        return xpos;
    }

    public int getYpos()
    {
        return ypos;
    }

    public void setYpos(int ypos)
    {
        this.ypos=ypos;
    }

    public void setXpos(int xpos)
    {
        this.xpos=xpos;
    }

}

