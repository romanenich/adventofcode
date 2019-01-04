package com.romanenich.adventofcode2018.day6;

import com.romanenich.AbstractDataLoader;

/**
 * Created by Roman on 04.01.2019.
 */
public class DataLoader6 extends AbstractDataLoader<Point> {

    public DataLoader6(String filePath) {
        super(filePath);
    }

    @Override
    protected Point convert(String line) {

        String[] split = line.split(",");

        return new Point(Integer.valueOf(split[0].trim()), Integer.valueOf(split[1].trim()));
    }
}
