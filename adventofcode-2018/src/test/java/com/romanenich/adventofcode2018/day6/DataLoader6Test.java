package com.romanenich.adventofcode2018.day6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataLoader6Test {

    private final static String FILE_PATH = "com.romanenich.adventofcode2018/day6/input6Test.txt";
    private DataLoader6 dataLoader6;

    @BeforeEach
    void setUp() {
        dataLoader6 = new DataLoader6(FILE_PATH);
    }

    @Test
    void convert() {
        List<Point> points = dataLoader6.loadData();
        assertEquals(6, points.size());
        assertEquals(new Point(1,1), points.get(0));
        assertEquals(new Point(8,9), points.get(5));
    }
}