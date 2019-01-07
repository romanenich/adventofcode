package com.romanenich.adventofcode2018.day6;

import java.util.List;

public class Solution6 {

    private final static String FILE_PATH = "com.romanenich/adventofcode2018/day6/input6.txt";

    public static void main(String[] args) {
        DataLoader6 dataLoader6 = new DataLoader6(FILE_PATH);
        List<Point> points = dataLoader6.loadData();

        PointsInfo pointsInfo = new PointsInfo(points);
        Square square = pointsInfo.getSquare();
        Point largestPoint = pointsInfo.getLargestPoint(square);
        System.out.println("1. The size of the largest area is " + largestPoint.area());
        System.out.println("2. The size of the region containing all locations which have a total distance to all given coordinates of less than 10000 " + pointsInfo.getSafeRegionSize(10000, square));
    }
}
