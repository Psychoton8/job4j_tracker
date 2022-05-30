package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends Pizza {
    private static final String CHEESETOMATO = " +  extra cheese + extra tomato";

    @Override
    public String name() {
        return super.name() + CHEESETOMATO;
    }
}
