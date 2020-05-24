package com.company;

public class FireTruck<T extends Fireman> extends Car<T>
{
    FireTruck(int seats)
    {
        super(seats);
    }

    @Override
    public boolean addPassenger(T person)
    {
        return super.addPassenger(person);
    }
}
