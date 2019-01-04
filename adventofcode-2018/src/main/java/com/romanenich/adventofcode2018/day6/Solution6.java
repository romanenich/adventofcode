package com.romanenich.adventofcode2018.day6;

import java.util.List;

public class Solution6 {

    private final static String FILE_PATH = "com.romanenich/adventofcode2018/day6/input6.txt";

    public static void main(String[] args) {
        DataLoader6 dataLoader6 = new DataLoader6(FILE_PATH);
        List<Point> points = dataLoader6.loadData();

        PointsInfo pointsInfo = new PointsInfo();
        System.out.println(pointsInfo.getSquare(points));
    }
}
