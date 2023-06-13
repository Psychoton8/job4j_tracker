package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemDescByNameTest {

    @Test
    void whenSortedDown() {
        List<Item> items = Arrays.asList(
                new Item(1, "Alla"),
                new Item(3, "Boris"),
                new Item(6, "Cello"),
                new Item(2, "Doctor")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(2, "Doctor"),
                new Item(6, "Cello"),
                new Item(3, "Boris"),
                new Item(1, "Alla")
        );
        assertThat(items).isEqualTo(expected);
    }
}