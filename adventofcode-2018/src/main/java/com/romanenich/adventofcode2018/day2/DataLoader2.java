package com.romanenich.adventofcode2018.day2;

import com.romanenich.AbstractDataLoader;

/**
 * Created by Roman on 23.12.2018.
 */
class DataLoader2 extends AbstractDataLoader<Data2> {

    DataLoader2(String filePath) {
        super(filePath);
    }

    @Override
    protected Data2 convert(String line) {
        return new Data2(line);
    }
}
