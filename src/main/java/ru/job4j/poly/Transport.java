package ru.job4j.poly;

public interface Transport {
    void go();

    void passenger(int pass);

    double gas(double amountOFfuel, double price);
}
