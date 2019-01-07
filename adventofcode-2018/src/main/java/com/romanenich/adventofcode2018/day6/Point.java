package com.romanenich.adventofcode2018.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Roman on 04.01.2019.
 */
public class Point {

    private final int x;
    private final int y;

    private List<Point> nearestPoints;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        nearestPoints = new ArrayList<>();
    }

    public void add(Point point){
        nearestPoints.add(point);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Point> getNearestPoints() {
        return nearestPoints;
    }

    public int area(){
        return nearestPoints.size();
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", area =" + area() +
                ", nearestPoints=" + nearestPoints +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
