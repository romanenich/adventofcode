package com.romanenich.adventofcode2018.day4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface Info {

    Long getAsleepMinutes();

    /**
     * @return Minute when guard sleeps frequently
     */
    LocalTime getMinute();

    /**
     * @return count of sleeping during the frequently sleeping minute
     */
    Integer getMaxSleepCount();

    /**
     * @param startSleep when guard starts sleeping (inclusive)
     * @param endSleep  when guard finishes sleeping (exclusive)
     */
    void add(LocalDateTime startSleep, LocalDateTime endSleep);

}
