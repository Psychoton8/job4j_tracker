package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    private static final String CHEESETOMATO = " + extra tomato";

    @Override
    public String name() {
        return super.name() + CHEESETOMATO;
    }
}
