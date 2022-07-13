package ru.job4j.poly;

public class Bus implements Transport{
    @Override
    public void go() {
    }

    @Override
    public int passenger() {
        return 0;
    }

    @Override
    public double gas(double price) {
        return price;
    }
}
