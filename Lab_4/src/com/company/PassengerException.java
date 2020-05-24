package com.company;

public class PassengerException extends RuntimeException
{
    String text;

    PassengerException(String text)
    {
        super(text);
        this.text = text;
    }
}
