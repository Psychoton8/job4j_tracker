package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemAscByNameTest {

    @Test
    void whenSortedUp() {
        List<Item> items = Arrays.asList(
                new Item(1, "abcde"),
                new Item(3, "qrstuv"),
                new Item(2, "klmnop"),
                new Item(4, "fghij")
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(1, "abcde"),
                new Item(4, "fghij"),
                new Item(2,"klmnop"),
                new Item(3, "qrstuv")
        );
        assertThat(items).isEqualTo(expected);
    }
}