package com.company;

public class Bus<T extends Person> extends Vehicle<T>
{
    Bus(int seats)
    {
        super(seats);
    }
}
