package com.romanenich.adventofcode2018.day4;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.MINUTES;

public class GuardInfo implements Comparable<GuardInfo>, Info {

    private Integer guardId;
    private Long asleepMinutes = 0L;
    private LocalTime maxMinute;
    private Integer maxMinuteCount = 0;
    private Map<LocalTime, Integer> minutesCount = new LinkedHashMap<>();

    @Override
    public LocalTime getMinute() {
        return maxMinute;
    }

    @Override
    public Integer getMaxSleepCount() {
        return maxMinuteCount;
    }

    @Override
    public void add(LocalDateTime startSleep, LocalDateTime endSleep) {
        asleepMinutes += Duration.between(startSleep, endSleep).toMinutes();
        LocalDateTime curTime = startSleep;
        while (curTime.compareTo(endSleep) < 0) {
            Integer curCount = minutesCount.get(curTime.toLocalTime());

            curCount = curCount == null ? 1 : ++curCount;

            if (maxMinute == null) {
                maxMinute = curTime.toLocalTime();
                maxMinuteCount = 1;
            } else if (maxMinute != curTime.toLocalTime() && maxMinuteCount < curCount) {
                maxMinuteCount = curCount;
                maxMinute = curTime.toLocalTime();
            }

            minutesCount.put(curTime.toLocalTime(), curCount);

            curTime = curTime.plus(1, MINUTES);
        }
    }


    public GuardInfo(Integer guardId) {
        this.guardId = guardId;
    }

    public void add(Long minutes) {
        asleepMinutes += minutes;
    }

    public Integer getGuardId() {
        return guardId;
    }

    @Override
    public Long getAsleepMinutes() {
        return asleepMinutes;
    }

    @Override
    public int compareTo(GuardInfo o) {
        return asleepMinutes.compareTo(o.asleepMinutes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuardInfo guardInfo = (GuardInfo) o;
        return Objects.equals(guardId, guardInfo.guardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guardId);
    }

    @Override
    public String toString() {
        return "GuardInfo{" +
                "guardId=" + guardId +
                ", asleepMinutes=" + asleepMinutes +
                ", maxMinute=" + maxMinute +
                ", maxMinuteCount=" + maxMinuteCount +
                ", minutesCount=" + minutesCount +
                '}';
    }
}
