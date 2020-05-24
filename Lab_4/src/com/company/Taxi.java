package com.company;

public class Taxi<T extends Person> extends Car<T>
{
    Taxi(int seats)
    {
        super(seats);
    }
}
