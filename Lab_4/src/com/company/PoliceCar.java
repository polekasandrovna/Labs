package com.company;

public class PoliceCar<T extends Policeman> extends Car<T> {
    PoliceCar(int seats)
    {
        super(seats); //используем для вызова конструктора суперкласса и для обращения к члену суперкласса, скрытому членом подкласса.
    }  //ключевое слово

        @Override //аннотация @Override указывает, что далее мы собираемся переопределять метод базового класса
    public boolean addPassenger(T person)
    {
        return super.addPassenger(person);
    }
}
