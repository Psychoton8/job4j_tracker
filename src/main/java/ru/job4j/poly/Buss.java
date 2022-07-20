package ru.job4j.poly;

public class Buss implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " is riding on the road.");
    }
}
