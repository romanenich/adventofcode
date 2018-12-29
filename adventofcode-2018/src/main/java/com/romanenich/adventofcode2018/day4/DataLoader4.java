package com.romanenich.adventofcode2018.day4;

import com.romanenich.AbstractDataLoader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataLoader4 extends AbstractDataLoader<Data4> {

    private final static String SPLITERATOR = "\\[|\\]";
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    DataLoader4(String filePath) {
        super(filePath);
    }

    @Override
    protected Data4 convert(String line) {
        String[] parts = line.split(SPLITERATOR);
        LocalDateTime dateTime = LocalDateTime.parse(parts[1], formatter);
        String typeId = parts[2].trim();
        Data4.TYPE type;
        if ("wakes up".equalsIgnoreCase(typeId)){
            return new Data4(dateTime, Data4.TYPE.WAKES_UP);
        } else if ("falls asleep".equalsIgnoreCase(typeId)){
            return new Data4(dateTime, Data4.TYPE.FALLS_ASLEEP);
        } else {
            //Guard #10 begins shift
            String[] split = typeId.split("\\s+");
            type = Data4.TYPE.SHIFT_BEGINS;
            Integer guardId =  Integer.valueOf(split[1].substring(1));
            return new Data4(guardId, dateTime, Data4.TYPE.SHIFT_BEGINS);
        }
    }
}
