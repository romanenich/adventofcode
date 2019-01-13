package com.romanenich.adventofcode2018.day7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataLoader7Test {

    private final static String FILE_PATH = "com.romanenich.adventofcode2018/day7/input7Test.txt";
    private DataLoader7 dataLoader7;

    @BeforeEach
    void setUp() {
        dataLoader7 = new DataLoader7(FILE_PATH);
    }

    @Test
    void testConvert() {
        List<Leg> legs = dataLoader7.loadData();
        assertEquals(7, legs.size());
        assertEquals(new Node("C"), legs.get(0).getFirst());
        assertEquals(new Node("A"), legs.get(0).getSecond());

        assertEquals(new Node("F"), legs.get(6).getFirst());
        assertEquals(new Node("E"), legs.get(6).getSecond());
    }
}