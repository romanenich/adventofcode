package com.romanenich.adventofcode2018.day3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DataLoader3Test {

    private final static String FILE_PATH = "com.romanenich.adventofcode2018/day3/input3Test.txt";

    private Data3 claim1;
    private Data3 claim2;
    private Data3 claim3;
    private DataLoader3 dataLoader3;

//    ........
//    ...2222.
//    ...2222.
//    .11XX22.
//    .11XX22.
//    .111133.
//    .111133.
//    ........

    @BeforeEach
    void setUp() {
        dataLoader3 = new DataLoader3(FILE_PATH);

        claim1 = Data3.builder()
                .id(1)
                .shiftLeft(1)
                .shiftTop(3)
                .width(4)
                .tall(4)
                .build();

        claim2 = Data3.builder()
                .id(2)
                .shiftLeft(3)
                .shiftTop(1)
                .width(4)
                .tall(4)
                .build();

        claim3 = Data3.builder()
                .id(3)
                .shiftLeft(5)
                .shiftTop(5)
                .width(2)
                .tall(2)
                .build();
    }

    @Test
    void loadData() {
        List<Data3> loadData = dataLoader3.loadData();

        assertEquals(3, loadData.size());
        assertTrue(loadData.containsAll(Arrays.asList(claim1, claim2, claim3)));

        assertEquals(7, dataLoader3.getMaxX());
        assertEquals(7, dataLoader3.getMaxY());
    }

}