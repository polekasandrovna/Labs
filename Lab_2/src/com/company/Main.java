package com.company;

import java.io.*;

public class Main
{

    public static void main(String[] args)
    {
        Person.setJsonPath(new File("json\\").getAbsolutePath() + "\\");

        Person tom = new Person("Tom", 20, Gender.MALE);
        Person ann = new Person("Ann", 20, Gender.FEMALE);

        tom.ToJson("test.json");
        Person ntom = Person.FromJson("test.json");

        String str = tom.ToJson();
        Person nntom = Person.FromJson(str);

        comparePersons(tom, ntom);
        comparePersons(tom, nntom);
        comparePersons(tom, ann);
    }

    public static void comparePersons(Person p1, Person p2)
    {
        System.out.print(p1.name + " i " + p2.name + " - ");
        if(p1.equals(p2))
            System.out.println("oднакові");
        else
            System.out.println("pізні");
    }
}
