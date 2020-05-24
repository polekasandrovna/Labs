package com.company;

public class Person
{
    private int ID;
    private static int idCountner;
    boolean inCar = false;

    Person()
    {
        this.ID = idCountner;
        idCountner++;
    }

    public int getID()
    {
        return ID;
    }
}
