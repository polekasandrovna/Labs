package com.company;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class RoadTest
{
    Road road;
    Person fireman, policeman, person;
    Vehicle fireTruck, policeCar, taxi, bus;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception
    {
        road = new Road();

        fireman = new Fireman();
        policeman = new Policeman();
        person = new Person();

        fireTruck = new FireTruck(4);
        policeCar = new PoliceCar(1);
        taxi = new Taxi(1);
        bus = new Bus(10);
    }

    @Test
    public void getCountOfHumansTest()
    {
        fireTruck.addPassenger(fireman);                    // +1
        policeCar.addPassenger(policeman);                  // +1
        bus.addPassenger(person);                           // +1
        fireTruck.disembarkPassenger(fireman.getID());      // -1

        road.addCarToRoad(fireTruck);
        road.addCarToRoad(policeCar);
        road.addCarToRoad(taxi);
        road.addCarToRoad(bus);

        assertEquals(2, road.getCountOfHumans());
    }

    @Test
    public void AddTest()
    {
        assertTrue(fireTruck.addPassenger(fireman));
    }

    @Test(expected = RuntimeException.class)
    public void AddTest_Exception()
    {
        fireTruck.addPassenger(policeman);                     // поліцейський сідає у пожежну машину - Exception
    }

    @Test(expected = PassengerException.class)
    public void AddManyTest_Exception()
    {
        taxi.addPassenger(policeman);
        taxi.addPassenger(fireman);                            // Недостатньо місць - Exception
    }

    @Test
    public void DisembarkTest()
    {
        fireTruck.addPassenger(fireman);
        assertTrue(fireTruck.disembarkPassenger(fireman.getID()));
    }

    @Test(expected = PassengerException.class)
    public void DisembarkTest_Exception()
    {
        taxi.disembarkPassenger(person.getID());              // пасажира не було у таксі - Exception
    }
}