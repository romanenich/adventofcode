package com.romanenich.adventofcode2018.day6;

import java.util.Comparator;
import java.util.List;

public class PointsInfo implements Info {

    private final List<Point> points;

    public PointsInfo(List<Point> points) {
        this.points = points;
    }

    @Override
    public Square getSquare() {
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

    @Override
    public Point getLargestPoint(Square square) {
        for (int i = square.getLeftX(); i <= square.getRightX(); i++) {
            for (int j = square.getTopY(); j <= square.getBottomY(); j++) {
                Point basePoint = new Point(i, j);
                Point minPoint1 = null;
                Point minPoint2 = null;
                int minDistance = Integer.MAX_VALUE;
                for (Point point : points) {
                    int distance = distance(point, basePoint);
                    if (distance < minDistance) {
                        minPoint1 = point;
                        minDistance = distance;
                        minPoint2 = null;
                        // two point have the same distance to the basePoint
                    } else if (distance == minDistance) {
                        minPoint2 = point;
                    }
                }
                if (minPoint1 != null && minPoint2 == null) {
                    minPoint1.add(basePoint);
                }
            }
        }

        return points.stream()
                .filter(point -> point.getNearestPoints().stream()
                        .noneMatch(point1 -> point1.getX() == square.getLeftX()
                                || point1.getX() == square.getRightX()
                                || point1.getY() == square.getTopY()
                                || point1.getY() == square.getBottomY()))
//                .peek(point -> System.out.println(point))
                .max(Comparator.comparingInt(Point::area))
                .get();
    }

    private int distance(Point point, Point basePoint) {
        int deltaX = point.getX() - basePoint.getX();
        int deltaY = point.getY() - basePoint.getY();

        if (deltaX < 0) {
            deltaX = -deltaX;
        }

        if (deltaY < 0) {
            deltaY = -deltaY;
        }

        return deltaX + deltaY;

    }

    @Override
    public int getSafeRegionSize(int maxDistance, Square square) {
        int count = 0;
        for (int i = square.getLeftX(); i <= square.getRightX(); i++) {
            for (int j = square.getTopY(); j <= square.getBottomY(); j++) {
                Point basePoint = new Point(i, j);
                int curDistance = 0;
                for (Point point : points) {
                    curDistance +=distance(point, basePoint);
                }
                if (curDistance < maxDistance) {
                    count++;
                }
            }
        }
        return count;
    }
}
