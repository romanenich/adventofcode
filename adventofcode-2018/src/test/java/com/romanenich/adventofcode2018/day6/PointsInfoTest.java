package com.romanenich.adventofcode2018.day6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PointsInfoTest {

    private Square expectedSquare;
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
        expectedSquare = new Square(1, 8, 1,9 );
        pointsInfo = new PointsInfo(points);
    }

    @Test
    void getSquare() {
        Square square = pointsInfo.getSquare();
        assertEquals(expectedSquare, square);
    }

    @Test
    void getLargestPoint() {
        Square square = pointsInfo.getSquare();
        Point largestPoint = pointsInfo.getLargestPoint(expectedSquare);
        System.out.println(largestPoint.area());
        assertEquals(5, largestPoint.getX());
        assertEquals(5, largestPoint.getY());
    }

    @Test
    void testGetSafeRegionSize() {
        assertEquals(16, pointsInfo.getSafeRegionSize(32, expectedSquare));

    }
}