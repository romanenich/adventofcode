package com.romanenich.adventofcode2018.day1;

import com.romanenich.AbstractDataLoader;

/**
 * Created by Roman on 23.12.2018.
 */
class DataLoader1 extends AbstractDataLoader<Data1> {

    DataLoader1(String filePath) {
        super(filePath);
    }

    @Override
    protected Data1 convert(String line) {
        return new Data1(Integer.valueOf(line));
    }
}
