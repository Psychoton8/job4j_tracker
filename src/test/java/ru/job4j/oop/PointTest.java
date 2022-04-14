package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void when00To10To00Then1() {
        int expected = 1;
        Point c = new Point(0, 1, 0);
        Point d = new Point(0, 0, 0);
        double dist = c.distance3d(d);
        Assert.assertEquals(expected, dist, 0.01);
    }

    @Test
    public void when01To01To01Then() {
        double expected = 1.41;
        Point c = new Point(0, 0, 0);
        Point d = new Point(1, 1, 1);
        double dist = c.distance(d);
        Assert.assertEquals(expected, dist, 0.01);
    }

}