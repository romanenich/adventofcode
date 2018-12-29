package com.romanenich.adventofcode2018.day4;

import com.romanenich.Data;

import java.time.LocalDateTime;
import java.util.Objects;

class Data4 implements Data, Comparable<Data4> {

    private Integer guardId;
    private LocalDateTime dateTime;
    private TYPE type;

    public Data4(LocalDateTime dateTime, TYPE type) {
        this.dateTime = dateTime;
        this.type = type;
    }

    public Data4(Integer guardId, LocalDateTime dateTime, TYPE type) {
        this.guardId = guardId;
        this.dateTime = dateTime;
        this.type = type;
    }

    public Integer getGuardId() {
        return guardId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public TYPE getType() {
        return type;
    }

    @Override
    public int compareTo(Data4 o) {
        return dateTime.compareTo(o.dateTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data4 data4 = (Data4) o;
        return Objects.equals(guardId, data4.guardId) &&
                Objects.equals(dateTime, data4.dateTime) &&
                type == data4.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(guardId, dateTime, type);
    }

    @Override
    public String toString() {
        return "Data4{" +
                "guardId=" + guardId +
                ", dateTime=" + dateTime +
                ", type=" + type +
                '}';
    }

    public static enum TYPE {
        WAKES_UP, FALLS_ASLEEP, SHIFT_BEGINS
    }


}
