package com.romanenich.adventofcode2018.day5;

import com.romanenich.AbstractDataLoader;

public class DataLoader5 extends AbstractDataLoader<Data5> {

    public DataLoader5(String filePath) {
        super(filePath);
    }

    @Override
    protected Data5 convert(String line) {
        return new Data5(line);
    }
}
