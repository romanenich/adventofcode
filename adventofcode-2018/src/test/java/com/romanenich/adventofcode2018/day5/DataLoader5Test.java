package com.romanenich.adventofcode2018.day5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataLoader5Test {

    private final static String FILE_PATH = "com.romanenich.adventofcode2018/day5/input5Test.txt";
    private DataLoader5 dataLoader5;

    @BeforeEach
    void setUp() {
        dataLoader5 = new DataLoader5(FILE_PATH);
    }

    @Test
    void testLoadData() {
        List<Data5> data5s = dataLoader5.loadData();
        assertEquals(1, data5s.size());
        assertEquals("VvbBfpPFrRyRrYNpYyPD", data5s.get(0).getValue());
    }
}