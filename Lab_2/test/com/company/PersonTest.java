package com.company;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class PersonTest {

    Person person, newperson;
    boolean result;

    @Before
    public void setUp()
    {
        Person.setJsonPath(new File("json\\").getAbsolutePath() + "\\");
        person = new Person("Max", 20, Gender.MALE);
        newperson = null;
        result = false;
    }

    @Test
    public void equals()
    {
        EqualsVerifier.forClass(Person.class).verify();
    }

    @Test
    public void equalsAfterJson()
    {
        if(person.ToJson("test.json"))
            newperson = Person.FromJson("test.json");

        result = person.equals(newperson);

        assertTrue(result);
    }

    @Test
    public void ToJson1()
    {
        result = person.ToJson("test.json");

        assertTrue(result);
    }

    @Test
    public void ToJson2()
    {
        String str = person.ToJson();

        assertNotNull(str);
    }

    @Test
    public void FromJson1()
    {
        person.ToJson("test.json");
        newperson = Person.FromJson("test.json");

        result = (newperson.getClass() == person.getClass() && newperson != null);

        assertTrue(result);
    }

    @Test
    public void FromJson2()
    {
        String str = person.ToJson();
        newperson = Person.FromJson(str);

        result = (newperson.getClass() == person.getClass() && newperson != null);

        assertTrue(result);
    }
}