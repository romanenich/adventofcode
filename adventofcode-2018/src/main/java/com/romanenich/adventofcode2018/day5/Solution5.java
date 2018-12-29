package com.romanenich.adventofcode2018.day5;

import java.util.List;

public class Solution5 {

    private final static String FILE_PATH = "com.romanenich/adventofcode2018/day5/input5.txt";

    public static void main(String[] args) {
        DataLoader5 dataLoader5 = new DataLoader5(FILE_PATH);
        List<Data5> data5s = dataLoader5.loadData();

        System.out.println(data5s);
    }
}
