package com.romanenich.adventofcode2018.day6;

public interface Info {
    Square getSquare();

    Point getLargestPoint(Square square);

    int getSafeRegionSize(int maxDistance, Square square);
}
