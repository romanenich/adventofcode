package com.romanenich.adventofcode2018.day5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PolymerInfoTest {

    private final static String INPUT_STRING = "VvbBfpPFrRyRrYNpYyPD";
    private final static String EXPECTED_RESULT = "ND";

    private PolymerInfo polymerInfo;

    @BeforeEach
    void setUp() {
        polymerInfo = new PolymerInfo(INPUT_STRING);
    }

    @Test
    void getRemainUnits() {
        assertEquals(EXPECTED_RESULT.length(), polymerInfo.getRemainedPolymer().length());
    }

    @Test
    void getAdjustedString() {
        assertEquals("VvfpPFrRyRrYNpYyPD", polymerInfo.getAdjustedString(INPUT_STRING,1));
    }

    @Test
    void getRemainUnitsAdjustedInput() {
        assertEquals(1, polymerInfo.getRemainAdjustedPolymer(INPUT_STRING).length());
    }
}