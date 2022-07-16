package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void go() {
        System.out.println("Let's go!");
    }

    @Override
    public void passenger(int pass) {
        System.out.println("Number of passengers is " + pass);
    }

    @Override
    public double gas(double amountOffuel, double price) {
        return price * amountOffuel;
    }
}
