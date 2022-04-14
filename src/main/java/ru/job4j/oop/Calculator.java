package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int z) {
        return z - x;
    }

    public int divide(int b) {
        return b / x;
    }

    public int sumAllOperation(int b, int a, int z, int y) {
        return divide(b) + minus(z) + multiply(a) + sum(y);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        int subtraction = Calculator.minus(14);
        System.out.println(subtraction);
        Calculator calc = new Calculator();
        int div = calc.divide(50);
        System.out.println(div);
        int sumAll = calc.sumAllOperation(50, 5, 14, 10);
        System.out.println(sumAll);
    }
}

