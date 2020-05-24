package com.company;

import com.google.gson.Gson;
import groovy.transform.Immutable;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

@Immutable
public final class Person
{
    public String name;
    public int age;
    public Gender gender;
    private static String jsonPath = "C:\\";

    public Person(String name, int age, Gender gender)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
            return true;

        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Person person = (Person)obj;

        return age == person.age && jsonPath != null && gender == person.gender
                && (name == person.name || (person.name != null && name != null && name.equals(person.name)));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());

        return result;
    }

    public static void setJsonPath(String path)
    {
        jsonPath = path;
    }

    public static String getJsonPath()
    {
        return jsonPath;
    }

    public boolean ToJson(String path)
    {
        boolean flag;
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter(jsonPath + path))
        {
            gson.toJson(this, writer);
            flag = true;
        }
        catch (IOException ex)
        {
            flag = false;
            System.out.println(ex.getMessage());
        }

        return flag;
    }

    public String ToJson()
    {
        Gson gson = new Gson();

        String str = gson.toJson(this);

        return str;
    }

    public static Person FromJson(String str)
    {
        Gson gson = new Gson();
        Person person = null;

        if(str.endsWith(".json"))
        {
            try (Reader reader = new FileReader(jsonPath + str))
            {
                person = gson.fromJson(reader, Person.class);
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        else
        {
            try
            {
                person = gson.fromJson(str, Person.class);
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }

        return person;
    }
}

enum Gender
{
    MALE,
    FEMALE
}
