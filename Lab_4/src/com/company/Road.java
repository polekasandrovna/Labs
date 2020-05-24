package com.company;

import java.util.ArrayList;

public class Road
{
    public ArrayList<Vehicle> carsInRoad = new ArrayList<>();

    public int getCountOfHumans()
    {
        int countOfHumans = 0;

        for(Vehicle el: carsInRoad)
        {
            countOfHumans += el.getBusy();
        }

        return countOfHumans;
    }

    public void addCarToRoad(Vehicle cars)
    {
        carsInRoad.add(cars);
    }
}
