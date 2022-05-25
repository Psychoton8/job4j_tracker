package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends Pizza {
    private static final String CHEESETOMATO = " +  extra cheese + extra tomato";

    public PizzaExtraCheeseExtraTomato(String name) {
        super(name);
    }

    public PizzaExtraCheeseExtraTomato() {
    }

    @Override
    public String name() {
        return super.name() + CHEESETOMATO;
    }
}
