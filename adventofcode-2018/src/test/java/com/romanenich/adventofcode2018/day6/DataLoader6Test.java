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
        List<Data6> data6s = dataLoader6.loadData();
        assertEquals(6, data6s.size());
        assertEquals(new Data6(1,1), data6s.get(0));
        assertEquals(new Data6(8,9), data6s.get(5));
    }
}