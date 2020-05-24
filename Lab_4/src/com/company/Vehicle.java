package com.company;

import java.util.ArrayList;

public abstract class Vehicle<T>
{
    int id;
    private static int idCountner;
    private int seats;
    protected ArrayList<T> passengers = new ArrayList<>();

    Vehicle(int seats) //конструктор
    {
        this.id = idCountner;
        idCountner++;
        this.seats = seats;
    }

    public int getSeats()
    {
        return seats;
    }

    boolean addPassenger(T person)
    {
        boolean flag = false;

        if(passengers.size() == getSeats())
        {
            throw new PassengerException("EXCEPTION: Усі місця зайняті");
        }
        else if(((Person)person).inCar)
        {
            throw new PassengerException("EXCEPTION: Пасажир (ID = " + ((Person)person).getID() + ") уже у танспортному засобі");
        }
        else
        {
            ((Person)person).inCar = true;
            passengers.add((T)person);
            flag = true;
        }

        return flag;
    }

    boolean disembarkPassenger(int personID)
    {
        boolean flag = false;

        Person person = findPersonByID(personID);

        if(person != null)
        {
            person.inCar = false;
            passengers.remove(person);
            flag = true;
        }
        else
            throw new PassengerException("EXCEPTION: Пасажира (ID = " + personID + ") не знайдено");

        return flag;
    }

    Person findPersonByID(int personID)
    {
        for (Person person: (ArrayList<Person>)passengers)
        {
            if(person.getID() == personID)
                return person;
        }

        return null;

    }

    public int getBusy()
    {
        return this.passengers.size();
    }
}
