package com.romanenich.adventofcode2018.day6;

import java.util.List;

public class PointsInfo implements Info {

    private List<Point> points;

    public PointsInfo(List<Point> points) {
        this.points = points;
    }

    @Override
    public Square getSquare(List<Point> points) {
        int leftX = Integer.MAX_VALUE;
        int rightX = Integer.MIN_VALUE;
        int topY = Integer.MAX_VALUE;
        int bottomY = Integer.MIN_VALUE;

        for (Point point : points) {
            leftX = Math.min(leftX, point.getX());
            rightX = Math.max(rightX, point.getX());

            topY = Math.min(topY, point.getY());
            bottomY = Math.max(bottomY, point.getY());
        }

        return new Square(leftX, rightX, topY, bottomY);
    }
}
