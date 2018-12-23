package com.romanenich.adventofcode2018.day3;

import com.romanenich.AbstractDataLoader;

import static sun.swing.MenuItemLayoutHelper.max;


class DataLoader3 extends AbstractDataLoader<Data3> {

    private static final String DELIMITERS = "[#@,:x]";

    private int maxX = 0;
    private int maxY = 0;

    DataLoader3(String filePath) {
        super(filePath);
    }

    int getMaxX() {
        return maxX;
    }

    int getMaxY() {
        return maxY;
    }

    @Override
    protected Data3 convert(String line) {
        //"#18 @ 383,79: 13x6"
        // should be the array like that [, 18 ,  383, 79,  13, 6]
        String[] values = line.split(DELIMITERS);

        maxX = max(maxX, Integer.valueOf(values[2].trim()) + Integer.valueOf(values[4].trim()));
        maxY = max(maxY, Integer.valueOf(values[3].trim()) + Integer.valueOf(values[5].trim()));

        return Data3.builder()
                .id(Integer.valueOf(values[1].trim()))
                .shiftLeft(Integer.valueOf(values[2].trim()))
                .shiftTop(Integer.valueOf(values[3].trim()))
                .width(Integer.valueOf(values[4].trim()))
                .tall(Integer.valueOf(values[5].trim()))
                .build();
    }

}
