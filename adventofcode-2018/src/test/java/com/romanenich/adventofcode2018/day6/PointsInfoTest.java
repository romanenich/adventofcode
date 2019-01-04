package com.romanenich.adventofcode2018.day6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PointsInfoTest {

    private List<Point> points;
    private PointsInfo pointsInfo;

    @BeforeEach
    void setUp() {
        points = Arrays.asList(
                new Point(1,1),
                new Point(1,6),
                new Point(8,3),
                new Point(3,4),
                new Point(5,5),
                new Point(8,9)
        );
        pointsInfo = new PointsInfo();
    }

    @Test
    void getSquare() {
        Square square = pointsInfo.getSquare(points);
        assertEquals(new Square(1, 8, 1,9 ), square);
    }
}