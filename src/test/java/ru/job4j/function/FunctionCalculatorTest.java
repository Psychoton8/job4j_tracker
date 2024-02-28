package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionCalculatorTest {

    @Test
    void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenQuadraticFunction() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 3, x -> 1 * x * x + 2 * x + 3);
        List<Double> expected = Arrays.asList(6D, 11D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenExponentialFunction () {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(4, 8, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(16D, 32D, 64D, 128D);
        assertThat(result).containsAll(expected);
    }
}