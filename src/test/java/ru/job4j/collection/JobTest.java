package ru.job4j.collection;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByNameAndPriority2() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Buy", 0),
                new Job("Again", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorAscByName() {
        Comparator<Job> cmpAscByName = new JobAscByName();
        int rsl = cmpAscByName.compare(
                new Job("Call friend", 0),
                new Job("Buy fruit", 3)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorAscByPriority() {
        Comparator<Job> cmpAscByPriority = new JobAscByPriority();
        int rsl = cmpAscByPriority.compare(
                new Job("Hello world", 0),
                new Job("Again", 5)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorDescByName() {
        Comparator<Job> cmpDescByName = new JobAscByName();
        int rsl = cmpDescByName.compare(
                new Job("Call friend", 1),
                new Job("Buy fruit", 3)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorDescByPriority() {
        Comparator<Job> cmpDescByPriority = new JobDescByPriority();
        int rsl = cmpDescByPriority.compare(
                new Job("Hello world", 4),
                new Job("Again", 5)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}