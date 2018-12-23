package com.romanenich.adventofcode2018.day3;

import java.util.List;

/**
 * Created by Roman on 23.12.2018.
 */
public class Solution3 {

    private final static String FILE_PATH = "com/romanenich/adventofcode2018/day3/input3.txt";

    public static void main(String[] args) {
        DataLoader3 dataLoader3 = new DataLoader3(FILE_PATH);
        List<Data3> data = dataLoader3.loadData();
        Object[] result = countIntersections(data, dataLoader3.getMaxX(), dataLoader3.getMaxY());
        System.out.println("count of intersected parts equal to " + result[0]);
        System.out.println("claim's ID is " + findId(data, (int[][])result[1]));
    }

    private static int findId(List<Data3> datas, int[][] matrix) {

        for (Data3 data : datas) {
            int curCountIntersections = 0;
            for (int i = data.getShiftLeft(); i < data.getShiftLeft() + data.getWidth(); i++) {
                for (int j = data.getShiftTop(); j < data.getShiftTop() + data.getTall(); j++) {
                    if (matrix[i][j] != 1) {
                        curCountIntersections++;
                    }
                }
            }

            if (curCountIntersections == 0) {
                return data.getId();
            }
        }

        return 0;
    }

    private static Object[] countIntersections(List<Data3> datas, int maxX, int maxY) {
        int[][] matrix = new int[maxX + 1][maxY + 1];
        int count = 0;
        for (Data3 data : datas) {
            for (int i = data.getShiftLeft(); i < data.getShiftLeft() + data.getWidth(); i++) {
                for (int j = data.getShiftTop(); j < data.getShiftTop() + data.getTall(); j++) {
                    if (matrix[i][j] == 1) {
                        count++;
                    }
                    matrix[i][j] = matrix[i][j] + 1;
                }
            }
        }
        return new Object[]{count, matrix};
    }
}
