package com.company;

public class Main
{
    public static void main(String[] args)
    {
        try {
            Road road = new Road();

            Policeman police = new Policeman();
            Fireman fireman = new Fireman();

            PoliceCar policeCar = new PoliceCar(2);
            Taxi taxi = new Taxi(1);
            Bus bus = new Bus(2);
            FireTruck fireCar = new FireTruck(1);

            System.out.println(fireCar.addPassenger(fireman));
            //System.out.println(fireCar.addPassenger(police)); // Exception

            policeCar.addPassenger(police);
            taxi.addPassenger(police); // Exception
            policeCar.disembarkPassenger(police.getID());
            taxi.addPassenger(police);


            road.addCarToRoad(policeCar);
            road.addCarToRoad(taxi);
            road.addCarToRoad(bus);
            road.addCarToRoad(fireCar);

            System.out.println(road.getCountOfHumans());
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}
