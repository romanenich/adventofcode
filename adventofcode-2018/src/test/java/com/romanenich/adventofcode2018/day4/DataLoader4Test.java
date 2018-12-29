package com.romanenich.adventofcode2018.day4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DataLoader4Test {

    private final static String FILE_PATH = "com.romanenich.adventofcode2018/day4/input4Test.txt";

    private final static String BEGIN_SHIFT = "[1518-11-01 00:00] Guard #10 begins shift";
    private final static String FALLS_ASLEEP = "[1518-11-01 00:05] falls asleep";
    private final static String WAKES_UP = "[1518-11-01 00:25] wakes up";

    private DataLoader4 dataLoader;

    @BeforeEach
    void setUp() {
        dataLoader = new DataLoader4(FILE_PATH);
        final LocalDate of = LocalDate.of(1518, 11, 1);
    }

    @Test
    void testConvertBeginShift() {
        Data4 data4 = dataLoader.convert(BEGIN_SHIFT);
        assertEquals(10, data4.getGuardId().intValue());
        assertEquals(LocalDateTime.of(1518, 11, 1,0, 0), data4.getDateTime());
    }

    @Test
    void testConvertFallsAsleep() {
        Data4 data4 = dataLoader.convert(FALLS_ASLEEP);
        assertNull(data4.getGuardId());
        assertEquals(LocalDateTime.of(1518, 11, 1,0, 5), data4.getDateTime());
    }

    @Test
    void testConvertWakesUp() {
        Data4 data4 = dataLoader.convert(WAKES_UP);
        assertNull(data4.getGuardId());
        assertEquals(LocalDateTime.of(1518, 11, 1,0, 25), data4.getDateTime());
    }
}
